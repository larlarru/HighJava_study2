

// 게시글 조회수 증가시키기
var updateBoardCnt = function() {
	
	boardNo = boardNo;
	console.log("boardNo : " + boardNo);
	
	boardCnt1 = boardCnt1;
	console.log("boardCnt1 : " + boardCnt1);
	
	boardCnt2 = boardCnt2;
	console.log("boardCnt2 : " + boardCnt2);
	
	$.ajax({
		
		url : '/webBoard/UpdateBoardCnt.do',
		type : 'post',
		data : {
			"board_no":boardNo
			},
		success : function(res) {
			
			//alert("게시글 수정" + res.sw);
			console.log("게시글 수정" + res.sw);
			boardNo = boardNo;
			boardCnt1 = Number(boardCnt1);
			boardCnt1 += 1;
			boardCnt2 = Number(boardCnt2);
			boardCnt2 += 1;
			$('#aHref_board_cnt'+boardNo).text(boardCnt1);
			$('#p1_labelboard_cnt'+boardNo).text(boardCnt2);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	})
	
}

// 검색된 게시판 리스트
var getSearchBoardList = function() {
	
	textVal = textVal;
	
	$.ajax({
		
		url : '/webBoard/getBoardAllList.do',
		type : 'post',
		data : {"board_title":textVal},
		success : function(res) {
			$('#result *').remove();
			// 게시판 출력
			code = '<div class="panel-group" id="accordion">';
		
			$.each(res, function(i, v) {
				
				code += '<div class="panel panel-default">';
				code += '<div class="panel-heading">';
				code += '<h4 class="panel-title">';
				code += '<label>No : </label>&nbsp;';
				code += '<label>'+v.board_no+'</label>&nbsp;&nbsp;&nbsp;';
				code += '<label>제목 : </label>&nbsp;';
				code += '<a id="aHrefboard_no" idx="'+v.board_no+'" data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.board_no +'">'+ v.board_title +'</a>&nbsp;&nbsp;&nbsp;';
				code += '<label>글쓴이 : </label>&nbsp;';
				code += '<label>'+v.board_writer+'</label>&nbsp;&nbsp;&nbsp;';
				code += '<label>조회수 : </label>&nbsp;';
				code += '<label id="aHref_board_cnt'+v.board_no+'">'+v.board_cnt+'</label>';
				code += '</h4>';
				code += '</div>';
				code += '<div id="collapse'+ v.board_no +'" class="panel-collapse collapse">';
				code += '<div class="panel-body">';
				code += '<p class="p1">';
				code += '<label>제목 : </label><p id="board_title'+v.board_no+'">'+ v.board_title +'</p>';
				code += '<label>작성자 : </label><p id="board_writer'+v.board_no+'">'+ v.board_writer +'</p>';
				code += '<label>내용 : </label><p id="board_content'+v.board_no+'">'+ v.board_content +'</p><br>';
				code += '<label>작성날짜 : </label><p id="board_date'+v.board_no+'">'+ v.board_date +'</p>';
				code += '<label>조회수 : </label><p id="p1_labelboard_cnt'+v.board_no+'">'+ v.board_cnt +'</p>';
				code += '</p>';

				code += '<p class="p2">';
				code += '<button id="updateBoardBtn" type="button" idx="'+ v.board_no +'" name="modify" class="action">수정</button>';
				code += '<button id="deleteBoardBtn" type="button" idx="'+ v.board_no +'" name="delete" class="action">삭제</button>';
				code += '</p>';


				code += '  </div>';
				code += '</div>';
				code += '    </div>';
			})
			
			code += '</div>';
			
			//$('#result *').remove();
			//$('#result').append(code);
			$('#result').html(code);
		},
		error : function(xhr) {
			//alert("상태 : " + xhr.status);
			alert("검색결과가 없습니다.");
			// 페이지 새로고침
			location.reload();
			
		},
		dataType : 'json'
	
	})
}

// 게시글 삭제
var deleteBoard = function() {
	
	boardNo = boardNo;
	console.log("boardNo : " + boardNo);
	
	$.ajax({
		
		url : '/webBoard/DeleteBoard.do',
		type : 'post',
		data : {
			"board_no":boardNo
			},
		success : function(res) {
			
			alert("게시글 삭제" + res.sw);
			// 페이지 새로고침
			location.reload();
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	})
	
}

// 게시글 수정 완료
var updateBoardAfter = function() {
	
	boardNo = boardNo;
	console.log("boardNo : " + boardNo);
	
	boardTitle = boardTitle;
	console.log("boardTitle : " + boardTitle);
	
	
	boardContent = boardContent;
	console.log("boardContent : " + boardContent);
	
	$.ajax({
		
		url : '/webBoard/UpdateBoard.do',
		type : 'post',
		data : {
			"board_no":boardNo,
			"board_title":boardTitle,
			"board_content":boardContent
			},
		success : function(res) {
			
			alert("게시글 수정" + res.sw);
			// 페이지 새로고침
			location.reload();
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	})
	
}

//글수정을 위한 모달창 만들기
var updateBoardBefore = function() {
	
	$('#modal_result *').remove();
	
	code ='<div id="uModal" class="modal fade" role="dialog">';
	code +='<div class="modal-dialog">';
	code +='글작성';
	code +='<div class="modal-content">';
	code +='<div class="modal-header">';
	code +='<button type="button" class="close" data-dismiss="modal">&times;</button>';
	code +='<h4 class="modal-title">글작성</h4>';
	code +='</div>';
	code +='<div class="modal-body">';
	code +='<form id="uform">';
	code +='<label>제 목</label> : <input id="uModalboard_title" type="text" name="board_title"><br>';
	code +='<label>작성자</label> : <input id="uModalboard_writer" type="text" name="board_writer" readonly ><br>';
	code +='<label>내 용</label> : <input id="uModalboard_content" type="text" name="board_content"><br>';
	code +='<br><input type="button" value="수정완료" id="updateBoardSubmitBtn"><br>';
	code +='</form>';
	code +='</div>';
	code +='<div class="modal-footer">';
	code +='<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
	code +='</div>';
	code +='</div>';
	code +='</div>';
	code +='</div>';
	
	$('#modal_result').append(code);
	
}

// 글 등록
var insertBoardAfter = function() {
	
	boardTitle = boardTitle;
	console.log("boardTitle : " + boardTitle);
	
	boardWriter = boardWriter;
	console.log("boardWriter : " + boardWriter);

	boardContent = boardContent;
	console.log("boardContent : " + boardContent);
	
	$.ajax({
		
		url : '/webBoard/InsertBoard.do',
		type : 'post',
		data : {
			"board_title":boardTitle,
			"board_writer":boardWriter,
			"board_content":boardContent
			},
		success : function(res) {
			
			alert("게시글 작성" + res.sw);
			// 페이지 새로고침
			location.reload();
			
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	})
	
}

// 글작성을 위한 모달창 만들기
var insertBoardBefore = function() {
	
	$('#modal_result *').remove();
	
	code ='<div id="cModal" class="modal fade" role="dialog">';
	code +='<div class="modal-dialog">';
	code +='글작성';
	code +='<div class="modal-content">';
	code +='<div class="modal-header">';
	code +='<button type="button" class="close" data-dismiss="modal">&times;</button>';
	code +='<h4 class="modal-title">글작성</h4>';
	code +='</div>';
	code +='<div class="modal-body">';
	code +='<form id="cform">';
	code +='<label>제 목</label> : <input id="cModalboard_title" type="text" name="board_title"><br>';
	code +='<label>작성자</label> : <input id="cModalboard_writer" type="text" name="board_writer"><br>';
	code +='<label>내 용</label> : <input id="cModalboard_content" type="text" name="board_content"><br>';
	code +='<br><input type="button" value="작성완료" id="createBoardSubmitBtn"><br>';
	code +='</form>';
	code +='</div>';
	code +='<div class="modal-footer">';
	code +='<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
	code +='</div>';
	code +='</div>';
	code +='</div>';
	code +='</div>';
	
	$('#modal_result').append(code);
	
}

// 게시판 리스트
var getAllBoardList = function() {
	
	$.ajax({
		
		url : '/webBoard/getBoardAllList.do',
		type : 'get',
		success : function(res) {
			
			//$('#result *').remove();
			
			// 게시판 출력
			code = '<div class="panel-group" id="accordion">';
			$.each(res, function(i, v) {
														
				code += '<div class="panel panel-default">';
				code += '<div class="panel-heading">';
				code += '<h4 class="panel-title">';
				code += '<label>No : </label>&nbsp;';
				code += '<label>'+v.board_no+'</label>&nbsp;&nbsp;&nbsp;';
				code += '<label>제목 : </label>&nbsp;';
				code += '<a id="aHrefboard_no" idx="'+v.board_no+'" data-toggle="collapse" data-parent="#accordion" href="#collapse'+ v.board_no +'">'+ v.board_title +'</a>&nbsp;&nbsp;&nbsp;';
				code += '<label>글쓴이 : </label>&nbsp;';
				code += '<label>'+v.board_writer+'</label>&nbsp;&nbsp;&nbsp;';
				code += '<label>조회수 : </label>&nbsp;';
				code += '<label id="aHref_board_cnt'+v.board_no+'">'+v.board_cnt+'</label>';
				code += '</h4>';
				code += '</div>';
				code += '<div id="collapse'+ v.board_no +'" class="panel-collapse collapse">';
				code += '<div class="panel-body">';
				code += '<p class="p1">';
				code += '<label>제목 : </label><p id="board_title'+v.board_no+'">'+ v.board_title +'</p>';
				code += '<label>작성자 : </label><p id="board_writer'+v.board_no+'">'+ v.board_writer +'</p>';
				code += '<label>내용 : </label><p id="board_content'+v.board_no+'">'+ v.board_content +'</p><br>';
				code += '<label>작성날짜 : </label><p id="board_date'+v.board_no+'">'+ v.board_date +'</p>';
				code += '<label>조회수 : </label><p id="p1_labelboard_cnt'+v.board_no+'">'+ v.board_cnt +'</p>';
				code += '</p>';

				code += '<p class="p2">';
				code += '<button id="updateBoardBtn" type="button" idx="'+ v.board_no +'" name="modify" class="action">수정</button>';
				code += '<button id="deleteBoardBtn" type="button" idx="'+ v.board_no +'" name="delete" class="action">삭제</button>';
				code += '</p>';


				code += '  </div>';
				code += '</div>';
				code += '    </div>';
			})
			
			code += '</div>';
			
			//$('#result *').remove();
			//$('#result').append(code);
			$('#result').html(code);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	
	})
}