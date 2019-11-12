<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="account" class="machingProject.AccountMigrate"></jsp:useBean>
<jsp:useBean id="bean" class="machingProject.accountBean"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입처리</title>
</head>
<body>
	<jsp:setProperty property="*" name="bean"/>
	<%
		boolean result = account.signup(bean);
		String msg = bean.getId();
		if(result){
			msg="회원가입에 성공하였습니다.";
		}
	%>
<script>
	alert("<%=msg%>");
</script>
	<% response.sendRedirect("login.jsp"); %>
</body>
</html>