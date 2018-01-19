<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<link rel="shortcut icon" href="/resources/img/improveicon.ico">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible"
	content="IE=edge,chrome=1,FF=3,otherUA=4" />
<meta name="viewport"
	content="width=device-width,user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<title>improve</title>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css" />
<!-- slideBanner-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript"
	src="/resources/js/jquery.touchSwipe.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="/resources/js/jquery.bxslider.js"></script>
<script src="/resources/js/improve.js"></script>

</head>

<body>
	<div id="wrap">
		<c:forEach items="${resume.grouping }" var="grouped">
			<c:forEach items="${grouped.value }" var="actItem">
				<div class="popup" id="pofol${actItem.p_no}">
					<article>
					<ul class="rolling">
						<c:forEach items="${actItem.p_attachFileList}" var="attachedFile">
							<li>
								<div>
									<img
										src="/attach/getAttachedFile?fileName=${attachedFile.a_filePath}">
								</div>
								<h3>${actItem.p_title}</h3>
								<p class="date">${actItem.p_startDate}~${actItem.p_endDate}</p>
								<p class="txtBox">${actItem.p_actcontent }</p>
							</li>
						</c:forEach>
						<c:forEach items="${actItem.p_mAttachFileList}"
							var="mAttachedFile">
							<li>
								<div>
									<video src="/attach/video?fileName=${mAttachedFile.m_filePath}"
										controls="controls" width="260" height="182"> 지원되지 않는
									동영상 형식입니다 </video>
								</div>

								<h3>${actItem.p_title}</h3>
								<p class="date">${actItem.p_startDate}~${actItem.p_endDate}</p>
								<p class="txtBox">${actItem.p_actcontent }</p>
							</li>
						</c:forEach>

					</ul>

					</article>
				</div>
			</c:forEach>
		</c:forEach>




		<!--popup bg-->
		<div class="fade"></div>
		<!-- //popup-->

		<header>
		<h1>
			<img src="/resources/img/logo_h1.gif" alt="improve" />
		</h1>
		<div>
			<article class="human">
			<div class="img">
				<div>
					<img
						style="transform: rotate(90deg);"  src="/attach/getAttachedFile?fileName=${resume.userVo.u_profilePhoto.a_filePath}"
						alt="profilePhoto" width="97px" height="100px">
				</div>

				<a href="tel:${resume.userVo.u_pnum}">통화</a>

			</div>
			<ul>
				<li>
					<p>이름 :</p> <span>${resume.userVo.u_name}</span>
				</li>
				<li>
					<p>전화번호 :</p> <span>${resume.userVo.u_pnum}</span>
				</li>
				<li>
					<p>이메일 :</p> <span>${resume.userVo.u_email}</span>
				</li>
				<li>
					<p>최종학력 :</p> <span>${resume.eduList[0].p_title}<br>${resume.eduList[0].p_major}
				</span>
				</li>
			</ul>

			</article>
		</div>
		</header>

<!--  ${fn:substring(string1, 5, 15)}-->
<!--  <c:set var="string2" value="${fn:substring(string1, 5, 15)}" />
${resume.h2Grouping[grouped.key]}
-->
		<!--contents-->
		<div id="container">

			<c:forEach items="${resume.grouping}" var="grouped"
				varStatus="status">
				<article class="bnWrap">
				<h2 class="${resume.h2Grouping[grouped.key]}">${grouped.key}</h2>
				<ul class="bn bn${status.count}">
					
					<c:if test="${fn: length(grouped.value)==0}">
						<li><a href="#;">
								<ul class="img">
									<li class="none">
										<div>
											<p>해당경력없음</p>
											<img src="/resources/img/img_none.gif" />
										</div>
										<dl class="txt">
											<dt>...</dt>
											<dd></dd>
										</dl>
									</li>
								</ul>
						</a></li>
					</c:if>

					<li><a href="#;">
							<ul class="img">
								<c:forEach items="${grouped.value}" var="pofol" begin="0"
									end="2" step="1" varStatus="status">
									<c:choose>
										<c:when
											test="${pofol.p_attachFileList[0].a_filePath!=null}">
											<li class="imev bx-clone" data-id="${pofol.p_no}"><div>
													<img
														src="/attach/getAttachedFile?fileName=${pofol.p_attachFileList[0].a_filePath}"
														width="130" height="119.36">
												</div>
												<dl class="txt">
													<dt>${pofol.p_title }</dt>
													<dd>${pofol.p_startDate}~${pofol.p_endDate}</dd>
												</dl></li>
										</c:when>
										<c:when
											test="${pofol.p_attachFileList[0].a_filePath==null}">
											<li class="imev none bx-clone" data-id="${pofol.p_no}">
												<div>
													<p>첨부파일 없음</p>
													<img src="/resources/img/img_none.gif" />
												</div>
												<dl class="txt">
													<dt>${pofol.p_title }</dt>
													<dd>${pofol.p_startDate}~${pofol.p_endDate}</dd>
												</dl>
											</li>
										</c:when>
									</c:choose>
								</c:forEach>
							</ul>
					</a></li>

					<c:if test="${fn: length(grouped.value)>3}">
						<li><a href="#;">
								<ul class="img">
									<c:forEach items="${grouped.value}" var="pofol"
										varStatus="status">
										<c:if test="${status.count>3}">
											<c:choose>
												<c:when
													test="${pofol.p_attachFileList[0].a_filePath!=null&&pofol.p_attachFileList[0].a_filePath ne ''}">
													<li class="imev" data-id="${pofol.p_no}"><div>
															<img
																src="/attach/getAttachedFile?fileName=${pofol.p_attachFileList[0].a_filePath}"
																width="130" height="119.36">
														</div>
														<dl class="txt">
															<dt>${pofol.p_title }</dt>
															<dd>${pofol.p_startDate}~${pofol.p_endDate}</dd>
														</dl></li>
												</c:when>
												<c:when
													test="${pofol.p_attachFileList[0].a_filePath==null&&pofol.p_attachFileList[0].a_filePath eq ''}">
													<li class="imev none" data-id="${pofol.p_no}">
														<div>
															<p>첨부파일 없음</p>
															<img src="/resources/img/img_none.gif" />
														</div>
														<dl class="txt">
															<dt>${pofol.p_title }</dt>
															<dd>${pofol.p_startDate}~${pofol.p_endDate}</dd>
														</dl>
													</li>
												</c:when>
											</c:choose>
										</c:if>
									</c:forEach>
								</ul>

						</a></li>

					</c:if>

				</ul>
				</article>


			</c:forEach>
		</div>

		<footer>
		<p>Copyright© Improve.All rights reserved</p>
		</footer>

	</div>
</body>
</html>
