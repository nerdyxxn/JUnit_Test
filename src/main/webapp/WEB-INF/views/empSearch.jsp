<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	${result }
<hr>
<hr>
	<form action="${pageContext.request.contextPath }/empsearch.action" method="get">
		<select name="deptno" id="deptno">
			<option value="">부서전체</option>
			<option value="10">10번부서</option>
			<option value="20">20번부서</option>
			<option value="30">30번부서</option>
		</select>
		<select name="job" id="job">
			<option value="">업무전체</option>
			<option value="SALESMAN">SALESMAN</option>
			<option value="MANAGER">MANAGER</option>
			<option value="CLERK">CLERK</option>
			<option value="ANALYST">ANALYST</option>
		</select>
		<input type="submit" value="검색하기">
	</form>
</body>
</html>