<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.serializejson.min.js"></script>

<style>
body * {
  box-sizing: border-box;
  margin: 3px;
  padding: 5px;
}

p{
  border: 1px dotted gray;
}

.pp12 {
  display: flex;
  flex-direction: row;
}
.p1 {
  /* flex: 70%; */
  flex-grow: 7;
  flex-basis: 0;
}

.p2 {
  /* flex: 30%; */
  flex-grow: 3;
  flex-basis: 0;
}

.p4 {
  display: flex;
  flex-direction: row;
  align-items: center;
}

nav a{
  visibility: hidden;
}
.card-header:hover {
  background-color: blue;
}
#pagelist {
  margin-left: 10%;

}

</style>
<script src="../js/board.js"></script>
<script>
currPage = 1;
mypath = '<%=request.getContextPath() %>';

$(function() {

  
  // 이전 클릭 이벤트
  
  // 다음 클릭 이벤트
  
  // search 이벤트
  $('#search').on('click', function() {
    currPage = 1;
    boardListServer();
  });

  // 페이지 번호 클릭 이벤트트
	
});
</script>


<title>Insert title here</title>
</head>
<body>

<h2>자유 게시판</h2>
  
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="javascript:void(0)">Link</a>
        </li>
      </ul>
      <form class="d-flex">

        <select class="form-select" name="" id="stype">
          <option value="">전체</option>
          <option value="writer">작성자</option>
          <option value="subject">제목</option>
          <option value="content">내용</option>
        </select>

        <input class="form-control me-2" type="text" placeholder="Search" id="sword">
        <button class="btn btn-primary" type="button" id="search">Search</button>
      </form>
    </div>
  </div>
</nav>

<!-- 게시판 글 리스트 3개씩 출력 -->
<div id="result"></div>

<br><br>

<!-- 페이지 정ㅂ 출력 -->
<div id="pagelist"></div>

</body>
</html>