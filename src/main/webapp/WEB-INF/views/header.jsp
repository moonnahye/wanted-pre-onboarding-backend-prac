<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<body>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between">

			<div>
				<a href="/" class="btn btn-info"> Home </a> <a href="/notice/saveForm" class="btn btn-success ">채용공고 등록하기</a>
			</div>
			<div class="form-group">
				<form action="/search" method="get" class="form-inline">
					<input type="text" class="form-control" name="keyword" required>
					<button class="btn btn-secondary">검색하기</button>
			</div>
			</form>
		</div>