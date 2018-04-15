/* version 2.7.15 */
function FastClick(layer) {
	'use strict';
	var oldOnClick, self = this;


	/**
	 * Whether a click is currently being tracked.
	 *
	 * @type boolean
	 */
	this.trackingClick = false;


	/**
	 * Timestamp for when when click tracking started.
	 *
	 * @type number
	 */
	this.trackingClickStart = 0;


	/**
	 * The element being tracked for a click.
	 *
	 * @type EventTarget
	 */
	this.targetElement = null;


	/**
	 * X-coordinate of touch start event.
	 *
	 * @type number
	 */
	this.touchStartX = 0;


	/**
	 * Y-coordinate of touch start event.
	 *
	 * @type number
	 */
	this.touchStartY = 0;


	/**
	 * ID of the last touch, retrieved from Touch.identifier.
	 *
	 * @type number
	 */
	this.lastTouchIdentifier = 0;


	/**
	 * The FastClick layer.
	 *
	 * @type Element
	 */
	this.layer = layer;

	if (!layer || !layer.nodeType) {
		throw new TypeError('Layer must be a document node');
	}

	/** @type function() */
	this.onClick = function() { return FastClick.prototype.onClick.apply(self, arguments); };

	/** @type function() */
	this.onMouse = function() { return FastClick.prototype.onMouse.apply(self, arguments); };

	/** @type function() */
	this.onTouchStart = function() { return FastClick.prototype.onTouchStart.apply(self, arguments); };

	/** @type function() */
	this.onTouchEnd = function() { return FastClick.prototype.onTouchEnd.apply(self, arguments); };

	/** @type function() */
	this.onTouchCancel = function() { return FastClick.prototype.onTouchCancel.apply(self, arguments); };

	// Devices that don't support touch don't need FastClick
	if (typeof window.ontouchstart === 'undefined') {
		return;
	}

	// Set up event handlers as required
	if (this.deviceIsAndroid) {
		layer.addEventListener('mouseover', this.onMouse, true);
		layer.addEventListener('mousedown', this.onMouse, true);
		layer.addEventListener('mouseup', this.onMouse, true);
	}

	layer.addEventListener('click', this.onClick, true);
	layer.addEventListener('touchstart', this.onTouchStart, false);
	layer.addEventListener('touchend', this.onTouchEnd, false);
	layer.addEventListener('touchcancel', this.onTouchCancel, false);

	// Hack is required for browsers that don't support Event#stopImmediatePropagation (e.g. Android 2)
	// which is how FastClick normally stops click events bubbling to callbacks registered on the FastClick
	// layer when they are cancelled.
	if (!Event.prototype.stopImmediatePropagation) {
		layer.removeEventListener = function(type, callback, capture) {
			var rmv = Node.prototype.removeEventListener;
			if (type === 'click') {
				rmv.call(layer, type, callback.hijacked || callback, capture);
			} else {
				rmv.call(layer, type, callback, capture);
			}
		};

		layer.addEventListener = function(type, callback, capture) {
			var adv = Node.prototype.addEventListener;
			if (type === 'click') {
				adv.call(layer, type, callback.hijacked || (callback.hijacked = function(event) {
					if (!event.propagationStopped) {
						callback(event);
					}
				}), capture);
			} else {
				adv.call(layer, type, callback, capture);
			}
		};
	}

	// If a handler is already declared in the element's onclick attribute, it will be fired before
	// FastClick's onClick handler. Fix this by pulling out the user-defined handler function and
	// adding it as listener.
	if (typeof layer.onclick === 'function') {

		// Android browser on at least 3.2 requires a new reference to the function in layer.onclick
		// - the old one won't work if passed to addEventListener directly.
		oldOnClick = layer.onclick;
		layer.addEventListener('click', function(event) {
			oldOnClick(event);
		}, false);
		layer.onclick = null;
	}
}


/**
 * Android requires exceptions.
 *
 * @type boolean
 */
FastClick.prototype.deviceIsAndroid = navigator.userAgent.indexOf('Android') > 0;


/**
 * iOS requires exceptions.
 *
 * @type boolean
 */
FastClick.prototype.deviceIsIOS = /iP(ad|hone|od)/.test(navigator.userAgent);


/**
 * iOS 4 requires an exception for select elements.
 *
 * @type boolean
 */
FastClick.prototype.deviceIsIOS4 = FastClick.prototype.deviceIsIOS && (/OS 4_\d(_\d)?/).test(navigator.userAgent);


/**
 * iOS 6.0(+?) requires the target element to be manually derived
 *
 * @type boolean
 */
FastClick.prototype.deviceIsIOSWithBadTarget = FastClick.prototype.deviceIsIOS && (/OS ([6-9]|\d{2})_\d/).test(navigator.userAgent);


/**
 * Determine whether a given element requires a native click.
 *
 * @param {EventTarget|Element} target Target DOM element
 * @returns {boolean} Returns true if the element needs a native click
 */
FastClick.prototype.needsClick = function(target) {
	'use strict';
	switch (target.nodeName.toLowerCase()) {
	case 'button':
	case 'input':

		// File inputs need real clicks on iOS 6 due to a browser bug (issue #68)
		if (this.deviceIsIOS && target.type === 'file') {
			return true;
		}

		// Don't send a synthetic click to disabled inputs (issue #62)
		return target.disabled;
	case 'label':
	case 'video':
		return true;
	default:
		return (/\bneedsclick\b/).test(target.className);
	}
};


/**
 * Determine whether a given element requires a call to focus to simulate click into element.
 *
 * @param {EventTarget|Element} target Target DOM element
 * @returns {boolean} Returns true if the element requires a call to focus to simulate native click.
 */
FastClick.prototype.needsFocus = function(target) {
	'use strict';
	switch (target.nodeName.toLowerCase()) {
	case 'textarea':
	case 'select':
		return true;
	case 'input':
		switch (target.type) {
		case 'button':
		case 'checkbox':
		case 'file':
		case 'image':
		case 'radio':
		case 'submit':
			return false;
		}

		// No point in attempting to focus disabled inputs
		return !target.disabled;
	default:
		return (/\bneedsfocus\b/).test(target.className);
	}
};


/**
 * Send a click event to the specified element.
 *
 * @param {EventTarget|Element} targetElement
 * @param {Event} event
 */
FastClick.prototype.sendClick = function(targetElement, event) {
	'use strict';
	var clickEvent, touch;

	// On some Android devices activeElement needs to be blurred otherwise the synthetic click will have no effect (#24)
	if (document.activeElement && document.activeElement !== targetElement) {
		document.activeElement.blur();
	}

	touch = event.changedTouches[0];

	// Synthesise a click event, with an extra attribute so it can be tracked
	clickEvent = document.createEvent('MouseEvents');
	clickEvent.initMouseEvent('click', true, true, window, 1, touch.screenX, touch.screenY, touch.clientX, touch.clientY, false, false, false, false, 0, null);
	clickEvent.forwardedTouchEvent = true;
	targetElement.dispatchEvent(clickEvent);
};


/**
 * @param {EventTarget|Element} targetElement
 */
FastClick.prototype.focus = function(targetElement) {
	'use strict';
	var length;

	if (this.deviceIsIOS && targetElement.setSelectionRange) {
		length = targetElement.value.length;
		targetElement.setSelectionRange(length, length);
	} else {
		targetElement.focus();
	}
};


/**
 * Check whether the given target element is a child of a scrollable layer and if so, set a flag on it.
 *
 * @param {EventTarget|Element} targetElement
 */
FastClick.prototype.updateScrollParent = function(targetElement) {
	'use strict';
	var scrollParent, parentElement;

	scrollParent = targetElement.fastClickScrollParent;

	// Attempt to discover whether the target element is contained within a scrollable layer. Re-check if the
	// target element was moved to another parent.
	if (!scrollParent || !scrollParent.contains(targetElement)) {
		parentElement = targetElement;
		do {
			if (parentElement.scrollHeight > parentElement.offsetHeight) {
				scrollParent = parentElement;
				targetElement.fastClickScrollParent = parentElement;
				break;
			}

			parentElement = parentElement.parentElement;
		} while (parentElement);
	}

	// Always update the scroll top tracker if possible.
	if (scrollParent) {
		scrollParent.fastClickLastScrollTop = scrollParent.scrollTop;
	}
};


/**
 * @param {EventTarget} targetElement
 * @returns {Element|EventTarget}
 */
FastClick.prototype.getTargetElementFromEventTarget = function(eventTarget) {
	'use strict';

	// On some older browsers (notably Safari on iOS 4.1 - see issue #56) the event target may be a text node.
	if (eventTarget.nodeType === Node.TEXT_NODE) {
		return eventTarget.parentNode;
	}

	return eventTarget;
};


/**
 * On touch start, record the position and scroll offset.
 *
 * @param {Event} event
 * @returns {boolean}
 */
FastClick.prototype.onTouchStart = function(event) {
	'use strict';
	var targetElement, touch, selection;

	targetElement = this.getTargetElementFromEventTarget(event.target);
	touch = event.targetTouches[0];

	if (this.deviceIsIOS) {

		// Only trusted events will deselect text on iOS (issue #49)
		selection = window.getSelection();
		if (selection.rangeCount && !selection.isCollapsed) {
			return true;
		}

		if (!this.deviceIsIOS4) {

			// Weird things happen on iOS when an alert or confirm dialog is opened from a click event callback (issue #23):
			// when the user next taps anywhere else on the page, new touchstart and touchend events are dispatched
			// with the same identifier as the touch event that previously triggered the click that triggered the alert.
			// Sadly, there is an issue on iOS 4 that causes some normal touch events to have the same identifier as an
			// immediately preceeding touch event (issue #52), so this fix is unavailable on that platform.
			if (touch.identifier === this.lastTouchIdentifier) {
				event.preventDefault();
				return false;
			}
		
			this.lastTouchIdentifier = touch.identifier;

			// If the target element is a child of a scrollable layer (using -webkit-overflow-scrolling: touch) and:
			// 1) the user does a fling scroll on the scrollable layer
			// 2) the user stops the fling scroll with another tap
			// then the event.target of the last 'touchend' event will be the element that was under the user's finger
			// when the fling scroll was started, causing FastClick to send a click event to that layer - unless a check
			// is made to ensure that a parent layer was not scrolled before sending a synthetic click (issue #42).
			this.updateScrollParent(targetElement);
		}
	}

	this.trackingClick = true;
	this.trackingClickStart = event.timeStamp;
	this.targetElement = targetElement;

	this.touchStartX = touch.pageX;
	this.touchStartY = touch.pageY;

	// Prevent phantom clicks on fast double-tap (issue #36)
	if ((event.timeStamp - this.lastClickTime) < 200) {
		event.preventDefault();
	}

	return true;
};


/**
 * Based on a touchmove event object, check whether the touch has moved past a boundary since it started.
 *
 * @param {Event} event
 * @returns {boolean}
 */
FastClick.prototype.touchHasMoved = function(event) {
	'use strict';
	var touch = event.changedTouches[0];

	if (Math.abs(touch.pageX - this.touchStartX) > 10 || Math.abs(touch.pageY - this.touchStartY) > 10) {
		return true;
	}

	return false;
};


/**
 * Attempt to find the labelled control for the given label element.
 *
 * @param {EventTarget|HTMLLabelElement} labelElement
 * @returns {Element|null}
 */
FastClick.prototype.findControl = function(labelElement) {
	'use strict';

	// Fast path for newer browsers supporting the HTML5 control attribute
	if (labelElement.control !== undefined) {
		return labelElement.control;
	}

	// All browsers under test that support touch events also support the HTML5 htmlFor attribute
	if (labelElement.htmlFor) {
		return document.getElementById(labelElement.htmlFor);
	}

	// If no for attribute exists, attempt to retrieve the first labellable descendant element
	// the list of which is defined here: http://www.w3.org/TR/html5/forms.html#category-label
	return labelElement.querySelector('button, input:not([type=hidden]), keygen, meter, output, progress, select, textarea');
};


/**
 * On touch end, determine whether to send a click event at once.
 *
 * @param {Event} event
 * @returns {boolean}
 */
FastClick.prototype.onTouchEnd = function(event) {
	'use strict';
	var forElement, trackingClickStart, targetTagName, scrollParent, touch, targetElement = this.targetElement;

	// If the touch has moved, cancel the click tracking
	if (this.touchHasMoved(event)) {
		this.trackingClick = false;
		this.targetElement = null;
	}

	if (!this.trackingClick) {
		return true;
	}

	// Prevent phantom clicks on fast double-tap (issue #36)
	if ((event.timeStamp - this.lastClickTime) < 200) {
		this.cancelNextClick = true;
		return true;
	}

	this.lastClickTime = event.timeStamp;

	trackingClickStart = this.trackingClickStart;
	this.trackingClick = false;
	this.trackingClickStart = 0;

	// On some iOS devices, the targetElement supplied with the event is invalid if the layer
	// is performing a transition or scroll, and has to be re-detected manually. Note that
	// for this to function correctly, it must be called *after* the event target is checked!
	// See issue #57; also filed as rdar://13048589 .
	if (this.deviceIsIOSWithBadTarget) {
		touch = event.changedTouches[0];
		targetElement = document.elementFromPoint(touch.pageX - window.pageXOffset, touch.pageY - window.pageYOffset);
	}

	targetTagName = targetElement.tagName.toLowerCase();
	if (targetTagName === 'label') {
		forElement = this.findControl(targetElement);
		if (forElement) {
			this.focus(targetElement);
			if (this.deviceIsAndroid) {
				return false;
			}

			targetElement = forElement;
		}
	} else if (this.needsFocus(targetElement)) {

		// Case 1: If the touch started a while ago (best guess is 100ms based on tests for issue #36) then focus will be triggered anyway. Return early and unset the target element reference so that the subsequent click will be allowed through.
		// Case 2: Without this exception for input elements tapped when the document is contained in an iframe, then any inputted text won't be visible even though the value attribute is updated as the user types (issue #37).
		if ((event.timeStamp - trackingClickStart) > 100 || (this.deviceIsIOS && window.top !== window && targetTagName === 'input')) {
			this.targetElement = null;
			return false;
		}

		this.focus(targetElement);

		// Select elements need the event to go through on iOS 4, otherwise the selector menu won't open.
		if (!this.deviceIsIOS4 || targetTagName !== 'select') {
			this.targetElement = null;
			event.preventDefault();
		}

		return false;
	}

	if (this.deviceIsIOS && !this.deviceIsIOS4) {

		// Don't send a synthetic click event if the target element is contained within a parent layer that was scrolled
		// and this tap is being used to stop the scrolling (usually initiated by a fling - issue #42).
		scrollParent = targetElement.fastClickScrollParent;
		if (scrollParent && scrollParent.fastClickLastScrollTop !== scrollParent.scrollTop) {
			return true;
		}
	}

	// Prevent the actual click from going though - unless the target node is marked as requiring
	// real clicks or if it is in the whitelist in which case only non-programmatic clicks are permitted.
	if (!this.needsClick(targetElement)) {
		event.preventDefault();
		var self = this;
		setTimeout(function(){
			self.sendClick(targetElement, event);
		}, 0);
	}

	return false;
};


/**
 * On touch cancel, stop tracking the click.
 *
 * @returns {void}
 */
FastClick.prototype.onTouchCancel = function() {
	'use strict';
	this.trackingClick = false;
	this.targetElement = null;
};


/**
 * Determine mouse events which should be permitted.
 *
 * @param {Event} event
 * @returns {boolean}
 */
FastClick.prototype.onMouse = function(event) {
	'use strict';

	// If a target element was never set (because a touch event was never fired) allow the event
	if (!this.targetElement) {
		return true;
	}

	if (event.forwardedTouchEvent) {
		return true;
	}

	// Programmatically generated events targeting a specific element should be permitted
	if (!event.cancelable) {
		return true;
	}

	// Derive and check the target element to see whether the mouse event needs to be permitted;
	// unless explicitly enabled, prevent non-touch click events from triggering actions,
	// to prevent ghost/doubleclicks.
	if (!this.needsClick(this.targetElement) || this.cancelNextClick) {

		// Prevent any user-added listeners declared on FastClick element from being fired.
		if (event.stopImmediatePropagation) {
			event.stopImmediatePropagation();
		} else {

			// Part of the hack for browsers that don't support Event#stopImmediatePropagation (e.g. Android 2)
			event.propagationStopped = true;
		}

		// Cancel the event
		event.stopPropagation();
		event.preventDefault();

		return false;
	}

	// If the mouse event is permitted, return true for the action to go through.
	return true;
};


/**
 * On actual clicks, determine whether this is a touch-generated click, a click action occurring
 * naturally after a delay after a touch (which needs to be cancelled to avoid duplication), or
 * an actual click which should be permitted.
 *
 * @param {Event} event
 * @returns {boolean}
 */
FastClick.prototype.onClick = function(event) {
	'use strict';
	var permitted;

	// It's possible for another FastClick-like library delivered with third-party code to fire a click event before FastClick does (issue #44). In that case, set the click-tracking flag back to false and return early. This will cause onTouchEnd to return early.
	if (this.trackingClick) {
		this.targetElement = null;
		this.trackingClick = false;
		return true;
	}

	// Very odd behaviour on iOS (issue #18): if a submit element is present inside a form and the user hits enter in the iOS simulator or clicks the Go button on the pop-up OS keyboard the a kind of 'fake' click event will be triggered with the submit-type input element as the target.
	if (event.target.type === 'submit' && event.detail === 0) {
		return true;
	}

	permitted = this.onMouse(event);

	// Only unset targetElement if the click is not permitted. This will ensure that the check for !targetElement in onMouse fails and the browser's click doesn't go through.
	if (!permitted) {
		this.targetElement = null;
	}

	// If clicks are permitted, return true for the action to go through.
	return permitted;
};


/**
 * Remove all FastClick's event listeners.
 *
 * @returns {void}
 */
FastClick.prototype.destroy = function() {
	'use strict';
	var layer = this.layer;

	if (this.deviceIsAndroid) {
		layer.removeEventListener('mouseover', this.onMouse, true);
		layer.removeEventListener('mousedown', this.onMouse, true);
		layer.removeEventListener('mouseup', this.onMouse, true);
	}

	layer.removeEventListener('click', this.onClick, true);
	layer.removeEventListener('touchstart', this.onTouchStart, false);
	layer.removeEventListener('touchend', this.onTouchEnd, false);
	layer.removeEventListener('touchcancel', this.onTouchCancel, false);
};


/**
 * Factory method for creating a FastClick object
 *
 * @param {Element} layer The layer to listen on
 */
FastClick.attach = function(layer) {
	'use strict';
	return new FastClick(layer);
};


if (typeof define !== 'undefined' && define.amd) {

	// AMD. Register as an anonymous module.
	define(function() {
		'use strict';
		return FastClick;
	});
}

if (typeof module !== 'undefined' && module.exports) {
	module.exports = FastClick.attach;
	module.exports.FastClick = FastClick;
}
;
/*
 * Swipe 2.0
 *
 * Brad Birdsall
 * Copyright 2013, MIT License
 *
*/


function Swipe(container, options) {

  "use strict";

  // utilities
  var noop = function() {}; // simple no operation function
  var offloadFn = function(fn) { setTimeout(fn || noop, 0) }; // offload a functions execution
  
  // check browser capabilities
  var browser = {
    addEventListener: !!window.addEventListener,
    touch: ('ontouchstart' in window) || window.DocumentTouch && document instanceof DocumentTouch,
    transitions: (function(temp) {
      var props = ['transitionProperty', 'WebkitTransition', 'MozTransition', 'OTransition', 'msTransition'];
      for ( var i in props ) if (temp.style[ props[i] ] !== undefined) return true;
      return false;
    })(document.createElement('swipe'))
  };

  // quit if no root element
  if (!container) return;
  var element = container.children[0];
  var slides, slidePos, width, length;
  options = options || {};
  var index = parseInt(options.startSlide, 10) || 0;
  var speed = options.speed || 300;
  options.continuous = options.continuous !== undefined ? options.continuous : true;

  function setup() {

    // cache slides
    slides = element.children;
    length = slides.length;

    // set continuous to false if only one slide
    if (slides.length < 2) options.continuous = false;

    //special case if two slides
    if (browser.transitions && options.continuous && slides.length < 3) {
      element.appendChild(slides[0].cloneNode(true));
      element.appendChild(element.children[1].cloneNode(true));
      slides = element.children;
    }

    // create an array to store current positions of each slide
    slidePos = new Array(slides.length);

    // determine width of each slide
    width = container.getBoundingClientRect().width || container.offsetWidth;

    element.style.width = (slides.length * width) + 'px';

    // stack elements
    var pos = slides.length;
    while(pos--) {

      var slide = slides[pos];

      slide.style.width = width + 'px';
      slide.setAttribute('data-index', pos);

      if (browser.transitions) {
        slide.style.left = (pos * -width) + 'px';
        move(pos, index > pos ? -width : (index < pos ? width : 0), 0);
      }

    }

    // reposition elements before and after index
    if (options.continuous && browser.transitions) {
      move(circle(index-1), -width, 0);
      move(circle(index+1), width, 0);
    }

    if (!browser.transitions) element.style.left = (index * -width) + 'px';

    container.style.visibility = 'visible';

  }

  function prev() {

    if (options.continuous) slide(index-1);
    else if (index) slide(index-1);

  }

  function next() {

    if (options.continuous) slide(index+1);
    else if (index < slides.length - 1) slide(index+1);

  }

  function circle(index) {

    // a simple positive modulo using slides.length
    return (slides.length + (index % slides.length)) % slides.length;

  }

  function slide(to, slideSpeed) {

    // do nothing if already on requested slide
    if (index == to) return;
    
    if (browser.transitions) {

      var direction = Math.abs(index-to) / (index-to); // 1: backward, -1: forward

      // get the actual position of the slide
      if (options.continuous) {
        var natural_direction = direction;
        direction = -slidePos[circle(to)] / width;

        // if going forward but to < index, use to = slides.length + to
        // if going backward but to > index, use to = -slides.length + to
        if (direction !== natural_direction) to =  -direction * slides.length + to;

      }

      var diff = Math.abs(index-to) - 1;

      // move all the slides between index and to in the right direction
      while (diff--) move( circle((to > index ? to : index) - diff - 1), width * direction, 0);
            
      to = circle(to);

      move(index, width * direction, slideSpeed || speed);
      move(to, 0, slideSpeed || speed);

      if (options.continuous) move(circle(to - direction), -(width * direction), 0); // we need to get the next in place
      
    } else {     
      
      to = circle(to);
      animate(index * -width, to * -width, slideSpeed || speed);
      //no fallback for a circular continuous if the browser does not accept transitions
    }

    index = to;
    offloadFn(options.callback && options.callback(index, slides[index]));
  }

  function move(index, dist, speed) {

    translate(index, dist, speed);
    slidePos[index] = dist;

  }

  function translate(index, dist, speed) {

    var slide = slides[index];
    var style = slide && slide.style;

    if (!style) return;

    style.webkitTransitionDuration = 
    style.MozTransitionDuration = 
    style.msTransitionDuration = 
    style.OTransitionDuration = 
    style.transitionDuration = speed + 'ms';

    style.webkitTransform = 'translate(' + dist + 'px,0)' + 'translateZ(0)';
    style.msTransform = 
    style.MozTransform = 
    style.OTransform = 'translateX(' + dist + 'px)';

  }

  function animate(from, to, speed) {

    // if not an animation, just reposition
    if (!speed) {

      element.style.left = to + 'px';
      return;

    }
    
    var start = +new Date;
    
    var timer = setInterval(function() {

      var timeElap = +new Date - start;
      
      if (timeElap > speed) {

        element.style.left = to + 'px';

        if (delay) begin();

        options.transitionEnd && options.transitionEnd.call(event, index, slides[index]);

        clearInterval(timer);
        return;

      }

      element.style.left = (( (to - from) * (Math.floor((timeElap / speed) * 100) / 100) ) + from) + 'px';

    }, 4);

  }

  // setup auto slideshow
  var delay = options.auto || 0;
  var interval;

  function begin() {

    interval = setTimeout(next, delay);

  }

  function stop() {

    delay = 0;
    clearTimeout(interval);

  }


  // setup initial vars
  var start = {};
  var delta = {};
  var isScrolling;      

  // setup event capturing
  var events = {

    handleEvent: function(event) {

      switch (event.type) {
        case 'touchstart': this.start(event); break;
        case 'touchmove': this.move(event); break;
        case 'touchend': offloadFn(this.end(event)); break;
        case 'webkitTransitionEnd':
        case 'msTransitionEnd':
        case 'oTransitionEnd':
        case 'otransitionend':
        case 'transitionend': offloadFn(this.transitionEnd(event)); break;
        case 'resize': offloadFn(setup.call()); break;
      }

      if (options.stopPropagation) event.stopPropagation();

    },
    start: function(event) {

      var touches = event.touches[0];

      // measure start values
      start = {

        // get initial touch coords
        x: touches.pageX,
        y: touches.pageY,

        // store time to determine touch duration
        time: +new Date

      };
      
      // used for testing first move event
      isScrolling = undefined;

      // reset delta and end measurements
      delta = {};

      // attach touchmove and touchend listeners
      element.addEventListener('touchmove', this, false);
      element.addEventListener('touchend', this, false);

    },
    move: function(event) {

      // ensure swiping with one touch and not pinching
      if ( event.touches.length > 1 || event.scale && event.scale !== 1) return

      if (options.disableScroll) event.preventDefault();

      var touches = event.touches[0];

      // measure change in x and y
      delta = {
        x: touches.pageX - start.x,
        y: touches.pageY - start.y
      }

      // determine if scrolling test has run - one time test
      if ( typeof isScrolling == 'undefined') {
        isScrolling = !!( isScrolling || Math.abs(delta.x) < Math.abs(delta.y) );
      }

      // if user is not trying to scroll vertically
      if (!isScrolling) {

        // prevent native scrolling 
        event.preventDefault();

        // stop slideshow
        stop();

        // increase resistance if first or last slide
        if (options.continuous) { // we don't add resistance at the end

          translate(circle(index-1), delta.x + slidePos[circle(index-1)], 0);
          translate(index, delta.x + slidePos[index], 0);
          translate(circle(index+1), delta.x + slidePos[circle(index+1)], 0);

        } else {

          delta.x = 
            delta.x / 
              ( (!index && delta.x > 0               // if first slide and sliding left
                || index == slides.length - 1        // or if last slide and sliding right
                && delta.x < 0                       // and if sliding at all
              ) ?                      
              ( Math.abs(delta.x) / width + 1 )      // determine resistance level
              : 1 );                                 // no resistance if false
          
          // translate 1:1
          translate(index-1, delta.x + slidePos[index-1], 0);
          translate(index, delta.x + slidePos[index], 0);
          translate(index+1, delta.x + slidePos[index+1], 0);
        }

      }

    },
    end: function(event) {

      // measure duration
      var duration = +new Date - start.time;

      // determine if slide attempt triggers next/prev slide
      var isValidSlide = 
            Number(duration) < 250               // if slide duration is less than 250ms
            && Math.abs(delta.x) > 20            // and if slide amt is greater than 20px
            || Math.abs(delta.x) > width/2;      // or if slide amt is greater than half the width

      // determine if slide attempt is past start and end
      var isPastBounds = 
            !index && delta.x > 0                            // if first slide and slide amt is greater than 0
            || index == slides.length - 1 && delta.x < 0;    // or if last slide and slide amt is less than 0

      if (options.continuous) isPastBounds = false;
      
      // determine direction of swipe (true:right, false:left)
      var direction = delta.x < 0;

      // if not scrolling vertically
      if (!isScrolling) {

        if (isValidSlide && !isPastBounds) {

          if (direction) {

            if (options.continuous) { // we need to get the next in this direction in place

              move(circle(index-1), -width, 0);
              move(circle(index+2), width, 0);

            } else {
              move(index-1, -width, 0);
            }

            move(index, slidePos[index]-width, speed);
            move(circle(index+1), slidePos[circle(index+1)]-width, speed);
            index = circle(index+1);  
                      
          } else {
            if (options.continuous) { // we need to get the next in this direction in place

              move(circle(index+1), width, 0);
              move(circle(index-2), -width, 0);

            } else {
              move(index+1, width, 0);
            }

            move(index, slidePos[index]+width, speed);
            move(circle(index-1), slidePos[circle(index-1)]+width, speed);
            index = circle(index-1);

          }

          options.callback && options.callback(index, slides[index]);

        } else {

          if (options.continuous) {

            move(circle(index-1), -width, speed);
            move(index, 0, speed);
            move(circle(index+1), width, speed);

          } else {

            move(index-1, -width, speed);
            move(index, 0, speed);
            move(index+1, width, speed);
          }

        }

      }

      // kill touchmove and touchend event listeners until touchstart called again
      element.removeEventListener('touchmove', events, false)
      element.removeEventListener('touchend', events, false)

    },
    transitionEnd: function(event) {

      if (parseInt(event.target.getAttribute('data-index'), 10) == index) {
        
        if (delay) begin();

        options.transitionEnd && options.transitionEnd.call(event, index, slides[index]);

      }

    }

  }

  // trigger setup
  setup();

  // start auto slideshow if applicable
  if (delay) begin();


  // add event listeners
  if (browser.addEventListener) {
    
    // set touchstart event on element    
    if (browser.touch) element.addEventListener('touchstart', events, false);

    if (browser.transitions) {
      element.addEventListener('webkitTransitionEnd', events, false);
      element.addEventListener('msTransitionEnd', events, false);
      element.addEventListener('oTransitionEnd', events, false);
      element.addEventListener('otransitionend', events, false);
      element.addEventListener('transitionend', events, false);
    }

    // set resize event on window
    window.addEventListener('resize', events, false);

  } else {

    window.onresize = function () { setup() }; // to play nice with old IE

  }

  // expose the Swipe API
  return {
    setup: function() {

      setup();

    },
    slide: function(to, speed) {
      
      // cancel slideshow
      stop();
      
      slide(to, speed);

    },
    prev: function() {

      // cancel slideshow
      stop();

      prev();

    },
    next: function() {

      // cancel slideshow
      stop();

      next();

    },
    getPos: function() {

      // return current index position
      return index;

    },
    getNumSlides: function() {
      
      // return total number of slides
      return length;
    },
    kill: function() {

      // cancel slideshow
      stop();

      // reset element
      element.style.width = 'auto';
      element.style.left = 0;

      // reset slides
      var pos = slides.length;
      while(pos--) {

        var slide = slides[pos];
        slide.style.width = '100%';
        slide.style.left = 0;

        if (browser.transitions) translate(pos, 0, 0);

      }

      // removed event listeners
      if (browser.addEventListener) {

        // remove current event listeners
        element.removeEventListener('touchstart', events, false);
        element.removeEventListener('webkitTransitionEnd', events, false);
        element.removeEventListener('msTransitionEnd', events, false);
        element.removeEventListener('oTransitionEnd', events, false);
        element.removeEventListener('otransitionend', events, false);
        element.removeEventListener('transitionend', events, false);
        window.removeEventListener('resize', events, false);

      }
      else {

        window.onresize = null;

      }

    }
  }

}


if ( window.jQuery || window.Zepto ) {
  (function($) {
    $.fn.Swipe = function(params) {
      return this.each(function() {
        $(this).data('Swipe', new Swipe($(this)[0], params));
      });
    }
  })( window.jQuery || window.Zepto )
}
;
;(function(window, undefined) {
// -----------------------------------------------------------------------------

/**
 * Avoid `console` errors in browsers that lack a console.
 */

if (!(window.console && window.console.log)) {
    var noop = function() {};
    var methods = ['assert', 'clear', 'count', 'debug', 'dir', 'dirxml', 'error', 'exception', 'group', 'groupCollapsed', 'groupEnd', 'info', 'log', 'markTimeline', 'profile', 'profileEnd', 'markTimeline', 'table', 'time', 'timeEnd', 'timeStamp', 'trace', 'warn'];
    var length = methods.length;
    var console = window.console = {};
    while (length--) {
        console[methods[length]] = noop;
    }
}

// -----------------------------------------------------------------------------
}(window));
;(function (window, undefined) {
// -----------------------------------------------------------------------------

/**
 * Executes a provided function once per array element.
 */

if (!Array.prototype.forEach) {
    Array.prototype.forEach = function (fn, scope) {
        for(var i = 0, len = this.length; i < len; ++i) {
            fn.call(scope, this[i], i, this);
        }
    };
}

// -----------------------------------------------------------------------------
})(window);
;(function (window, undefined) {
// -----------------------------------------------------------------------------

/**
 * Creates a new object with the specified prototype object and properties.
 * Only the first param is usable, as there is no way to polfill the properties
 * object.
 */

if (!Object.create) {
    Object.create = function (o) {
        if (arguments.length > 1) {
            throw new Error('Object.create implementation only accepts the first parameter.');
        }
        function F() {}
        F.prototype = o;
        return new F();
    };
}

// -----------------------------------------------------------------------------
})(window);



;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/**
 * Take an element and convert it and its contents into a module.
 *
 * This script expects the element to have a "data-module-type" attribute
 * specifying which module constructor to use.
 *
 * @param {HTMLElement} elem The containing element of the module.
 *
 * @return {object} The object representing the module.
 */
app.createModule = function __createModule__(elem) {
    var moduleTypes = elem.getAttribute('data-module-type').split(' ');
    var module = null;
    var modules = app.modules || [];
    var start = new Date().getTime();
    var end;

    moduleTypes.forEach(function (moduleType) {
        if (app[moduleType] && typeof app[moduleType] === 'function') {
            try {
                module = new app[moduleType](elem);
                end = new Date().getTime();
                console.log('###', moduleType, 'module loaded in', end - start + 'ms.');
            } catch (e) {
                console.log('Attempted to initialize a ', moduleType, 'using', elem, 'but there was an error:', e);
            }
        }

        if (module) {
            modules.push(module);
        }
    });
};

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);
;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

// Returns a function, that, when invoked, will only be triggered at most once
// during a given window of time. Normally, the throttled function will run
// as much as it can, without ever going more than once per `wait` duration;
// but if you'd like to disable the execution on the leading edge, pass
// `{leading: false}`. To disable execution on the trailing edge, ditto.
app.throttle = function(func, wait, options) {
    var context, args, result;
    var timeout = null;
    var previous = 0;
    options || (options = {});
    var later = function() {
        previous = options.leading === false ? 0 : new Date;
        timeout = null;
        result = func.apply(context, args);
    };
    return function() {
        var now = new Date;
        if (!previous && options.leading === false) previous = now;
            var remaining = wait - (now - previous);
            context = this;
            args = arguments;
            if (remaining <= 0) {
                clearTimeout(timeout);
                timeout = null;
                previous = now;
                result = func.apply(context, args);
            } else if (!timeout && options.trailing !== false) {
            timeout = setTimeout(later, remaining);
        }
        return result;
    };
};


// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);



;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/**
 * Hide addressbar in iOS
 *
 * @return {Object} app
 */

app.hideAddressBar = function __hideAddressBar__(options) {

    // Big screen. Fixed chrome likely.
    if(screen.width > 980 || screen.height > 980) return;

    // Standalone (full screen webapp) mode
    if(window.navigator.standalone === true) return;

    // Page zoom or vertical scrollbars
    if(window.innerWidth !== document.documentElement.clientWidth) {
        // Sometimes one pixel too much. Compensate.
        if((window.innerWidth - 1) !== document.documentElement.clientWidth) return;

    }

    var bodyTag;

    // Pad content if necessary.
    if(document.documentElement.scrollHeight <= document.documentElement.clientHeight) {
        // Extend body height to overflow and cause scrolling
        bodyTag = document.getElementsByTagName('body')[0];

        // Viewport height at fullscreen
        bodyTag.style.height = document.documentElement.clientWidth / screen.width * screen.height + 'px';

    }

    setTimeout(function() {
        // Already scrolled?
        if(window.pageYOffset !== 0) return;

        // Perform autoscroll
        window.scrollTo(0, 1);

        // Reset body height and scroll
        if(bodyTag !== undefined) bodyTag.style.height = window.innerHeight + 'px';
        window.scrollTo(0, 0);

    }, 1000);

    return app;
};

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);




;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

Modernizr.addTest("boxsizing", function() {
    return Modernizr.testAllProps("boxSizing") && (document.documentMode === undefined || document.documentMode > 7);
});

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);




// This is used explicitly by the mobile menu toggle.


;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */


/*
 * Helper Functions
 */


/*
 * Constructor
 */
var MobileMenu = function(el) {
    var self = this instanceof MobileMenu
             ? this
             : Object.create(MobileMenu.prototype);
    self.el = el;
    self.$el = dojo.query(el);
    self.initialize();
    return self;
};

MobileMenu.prototype.initialize = function initialize() {
    var self = this;

    self.$htmlElement = dojo.query('html');
    self.activeClass = 'mobile-menu-active';

    self.bindEvents();
};

MobileMenu.prototype.bindEvents = function bindEvents() {
    var self = this;

    // Binds onclick event to dojo.nodeList element of this module ( mobile menu button),
    // with a callback function to toggle a "mobile-menu-active" class on the <html> element.
    // This class trigger the CSS styles that handles the animations and interaction
    // of the mobile menu
    self.$el.connect('onclick', self, self.toggleMobileMenu);
};

MobileMenu.prototype.toggleMobileMenu = function toggleMobileMenu() {
    var self = this;

    self.$htmlElement.toggleClass(self.activeClass);
    app.hideAddressBar();
};

return app.MobileMenu = MobileMenu;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);
;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */


/*
 * Helper Functions
 */


/*
 * Constructor
 */
var MainNav = function(el) {
    var self = this instanceof MainNav
             ? this
             : Object.create(MainNav.prototype);
    self.el = el;
    self.$el = dojo.query(el);
    self.initialize();
    return self;
};

MainNav.prototype.initialize = function initialize() {
    var self = this;

    // initialize variables/properties used by this module
    self.activeClass = 'active';
    self.mobileActiveClass = 'mobile-active';
    self.$navItems = self.$el.query('.nav__item');
    self.timer = null;
    self.delay = 500;
    self.$activeNav = null;

    self.bindEvents();
};

/**
 * Attach all event handlers relevant to the module
 *
 * @function bindEvents
 */
MainNav.prototype.bindEvents = function bindEvents() {
    var self = this;

    // bind click events of each subnav__toggle and pass in new context containing reference
    // to this module and the current menu item.
    self.$navItems.forEach(function (node, index, array) {
        var $node = self.$el.query(node),
            $toggle = $node.children('.nav__link'),
            newContext = {
                'module': self,
                '$node': $node
            };

        $node.connect('onmouseover', newContext, self.mouseEnterHandler);
        $node.connect('onmouseout', newContext, self.mouseLeaveHandler);
        $toggle.connect('onclick', newContext, self.clickHandler);

    });

    dojo.query(dojo.body()).connect('onclick', self, self.closeMenu);

};

MainNav.prototype.openMenu = function openMenu($menu) {
    var self = this;

    $menu.addClass(self.activeClass);
    self.$activeNav = $menu;
};

MainNav.prototype.closeMenu = function closeMenu() {
    var self = this;
    if(self.$activeNav) {

        self.$activeNav.removeClass(self.activeClass);
        self.$activeNav = null;
    }
};

MainNav.prototype.mouseEnterHandler = function mouseEnterHandler(event) {
    var self = this.module,
        $node = this.$node;

    clearTimeout(self.timer);
    self.timer = setTimeout(function () {
        self.closeMenu();
        self.openMenu($node);
    }, self.delay);
};

MainNav.prototype.mouseLeaveHandler = function mouseLeaveHandler(event) {
    var self = this.module,
        $node = this.$node;

    clearTimeout(self.timer);
    self.timer = setTimeout(function () {
        self.closeMenu();
    }, self.delay);
};

MainNav.prototype.clickHandler = function clickHandler(event) {
    event.stopPropagation();

    var self = this.module,
        $node = this.$node;

    $node.toggleClass(self.mobileActiveClass);
    $node.toggleClass(self.activeClass);
    $node.siblings('.' + self.activeClass).removeClass(self.activeClass);
    self.$activeNav = dojo.hasClass($node[0], self.activeClass) ? $node : null;
};



return app.MainNav = MainNav;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);





;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/**
 * @constructor Nav
 * @returns {Object}
 */
var SubNav = function(el) {
    var self = this instanceof SubNav
             ? this
             : Object.create(SubNav.prototype);
    self.el = el;
    self.$el = dojo.query(el);

    self.initialize();
    return self;
};

/**
 * Set the module's properties with the relevant elements
 *
 * @function initialize
 */
SubNav.prototype.initialize = function initialize() {
    var self = this;

    // Store subnavigation toggles, views (panels), and activeIndex value.
    self.$subnavToggles = self.$el.query('.subnav__toggle');
    self.$subnavPanels = self.$el.query('.subnav__panel');
    self.activeIndex = 0;
    self.activeClass = 'active';

    // Call bindEvents function on each toggles with the module as the context
    self.$subnavToggles.forEach(dojo.hitch(self, self.bindEvents));
};

/**
 * Attach all event handlers relevant to the module
 *
 * @function bindEvents
 */
SubNav.prototype.bindEvents = function bindEvents(node, index, array) {
    var self = this,
        $node = dojo.query(node),
        handler = self.returnToggleHandler(index);
    // return a specific handler for each toggle based on it's index.

    // Bind the handler to node's "onmouseenter" and "onclick" event

    $node.connect('onmouseenter', self, handler);
    $node.connect('onclick', self, handler);

    self.$el.connect('onclick', function(event) {
        event.stopPropagation();
    })
};

SubNav.prototype.returnToggleHandler = function returnToggleHandler(_index) {

    // return toggleHandler function with the module context and correct index stored.
    return function () {
        var self = this,
            index = _index;

        // if this toggle is not the current view toggle, hide the current view
        // by removing the active classes and active this toggle and view.
        if (self.activeIndex !== index) {
            self.$subnavToggles.at(self.activeIndex).removeClass(self.activeClass);
            self.$subnavPanels.at(self.activeIndex).removeClass(self.activeClass);

            self.$subnavToggles.at(index).addClass(self.activeClass);
            self.$subnavPanels.at(index).addClass(self.activeClass);
            
            self.activeIndex = index;
        }
    }
};


return app.SubNav = SubNav;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);


;(function (window, document, dojo, undefined) {


var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */


/*
 * Helper Functions
 */


/*
 * Constructor
 */
var ImageSlider = function(el) {
    var self = this instanceof ImageSlider
             ? this
             : Object.create(ImageSlider.prototype);
    self.el = el;
    self.$el = dojo.query(el);
    self.$bulletsWrap = self.$el.query('.slider-bullets');
    self.bulletList = [];
    self.activeBullet;
    self.initialize();
    return self;
};

ImageSlider.prototype.initialize = function initialize() {
    var self    = this,
        options = {
            auto : 8000,
            continuous : false,
            callback : dojo.hitch(self, self.goToBullet)
        };

    dojo.ready(function () {

        self.slider = new Swipe(self.el, options);

        self.createBullets();

    });

};

ImageSlider.prototype.createBullets = function createBullets(index, element) {
    var self = this,
        slideCount = self.slider.getNumSlides();


    // for each slide, add a bullet
    for( var i = 0; i < slideCount; i++ ) {
        (function (index) {
            var $thisBullet = dojo.NodeList(dojo.doc.createElement('span'));

            $thisBullet.addClass('bullet');

            $thisBullet.connect('onclick', function () {
                self.slider.slide(index);
            })

            self.bulletList.push($thisBullet);
            self.$bulletsWrap.append($thisBullet);

            if (index == 0) {
                $thisBullet.addClass('active');
                self.activeBullet = $thisBullet;
            }
        })(i);

    }

    if(slideCount == 2) {
        self.bulletList = self.bulletList.concat(self.bulletList);
    }
};

ImageSlider.prototype.goToBullet = function goToBullet(index, element) {
    var self = this;

    self.activeBullet.removeClass('active');

    self.activeBullet = self.bulletList[index].addClass('active');
};


return app.ImageSlider = ImageSlider;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);




 ;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */


/*
 * Helper Functions
 */

function getMediaQueryTest(mqString) {

    return function() {
        return Modernizr.mq(mqString);
    }
}

/*
 * Constructor
 */
var Drawer = function(el) {
    var self = this instanceof Drawer
             ? this
             : Object.create(Drawer.prototype);
    self.el = el;
    self.$el = dojo.query(el);

    self.initialize();
    return self;
};

Drawer.prototype.initialize = function initialize() {

    var self = this;

    // Store toggle and content element for event binding
    self.$toggle = self.$el.children('.drawer-toggle');
    //self.$siblings = self.$el.siblings('[data-module-type="Drawer"]');
    self.activeClass = 'active';

    // The only drawer-type currently is 'Accordion', which is one of the 2 conditions
    // for enabling Accordion functionality
    if(dojo.hasAttr(self.el, 'data-drawer-type')) {
        self.drawerType = self.$el.attr('data-drawer-type').toString().toLowerCase();
    } else {
        self.drawerType = null;
    }

    // 'data-accordion-mq' is the 2nd condition for enabling the Accordion
    // functionality if provided.
    // This is only used by the Utility dropdowns because they need to behave like
    // Accordions in desktop but not in mobile break-point.
    if(dojo.hasAttr(self.el, 'data-accordion-mq')) {
        var mqString = self.$el.attr('data-accordion-mq').toString();

        self.accordionMq = function() {
            return Modernizr.mq(mqString);
        }

    } else {
        self.accordionMq = function(){
            return true;
        };
    }

    self.bindEvents();
};

Drawer.prototype.bindEvents = function bindEvents() {
    var self = this;

    // Bind "onclick" event to toggle with a callback to add a class to
    // trigger CSS changes for active state.
    // This can be used by multiple modules with different CSS for active states.
    self.$toggle.connect('onclick', self, self.toggleDrawer);
};

Drawer.prototype.toggleDrawer = function toggleDrawer() {
    var self = this
        activeClass = self.activeClass;

 // Lazy load our DOM collection
    if(!self.$siblings){
        self.$siblings = self.$el.siblings('[data-module-type="Drawer"]'); 
    }
    
    if(self.drawerType === 'accordion' && self.accordionMq()) {
        //self.$siblings.filter('.' + activeClass).removeClass(activeClass);
    	self.$siblings.removeClass(activeClass);
    }
    self.$el.toggleClass(activeClass);
};



return app.Drawer = Drawer;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);
 


;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */

function showToTop () {
    var self = this;
    
    if(-dojo.position(dojo.body()).y > self.scrollLimit) {
        self.$toTop.addClass('active');
        self.onscrollHandler = hideToTop;
    }
}

function hideToTop () {
    var self = this;
    if(-dojo.position(dojo.body()).y <= self.scrollLimit) {
        self.$toTop.removeClass('active');
        self.onscrollHandler = showToTop;
    }
}

/*
 * Helper Functions
 */


/*
 * Constructor
 */
var LandingNav = function(el) {
    var self = this instanceof LandingNav
             ? this
             : Object.create(LandingNav.prototype);
    self.el = el;
    self.$el = dojo.query(el);
    self.initialize();
    return self;
};

LandingNav.prototype.initialize = function initialize() {
    var self = this;

    self.activeClass = 'active';
    self.$toTop = self.$el.query('#back-top');

    self.$subAccordions = self.$el.query('.landing-subnav-accordion');
    self.$contentToggles = self.$subAccordions.children('.drawer-toggle');
    self.$landingLayout = dojo.query('#landing-layout');
    self.$landingHead = self.$landingLayout.query('.landing-head');
    self.$contentBlocks = self.$landingLayout.query('.landing-content');
    

    // This is used for keeping track of the active content/toggle index
    self.activeContentIndex = 0;

    self.onscrollHandler = showToTop;
    self.bindEvents();

    

    if(self.$subAccordions.length > 0) {
        // Check for 'landingContent' query string parameter
        self.parseQueryParam();
    } else {
        // If there are no sub level toggle, just show the first and only content
        // block.
        self.$contentBlocks.at(0).addClass(self.activeClass);
    }

    // show the content header
    self.$landingHead.style('display', 'block');


    // set scroll limit after the right navigation drawer is expanded
    // in order to get the right scroll value.
    self.setScrollLimit();
};


LandingNav.prototype.bindEvents = function bindEvents() {
    var self = this;

    dojo.connect(window, 'onscroll', app.throttle(function () {
        self.onscrollHandler();
    }, 200));
    dojo.connect(window, 'onscroll', app.throttle(function () {
        self.setScrollLimit();
    }, 1000));

    // Attach click event for each 3rd level accordion toggles
    // pass in new context with necessary properties
    self.$contentToggles.forEach(function (node, index, array) {
        var $node = dojo.query(node),
            newContext = {
                'self'  : self,
                'index' : index,
                'node'  : node,
                '$node' : $node
            };

        $node.connect('onclick', newContext, self.clickHandler);
    });

    // update scroll limit since the hight of the container is changed
    // using delegate to ensure it fires after the click event for Drawer and Accordion
    self.$el.delegate('.drawer-toggle', 'onclick', dojo.hitch(self, self.setScrollLimit));
        
};

// show the corrct landing page content block when 3rd level accordion toggle is clicked
LandingNav.prototype.clickHandler = function clickHandler(event) {
    var self = this.self,
        index = this.index;
    
    // only continue if the index of the toggle is not the active one
    if (self.activeContentIndex != index) {
        self.showContent(index, this.$node, this.node);
    }
};

// show the content based on the index value passed in
LandingNav.prototype.showContent = function showContent(toggleIndex, $toggleNode, toggleNode) {
    var self = this,
        index = toggleIndex || 0,
        $node = $toggleNode || self.$contentToggles.at(index),
        node = toggleNode || $node[0],
        titleText;

    if (dojo.hasAttr(node, 'data-content-title')) {
        titleText = $node.attr('data-content-title');
    } else {
        titleText = $node.text();
    }

    self.$contentBlocks.at(self.activeContentIndex).removeClass(self.activeClass);
    self.$contentBlocks.at(index).addClass(self.activeClass);
    self.activeContentIndex = index;

    if(titleText[0]){
    	self.$landingHead.text(titleText); }
};

LandingNav.prototype.setScrollLimit = function setScrollLimit() {
    var self = this;
    self.scrollLimit = dojo.position(self.el, true).y + parseInt(self.$el.style('height'));

};

// toggles the right content block via a query string parameter of 'landingContent' if exist
LandingNav.prototype.parseQueryParam = function parseQueryParam() {
    var self = this,
        query = location.search.substr(1),
        data = query.split("&"),
        hash = window.location.hash;

    // set hash to empty string so it would work when we set it below.
    window.location.hash = '';

    // loop throught the paremeters and look for 'landingContent'
    for( var i=0; i<data.length; i++ ) {
        var item = data[i].split("="),
            targetIndex = parseInt(item[1]);

        if (item[0] == 'landingContent' && (typeof targetIndex).toLowerCase() == 'number') {
            // if match, expand and collapse the appropriate accordion drawers,
            // and show the right content block.
            // Then exit this function
            self.$subAccordions.at(self.activeContentIndex).removeClass(self.activeClass);
            self.$subAccordions.at(targetIndex).addClass(self.activeClass);
            self.showContent(targetIndex);
            window.location.hash = hash;
            return;
        }
    }

    // If 'landingContent' query param doesn't exist, toggle the first item/content block
    self.$subAccordions.at(0).addClass(self.activeClass);
    self.showContent(0);
    window.location.hash = hash;
};



return app.LandingNav = LandingNav;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);





;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */


/*
 * Helper Functions
 */


/*
 * Constructor
 */
var QuickLink = function(el) {
    var self = this instanceof QuickLink
             ? this
             : Object.create(QuickLink.prototype);
    self.el = el;
    self.$el = dojo.query(el);

    self.initialize();
    return self;
};

QuickLink.prototype.initialize = function initialize() {
    var self = this;

    self.activeClass = 'active';
    self.touchActiveClass = 'touch-active';
    self.$links = self.$el.query('.quick-link');

    self.inTimer = null;
    self.outTimer = null;
    self.delay = 500;

    self.bindEvents();
};

QuickLink.prototype.bindEvents = function bindEvents() {
    var self = this;

    self.$links.forEach(function(node) {
        var $node = dojo.query(node),
            newContext = {
                'module'    : self,
                'node'      : node,
                '$node'     : $node
            };

        
        // Bind event base on touch support
        if(Modernizr.touch) {
            $node.connect('onclick', newContext, self.clickHandler);
        } else {
            $node.connect('onmouseover', newContext, self.mouseoverHandler);
            $node.connect('onmouseout', newContext, self.mouseoutHandler);
        }


    });

};


// Create method base on touch support
if(Modernizr.touch) {

    // Use click event instead of hover events to toggle quicklink drawer on touch device.
    QuickLink.prototype.clickHandler = function clickHandler(event) {
        var self = this.module,
            $node = this.$node;

        $node.siblings('.' + self.activeClass).removeClass(self.activeClass);
        $node.toggleClass(self.activeClass);
    };

} else {

    QuickLink.prototype.openQuicklink = function openQuicklink($node) {
        var self = this;
        $node.siblings('.' + self.activeClass).removeClass(self.activeClass);
        $node.addClass(self.activeClass);
    };

    QuickLink.prototype.closeQuicklink = function closeQuicklink($node) {
        var self = this;
        $node.removeClass(self.activeClass);
    };

    QuickLink.prototype.mouseoverHandler = function mouseoverHandler(event) {
        var self = this.module,
            node = this.node,
            $node = this.$node;

            clearTimeout(self.inTimer);
            clearTimeout(self.outTimer);
            self.inTimer = setTimeout(function () {
                self.openQuicklink($node);
            }, self.delay);

    };

    QuickLink.prototype.mouseoutHandler = function mouseoutHandler(event) {
        var self = this.module,
            $node = this.$node;

        self.outTimer = setTimeout(function () {
            self.closeQuicklink($node);
        }, self.delay);
        
    };
}






return app.QuickLink = QuickLink;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);





;(function (window, document, dojo, undefined) {

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */


/*
 * Helper Functions
 */


/*
 * Constructor
 */
var MessageBar = function(el) {
    var self = this instanceof MessageBar
             ? this
             : Object.create(MessageBar.prototype);
    self.el = el;
    self.$el = dojo.query(el);

    // Store toggle and content element for event binding
    self.$toggle = self.$el.query('.drawer-toggle');
    self.$content = self.$el.query('.drawer-content');
    self.activeClass = 'active';

    self.initialize();
    return self;
};

MessageBar.prototype.initialize = function initialize() {
    var self = this;

    // Bind "onclick" event to toggle with a callback to add a class to
    // trigger CSS changes for active state.
    // This can be used by multiple modules with different CSS for active states.
    self.$toggle.connect('onclick', self, self.toggleMessageBar);
};

MessageBar.prototype.toggleMessageBar = function toggleMessageBar() {
    var self = this;
    /* Tulio - Create a cookie so that we know that the user closed the messages  */
    cmManager.writeSessionCookie();
    self.$el.toggleClass(self.activeClass);
};

return app.MessageBar = MessageBar;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);

;(function (window, document, dojo, undefined) {

dojo.require("dijit.Dialog");

var app = this;
// -----------------------------------------------------------------------------

/*
 * Default Variables
 */

// Define methods cooresponse to the value of "data-modal-action" attribute
var modalActions = {
    'close' : function() {
        app.$modal.hide();
    }
}

/*
 * Helper Functions
 */

function createModal(module) {
    var self = module,
        options = {
            'draggable' : false,
            'id'        : self.modalId,
            'showTitle' : false,
			'errorMessage' : 'Your session has expired.  Plese <a href="#" onclick="location.reload();">log out</a> and log in again',
            'onShow'    : function () {
                // disconnect onscroll and onresize event for the modal
                // to prevent it from re-positioning.
                dojo.disconnect(self.$modal._modalconnects[0]);
                dojo.disconnect(self.$modal._modalconnects[1]);
            },
            'onLoad'   : dojo.hitch(self, self.loadHandler),
            'onHide'  : dojo.hitch(self, self.closeHandler),
			'onDownloadError' : dojo.hitch(self, self.downLoadErrorHandler),
			'onContentError' : dojo.hitch(self, self.contentErrorHandler),
			'onError' : dojo.hitch(self, self.errorHandler)
        };

    var $modal = new dijit.Dialog(options);

    // self.$modal.set(options);
    $modal.closeButtonNode.innerText = 'Close';

    dojo.connect($modal, '_position', function () {
        var modalSize = dojo._getMarginSize($modal.domNode),
            viewport = dojo.window.getBox(),
            topOffset;

        // Checking to see if the modal is bigger than the viewport
        // If so we adjust the vertical offset.
        if (viewport.h < modalSize.h) {
            topOffset = dojo.position(dojo.body()).y + 100;

            // Make sure not to use a negative offset
            topOffset = (topOffset >= 0 ? topOffset : 10) + 'px';

            dojo.style(self.$modal.domNode, {
                top: topOffset
            })

        }
        
        // fix for resizing #main-content when modal is visible
        // var maincontent = document.getElementById('main-content');
        // var maincontentSize = dojo._getMarginSize(maincontent);

        // if (modalSize.h > maincontentSize.h) {
        //     var modalOffset = Math.floor(modalSize.h - maincontentSize.h);

        //     dojo.style(maincontent, {
        //         height: maincontentSize.h + modalOffset + 50 + 'px'
        //     })
        // }
        // end #main-content fix
    })

    // calling dojo.publish('modalClose') would close the modal.
    dojo.subscribe('modalClose', modalActions['close']);

    // bind onclick event on modal background to modal close method.
    //dojo.query(dojo.body()).delegate('.dijitDialogUnderlayWrapper', 'onclick', modalActions['close']);

    bindModalActions();

    return app.$modal = $modal;
}

// Bind onclick event to elements that has the "data-modal-action" attribute
function bindModalActions() {
    dojo.query(dojo.body()).delegate('[data-modal-action]', 'onclick', routeActions);
}

// Route the event to the appropriate method defined in the "modalActions" object
// based on the value of the "data-modal-action" attribute
function routeActions(event) {
    var $this = dojo.query(this),
        actionType = $this.attr('data-modal-action');

    if (actionType in modalActions) {
        modalActions[actionType]();
    }
}



/*
 * Constructor
 */
var Modal = function(el) {
    var self = this instanceof Modal
             ? this
             : Object.create(Modal.prototype);
    self.el = el;
    self.$el = dojo.query(el);
    self.initialize();

    return self;
};

Modal.prototype.initialize = function initialize() {

    var self    = this;

    self.modalId = 'login-modals';

    dojo.addOnLoad(function () {
        self.$modal = app.$modal || createModal(self);


        self.$modalNode = dojo.query(self.$modal.domNode);
        self.modalUrl = self.$el.attr('data-modal-url');
        self.bindEvents();
    });
    
};
/* Tulio  */
Modal.prototype.loadHandler = function loadHandler(event) {
    // At this point element within the modal should have been completely loaded.

    // This should log the login-modal-header within the modal correctly

    var self = this;

	if(self.modalUrl[0].indexOf("profile") > 0){
	  	 //ProfileManager.getUserData(); 
		//add the js module (selfexecutalbe) file dynamically -- pass the name of the js and an id.
		if($("jsUserProfileAdmin") == null){
			addJsScript(StorageManager.getSessionStoredData('portalContext') + "/shared/js/userProfileManager.js", "jsUserProfileAdmin");
			
		} else {
			ProfileManager.recall();
		}
	}
	else if(self.modalUrl[0].indexOf("password") > 0){
		//add the js module (selfexecutalbe) file dynamically -- pass the name of the js and an id.
		if($("jsPassword") == null){
			//var tulio = StorageManager.getSessionStoredData('portalContext');
			addJsScript(StorageManager.getSessionStoredData('portalContext') + "/shared/js/updatePasswordManager.js", "jsPassword");
		} 
	}
	
	else if ( self.$modalNode.query('.BrightcoveExperience').length > 0 ) {
		
		try{
			 var videoId = $("txtVideoId").value;
			 var playerKey = CB_bcove[$("txtVideoAcct").value];
			 
			 if(videoId){
				 var params = document.getElementsByTagName('param');

				 for ( var i = 0; i < params.length; i++ ){
					 if ( params[i].name == '@videoPlayer' ){
						 params[i].setAttribute('value', videoId);
					 } else if ( params[i].name == 'playerKey' ){
						 params[i].setAttribute('value', playerKey);
					 }
				 }			 
				 //console.log('video id:'+videoId+ ' playerId: ' + playerKey);
			 }
			 
			 brightcove.createExperiences();
		
		} catch (e){
			console.log(e);
		}

   }
   
   /* App specific code executed when Opening a modal window  */
   CB.doModalAppLoadHandler(self);
   
   self.$modal.layout();
};
/* Tulio  */
Modal.prototype.closeHandler = function closeHandler(event) {
	var self    = this;
	try {
		if ( self.$modalNode.query('.BrightcoveExperience').length > 0 ) {
			var player = brightcove.api.getExperience("myExperience");
			videoPlayer = player.getModule(brightcove.api.modules.APIModules.VIDEO_PLAYER);
			videoPlayer.pause(true);
		}
		
		/* App specific code executed when closing a modal window  */
		CB.doModalAppCloseHandler(self);
		
	} catch (err){
		console.log('Error pausing video player');
	}
	 
};
Modal.prototype.downLoadErrorHandler = function downLoadErrorHandler(error) {
	//var self    = this;
	try {
		console.log('Error opening the window.  Modal.errorHandler invoked. ' + error);
		location.reload();
	} catch (err){
		console.log('tbd');
	} 
};
Modal.prototype.contentErrorHandler = function contentErrorHandler(error) {
	//var self    = this;
	try {
		console.log('Error opening the window.  Modal.contentErrorHandler invoked. ' + error);
	} catch (err){
		console.log('tbd');
	} 
};
Modal.prototype.errorHandler = function errorHandler(error) {
	//var self    = this;
	try {
		console.log('Error opening the window.  Modal.errorHandler invoked. ' + error);
	} catch (err){
		console.log('tbd');
	}  
};

Modal.prototype.bindEvents = function bindEvents() {

    var self = this;

    self.$el.connect('onclick', self, self.clickHandler);
};

Modal.prototype.clickHandler = function clickHandler(event) {
    var self = this;
	
    if ( Modernizr.mq('(max-width: 767px)') ) {
		try{
			if(self.modalUrl[0].indexOf("video-player-modal") > -1){
				var videoId = $("txtVideoId").value;
				var playerType = $("txtVideoAcct").value;
				CookieManager.writeSessionCookie('mobile-video-params', videoId + "," + playerType);
			 }
		}catch(e){
			console.log(e);
		}
        return false;
    }
    event.preventDefault();


    // set onLoad callback to the loadHandler of current instance to ensure
    // the onLoad callback has the right context.
    self.$modal.set('onLoad', dojo.hitch(self, self.loadHandler));

    self.$modal.set('href', self.modalUrl);
    self.$modal.show();
};



return app.Modal = Modal;

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);














;(function (window, document, dojo, undefined) {


dojo.require("dojo.NodeList-manipulate");
dojo.require("dojo.NodeList-traverse");
dojo.require("dojox.NodeList.delegate");

var app = this;
// -----------------------------------------------------------------------------

// configs and 3rd-party libs to be initialized BEFORE app modules are loaded
var beforeModules = function beforeModules() {
	/* this is called as part of the UI framework */
	app.breakpoints = {
        tablet: 620,
        desktop: 940,
        huge: 1260
    };
	/* this is for each individual application */
    CB.doBeforeModulesLoadWork();
};

// configs and 3rd-party libs to be initialized AFTER app modules are loaded
var afterModules = function afterModules() {
	
	/* this is called as part of the UI framework */
    app.fastclick = new FastClick(document.body);
    
    /* this is for each individual application */
    CB.doAfterModulesLoadWork();

};


/**
 * Bootstrap the app, and initialize the appropriate modules.
 *
 * @return {Object} app
 */
app.start = function __start__() {
    console.log('...app.start');

    beforeModules();

    // Instantiate all modules
    var moduleElements = dojo.query('[data-module-type]');
    moduleElements.forEach(function (node) {
        app.createModule(node);
    });

    afterModules();

    // Overwrite the start function so that it cannot be called again.
    // If it is called again, log the attempt to console.
    app.start = function () {
        if (console && console.trace) console.trace();
        console.log('Warning: Attempting to run start function more than once!');
    };

    return app;
};

// -----------------------------------------------------------------------------
}).call(window.CHBB = window.CHBB || {}, window, document, dojo);








// -----------------------------------------------------------------------------

dojo.ready(CHBB.start);




(function (window, document, undefined) {

    function performance () {
        var t = performance && performance.timing;
        if (t) {
            console.log('___ URI downloaded in', t.responseEnd - t.navigationStart, 'ms.');
            console.log('___ DOM loaded in    ', t.domComplete - t.domLoading, 'ms.');
            setTimeout(function () {
                console.log('___ Total loadtime   ', t.loadEventEnd - t.navigationStart, 'ms.');
            },0);
        }
    }

    if (!window.addEventListener) {
        window.attachEvent('load', performance);
    } else {
        window.addEventListener('load', performance, false);
    }

})(window, document);


//======================================================================================


/**
 * Description
 *
 * @param  {String} id    A specific element ID
 * @return {Object}       HTML element
 */
var endPointMap = new Object();
endPointMap["localhost"] ="https://www-ut.chubb.com/atChubbContent";
endPointMap["www-ut.chubb.com"] ="https://www-ut.chubb.com/atChubbContent";
endPointMap["www-it.chubb.com"] ="https://www-ut.chubb.com/atChubbContent";
endPointMap["www-st.chubb.com"] ="https://www-st.chubb.com/atChubbContent";
endPointMap["www-ps.chubb.com"] ="https://www-ps.chubb.com/atChubbContent";
endPointMap["www.chubb.com"] ="https://www.chubb.com/atChubbContent";


/**
 * Description
 *
 * @param  {String} id    A specific element ID
 * @return {Object}       HTML element
 */
var cmManager = {
	loadContent: function(){
		dojo.xhrGet({
				url: "TBD",
				handleAs: "json",
				load: cmManager.processReply
			}); 
	},
	processReply: function(response, processNews, showAllNews){
		
		var cm_items = response.items;

		try{
			var filteredItems = [];
			//cm_items.sort(comp);
			var _userCategories = $("txtUserType").value;
			if (_userCategories != ""){
				dojo.forEach(cm_items, function(item, i){
					var _userRoles = item.user_roles;
					var flag = false;
					  dojo.forEach(_userRoles, function(role, y) {
						  if(_userCategories.indexOf(role) > 0){
					       	  flag = true;
					       }
		                });
					  if(flag){
						  filteredItems.push(item);
					  }
				});
			}
			
			if(filteredItems.length > 0){  cm_items = filteredItems; }
			
			/* check for server side message */
			

	
			try{
				var uiMsg = $("txtUiMsg").value;
				if(uiMsg){
					var msgItem = {};
					msgItem.id = "00001";
					msgItem.item_type = "notice";
					
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth()+1; //January is 0!

					var yyyy = today.getFullYear();
					if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm} today = mm+'/'+dd+'/'+yyyy;
					msgItem.publish_date = today;
					
					msgItem.display_title = "IMPORTANT";
					msgItem.text = uiMsg;
					
					cm_items.push(msgItem);
				}
				
			} catch (e){
				console.log('Error adding a ui message');
			}
			
			/* sort itesm by date */
			cm_items.sort(comp);
			
		} catch (e){
			console.log('Exception filtering array');
		}

		if(processNews){
			var newsCount = 0;
			dojo.forEach(cm_items, function(item, i){
				if(item.item_type === "news_attachment" || item.item_type === "news_link"){
					newsCount++;
					var newsHolder = "news1";
					/*if (i%2 == 0){
						newsHolder = "news2";
					} */
					var link;
					if(typeof item.External_Link != 'undefined'){
						link = item.External_Link;
					} else {
						var env = $('txtEnv').value;
						link = endPointMap[env] + item.file_upload;
						//link = "https://www-ut.chubb.com/atChubbContent" + item.file_upload;
					}
					
					if(showAllNews){
						dojo.place("<li class='news-item'><a href='"+link+"' class='news' id='"+item.id+"' target='_blank' onclick='return jsPageManager.processClick(this);'>"+item.display_title+"</a> <span class='news-date'>"+item.publish_date+"</span></li>", newsHolder);
					}else {
						if(newsCount < 5){
							dojo.place("<li class='news-item'><a href='"+link+"' class='news' id='"+item.id+"' target='_blank' onclick='return jsPageManager.processClick(this);'>"+item.display_title+"</a> <span class='news-date'>"+item.publish_date+"</span></li>", newsHolder);
						} else {
							$("view-all-news-link").style.display = 'block';
						}
					} 
				}
			});
		}
		
		var messages = 0;
		
		dojo.forEach(cm_items, function(item, i){
			if(item.item_type === "notice"){
				messages++;
				
				dojo.place("<p class='message last'><span class='date'>"+item.publish_date+"</span><b>"+item.display_title+": </b>"+item.text+"</p>", "importantMsgs");
			}
		});
		
		/*  Open messages drawer if a message exist -- don't display it if user closed the drawer */
		if(messages > 0){
			$("message-count").innerHTML = messages;   /* shows total number of messages */
			$("message-bar").style.display = "block";   /* shows the little widget to open/close the messages section  */
			$("message-bar-toggle").style.display = "block"; /* MOBILE ONLY -- shows an envelope icon with total number of messages */
			
			var cookieCheck = cmManager.getCookieValue("closeMsgs");
			if (cookieCheck != 'y'){
				$("message-bar").className = "drawer-ui active";
				$("message-bar-bottom").style.display = "block";
				$("message-bar-bottom").className = "drawer-ui active";
			}
		}
		
	},
	getCookieValue: function (cookieName) {
		var exp = new RegExp (escape(cookieName) + "=([^;]+)");
		if (exp.test (document.cookie + ";")) {
			exp.exec (document.cookie + ";");
			//alert( unescape(RegExp.$1));
			return unescape(RegExp.$1);
		}
			else return false;
	},

	writeSessionCookie: function () {
		var cookieName, cookieValue;
		//cookieName = document.getElementById("txtCookieName").value;
		cookieName = "closeMsgs"
		//cookieValue = document.getElementById("txtCookieValue").value;
		cookieValue = "y";
		document.cookie = escape(cookieName) + "=" + escape(cookieValue) + "; path=/";
		return false;
	}
};
/**
 * Description
 *
 * @param  {String} id    A specific element ID
 * @return {Object}       HTML element
 */




/**
 * Get the Rx content for news and messages via JsonP
 */
var getCmData = function (){
	try {
		var d = new Date();
		var nocache = d.getTime();
		//var env = $('txtEnv').value;
		var url = endPointMap[window.location.hostname]+ '/jsondoc/atChubbMessages.js?' + nocache; // URL of the external script
		//var url = '/AtChubb/js/test-data/atChubbMessages.js?'+nocache; 
		var script = document.createElement('script');
		script.setAttribute('src', url);
		document.getElementsByTagName('head')[0].appendChild(script); 
		console.log('1. Important Messages Loaded from Rx');
	} catch (e) {
		console.log('Error Getting Important Messages');
	}

		
};

/**
 * Shorthand for document.getElementById()
 *
 * @param  {String} id    A specific element ID
 * @return {Object}       HTML element
 */
$ = function (id) {
	
	try {
		return document.getElementById(id);
	} catch (e) {
		console.log("Error getting an instance of obj with id= " + id)
	}
	
};

function comp(b, a) {
	return new Date(a.publish_date).getTime() - new Date(b.publish_date).getTime();
}

/**
 * Dynamically add a JS file
 */
var addJsScript = function (scriptName, scriptId){
	
	try {

			var d = new Date();
			var nocache = d.getTime();
	
			var script = document.createElement('script');
			script.setAttribute('type', 'text/javascript');
			script.setAttribute('id', scriptId);
			script.setAttribute('src', scriptName);
			document.getElementsByTagName('head')[0].appendChild(script);

	} catch (e) {
		console.log('');
	}

		
};

