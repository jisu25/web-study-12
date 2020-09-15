<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
	<h1>게시글 상세 보기</h1>
	<table>
		<tr>
			<th>작성자</th><td>${board.name }</td>
			<th>이메일</th><td>${board.email }</td>
		</tr>
		<tr>
			<th>작성일</th><td><fmt:formatDate value="${board.writeDate }" pattern="yyyy년  MM월 dd일 HH:mm:ss"/></td>
			<th>조회수</th><td>${board.readCount }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><pre>${board.content }</pre></td>
		</tr>		
	</table>
	<br><br>
	<input type="button" value="게시글 수정" onclick="open_win('boardCheckPass.do?num=${board.num}', 'update')">
	<input type="button" value="게시글 삭제" onclick="open_win('boardCheckPass.do?num=${board.num}', 'delete')">
	<input type="button" value="게시글 목록" onclick="location.href='boardList.do'">
	<input type="button" value="게시글 등록" onclick="location.href='boardWrite.do'">
</div>
</body>
</html>