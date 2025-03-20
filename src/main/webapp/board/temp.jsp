<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script src="http://localhost/js/jquery-3.7.1.js"></script>
<script src="http://localhost/js/jquery.serializejson.min.js"></script>

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

</style>

<title>Insert title here</title>
</head>
<body>

<div class="container mt-3">
  <h2>자유 게시판</h2>
  
  <div id="accordion">

    <div class="card">
      <div class="card-header">
        <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
          제목1
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
        <div class="card-body">
          <div class="pp12">
            <p class="p1">
              작성자:<span class="wr">김은대</span>&nbsp;&nbsp;&nbsp;
              이메일:<span class="em">seok@test.com</span>&nbsp;&nbsp;&nbsp;
              날짜:<span class="da">2025-02-14</span>&nbsp;&nbsp;&nbsp;
              조회수:<span class="hit">0</span>&nbsp;&nbsp;&nbsp;
            </p>
            <p class="p2">
              <input type="button" value="삭제" data-idx="20" name="del" class="action">
              <input type="button" value="수정" data-idx="20" name="update" class="action">
            </p>
          </div>

          <p class="p3">
            내용출력
          </p>
          <p class="p4">
            <textarea cols="50" class="area"></textarea>
            <input type="button" value="등록" data-idx="20" name="reply" class="action">
          </p>

        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
        Collapsible Group Item #2
      </a>
      </div>
      <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
        <div class="card-body">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
          Collapsible Group Item #3
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
        <div class="card-body">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>