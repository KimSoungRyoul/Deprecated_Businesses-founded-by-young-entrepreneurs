$(document).ready(function(){
	$(document).on("keyup","input[name^=busi_num]",function(){
		$(this).val($(this).val().replace(/[^0-9]/gi,""));
	});

	$("#email3").change(function(){
		$("input[name=email2]").val($(this).val());
	});
});
function AgreeChk(obj){

	if($("#agree1").is(":checked")==false){
		alert('회원가입약관에 동의 해 주세요');
		$("#agree1").focus();
		return false;
	}else if($("#agree2").is(":checked")==false){
		alert('개인정보 취급방침에 동의 해 주세요');
		$("#agree2").focus();
		return false;
	}

	return true;

}




function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e1) { return null; }
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return null;
	}
}
var httpRequest = null;

function sendRequest(url, params, callback, method) {
	httpRequest = getXMLHttpRequest();
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + httpParams;
	}
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader(
		'Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}



function id_check(){
	var frm	=	document.join_form;
	var id=frm.userid.value;

	
	if(id.length < 4 || id.length> 80) {
		alert('4~20자 이내의 아이디를 입력하여 주십시오.');
		frm.userid.focus();
		return;
	}

	var chk_num = id.search(/[0-9]/g); 
	var chk_eng = id.search(/[a-z]/ig); 
	//var chk_esp = id.search(/[^0-9a-zA-Z]/g);  
	/*
	if(chk_eng> 0 || chk_num < 0) {
		alert('영문 또는 영문+숫자의 조합으로 아이디를 설정해 주세요 첫번째 글자는 영문입니다.'); 
		frm.userid.focus();
		return;
	}
	*/
	var params = "userid="+encodeURIComponent(id);
	sendRequest("/common/member/ajax_idCheck.php", params, idcheckResult, 'POST');

}





function idcheckResult() {
		if (httpRequest.readyState == 4) {

			if (httpRequest.status == 200) {
				var resultText = httpRequest.responseText;

					rel=resultText.split("||");
					var jangList=document.getElementById("id_ck");

					var resultText = httpRequest.responseText;
					jangList.innerHTML=rel[1];

					


					if(rel[0]=="y"){ document.join_form.num.value="y";	}else{	document.join_form.num.value="";	}


			} else {
				alert("Error: "+httpRequest.status);
			}
		}
}




function join_sendit(obj) {
	var form=document.join_form;

	if(form.company.value=="") {
		alert("회사명을 입력해 주세요.");
		form.company.focus();
		return false;
	}else if(form.busi_num1.value=="") {
		alert("사업자번호를 입력해 주세요.");
		form.busi_num1.focus();
		return false;
	}else if(form.busi_num1.value.length!=3) {
		alert("사업자번호 앞자리는 3자 입니다..");
		form.busi_num1.focus();
		return false;
	}else if(form.busi_num2.value=="") {
		alert("사업자번호를 입력해 주세요.");
		form.busi_num2.focus();
		return false;
	} else if(form.busi_num2.value.length!=2) {
		alert("사업자번호 가운데 자리는 2자 입니다..");
		form.busi_num2.focus();
		return false;
	}else if(form.busi_num3.value=="") {
		alert("사업자번호를 입력해 주세요.");
		form.busi_num3.focus();
		return false;
	}else if(form.busi_num3.value.length!=5) {
		alert("사업자번호 끝자리는 5자 입니다..");
		form.busi_num3.focus();
		return false;
	}else if(form.userid.value=="") {
		alert("아이디를 입력해 주세요.");
		form.userid.focus();
		return false;
	}else if(form.userid.value.length < 4 || form.userid.value.length > 30) {
		alert("아이디는 4~30자 이내입니다.");
		form.userid.focus();
		return false;
	}else if(form.num.value=="") {
		alert("아이디 중복체크를 하여 주십시오.");
		id_check();
		return false;
	}else if(form.passwd.value=="") {
		alert("비밀번호를 입력해 주세요.");
		form.passwd.focus();
		return false;
	} else if(form.passwd.value.length < 4 || form.passwd.value.length > 11) {
		alert("비밀번호는 4~11자 이내입니다.");
		form.passwd.focus();
		return false;
	}else if(form.passwd_check.value=="") {
		alert("비밀번호를 입력해 주세요.");
		form.passwd_check.focus();
		return false;
	} else if(form.passwd.value != form.passwd_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.passwd_check.focus();
		return false;
	}else if(form.name.value=="") {
		alert("이름을 입력해 주세요.");
		form.name.focus();
		return false;
	}else if(form.email.value=="") {
		alert("이메일을 입력해 주세요.");
		form.email.focus();
		return false;
	}else if(form.email2.value=="") {
		alert("이메일을 입력해 주세요.");
		form.email2.focus();
		return false;
	}else if(form.tel1.value=="") {
		alert("연락처를 입력해 주세요.");
		form.tel1.focus();
		return false;
	}else if(form.tel2.value=="") {
		alert("연락처를 입력해 주세요.");
		form.tel2.focus();
		return false;
	}else if(form.tel3.value=="") {
		alert("연락처를 입력해 주세요.");
		form.tel3.focus();
		return false;
	}else if(form.phone1.value=="") {
		alert("휴대전화번호를 입력해 주세요.");
		form.phone1.focus();
		return false;
	}else if(form.phone2.value=="") {
		alert("휴대전화번호를 입력해 주세요.");
		form.phone2.focus();
		return false;
	}else if(form.phone3.value=="") {
		alert("휴대전화번호를 입력해 주세요.");
		form.phone3.focus();
		return false;
	}else if(form.com_zip5.value==''){
		alert("우편번호를 입력하여 주시기 바랍니다.");
		openDaumPostcode(2)
			return false;
	}else if(form.com_add1.value==''){
		alert("주소를 입력하여 주시기 바랍니다.");
		openDaumPostcode(2)
		return false;
	} else {
		form.submit();
	}
}





function mainLoginInputSendit() {
	if(event.keyCode==13) { 
		login_sendit();
	}
}



function login_sendit() {

	var form=document.login_form;
	if(form.userid.value=="") {
		alert("아이디를 입력해 주십시오.");
		form.userid.focus();
	} else if(form.userid.value.length < 4 || form.userid.value.length > 21) {
		alert("회원 아이디는 4~20자로 입력 주세요.");
		form.userid.focus();
	} else if(form.passwd.value=="") {
		alert("비밀번호를 입력해 주십시오.");
		form.passwd.focus();
	} else if(form.passwd.value.length < 4 || form.passwd.value.length > 21) {
		alert("비밀번호는 4~20자로 입력 주세요.");
		form.passwd.focus();
	} else {
		form.submit();
	}

}




function LoginInputSendit() {
	if(event.keyCode==13) { 
		main_login_sendit();
	}
}



function main_login_sendit(){

	var frm	=	document.main_login_Form;


	if(frm.userid.value=="") {
		alert("아이디를 입력해 주십시오.");
		frm.userid.focus();
	} else if(frm.userid.value.length < 4 || frm.userid.value.length > 21) {
		alert("회원 아이디는 4~20자로 입력 주세요.");
		frm.userid.focus();
	} else if(frm.passwd.value=="") {
		alert("비밀번호를 입력해 주십시오.");
		frm.passwd.focus();
	} else if(frm.passwd.value.length < 4 || frm.passwd.value.length > 21) {
		alert("비밀번호는 4~20자로 입력 주세요.");
		frm.passwd.focus();
	} else {
		frm.submit();
	}


}

//아이디비번찾기
function id_search(){
	var frm	=	document.search_id_form;

	if(frm.name.value==''){
		alert("이름을 입력하여 주세요!");
		frm.name.focus();
	}else if(frm.email1.value==''){
		alert("이메일을 입력하여 주세요!");
		frm.email1.focus();
	}else if(frm.email2.value==''){
		alert("이메일을 입력하여 주세요!");
		frm.email2.focus();
	}else if(frm.phone1.value==''){
		alert("휴대폰번호를 입력하여 주세요!");
		frm.phone1.focus();
	}else if(frm.phone2.value==''){
		alert("휴대폰번호를 입력하여 주세요!");
		frm.phone2.focus();
	}else if(frm.phone3.value==''){
		alert("휴대폰번호를 입력하여 주세요!");
		frm.phone3.focus();
	}else{
		frm.submit();
	}
}

function pw_search(){
	var frm	=	document.search_pw_form;

	if(frm.userid.value==''){
		alert("아이디를 입력하여 주세요!");
		frm.userid.focus();
	}else if(frm.name.value==''){
		alert("이름을 입력하여 주세요!");
		frm.name.focus();
	}else if(frm.email1.value==''){
		alert("이메일을 입력하여 주세요!");
		frm.email1.focus();
	}else if(frm.email2.value==''){
		alert("이메일을 입력하여 주세요!");
		frm.email2.focus();
	}else{
		frm.submit();
	}
}






function modify_sendit(obj) {
	var form=document.modify_form;

	 if(form.passwd.value=="") {
		alert("비밀번호를 입력해 주세요.");
		form.passwd.focus();
		return false;
	} else if(form.passwd.value.length < 4 || form.passwd.value.length > 11) {
		alert("비밀번호는 4~11자 이내입니다.");
		form.passwd.focus();
		return false;
	}else if(form.passwd_check.value=="") {
		alert("비밀번호를 입력해 주세요.");
		form.passwd_check.focus();
		return false;
	} else if(form.passwd.value != form.passwd_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.passwd_check.focus();
		return false;
	}else if(form.email.value=="") {
		alert("이메일을 입력해 주세요.");
		form.email.focus();
		return false;
	}else if(form.email2.value=="") {
		alert("이메일을 입력해 주세요.");
		form.email2.focus();
		return false;
	}else if(form.tel1.value=="") {
		alert("연락처를 입력해 주세요.");
		form.tel1.focus();
		return false;
	}else if(form.tel2.value=="") {
		alert("연락처를 입력해 주세요.");
		form.tel2.focus();
		return false;
	}else if(form.tel3.value=="") {
		alert("연락처를 입력해 주세요.");
		form.tel3.focus();
		return false;
	}else if(form.phone1.value=="") {
		alert("휴대전화번호를 입력해 주세요.");
		form.phone1.focus();
		return false;
	}else if(form.phone2.value=="") {
		alert("휴대전화번호를 입력해 주세요.");
		form.phone2.focus();
		return false;
	}else if(form.phone3.value=="") {
		alert("휴대전화번호를 입력해 주세요.");
		form.phone3.focus();
		return false;

	}else if(form.com_zip5.value==''){
		alert("우편번호를 입력하여 주시기 바랍니다.");
		openDaumPostcode(2)
			return false;
	}else if(form.com_add1.value==''){
		alert("주소를 입력하여 주시기 바랍니다.");
		openDaumPostcode(2)
		return false;
	} else {
		form.submit();
	}
}



function withdraw_sendit(){
	var form=document.withdraw_form;

	 if(form.name.value=="") {
		alert("이름을 입력해 주세요.");
		form.name.focus();
		return false;
	 }else if(form.passwd.value=="") {
		alert("비밀번호를 입력해 주세요.");
		form.passwd.focus();
		return false;
	} else if(form.passwd.value.length < 4 || form.passwd.value.length > 11) {
		alert("비밀번호는 4~11자 이내입니다.");
		form.passwd.focus();
		return false;
	}else if(form.content.value=="") {
		alert("탈퇴사유를 입력해 주세요.");
		form.content.focus();
		return false;
	} else {
		form.submit();
	}
}



function openDaumPostcode(v) {
       new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById("sample6_postcode").value = data.postcode; //6자리 우편번호 사용


				var zip1	=	data.postcode.substring(0,3); 
				var zip2	=	data.postcode.substring(4,7); 
                //document.getElementById("zip1").value = zip1; //6자리 기초구역번호 사용
                //document.getElementById("zip2").value = zip2; //6자리 기초구역번호 사용

				if(v==2){
					document.getElementById("com_zip5").value = data.zonecode; //5자리 기초구역번호 사용
					document.getElementById("com_add1").value = fullAddr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("com_add2").focus();					
				}else{
					document.getElementById("zip5").value = data.zonecode; //5자리 기초구역번호 사용
					document.getElementById("add1").value = fullAddr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("add2").focus();					
				}





            }
        }).open();

}



function setCookie (name, value, expires) {
	document.cookie = name + "=" + escape (value) +
	"; path=/; expires=" + expires.toGMTString();
} 

function getCookie(Name) {
	var search = Name + "="
	if (document.cookie.length > 0) { 
		offset = document.cookie.indexOf(search)
		if (offset != -1) { 
			offset += search.length
			end = document.cookie.indexOf(";", offset)
		if (end == -1)
			end = document.cookie.length
			return unescape(document.cookie.substring(offset, end))
		}
	}
	return "";
}

function SaveId(form) {  
	if (document.login_form.checksaveid.checked==true) {
	var check;
	check = confirm("아이디, 패스워드 저장 기능을 사용하시겠습니까?");
	if(check==false) {document.loginform.checksaveid.checked=false;} 	 
	var expdate = new Date();
	if (form.checksaveid.checked)
		expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30);
	else
		expdate.setTime(expdate.getTime() - 1);
	setCookie("saveid", form.userid.value, expdate);
	setCookie("savepw", form.passwd.value, expdate);
	}  
}

function getid(form) {
	//form.checksaveid.checked = ((form.userid.value = getCookie("saveid")) != "");
	//form.checksaveid.checked = ((form.passwd.value = getCookie("savepw")) != "");
}