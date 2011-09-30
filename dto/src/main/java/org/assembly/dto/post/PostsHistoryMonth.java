package org.assembly.dto.post;

import java.util.ArrayList;
import java.util.List;


/**
 * @author emanuel
 * 
 *         class represents a Month in tree History
 * 
 */
public class PostsHistoryMonth {
	
	private Integer month; 
	
	private List<PostHistoryDTO> posts = new ArrayList<PostHistoryDTO>();

	public PostsHistoryMonth() {
	}
	
	public PostsHistoryMonth(Integer month) {
		this.month = month;
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public List<PostHistoryDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostHistoryDTO> posts) {
		this.posts = posts;
	}

}
