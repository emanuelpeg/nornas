/**
 * 
 */
package org.assembly.nornas.model.blog.fixture;

import java.util.HashSet;
import java.util.Set;

import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.style.fixture.StyleFixture;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.model.user.fixture.UserFixture;

/**
 * @author emanuel
 * 
 *         Fixture of Blog
 * 
 */
public class BlogFixture {

	public static Blog createBlogOfPedro() {
		User pedro = UserFixture.createPedro();

		Blog ablog = new Blog("pepeBlog", "El Blog de pepe", "me dicen pepe",
				pedro);

		Set<Author> authors = new HashSet<Author>();
		authors.add(new Author(pedro, ablog));
		ablog.setAuthors(authors);

		ablog.setStyle(StyleFixture.createStyleGreen());

		return ablog;
	}

	public static Blog createBlogOfEmanuel() {
		User emanuel = UserFixture.createEmanuel();

		Blog ablog = new Blog("EmanuelBlog", "El Blog de Emanuel", "alias Crespo!",
				emanuel);

		Set<Author> authors = new HashSet<Author>();
		authors.add(new Author(emanuel, ablog));
		ablog.setAuthors(authors);

		ablog.setStyle(StyleFixture.createStyleGreen());

		return ablog;
	}

}
