<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>

	<c:forEach var="notice" items="${notices}">
		<div class="card m-4">
			<div class="card-body">
				<input type="hidden" id="id" value="${notice.id}">
				<h6 class="card-title">채용공고ID : ${notice.id}</h6>
				<h5 class="card-title">회사 이름 : ${notice.company.name}</h5>
				<h5 class="card-title">국가 : ${notice.company.nation}</h5>
				<h5 class="card-title">지역 : ${notice.company.area}</h5>

				<h5 class="card-title">채용 포지션 : ${notice.position}</h5>
				<h5 class="card-title">채용 보상금 : ${notice.compensation}</h5>
				<h5 class="card-title">사용기술 : ${notice.skill}</h5>

				<div class="d-flex justify-content-between">
					<a href="/notice/${notice.id}?comId=${notice.company.comId}" class="btn btn-primary">상세보기</a>
					<div>
						<a href="/notice/${notice.id}/updateForm" class="btn btn-dark">수정하기</a>
						<button class="btn-delete btn btn-warning" data-id="${notice.id}">삭제하기</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
	<script src="/js/notice.js"></script>
</body>
</html>