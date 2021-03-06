<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- 
	JSTL(JSP Standard Tag Library) 이란?
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하는 JSP 표준 태그
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
<center>
<h1><spring:message code="message.board.list.mainTitle"/></h1>
<h3><font color="red">${user.name }</font><spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">LOG-OUT</a></h3>
<a href="getBoardList.do?lang=en"><spring:message code="message.user.login.language.en"/></a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do?lang=ko"><spring:message code="message.user.login.language.ko"/></a>
<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE"><spring:message code="message.board.list.search.condition.title"/></option>
			<option value="CONTENT"><spring:message code="message.board.list.search.condition.content"/></option>
			</select>
			<input name="searchKeyword" type="text"/>
			<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"/>
		</td>
	</tr>
	</table>
</form>
<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.seq"/></th>
	<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"/></th>
	<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"/></th>
	<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"/></th>
	<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"/></th>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td>${board.regDate }</td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

</table>
<br>
<a href="insertBoardView.do"><spring:message code="message.board.list.link.insertBoard"/></a>
</center>
</body>
</html>



