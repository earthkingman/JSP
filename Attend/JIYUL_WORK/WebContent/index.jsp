<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="GMgr" class="pack_JDBC.Go_Out"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>박지율 출퇴근 확인</title>
</head>
<body>
<%
Date date = new Date(); //객체 생성


SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

SimpleDateFormat time = new SimpleDateFormat("HH시 mm분 ss초");

String result = GMgr.GO_Select(sdf.format(date));
String button_value = "";



if (result == null || result == "") {
	button_value = "출근";
	
} 
else {
	button_value = "퇴근";
}
%>

<!-- 버튼을 누르는 시점의 날짜를 가지고 DB select -->
<button id="go_out" onclick="test();" value=<%=button_value %>> <%=button_value %></button>

<%
//if (button_value == "출근") {
	
	
//}
	
//if (button_value == "퇴근") {
//	 Update_Work(,String nowtime)
//}
%>


<script type="text/javascript">
function test() {
	var value = document.getElementById("go_out").value;
	 alert("테스트입니다요.");
	if (value =='출근') {
		location.href = "go.jsp";
	} else if (value =='퇴근') {
		location.href = "out.jsp"
	}
}



</script>



</body>
</html>
