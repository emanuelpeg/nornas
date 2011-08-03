/*********************************************************************
 *                                                                   *
 *                      javascripts Utils Home                       *
 *                                                                   *
 ********************************************************************/

function addPost(urlPost, blogID) {
	var url = urlPost + blogID + "/" + initPost;
	var urlCount = urlPost + "count/" + blogID ;
	addPostByUrl(url, urlCount, urlPost, blogID);
}

function addPostByUrl(url, urlCount, urlPost, blogID) {
	$.getJSON(url, function(data) {
		var div = $('<div/>');

		$.each(data, function(index, post) {
			
			var datePost = new Date(post.publishDate);
			var datePostLabel = datePost.format("fullDate");
			
			div.append('<h3><a  href="#"> <span class="postTitle"> ' + post.title + '</span> by ' + post.author + ' <br/> '+datePostLabel+' </a>  </h3>');
			var divPost = $('<div/>').append( $('<span class="post">' +   post.content + ' <br/> </span>'));
			
			$.each(post.tags, function(index, tag) {
				divPost.append(
						$("<div>"+tag.name+"</div>").button().click(function () {
								alert(tag.name);
							}
						)
				);
			});
					
			var divComment = $('<div class="comments" />');
			$.each(post.comments, function(index, comment) {
				var creationDate = new Date(comment.creationDate);
				var creationDateLabel = creationDate.format("fullDate");
				
				divComment.append(' <h3 class="ui-accordion-header ui-helper-reset ui-state-active ui-corner-top">  <span class="commentTitle"> '+ creationDateLabel +' - ' + comment.author + '  </span>  </h3>');
				divComment.append(' <div class="ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active">  <div class="comment">' +   comment.content + ' </div> </div>');
				
			});
			
			divPost.append(divComment);
			div.append(divPost);
		});

		$('#post').empty();
		div.appendTo('#post');
		div.accordion(); 	
		div.hide();
		div.fadeIn("slow");
		addPostFooterByUrl(urlCount, urlPost, blogID);
	});
}

function createPageFooter(from, to, divFooter, urlPost, blogID) {
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
				addPost(urlPost, blogID);
			});
		}
		
		divFooter.append(buttonDiv);
	}
}

function addPostFooterByUrl(urlCount, urlPost, blogID) {
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
				addPost(urlPost, blogID);
			}
		});
		divFooter.append(buttonBack);
		
		if( pages <= 3) {
			createPageFooter(0, pages, divFooter, urlPost, blogID);
		} else {
			createPageFooter(0, 3, divFooter, urlPost, blogID);
		}
		if( pages > 6) {
			if (avg > 4) {
				divFooter.append($("<span> </span>"));
				if (initPost > 2 && initPost < (pages-3)) {
					createPageFooter(initPost - 1, initPost + 2, divFooter, urlPost, blogID);												
				} else {
					createPageFooter(avg - 1, avg + 2, divFooter, urlPost, blogID);	
				}
				divFooter.append($("<span> </span>"));
			} else {
				createPageFooter(3 , 3 + 4 - avg, divFooter, urlPost, blogID);	
			}
		}
		if( pages > 3) {
			var del = (pages > 6) ? 3 : 6 - pages;
			createPageFooter(pages - del, pages, divFooter, urlPost, blogID);			
		}
		var buttonNext = $('<span/>');
		buttonNext = buttonNext.append("&lt;&lt;");
		buttonNext = buttonNext.button();
		buttonNext.click(function () {
			if (initPost < pages-1) {
				initPost = initPost + 1;
				addPost(urlPost, blogID);
			}
		});
		divFooter.append(buttonNext);
		divFooter.appendTo('#post');	
	});
}

function addTags(urlTags, blogID) {
	var url = urlTags + blogID;

	$.getJSON(url, function(data) {
		var divTag = $('<div/>');

		$.each(data, function(index, tag) {
			divTag.append(
					$("<div>"+tag.name+"</div>").button().click(function () {
							alert(tag.name);
						}
					)
			);
		});
		
		$('#tags').empty();
		divTag.appendTo('#tags');		
	});
}

