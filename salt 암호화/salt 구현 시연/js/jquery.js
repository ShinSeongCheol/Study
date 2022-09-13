$(function () {

    $("#startButton").on("click", function () {
        $("#startButton").fadeOut(1000);
        $("#loginButton").delay(1000).fadeIn(1000);
        $("#registerButton").delay(1000).fadeIn(1000);
    });

    $("#loginButton").on("click", function () {
        $("#registerButton").fadeOut().finish();
        $("#loginButton").fadeOut().finish();
        $("#loginId").fadeIn().finish();
        $("#loginPassword").fadeIn().finish();
        $("#loginBox").slideDown(1000);
        $(".wrapper h1").animate({ top: "-30%" });
    });

    $("#registerButton").on("click", function () {
        $("#registerButton").fadeOut().finish();
        $("#loginButton").fadeOut().finish();
        $("#registerId").fadeIn().finish();
        $("#registerPassword").fadeIn().finish();
        $("#registerBox").slideDown(1000);
        $(".wrapper h1").animate({ top: "-30%" });
    });

    $("#retryLogin").on("click", function () {
        $("#loginBox").hide();
        $("#registerBox").hide();
        $(".wrapper h1").animate({ top: "-40%" });
        $("#loginButton").fadeIn(1000);
        $("#registerButton").fadeIn(1000);
        $("#loginId").val("");
        $("#loginPassword").val("");
        $("h2").remove();
        $("h3").remove();
        $("#confirmLogin").show();
    });

    $("#retryRegister").on("click", function () {
        $("#loginBox").hide();
        $("#registerBox").hide();
        $(".wrapper h1").animate({ top: "-40%" });
        $("#loginButton").fadeIn(1000);
        $("#registerButton").fadeIn(1000);
        $("#registerId").val("");
        $("#registerPassword").val("");
        $("h2").remove();
        $("#confirmRegister").show();
    });

    $("#confirmLogin").on("click", function () {
        const loginForm = $("#loginF").serialize();

        $.ajax({
            url: "./php/login.php",
            type: "post",
            data: {
                loginForm
            },
            success: function (result) {
                $("#loginId").fadeOut().finish();
                $("#loginPassword").fadeOut().finish();
                try {
                    const json = JSON.parse(result);
                    if (json.success) {
                        $("#retryLogin").before("<h2>로그인 성공!!</h2>");
                        $("#retryLogin").before("<h3 style='background-color:red; width:825px;'>이전 비밀번호 : " + json.oldPassword + "</h3>");
                        $("#retryLogin").before("<h3 style='background-color:red'>New 비밀번호 : " + json.newPassword + "</h3>");
                    }
                }
                catch (e) {
                    $("#retryLogin").before("<h2>" + result + "</h2>");
                }
                $("#confirmLogin").hide();
            }
        });
    });

    $("#confirmRegister").on("click", function () {
        const registerForm = $("#registerForm").serialize();
        $.ajax({
            url: "./php/register.php",
            type: "post",
            data: {
                registerForm
            },
            success: function (result) {
                $("#registerId").fadeOut().finish();
                $("#registerPassword").fadeOut().finish();
                $("#retryRegister").before("<h2>" + result + "</h2>");
                $("#confirmRegister").hide();
            }
        });
    });
});