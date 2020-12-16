/**
 * 
 */

var roomPlList = function() {
	
	// 지점 가져오기
	$.ajax({
		
		url : '/servletTest2/Room_pl.do',
		type : 'get',
		dataType : 'json',
		success : function(res) {
			
			code = '<select id="">';
			$.each(res, function(i, v) {
				code += '<option name = "'+ v.room_pl +'" value="'+ v.room_pl +'">'+ v.room_pl +'</option>';
			})
			
			code += '</select>';
			
			alert(res.sw);
			
			$('#room_pl').append(code);
			
		},
		error : function(xhr) {
			
			alert("상태 : " + xhr.stauts)
		}
		
	})
	
}




