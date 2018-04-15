/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlInputHidden;

/**
 * @author npgm56l
 *
 */
public class Index extends PageCodeBase {

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