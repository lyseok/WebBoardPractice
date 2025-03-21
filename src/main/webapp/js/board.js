
const boardWriteServer = () => {
  $.ajax({
    url:`${mypath}/insertBoard.do`,
    data: JSON.stringify(fdata),
    method: 'post',
    contentType: 'application/json;charset=utf-8',
    success: res => {
      console.log(res.flag);
      boardListServer();
    },
    error: xhr => {
      alert(xhr.status);
    },
    dataType: 'json'
  });
}

const boardListServer = () => {
  vtype = $('#stype option:selected').val().trim();
	vword = $('#sword').val().trim();
	
	code = "";
	
  $.ajax({
    url :`${mypath}/listBoard.do`,
    data : JSON.stringify({ page :currPage,
      stype : vtype,
      sword : vword
    }),
    method : 'post',
    contentType : 'application/json;charset=utf-8',
    success : res=>{
      code = `
        <div class="container mt-3">
          <div id="accordion">
        `;

      $.each(res.datas, function(i, v){
        cont = v.content;
        cont = cont.replaceAll(/\n/g, "<br>");
      code += `
        <div class="card">
          <div class="card-header">
            <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
              ${v.subject}
            </a>
          </div>
          <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
            <div class="card-body">
              <div class="pp12">
                <p class="p1">
                  작성자:<span class="wr">${v.writer}</span>&nbsp;&nbsp;&nbsp;
                  이메일:<span class="em">${v.mail}</span>&nbsp;&nbsp;&nbsp;
                  날짜:<span class="da">${v.wdate}</span>&nbsp;&nbsp;&nbsp;
                  조회수:<span class="hit">${v.hit}</span>&nbsp;&nbsp;&nbsp;
                </p>
                <p class="p2">
                  <input type="button" value="삭제" data-idx="${v.num}" name="del" class="action">
                  <input type="button" value="수정" data-idx="${v.num}" name="update" class="action">
                </p>
              </div>

              <p class="p3">
                ${cont}
              </p>
              <p class="p4">
                <textarea cols="50" class="area"></textarea>
                <input type="button" value="등록" data-idx="${v.num}" name="reply" class="action">
              </p>

            </div>
          </div>
        </div>`;

        }); // 반복문
        code += `
            </div>
          </div>
          `;
        $('#result').html(code);

        plist =  pageList(res.sp, res.ep, res.tp);
        $('#pagelist').html(plist);
    },
    error : xhr =>{
      alert("상태 :" + xhr.status);
    },
    dataType : 'json'
  });

  
}

const pageList = (sp, ep, tp) => {
  pager = `<ul class="pagination">`;

  // 이전버튼
  if(sp > 1){
    pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
  }
  // 페이지 번호
  for(let i = sp; i <= ep; i++){

    if(currPage == i){
      pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
    } else {
      pager += `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
    }
  }

  // 다음버튼
  if(ep < tp) {
    pager += `<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
  }


  pager += `</ul>`;

  return pager;
}