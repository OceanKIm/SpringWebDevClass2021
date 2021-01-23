<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<div>
	<h3>메인페이지</h3>
	<div>
		<h4>공부 메모장 저장하기</h4>
		<div class="fileListCont">
			<table class="fileList">
			<tr>
				<th>번호</th>
				<th>파일명</th>
				<th>저장날짜</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${data}" var="item">
			<tr>
				<td>${item.i_file}</td>
				<td>${item.f_nm}</td>
				<td>${item.f_dt}</td>
				<td id="option">
					<form action="delFile.korea" method="post">
						<input type="hidden" name="i_file" value="${item.i_file}">
						<input type="hidden" name="f_nm" value="${item.f_nm}">
						<input type="submit" value="삭제">
					</form>
					<form action="downFile.korea" method="post">
						<input type="hidden" name="f_nm" value="${item.f_nm}">
						<input type="submit" value="다운">
					</form>			
				</td>
			</tr>
			</c:forEach>
			</table>
		</div>
		<form action="/upload.korea" method="post" enctype="multipart/form-data">
			<input type="file" name="fileName">
			<input type="submit" value="저장">			
		</form>
	</div>
</div>