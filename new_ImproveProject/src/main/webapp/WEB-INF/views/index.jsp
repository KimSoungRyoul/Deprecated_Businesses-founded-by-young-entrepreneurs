<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!doctype html>
<html lang="ko">
<link rel="shortcut icon" href="/resources/img/improveicon.ico">
 <head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1,FF=3,otherUA=4" />
	<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<title>improve</title>
	<link href="/resources/pc/css/style.css" rel="stylesheet" type="text/css" />
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	<!--[if lt IE 9]>
	<script src="./js/html5shiv.js"></script>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<!--js-->
	<script src="http://www.w3schools.com/lib/w3data.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="/resources/pc/js/common.js"></script>
	<!--slideBanner-->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="/resources/pc/js/jquery.bxslider.js"></script>
	<!--scroll page-->
	<script type="text/javascript" src="/resources/pc/js/jquery.fullPage.js"></script>
	<script type="text/javascript">
		//main scroll page
		$(document).ready(function() {
			$('#fullpage').fullpage({
				anchors: ['1stPage', '2ndPage', '3rdPage', '4thPage'],
				css3: true,
				slidesNavigation: true,
				//responsiveWidth: 1180,
				responsiveHeight: 750,
				afterResponsive: function(isResponsive){		
				}
			});
		});
	</script>
	<!--[if IE]>
		<script type="text/javascript">
			 var console = { log: function() {} };
		</script>
	<![endif]-->
</head>
<body>

<div id="wrap">
	<!--상단-->
	<header class="scroll">
		<!--  <div w3-include-html="/inc/header.inc.jsp"></div>   -->
		<%--  <%@include file="./inc/header.inc.jsp" %>  --%>
	</header>
	<!--//상단-->
	<!--메인 컨텐츠-->
	<div id="fullpage">
		<!--메인비주얼-->
		<div class="section mvBg" id="section0" >
			<div class="mvWrap">
				<p id="mvIcon"><i class="fa fa-angle-down" aria-hidden="true"></i></p>
				<ul class="visual">
					<li>
						<h2>나를 증명하고, 성장한다</h2>
						<p class="txt">임프로브는 다양한 기술력과 축적된 경험을 통한  E-BUSINESS의 선두주자로써<br/><b>이력서</b>부터 <b>포트폴리오 페이지</b>까지 한번에 해결하실 수 있습니다.</p>
						<a href="#;"><img src="/resources/img/main/btn_google.png" alt="플레이스토어 바로가기"/></a>
						<p class="sTxt">EXPERIENCE & CREATIVE</p>
					</li>
					<li>
						<h2>나를 증명하고, 성장한다2</h2>
						<p class="txt">임프로브는 다양한 기술력과 축적된 경험을 통한  E-BUSINESS의 선두주자로써<br/><b>이력서</b>부터 <b>포트폴리오 페이지</b>까지 한번에 해결하실 수 있습니다.</p>
						<a href="#;"><img src="/resources/img/main/btn_google.png" alt="플레이스토어 바로가기"/></a>
						<p class="sTxt">EXPERIENCE & CREATIVE</p>
					</li>
				</ul>
			</div>
		</div>
		<!--//메인비주얼-->
		<div class="section service" id="section1">
			<div class="wrap">
				<h2>OUR SERVICES<span>IMPROVE</span></h2>
				<article class="left">
					<div>
						<dl class="sv1">
							<dt>핸드폰으로 언제 어디서나</dt>
								<dd>시간, 장소 제약없이 언제 어디서든지<br/>생각날 때 틈틈이 입력가능합니다.</dd>
						</dl>
						<dl class="sv2">
							<dt>입력해둔 이력을 메일로</dt>
								<dd>입력한 사항들을 보기 좋은 이력서로<br/>자동 추출되어 회원님의 메일로 발송됩니다.</dd>
						</dl>
					</div>
				</article>
				<article class="right">
					<div>
						<dl class="sv3">
							<dt>활동 사진/동영상 첨부도 O.K</dt>
								<dd>경력 및 활동에 관한 사진/ 동영상 등의<br/>자료도 쉽게 업로드 하여 기록, 증명</dd>
						</dl>
						<dl  class="sv4">
							<dt>이력서와 포트폴리오가 합쳐진</dt>
								<dd>이력서와 포트폴리오를 따로 준비할 필요없이<br/>QR코드를 활용한 포트폴리오 홈페이지를<br/>회원님 마다 무료로 제공해 드립니다.</dd>
						</dl>
					</div>
				</article>
			</div>
		</div>
		<div class="section detail" id="section2">
			<div class="wrap">
				<h2>DETAIL FUNCTION<span>IMPROVE</span></h2>
				<article>
					<div class="dtBox">
						<div>
							<article>
								<div class="icon">
									<div><img src="/resources/img/main/icon_bt1.png"/></div>
								</div>
								<dl>
									<dt>인적사항</dt>
										<dd>사용자의 이름, 성별, 생일, 핸드폰 번호, 메일, 병역여부 등을<br/>기재하는 메뉴로써 사용자가 작성한 내용들을 토대로<br/>향후 PDF로 변환되어 제공될 이력서에 기재가 된다.</dd>
								</dl>
							</article>
							<article>
								<div class="icon">
									<div><img src="/resources/img/main/icon_bt2.png"/></div>
								</div>
								<dl>
									<dt>학력사항 ~ 어학능력</dt>
										<dd>사용자의 학력사항, 주요활동, 수상내역, 자격사항, 어학능력을<br/>기재하는 메뉴로 제목과 기간 그리고 내용 등의 형식으로 꾸며져 있다.<br/>내용은 최대 300자 까지 적을 수 있으며 사진 및 동영상 첨부가 가능하고<br/>첨부된 내용들은 이력서 우측 상단의 QR코드를 통해 확인 할 수 있다.</dd>
								</dl>
							</article>
							<article>
								<div class="icon">
									<div><img src="/resources/img/main/icon_bt3.png"/></div>
								</div>
								<dl>
									<dt>PDF 변환하기</dt>
										<dd>앞서 적은 이력들을 PDF 파일로 변환시켜 주는 것을 말한다.<br/>이곳에서는 이력서에 들어갈 주소지 검색 서비스가 제공되며 앞으로<br/>추출될 이력서에 기재될 대표 이력사항을 체크한 다음 변환하기 버튼을<br/>누르면 회원의 이메일로 전송되어진다.</dd>
								</dl>
							</article>
						</div>
						<img src="/resources/img/main/img_dtList1.png"/>
					</div>
				</article>
			</div>
		</div>
		<div class="section psn" id="section3">
			<div class="wrap">
				<div class="psnImg">
					<article>
						<ul class="psnList">
							<li><img src="/resources/img/main/img_psn1.png"/></li>
							<li><img src="/resources/img/main/img_psn2.png"/></li>
							<li><img src="/resources/img/main/img_psn3.png"/></li>
							<li><img src="/resources/img/main/img_psn4.png"/></li>
						</ul>
					</article>
				</div>
				<div class="psnTxt">
					<h2><span>Improve & I'm prove</span>이력서, 포트폴리오</h2>
					<p>언제 따로 준비할래?</p>
					<p class="blue">이제는 한번에 관리하자!</p>
				</div>
			</div>
			<footer class="main">
				<!-- <div w3-include-html="/inc/footer.inc.jsp"></div>  -->
				<%@include file="./inc/footer.inc.jsp" %>
			</footer>
		</div>
	</div>
	<!--//메인 컨텐츠-->
</div>

<script>
	w3IncludeHTML();
</script>

</body>
</html>