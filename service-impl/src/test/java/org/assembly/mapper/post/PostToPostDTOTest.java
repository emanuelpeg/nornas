/**
 * 
 */
package org.assembly.mapper.post;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.assembly.dto.comment.CommentDTO;
import org.assembly.dto.post.PostDTO;
import org.assembly.dto.tag.TagDTO;
import org.assembly.dto.user.UserDTO;
import org.assembly.mapper.DozerTest;
import org.assembly.nornas.model.comment.Comment;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.post.fixture.PostFixture;
import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.model.user.User;
import org.dozer.DozerBeanMapper;
import org.junit.Test;

/**
 * @author emanuel
 * 
 * Test of Dozer's mapping by Person
 *
 */
public class PostToPostDTOTest extends DozerTest {
	
	@Resource
	private DozerBeanMapper dtoMapper;
	
	@Test
	public void map() {
		Post post = PostFixture.createPost();
		PostDTO postDTO = this.dtoMapper.map(post, PostDTO.class, "post_postDTO");
		
		verifyPost(postDTO, post);
	}


	
	private void verifyPost(PostDTO postDTO, Post post) {
		assertEquals(postDTO.getContent(), post.getContent());
		assertEquals(postDTO.getTitle(), post.getTitle());
		assertEquals(postDTO.getAuthor(), post.getAuthor().getUser().getName());
		assertEquals(postDTO.getCommentAllow(), post.getCommentAllow());
		assertEquals(postDTO.getCreationDate(), post.getCreationDate());
		assertEquals(postDTO.getTags().size(), post.getTags().size());
		assertEquals(postDTO.getComments().size(), post.getComments().size());
		
		for(int i = 0; i<postDTO.getTags().size(); i++) {
			verificarTag(postDTO.getTags().get(i), post.getTags().get(i));			
		}
		
		for(int i = 0; i<postDTO.getComments().size(); i++) {
			verificarComment(postDTO.getComments().get(i), post.getComments().get(i));			
		}
	}

	private void verificarTag(TagDTO tagDTO, Tag tag) {
		assertEquals(tagDTO.getName(), tag.getName());		
	}

	private void verificarComment(CommentDTO commentDTO, Comment comment) {
		assertEquals(commentDTO.getAuthorized(), comment.getAuthorized());
		assertEquals(commentDTO.getContent(), comment.getContent());
		assertEquals(commentDTO.getCreationDate(), comment.getCreationDate());
		
		verifyPerson(commentDTO.getAuthor(), comment.getAuthor());
	}

	
	private void verifyPerson(UserDTO dto, User user) {
		assertEquals(dto.getName(), user.getName());
		assertEquals(dto.getNick(), user.getNick());
		assertEquals(dto.getBirthDate(), user.getBirthDate());
		assertEquals(dto.getEmails(), user.getEmails());	
	}

}
