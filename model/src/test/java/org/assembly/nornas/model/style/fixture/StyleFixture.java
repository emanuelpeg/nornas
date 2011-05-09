/**
 * 
 */
package org.assembly.nornas.model.style.fixture;

import org.assembly.nornas.model.style.Style;

/**
 * @author emanuel
 * 
 *         Fixture of Style
 * 
 */
public class StyleFixture {

	public static Style createStyleGreen() {
		String css = "body {"
				+ " margin: 0;"
				+ "padding: 0;"
				+ "background: #FFFFFF url(images/img05.jpg) no-repeat right bottom;"
				+ "font-family: Arial, Helvetica, sans-serif;"
				+ "font-size: 13px;" + "color: #3B3B3B;" + "}" + ""
				+ "h1, h2, h3 {" + "margin: 0;" + "padding: 0;"
				+ "font-family: Georgia, 'Times New Roman', Times, serif;"
				+ "font-weight: normal;" + "color: #000000;" + "}" + ""
				+ "	h1 {" + "font-size: 2em;" + "}" + "" + "h2 {"
				+ "font-size: 2.4em;" + "}" + "" + "h3 {" + "font-size: 1.6em;"
				+ "}" + "" + "p, ul, ol {" + "margin-top: 0;"
				+ "line-height: 180%;" + "} ";
		Style styleGreen = new Style(css);
		return styleGreen;
	}

}
