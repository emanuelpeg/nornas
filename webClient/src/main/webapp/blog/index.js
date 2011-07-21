/*********************************************************************
 *                                                                   *
 *                      javascripts Utils Home                       *
 *                                                                   *
 ********************************************************************/

function addPost(urlPost, blogID) {
	var url = urlPost + blogID + "/" + initPost;
	
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

		$('#post').html("");
		div.appendTo('#post');
		div.accordion(); 
		var divFooter = $('<div/>');
		var urlCount = urlPost + "count/" + blogID ;
		
		$.getJSON(urlCount, function(data) {
			var pages = Math.round(data / countPost) + 1;
			for(var i = 0; i < 3; i++) {
				var button = $('<div/>');
				button.append(i+1).button().click(function () {
					alert(i);
				});
				divFooter.append(button);
			}
			var avg = Math.round(pages/2);
			for(var i = avg; i < avg + 3; i++) {
				var button = $('<div/>');
				button.append(i+1).button().click(function () {
					alert(i);
				});
				divFooter.append(button);
			}
			for(var i = pages - 3; i < pages; i++) {
				var button = $('<div/>');
				button.append(i+1).button().click(function () {
					alert(i);
				});
				divFooter.append(button);
			}
		});
		
		divFooter.appendTo('#post');		
	});

}