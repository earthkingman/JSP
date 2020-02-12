<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="GMgr" class="pack_JDBC.Go_Out"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출근</title>
</head>
<body>
<%
Date date = new Date(); //객체 생성
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
// Go_Out.GO_Select 메서드의 값을 비교하여 출근, 퇴근 버튼 값 변경
SimpleDateFormat time = new SimpleDateFormat("HH시 mm분 ss초");

GMgr.Insert_Work(sdf.format(date), time.format(date));
%>
</body>
</html>