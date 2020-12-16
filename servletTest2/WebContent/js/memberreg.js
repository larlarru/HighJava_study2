/**
 * 
 */

function idcheck() {
	
	idvalue = $('#id').val().trim();
	
	// 공백 체크
	if(idvalue.length < 1){
		alert("아이디입력");
		
		return false;
	}
	
	// 아이디 길이 4 ~ 8
	if(idvalue.length < 4 || idvalue.length > 8) {
		
		alert("아이디 4 ~ 8사이");
		return false;
	}
	
	// 아이디 정규식 - 소문자로 시작하고 대문자와 숫자로 조합
	idreg = /^[a-z][a-zA-Z0-9]{3,7}$/;
	if(!(idreg.test(idvalue))) {
		
		alert("아이디 형식 오류");
		return false;
	}
	
	
	return true;
	
}

function regcheck() {
	
	// 이름, 공백, 길이,  정규식
	
	// 비밀번호 - 공백, 길이, 정규식
	
	// 전화번호 - 공백 정규식
	
	// 이메일 - 공백 정규식
	
	return true;
	
}






