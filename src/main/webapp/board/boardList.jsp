<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// controller애서 저장한 값 꺼내기
@SuppressWarnings("unchecked")
List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
int startP = (int)request.getAttribute("sp");
int endP = (int)request.getAttribute("ep");
int totalP = (int)request.getAttribute("tp");

Gson gson = new GsonBuilder().setPrettyPrinting().create();

JsonObject obj = new JsonObject();
obj.addProperty("sp", startP);
obj.addProperty("ep", endP);
obj.addProperty("tp", totalP);
obj.add("datas", gson.toJsonTree(list));

out.print(obj);
out.flush();

%>

