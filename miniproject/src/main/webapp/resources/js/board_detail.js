$(function(){
		var cmntPstgNo = $("[name=cmntPstgNo]").val();
		
		/* 댓글 작성 */
		$(".reply-write-btn").click(function(){
			var cmntWrtCn = $("[name=cmntWrtCn]").val();
			var cmntWrtNm = $("[name=cmntWrtNm]").val();
			
			var data = {
					"cmntWrtCn" : cmntWrtCn,
					"cmntWrtNm" : cmntWrtNm,
					"cmntPstgNo" : cmntPstgNo
			};
			$.ajax({
				url: root+'/rest/board/reply-write',
				method: 'POST',
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function() {
					$("[name=cmntWrtCn]").val("");

					$.ajax({
						url: root+'/rest/board/reply-list',
						method: 'GET',
						data: {pstgNo:cmntPstgNo},
						success: function(resp) {
							var replyBox = $('<div>').addClass("reply-box");
							
							/* 댓글 내용 */
							var replyContent = $("<span>").text(resp[resp.length-1].cmntWrtCn);
							/* 작성한 사람 */
							var replyId = $("<span>").text(resp[resp.length-1].cmntWrtNm);
							/* 작성일 */
							var date = moment(resp[resp.length-1].cmntWrtYmd).format("YYYY-MM-DD HH:mm");
							/* 댓글 번호 */
							var cmntNo = resp[resp.length-1].cmntNo;
							
							var replyDate = $("<span>").text(date);
							var replyUpdateBtn = $("<button>").text("수정").addClass("reply-update-btn");
							var replyDeleteBtn = $("<button>").text("삭제").addClass("reply-delete-btn");
							
							/* 비동기 댓글 작성시 태그 추가 */
							var div = $('<div>').append(replyId);
							replyBox.append(div);
							var div2 = $('<div>').append(replyContent);
							replyBox.children("div").last().append(div2);
							var div3 = $('<div>').append(replyDate).append($("<input>").val(cmntNo).attr("type","hidden"));
							replyBox.children("div").last().append(div3);
							var div4 = $('<div>').append(replyUpdateBtn).append(replyDeleteBtn);
							replyBox.children("div").last().append(div4);
							console.log(resp.length);
							if(resp.length == 1) {
								$(".reply-box-container").append(replyBox);
							}
							else {
								$(".reply-box-container").children("div").last().after(replyBox);
							}
							
						}
					});//ajax end
					
				}
				
			});//ajax end
		});//reply-write-btn.click end
		
		/* 댓글 삭제 */
		$(document).on("click", ".reply-delete-btn", function(){
			var thisBtn = $(this);
			var cmntNo = thisBtn.parents(".reply-box").find("input").val();
			//console.log(cmntNo); //확인 완료
			//console.log(cmntPstgNo); //확인 완료
			var q = confirm("정말 삭제하시겠습니까?");
			
			if(q == true){
				$.ajax({
					url: root+"/rest/board/reply-delete",
					method: "GET",
					data: {cmntNo:cmntNo},
					success: function(){
						thisBtn.parents(".reply-box").remove();
					}
				});//ajax end
			}
			
			
		});//reply-delete-btn.click end
		
		/* 댓글 수정 */
		$(document).on("click",".reply-update-btn", function(){
			var thisBtn = $(this);
			var originalText = thisBtn.parents(".reply-box").find(".reply-content").text();
			
			//수정 버튼 클릭시textarea를 생성하고 기존 내용을 지워주고 textarea 안에 작성되어 있었던 내용을 뿌려준다
			var textarea = thisBtn.parents(".reply-box").find(".reply-content").parent().append($("<textarea>").val(originalText));
			thisBtn.parents(".reply-box").find(".reply-content").remove();
			
			//기존 수정 삭제 버튼을 제거하고 수정 완료 버튼을 신규 생성
			thisBtn.parent().children().remove();
			var updateCompleteBtn = $("<button>").text("수정 완료").addClass("update-complete-btn");
			textarea.append(updateCompleteBtn);
		});//reply-update-btn.click end
		
		/* 수정 완료 */
		//수정 완료 버튼을 누르면 해당 내용을 비동기로 update 시킨 후 다시 기존 양식으로 보이게 설정
		$(document).on("click", ".update-complete-btn", function(){
			var textarea = $(this).prev("textarea");
			var replyBtnContainer = $(this).parents(".reply-box").find(".reply-btn-container");
			//수정, 삭제 버튼 생성
			var replyUpdateBtn = $("<button>").addClass("reply-update-btn").text("수정");
			var replyDeleteBtn = $("<button>").addClass("reply-delete-btn").text("삭제");
			
			var cmntWrtCn = textarea.val();
			var cmntNo = $(this).parents(".reply-box").find("input").val();
			
			var data = {
						"cmntWrtCn":cmntWrtCn,
						"cmntNo":cmntNo
						}
			
			$.ajax({
				url: root+"/rest/board/reply-update",
				method: "post",
				contentType: "application/json",
				data: JSON.stringify(data), 
				success: function(resp){
					if(resp == true) {
						textarea.parent().append("<span>").text(cmntWrtCn);
						textarea.remove();
						replyBtnContainer.append(replyUpdateBtn).append(replyDeleteBtn);
					}
				}
			});//ajax end
		});//updateCompleteBtn.click end
		
		
		
	});