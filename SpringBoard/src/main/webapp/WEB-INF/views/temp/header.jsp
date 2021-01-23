<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<header>
	<ul>
		<li>
			<a href="/main">
			메인
			</a>
		</li>
		<!-- TODO: 메뉴 뿌리기 -->
		<c:forEach items="${menus}" var="item">
			<li class="${item.typ == param.typ ? 'selectedBoard': ''}">
				<a href="/board/list?typ=${item.typ}">
				${item.nm}
				</a>
			</li>	
		</c:forEach>
		<c:if test="${loginUser != null}">
			<li><a href="/user/profile">프로필</a></li>
			<li><a href="/user/changePw">비밀번호변경</a></li>
		</c:if>	
		<c:if test="${loginUser == null}">
			<li><a href="/user/login">로그인</a>
		</c:if>
		<c:if test="${loginUser != null}">
			<li><a href="/user/logout">Logout</a></li>
			<li>${loginUser.nm}님 환영합니다.</li>
		</c:if>
	</ul>
</header>