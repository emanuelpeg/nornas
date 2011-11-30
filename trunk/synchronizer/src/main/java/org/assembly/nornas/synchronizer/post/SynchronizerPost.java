/**
 * 
 */
package org.assembly.nornas.synchronizer.post;

import java.util.ArrayList;
import java.util.List;

import org.assembly.dto.post.PostDTO;
import org.assembly.dto.tag.TagDTO;
import org.assembly.nornas.model.author.Author;
import org.assembly.nornas.model.post.Post;
import org.assembly.nornas.model.tag.Tag;
import org.assembly.nornas.model.user.User;
import org.assembly.nornas.repository.author.AuthorRepository;
import org.assembly.nornas.repository.post.PostRepository;
import org.assembly.nornas.repository.tag.TagRepository;
import org.assembly.nornas.repository.user.UserRepository;
import org.assembly.nornas.synchronizer.Synchronizer;

/**
 * @author emanuel
 * 
 *  class responsible of synchronize Post with PostDTO
 *
 */
public class SynchronizerPost implements Synchronizer<PostDTO, Post>{
	
	private PostRepository postDAO;
	
	public void setPostDAO(PostRepository postDAO) {
		this.postDAO = postDAO;
	}
	
	private UserRepository userDAO;
	
	public void setUserDAO(UserRepository userDAO) {
		this.userDAO = userDAO;
	}
	
	private AuthorRepository authorDAO;
	
	public void setAuthorDAO(AuthorRepository authorDAO) {
		this.authorDAO = authorDAO;
	}
	
	private TagRepository tagDAO;
	
	public void setTagDAO(TagRepository tagDAO) {
		this.tagDAO = tagDAO;
	}

	public Post synchronize(PostDTO dto) {
		Post aPost = null;
		
		User user = userDAO.findByNick(dto.getAuthor());
		Author author = authorDAO.findByUser(user);
		
		List<Tag> tags = new ArrayList<Tag>();
		
		for(TagDTO tagDTO : dto.getTags()) {
			Tag tag = this.tagDAO.findByName(tagDTO.getName());
			if (tag == null) {
				tag = new Tag(tagDTO.getName());
				this.tagDAO.save(tag);
			 }
			tags.add(tag);
		}
		
		if (dto.getId() != null) {
			aPost = this.postDAO.findBy(dto.getId());
			
			aPost.setContent(dto.getContent());
			aPost.setTitle(dto.getTitle());
		
		} else {
			aPost = new Post(dto.getTitle(), dto.getContent(), author);
		}
		aPost.setTags(tags);
		
		return aPost;
	}

}
