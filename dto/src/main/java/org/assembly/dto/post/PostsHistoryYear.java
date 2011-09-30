package org.assembly.dto.post;

import java.util.ArrayList;
import java.util.List;


/**
 * @author emanuel
 * 
 *         class represents a years in tree History
 * 
 */
public class PostsHistoryYear {
	
	private Integer year; 
	
	private List<PostsHistoryMonth> months = new ArrayList<PostsHistoryMonth>();
	
	public PostsHistoryYear() {
	}
	
	public PostsHistoryYear(Integer year) {
		this.year = year;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<PostsHistoryMonth> getMonths() {
		return months;
	}

	public void setMonths(List<PostsHistoryMonth> months) {
		this.months = months;
	}
	
}
