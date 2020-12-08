/**
 * 
 */

function idcheck() {
	
	idvalue = $('#id').val().trim();
	
	// 공백 체크
	if(idvalue.length < 1){
		//alert("아이디입력");
		$('#idspan').html("아이디입력").css('color', 'red');
		
		return false;
	}
	
	// 아이디 길이 4 ~ 8
	if(idvalue.length < 4 || idvalue.length > 12) {
		
		$('#idspan').html("아이디 4 ~ 12사이").css('color', 'red');
		//alert("아이디 4 ~ 12사이");
		return false;
	}
	
	// 아이디 정규식 - 소문자로 시작하고 대문자와 숫자로 조합
	idreg = /^[a-z][a-zA-Z0-9]{3,11}$/;
	if(!(idreg.test(idvalue))) {
		
		$('#idspan').html("아이디 형식 오류").css('color', 'red');
		//alert("아이디 형식 오류");
		return false;
	} else {
		$('#idspan').html("올바른 아이디 형식 입니다.").css('color', 'green');
	}
	
	
	return true;
	
}

function regcheck() {
	
	// 비밀번호 - 공백, 길이, 정규식
	vpass = $('#pwd').val().trim();
	
	if(vpass.length < 1){
		//alert("비밀번호 입력");
		$('#pwdspan').html("비밀번호 입력").css('color', 'red');
		return false;
	}
	
	// 비밀번호 길이 
	if(vpass.length < 8 || vpass.length > 12) {
		
		$('#pwdspan').html("비밀번호 8 ~ 12사이").css('color', 'red');
		return false;
	}
	
	passReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,12}$/;
	
	if(!(passReg.test(vpass))) {
		$('#pwdspan').html("올바르지 않습니다. 영문대소문자 숫자 특수문자가 하나이상씩 8~12 입력해주십시오.").css('color', 'red');
		return false;
	} else {
		$('#pwdspan').html("올바른 형식입니다.").css('color', 'green');
	}
	
	// 이름, 공백, 길이,  정규식
	vname = $('#name').val().trim();
	
	if(vname.length < 1){
		$('#namespan').html("이름 입력").css('color', 'red');
		return false;
	}
	
	// 이름 2 ~ 5
	if(vname.length < 2 || vname.length > 5) {
		
		$('#namespan').html("한글로 이름 2 ~ 5 입력해 주십시오.").css('color', 'red');
		return false;
	}
	
	nameReg = /^[가-힣]{2,5}$/;
	
	if(!(nameReg.test(vname))) {
		$('#namespan').html("올바르지 않습니다. 한글로 이름 2 ~ 5 입력해 주십시오.").css('color', 'red');
		return false;
	} else {
		$('#namespan').html("올바른 형식입니다.").css('color', 'green');
	}
	
	// 생일
	birvalue = $('#bir').val().trim();
	sub = parseInt(birvalue.substr(0,4));
	age = 2020 - sub;
	
	if(sub.length < 1) {
		$('#birspan').html("생년월일을 입력해주세요.").css('color', 'red');
		return false;
	}
	
	if(age < 10) {
		$('#birspan').html("당신의 나이는 어립니다.").css('color', 'red');
		return false;
	} else if(age >= 10) {
		$('#birspan').html("올바른 형식입니다.").css('color', 'green');
	} else {
		$('#birspan').html("올바른 형식이 아닙니다.").css('color', 'red');
	}
	
	// 성별
	genderVal = $('#gender').val();
	if(genderVal == "남") {
		$('#genderspan').html("올바른 형식입니다.(남)").css('color', 'green');
	} else if(genderVal == "여") {
		$('#genderspan').html("올바른 형식입니다.(여)").css('color', 'green');
	} else {
		$('#genderspan').html("올바른 형식이 아닙니다.").css('color', 'red');
	}
	
	
	
	// 전화번호 - 공백 정규식
	vhp = $('#hp').val().trim();
	
	// 전화번호 공백
	if(vhp < 1) {
		$('#hpspan').html("전화번호 입력").css('color', 'red');
		return false;
	}
	
	// 전화번호 정규식
	telReg = /\d{3}\d{4}\d{4}/;
	if(!(telReg.test(vhp))) {
		$('#hpspan').html("전화번호 형식 오류(3-4-4(-빼고 입력해 주십시오.))").css('color', 'red');
		return false;
	}  else {
		$('#hpspan').html("올바른 형식입니다.").css('color', 'green');
	}
	
	// 이메일 - 공백 정규식
	vemail = $('#email').val().trim();
	
	if(vemail.length < 1){
		$('#emailspan').html("이메일 입력").css('color', 'red');
		return false;
	}
	
	
	// 메일 정규식
	mailReg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z]+){1,2}$/;
	if(!(mailReg.test(vemail))) {
		$('#emailspan').html("올바르지 않습니다.").css('color', 'red');
		return false;
	} else {
		$('#emailspan').html("올바른 형식입니다.").css('color', 'green');
	}
	
	return true;
	
}






