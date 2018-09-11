<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
        <article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>게시글 작성</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form>

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
						<button class="btn btn-primary " name="submit" type="submit">Submit</button>
					</div>
					
				</form>								
			
            </div>

        </article>