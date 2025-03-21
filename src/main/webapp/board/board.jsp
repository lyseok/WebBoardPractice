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
  boardListServer();
  
  // 이전 클릭 이벤트
  $(document).on('click', '#next', function(){
    currPage = parseInt($('.pageno').last().text()) + 1;
    boardListServer();
  });

  // 다음 클릭 이벤트
  $(document).on('click', '#prev', function(){
    currPage = parseInt($('.pageno').first().text()) - 1;
    boardListServer();
  });

  // search 이벤트
  $('#search').on('click', function() {
    currPage = 1;
    boardListServer();
  });

  // 페이지 번호 클릭 이벤트
  $(document).on('click', '.pageno', function() {
    currPage = parseInt($(this).text());
    boardListServer();
  });

  // 글쓰기 버튼 이벤트(모달창 띄우기)
  $('#write').on('click', function() {
    $('#wModal').modal('show');
  });

  // 글쓰기 모달창에서 데이터 입력 후 전송버튼 클릭 이벤트
  $('#send').on('click', function() {
    // 입력한 모든 값을 전부 가져오기
    fdata = $('#wform').serializeJSON();
    console.log(fdata);
    
    boardWriteServer();
     // 모달창 값 지우기
    $('#wModal .txt').val("");
      
      // 모달 닫기
      $('#wModal').modal('hide');
  });


	
});
</script>


<title>Insert title here</title>
</head>
<body>

<h2>자유 게시판</h2>
  
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <div class="container-fluid">
    <input type="button" id="write" value="글쓰기">
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

<!-- The Modal -->
<div class="modal" id="wModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">글쓰기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <form name="wfrom" id="wform">
          
          <label>이름</label>
          <input type="text" class="txt" id="writer" name="writer"> <br> 
          
          <label>제목</label>
          <input type="text" class="txt" id="subject" name="subject"> <br> 
          
          <label>메일</label>
          <input type="text" class="txt" id="mail" name="mail"> <br> 
          
          <label>비밀번호</label>
          <input type="password" class="txt" id="password" name="password"> <br> 
          
          <label>내용</label>
          <br>
          <textarea rows="5" cols="40" class="txt" id="content" name="content"></textarea>
          <br>
          <br>
          <input type="button" value="전송" id="send">
        </form>

      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>

</body>
</html>