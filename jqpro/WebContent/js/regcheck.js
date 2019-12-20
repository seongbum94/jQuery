/**
 * 
 */
var idcheck = function(){
	
	idlen = idvalue.trim().length;
	
	if(idlen <= 0){
		alert("아이디를 입력하세요");
		return false;
	}
	
	if(idlen < 4 || idlen > 12){
		alert("아이디는 4~12 입니다.");
		return false;
	}
	
	regid = /^[a-zA-Z]+[a-zA-Z0-9]{3,11}$/

	if(!(regid.test(idvalue))){
		alert("아이디 형식 오류입니다.");
	}
	
	return true;
}

var submitcheck = function(){
	//이름
	nameval = $('#name').val();
	
	namelen = nameval.trim().length;
	
	//공백
	if(namelen <= 0){
		alert("이름을 입력하세요");
		return false;
	}
	
	//길이
	if(namelen < 2 || namelen > 5){
		alert("이름은 2 ~ 5입니다.");
		return false;
	}
	
	//정규식
	regname = /^[가-힣]{2,5}$/
	if(!(regname.test(nameval))){
		alert("이름형식 오류입니다");
		return false;
	}
	
	//비밀번호 체크
	passval = $('#pwd').val()
	passlen = passval.trim().length;
	
	//공백
	if(passlen <= 0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	//길이
	if(passlen < 4 || passlen > 10){
		alert("비밀번호는 4 ~ 10 자리로 입력하세요");
		return false;
	}
	//정규식
	regpass = /^[a-zA-Z0-9]{4,10}$/;
	
	if(!regpass.test(passval)){
		alert("비밀번호 형식 오류");
		return false;	
	}
		
	//전화번호 체크
	telval = $('#tel').val();
	tellen = telval.trim().length;
	
	//공백체크
	if(tellen <= 0){
		alert("전화번호를 입력하세요");
		return false;
	}
	
	//정규식
	regtel = /^\d{3}-\d{4}-\d{4}$/;
	if(!(regtel.test(telval))){
		alert("전화번호 형식 오류");
		return false;
	}
	
	//생년월일 형식 체크(4 2 2)
	birval = $('#birth').val();
	birlen = birval.trim().length;
	
	//공백
	if(birlen <= 0){
		alert("생년월일 입력");
		return false;
	}
	
	//정규식
	regbir = /^\d{4}-\d{1,2}-\d{1,2}$/;
	if(!(regbir.test(birval))){
		alert("생년월일 형식 오류")
		return false;
	}
	
	//이메일
	emailval = $('#email').val();
	emaillen = emailval.trim().length;
	
	if(emaillen <= 0){
		alert("이메일을 입력하세요");
		return false;
	}
	
	regemail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9]+){1,2}$/;
	if(!(regemail.test(emailval))){
		alert("이메일 형식오류");
		return false;
	}
	
	//동입력
	
	
	return true;
}

var dongcheck = function(){
	dongvalue = $('#dong').val();
	
	donglen = dongvalue.trim().length;
	
	//공백 확인
	if(donglen <= 0){
		alert("동을 입력하세요");
		return false;
	}
	
	//정규식
	regdong = /^[가-힣]+$/;
	if(!(regdong.test(dongvalue))){
		alert("동 형식 오류");
		return false;
	}
	
	return true;
}




