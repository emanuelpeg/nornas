/**
 * 
 */
package org.assembly.nornas.model.comment;

import java.util.ArrayList;
import java.util.List;

import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.user.fixture.UserFixture;


/**
 * @author emanuel
 * 
 *         Fixture of Blog
 * 
 */
public class CommentFixture {

	public static List<Comment> createComments(Post post) {
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment(post,"Muy Bueno", UserFixture.createEmanuel()));
		comments.add(new Comment(post,"No me guto..", UserFixture.createJose()));
		comments.add(new Comment(post,"Muy Bueno!!", UserFixture.createPedro()));
		return comments;
	}

	

}
