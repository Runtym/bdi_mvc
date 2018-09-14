<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${!empty cnt}">
	<script>
		alert("게시물이 정상적으로 등록되었습니다.");
		location.href="/board/boardList";
	</script>
</c:if>
<body>
        <article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>게시글 작성</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form method="post" action="/board/boardInsert" enctype="multipart/form-data" id="biForm">
					<div class="form-group"> <!-- Name field -->
						<label class="control-label " for="uiname">등록자</label>
						<input class="form-control" id="uiname" name="uiname" type="text" value="${user.uiname}" disabled/>
					</div>
					<div class="form-group"> <!-- Subject field -->
						<label class="control-label " for="bititle">제목</label>
						<input class="form-control" id="bititle" name="bititle" type="text"/>
					</div>
					
					<div class="form-group"> <!-- Message field -->
						<label class="control-label " for="bitext">내용</label>
						<textarea class="form-control" cols="40" id="bitext" name="bitext" rows="10"></textarea>
					</div>
					
					<div class="form-group"> <!-- Message field -->
						<label class="control-label " for="bifile">파일</label>
						<input class="form-control" id="bifile" name="bifile" type="file"/>
					</div>
					
					<div class="form-group">
						<button class="btn btn-primary " name="submit" type="button">등록</button>
						<button class="btn " data-page="/board/boardList">취소</button>
					</div>
					<input type="hidden" name="uinum" value="${user.uinum}">
				</form>								
			
            </div>

        </article>
        <progress id="progressBar" value="0"></progress>
<div>
</div>
<script>
	document.querySelector('button[name=submit]').onclick = function(){
		var url = '/board/boardInsert';
		var file = document.getElementById('bifile').files[0];
		var biForm = document.querySelector('#biForm');
		var formData = new FormData(biForm);
		var progressBar = document.querySelector('#progressBar');
	    xhr = new XMLHttpRequest();
		xhr.open('POST', url);

		xhr.onreadystatechange = function(){
			if(xhr.readyState==xhr.DONE){
				if(xhr.status==200){
					var json = xhr.responseText;
					alert(json);
				}else{
					alert('뭔지 몰라도 실패');
				}
			}
		}

		xhr.upload.onprogress = function (e) {
		    if (e.lengthComputable) {
		        progressBar.max = e.total;
		        progressBar.value = e.loaded;
		    }
		}
		xhr.upload.onloadstart = function (e) {
		    progressBar.value = 0;
		}
		xhr.upload.onloadend = function (e) {
		    progressBar.value = e.loaded;
		}
		xhr.send(formData);
	}
</script>