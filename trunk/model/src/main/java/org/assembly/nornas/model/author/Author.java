/**
 * 
 */
package org.assembly.nornas.model.author;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.assembly.nornas.model.PersistenEntity;
import org.assembly.nornas.model.blog.Blog;
import org.assembly.nornas.model.user.User;

/**
 * @author emanuel
 * 
 *         class represents a Author
 * 
 */

public class Author extends PersistenEntity {

	private User user;

	private Set<Blog> blogs = new HashSet<Blog>();
	
	public Author(User user, Set<Blog> blogs) {
		super();
		this.user = user;
		this.blogs = blogs;
	}

	public Author(User user, Blog blog) {
		super();
		this.user = user;
		this.blogs.add(blog);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!obj.getClass().isAssignableFrom(getClass()))
			return false;

		Author otherAuthor = (Author) obj;

		return new EqualsBuilder().append(this.user, otherAuthor.getUser())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.user).toHashCode();
	}

	// is used by hibernate
	public Author() {
	}
	
}
