<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>


<div class="card m-4">
	<div class="card-body">
		<div class="form-group">
			<h1>채용 공고 등록</h1>
			<label for="comId">회사 ID : </label> <input type="text" class="form-control" id="comId">
		</div>
		<div class="form-group">
			<label for="position">채용 포지션 :</label> <input type="text" class="form-control" id="position">
		</div>
		<div class="form-group">
			<label for="compensation">채용 보상금 : </label> <input type="text" class="form-control" id="compensation">
		</div>
		<div class="form-group">
			<label for="content">채용 내용 : </label>
			<textarea class="form-control" id="content"></textarea>
		</div>
		<div class="form-group">
			<label for="skill">사용 기술: </label> <input type="text" class="form-control" id="skill">
		</div>
		<button id="btn-save" class="btn btn-primary">등록 완료</button>
	</div>
</div>





<script src="/js/notice.js"></script>
</body>
</html>





