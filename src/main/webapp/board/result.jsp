<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="true" %> 
<%

// controller에서 저장한 값 꺼내기
int res = (int)request.getAttribute("result");

if(res > 0){
%>
	{
		"flag" : "성공"
	}
<%
} else {	
%>
	{
		"flag" : "실패"
	}
<%
}



%>