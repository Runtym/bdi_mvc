<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<c:if test="${cnt eq 1}">
	<script>
		alert("회원가입이 정상적으로 완료 되었습니다.");
		//TODO 로그인 페이지로 이동
	</script>
</c:if>
<c:if test="${!empty err}">
	<script>
		alert("${err}");
		//TODO 로그인 페이지로 이동
	</script>
</c:if>
        <article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>회원가입 Form</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form" action="/user/userJoin" method="post">
                    <div class="form-group">
                        <label for="inputName">아이디</label>
                        <input type="text" class="form-control" id="uiid" name="uiid" required placeholder="아이디를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputName">성명</label>
                        <input type="text" class="form-control" id="uiname" name="uiname" required placeholder="이름을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">이메일 주소</label>
                        <input type="email" class="form-control" id="uiemail" name="uiemail" required placeholder="이메일 주소를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" class="form-control" id="uipwd" name="uipwd" required placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordCheck">비밀번호 확인</label>
                        <input type="password" class="form-control" id="uipwdchk" required placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" id="join-submit" class="btn btn-primary">
                            회원가입<i class="fa fa-check spaceLeft"></i>
                        </button>
                        <button type="submit" class="btn btn-warning">
                            가입취소<i class="fa fa-times spaceLeft"></i>
                        </button>
                    </div>
                </form>
            </div>

        </article>