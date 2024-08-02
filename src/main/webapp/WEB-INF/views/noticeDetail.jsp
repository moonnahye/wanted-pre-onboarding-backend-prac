<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="header.jsp" %>


	<div class="container mt-5">
		
		<div class="card m-4">
			<div class="card-body">
			
			<a href="/" class="btn btn-secondary"">전체 목록보기</a>
			<p>
				<input type="hidden" value="${notice.id}">
				<h6 class="card-title">채용공고ID : ${notice.id}</h6>
				<h5 class="card-title">회사 이름 : ${notice.company.name}</h5>
				<h5 class="card-title">국가 : ${notice.company.nation}</h5>
				<h5 class="card-title">지역 : ${notice.company.area}</h5>
				<br />
				<h5 class="card-title">채용 포지션 : ${notice.position}</h5>
				<h5 class="card-title">채용 보상금 : ${notice.compensation}</h5>
				<h5 class="card-title">사용기술 : ${notice.skill}</h5>
				<br />
				<h5 class="card-title">채용 내용 : ${notice.content}</h5>

				<h5 class="card-title">

					회사가올린 다른채용공고 :
					<c:forEach var="notice2" items="${noticebycom}">
						<c:if test="${notice.id != notice2.id}">
							<a href="/notice/${notice2.id}?comId=${notice2.company.comId}">${notice2.id}</a>
						</c:if>
					</c:forEach>
				</h5>

			</div>
		</div>
	</div>

	<script src="/js/notice.js"></script>
</body>
</html>