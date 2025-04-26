<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>회원 가입</title>
</head>
<body>
    <!-- validation check
        브라우저 내장 유효성 검사 off
        BootStrap이 제공하는 유효성 검사 O
    -->
    <div class="container">
        <div class="mb-3 mt-5 d-flex justify-content-center">
            <h1 class="display-4">수현이 세상</h1>
        </div>
        <div class="mb-3">
            <h2>회원 가입</h2>
        </div>
        <form novalidate>
            <div class="mb-3">
                <label for="userName" class="form-label">User Name : </label>
                <input type="text" class="form-control" id="userName" name = "userName" placeholder="Enter User Name">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback">User Name은 두 글자 이상입니다.</div>

            </div>
            <div class="mb-3">
                <label for="userPassword" class="form-label">Password : </label>
                <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="Enter Password">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback"> Password는 한 개이상의 특수문자, 알파벳, 숫자를 포함해야 합니다.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword2" class="form-label">Password Confirm : </label>
                <input type="password" class="form-control" id="userPassword2" name="userPassword2" placeholder="Confirm Password">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback"> Password가 일치하지 않습니다.</div>
            </div>
            <div class="mb-3">
                <label for="userEmail" class="form-label">Email : </label>
                <input type="email" class="form-control" id="userEmail" name="userEmail" placeholder="Enter Email">
                <div class="valid-feedback">Valid</div>
                <div class="invalid-feedback"> 올바르지 않은 Email 형식입니다.</div>
            </div>
        </form>
        <div>
            <button type="button" id="btnRegister" class="btn btn-primary">회원 가입</button>
        </div>
    </div>


<script>
    window.onload = function (){
        // btnRegister 처리
        document.querySelector("#btnRegister").onclick = function (){
            // validation check
            if(document.querySelector("form .is-invalid").length>0) {
                alert("입력이 올바르지 않습니다.");
                return;
            }
            register();

            // focus 를 잃을 때 <= 입력 완료하고 다른 입력으로 넘어갈 때
        }
        document.querySelector("#userName").onblur = function (){
            if(validateUserName(this.value)){
                this.classList.remove("is-invalid");
                this.classList.add("is-valid");
            }else{
                this.classList.remove("is-valid");
                this.classList.add("is-invalid");
            }
        }

        document.querySelector("#userPassword").onblur = function (){
            if(validatePassword(this.value)){
                this.classList.remove("is-invalid");
                this.classList.add("is-valid");
            }else{
                this.classList.remove("is-valid");
                this.classList.add("is-invalid");
            }
        }

        document.querySelector("#userPassword2").onblur = function (){
            if(validateUserPassword2(this.value)){
                this.classList.remove("is-invalid");
                this.classList.add("is-valid");
            }else{
                this.classList.remove("is-valid");
                this.classList.add("is-invalid");
            }
        }

        document.querySelector("#userEmail").onblur = function (){
            if(validateUserEmail(this.value)){
                this.classList.remove("is-invalid");
                this.classList.add("is-valid");
            }else{
                this.classList.remove("is-valid");
                this.classList.add("is-invalid");
            }
        }
    }

    function validateUserName(userName){
        // 2글자 이상
        return userName.length >= 2;
    }

    function validatePassword(userPassword){
        // 알파벳 적어도 1개
        // 특수문자 적어도 1개
        // 숫자 적어도 1개
        let patternEngAtListOne = new RegExp(/[a-zA-Z]+/);// + for at least one
        let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/);// + for at least one
        let patternNumAtListOne = new RegExp(/[0-9]+/);// + for at least one
        return patternEngAtListOne.test(userPassword) &&
            patternSpeAtListOne.test(userPassword) &&
            patternNumAtListOne.test(userPassword);
    }


    function validateUserPassword2(userPassword2){
        return userPassword2 == document.querySelector("#userPassword").value;
    }

    function validateUserEmail(userEmail){
        let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        return regexp.test(userEmail);
    }

    async function register(){
        // 사용자 입력 값
        let userName = document.querySelector("#userName").value;
        let userPassword = document.querySelector("#userPassword").value;
        let userEmail = document.querySelector("#userEmail").value;

        // x-www-form-urlencoded
        let urlParams = new URLSearchParams({
            userName : userName,
            userPassword : userPassword,
            userEmail : userEmail,
        });

        // fetch Option
        let fetchOptions = {
            method : "POST",
            body : urlParams
        }

        let response = await fetch("/user/register",fetchOptions);
        console.log(response);
        let data = await response.json();

        if(data.result == "success"){
            alert("회원가입에 성공했습니다.");
            // 로그인 페이지 이동
            window.location.href = "/pages/login";
        }else{
            alert("회원가입에 실패했습니다.");
        }
    }
</script>
</body>
</html>