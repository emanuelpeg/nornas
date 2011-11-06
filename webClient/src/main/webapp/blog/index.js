/*********************************************************************
 *                                                                   *
 *                      javascripts Utils Home                       *
 *                                                                   *
 ********************************************************************/

function addPost(urlPost, blogID, tag) {
	var url = urlPost + blogID + "/" + initPost + "?tag=" + tag;
	var urlCount = urlPost + "count/" + blogID + "?tag=" + tag;
	addPostByUrl(url, urlCount, urlPost, blogID, tag);
}

function addPostByUrl(url, urlCount, urlPost, blogID, tag) {
	$.getJSON(url, function(data) {
		var div = $('<div/>');

		$.each(data, function(index, post) {
			
			var datePost = new Date(post.publishDate);
			var datePostLabel = datePost.format("fullDate");
			var divPost = $('<div id="post'+ post.id +'"></div>');
			var divHead = $('<div/>');
	
			divHead.append('<h3><a  href="#"> <span class="postTitle"> ' + post.title + '</span> by ' + post.author + ' <br/> '+datePostLabel+' </a>  </h3>');
		
			divPost.append(createPostBody(post, urlPost, blogID));
			
			div.append(divHead);
			div.append(divPost);
		});

		$('#post').empty();
		div.appendTo('#post');
		div.accordion(); 	
		div.hide();
		div.fadeIn("slow");
		addPostFooterByUrl(urlCount, urlPost, blogID, tag);
	});
}

function createPostBody(post, urlPost, blogID) {
	     
	var divBody = $('<div/>');
	
	divBody.append( $('<span class="post">' +   post.content + ' <br/> </span>'));
	
	$.each(post.tags, function(index, tag) {
		divBody.append(
				$("<div>"+tag.name+"</div>").button().click(function () {
						initPost = 0;
						addPost(urlPost, blogID, tag.name);
					}
				)
		);
	});
			
	var divComment = $('<div class="comments" />');
	$.each(post.comments, function(index, comment) {
		if (comment != null) {
			var creationDate = new Date(comment.creationDate);
			var creationDateLabel = creationDate.format("fullDate");
			
			divComment.append(' <h3 class="ui-accordion-header ui-helper-reset ui-state-active ui-corner-top">  <span class="commentTitle"> '+ creationDateLabel +' - ' + comment.author + '  </span>  </h3>');
			divComment.append(' <div class="ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active">  <div class="comment">' +   comment.content + ' </div> </div>');
		}
		
	});
	
	var divAddComment = $("<div/>");
	divAddComment.append(
			$("<div> Add Comment </div>").button().click(function () {
					$.get("addComment.htm?postId="+post.id+"&blogID="+blogID, function(data) {
						var dialog = $("<div id='addCommentDiv'> </div>");
						dialog.append(data);
						dialog.dialog({ 
							            modal: true, 
							            title : "Add Comment", 
							            height: 550, 
							            width: 790,
							            beforeClose: function(event, ui) { dialog.remove(); },
										open: function(event, ui) { $('#comment').markItUp(mySettings); } 
							           });
					});
				}
			)
	);
	
	divBody.append(divComment);
	divBody.append(divAddComment);
	
	return divBody;
}

function createPageFooter(from, to, divFooter, urlPost, blogID, tag) {
	for(var i = from; i < to; i++) {
		var buttonDiv = $('<span/>');
		var button;
		
		if (initPost == i) {
			buttonDiv.addClass("ui-button ui-widget ui-corner-all ui-button-text-only ui-state-active");
			button = $('<span/>');
			button.addClass("ui-button-text");
			button.append(i+1);
			buttonDiv.append(button);
		} else {
			button = buttonDiv.append(i+1);
			button = button.button();
			button.click(function () {
				initPost = $(this).find(".ui-button-text").html() - 1;
				addPost(urlPost, blogID, tag);
			});
		}
		
		divFooter.append(buttonDiv);
	}
}

function addPostFooterByUrl(urlCount, urlPost, blogID, tag) {
	$.getJSON(urlCount, function(data) {
	    var divFooter = $('<div/>');
	    divFooter.attr("align", "center");
		var pages = Math.ceil(data / countPost);
		var avg = Math.round(pages/2);
		
		var buttonBack = $('<span/>');
		buttonBack = buttonBack.append("&lt;&lt;");
		buttonBack = buttonBack.button();
		buttonBack.click(function () {
			if (initPost > 0) {
				initPost = initPost - 1;
				addPost(urlPost, blogID, tag);
			}
		});
		divFooter.append(buttonBack);
		
		if( pages <= 3) {
			createPageFooter(0, pages, divFooter, urlPost, blogID, tag);
		} else {
			createPageFooter(0, 3, divFooter, urlPost, blogID, tag);
		}
		if( pages > 6) {
			if (avg > 4) {
				divFooter.append($("<span> </span>"));
				if (initPost > 2 && initPost < (pages-3)) {
					createPageFooter(initPost - 1, initPost + 2, divFooter, urlPost, blogID, tag);												
				} else {
					createPageFooter(avg - 1, avg + 2, divFooter, urlPost, blogID, tag);	
				}
				divFooter.append($("<span> </span>"));
			} else {
				createPageFooter(3 , 3 + 4 - avg, divFooter, urlPost, blogID, tag);	
			}
		}
		if( pages > 3) {
			var del = (pages > 6) ? 3 : 6 - pages;
			createPageFooter(pages - del, pages, divFooter, urlPost, blogID, tag);			
		}
		var buttonNext = $('<span/>');
		buttonNext = buttonNext.append("&gt;&gt;");
		buttonNext = buttonNext.button();
		buttonNext.click(function () {
			if (initPost < pages-1) {
				initPost = initPost + 1;
				addPost(urlPost, blogID, tag);
			}
		});
		divFooter.append(buttonNext);
		divFooter.appendTo('#post');	
	});
}

function addTags(urlPost, urlTags, blogID) {
	var url = urlTags + blogID;

	$.getJSON(url, function(data) {
		var divTag = $('<div/>');

		$.each(data, function(index, tag) {
			divTag.append(
					$("<div>"+tag.name+"</div>").button().click(function () {
							initPost = 0;
							addPost(urlPost, blogID, tag.name);
						}
					)
			);
		});
		
		$('#tags').empty();
		divTag.appendTo('#tags');		
	});
}

function addHistory(urlHistory, blogID) {
	var url = urlHistory + blogID;

    $.getJSON(url, function(data) {
		var ulHistory = $('<ul/>');
	
		$.each(data.years, function(index, postYear) {
			var liYear = $("<li/>");
			liYear.append(postYear.year);
			
			var ulMonths = $("<ul/>");
			
			$.each(postYear.months, function(index, postMonth) {
				var liMonth = $("<li/>");
				liMonth.append(dateFormat.i18n.monthNames[postMonth.month-1]);
				
				var ulposts = $("<ul/>");
				$.each(postMonth.posts, function(index, post) {
					var liPost = $("<li/>");
					liPost.append(post.title);
					ulposts.append(liPost);
				});
				
				liMonth.append(ulposts);
				ulMonths.append(liMonth);
			});
			
			liYear.append(ulMonths);
			ulHistory.append(liYear);
		});
		
		
		
		ulHistory.treeview({
			collapsed: true,
			animated: "medium",
			control:"#sidetreecontrol",
			persist: "location"
		});
		
		$('#history').empty();
		ulHistory.appendTo('#history');		
	});
}

function addComment(urlAddComment, url, postID, urlPost, blogID) {
	$.post(urlAddComment, { comment: $("#comment").val()  },
			function(data) {
				$("#addCommentDiv").dialog("close");
				
				$.getJSON(url, function(post) {
					$("#post" + postID).html(createPostBody(post, urlPost, blogID));
				});
			}		        
	);
}

















