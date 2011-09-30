package org.assembly.dto.post;

import java.util.ArrayList;
import java.util.List;


/**
 * @author emanuel
 * 
 *         class represents a root in tree History
 * 
 */
public class PostsHistoryRoot {
	
	List<PostsHistoryYear> years = new ArrayList<PostsHistoryYear>();

	public List<PostsHistoryYear> getYears() {
		return years;
	}

	public void setYears(List<PostsHistoryYear> years) {
		this.years = years;
	}
	
}
