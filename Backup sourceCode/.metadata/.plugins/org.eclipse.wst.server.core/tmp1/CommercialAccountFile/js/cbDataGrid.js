 var CBgrid = function (data, gridMapper, gridId) {
  var self = this;
  self.data = data;
  self.lastSortedCol = "";
  self.domMapper = gridMapper;
  self.gridId = gridId;
  
  self.domMapper(this.data);
   var _gridQueryString = '#' + this.gridId + " thead a";
   //var tulio = dojo.query(_gridQueryString);

   dojo.query(_gridQueryString).connect('onclick', function(){ 
	  return self.columnSort(this);
	});
  
  

};
CBgrid.prototype.columnSort = function(column) {
	if (column.getAttribute('data-column-name') !== null){
		var json_column = column.getAttribute('data-column-name');
		var sortMethod = column.getAttribute('data-sort-method');
		console.log('Column Name:= ' + column.innerHTML + '. JSON column name= ' + json_column);

		//determines method of sort based on a data-sort-method attribute in html files
		//However, this requires manually adding attribute to all tables in html
		if (sortMethod == "num"){
			this.Sort(json_column, (parseInt));
		} else if (sortMethod == "alpha"){
			//-1 to reverse sort order. Right now, ints and alpha sort in opposite orders
			//multiplying either by -1 fixes this
			this.Sort(json_column, -1 * function(a){ return a.toUpperCase(); });
		}

//	    shortenText();
		
		//change arrows look
		var _gridQueryString = '#' + this.gridId + " thead a";
		dojo.query(_gridQueryString).forEach(function(node){
			if(column.innerHTML !== node.innerHTML){
				node.className = ''; 
			}
		});
		
		if(column.className !== 'sort-arrows-ascending'){
			column.className = 'sort-arrows-ascending';
		} else {
			column.className = 'sort-arrows-descending';
		}
	}
	return true;
};
CBgrid.prototype.Sort = function(col, method) {
		//sorts a column, checking whether that column has previously been sorted
		//if the column has already been sorted, reverse is true, and column is sorted
		//in reverse, while last col is set to be empty, so it can be switched back to normal sort
		var reverse = !(col == this.lastSortedCol);
		this.lastSortedCol = reverse ? col : "";
		this.data.sort(this.SortBy(col, reverse, method)); //TULIO
		//tempOpen.sort(sort_by(col, reverse, method));
		//this.DomMapper(this.currentData);  //tulio
		this.domMapper(this.data);
};
CBgrid.prototype.SortBy = function(field, reverse, primer) {
	var key = function(x){
		return primer ? primer(x[field]) : x[field];
	};

	return function(a, b){
		var A = key(a),
			B = key(b);
		return ((A < B) ? -1 : ((A > B) ? 1 : 0)) * [-1, 1][+ !! reverse];
	};
};
