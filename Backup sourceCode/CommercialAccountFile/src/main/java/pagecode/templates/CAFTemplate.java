/**
 * 
 */
package pagecode.templates;

import pagecode.PageCodeBase;
import javax.faces.component.html.HtmlInputHidden;

/**
 * @author npgm56l
 *
 */
public class CAFTemplate extends PageCodeBase {

	protected HtmlInputHidden txtUserType;

	protected HtmlInputHidden getTxtUserType() {
		if (txtUserType == null) {
			txtUserType = (HtmlInputHidden) findComponentInRoot("txtUserType");
		}
		return txtUserType;
	}

}