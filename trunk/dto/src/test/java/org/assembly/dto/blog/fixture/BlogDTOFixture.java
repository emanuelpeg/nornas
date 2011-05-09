/**
 * 
 */
package org.assembly.dto.blog.fixture;

import org.assembly.dto.blog.BlogDTO;
import org.assembly.dto.style.fixture.StyleDTOFixture;
import org.assembly.dto.user.UserDTO;
import org.assembly.dto.user.fixture.UserDTOFixture;

/**
 * @author emanuel
 * 
 * Fixture of Blog
 *
 */
public class BlogDTOFixture {

	public static BlogDTO createBlogOfPedro() {
		UserDTO pedro = UserDTOFixture.createPedro();
		
		BlogDTO ablog = new BlogDTO("pepeBlog", "El Blog de pepe", "me dicen pepe", pedro);
		
		ablog.setStyle(StyleDTOFixture.createStyleGreen());
		
		return ablog;
	}

	public static BlogDTO createBlogOfEmanuel() {

	    UserDTO emanuel = UserDTOFixture.createEmanuel();
		
		BlogDTO ablog = new BlogDTO("EmanuelBlog", "El Blog de Emanuel", "alias Crespo!",
				emanuel);
		
		ablog.setStyle(StyleDTOFixture.createStyleGreen());
		
		return ablog;
	}

}
