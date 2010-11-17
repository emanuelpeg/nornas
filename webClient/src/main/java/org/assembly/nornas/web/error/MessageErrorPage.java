/**
 * 
 */
package org.assembly.nornas.web.error;

import org.apache.click.Page;
import org.apache.click.util.Bindable;

/**
 * @author emanuel
 *
 */
public class MessageErrorPage extends Page {

	private static final long serialVersionUID = 2217449254650809934L;

	@Bindable 
	private String error;
	
	@Override
	public void onInit() {
		super.onInit();
		error = getContext().getRequestParameter("error");
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
