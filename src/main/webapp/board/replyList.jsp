<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("list");

Gson gson = new GsonBuilder().setPrettyPrinting().create();

String json = gson.toJson(list);

out.print(json);
out.flush();

%>