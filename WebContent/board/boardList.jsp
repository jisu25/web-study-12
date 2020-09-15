<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="js/board.js"></script>
<script>
	$(function() {
		$.ajax({
			type: "POST",
			url: "boardList.do",
			dataType: "json",
			success: function(data) {
				var str="";
				$.each(data, function(i) {
					str += "<tr class='record'><td>" + data[i].num + "</td>"
					+ "<td><a href='boardView.do?num=" + data[i].num + "'>" + data[i].title + "</a></td>"
					+ "<td>" + data[i].name + "</td>"
					+ "<td>" + data[i].writeDate + "</td>"
					+ "<td>" + data[i].readCount + "</td></tr>"
				});
				console.log(str);
				$("#list_table").append(str);
			}
		});
	});
</script>
</head>
<body>
	<div id="wrap" align="center">
	<h1>게시글 리스트</h1>
	<table class="list" id="list_table">
		<tr>
			<td colspan="5" style="border: white; text-align: right">
				<a href="boardWrite.do">게시글 등록</a>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회</th>
		</tr>
		<%-- <c:forEach var="board" items="${list }">
			<tr class="record">
				<td>${board.num }</td>
				<td><a href="boardView.do?num=${board.num }">${board.title }</a></td>
				<td>${board.name }</td>
				<td><fmt:formatDate value="${board.writeDate }"/></td>
				<td>${board.readCount }</td>
			</tr>
		</c:forEach> --%>
	</table>
	</div>
</body>
</html>