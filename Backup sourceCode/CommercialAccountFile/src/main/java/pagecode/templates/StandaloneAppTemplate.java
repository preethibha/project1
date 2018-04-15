/**
 * 
 */
package pagecode.templates;

import pagecode.PageCodeBase;
import javax.faces.component.html.HtmlInputHidden;

/**
 * @author p6248a5
 *
 */
public class StandaloneAppTemplate extends PageCodeBase {

	protected HtmlInputHidden txtUserType;
	protected HtmlInputHidden txtUserId;

	protected HtmlInputHidden getTxtUserType() {
		if (txtUserType == null) {
			txtUserType = (HtmlInputHidden) findComponentInRoot("txtUserType");
		}
		return txtUserType;
	}

	protected HtmlInputHidden getTxtUserId() {
		if (txtUserId == null) {
			txtUserId = (HtmlInputHidden) findComponentInRoot("txtUserId");
		}
		return txtUserId;
	}

}