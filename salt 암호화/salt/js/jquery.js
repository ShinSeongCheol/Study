$(function () {

    $("#startButton").on("click", function () {
        $("#startButton").fadeOut(1000);
        $("#loginButton").delay(1000).fadeIn(1000);
        $("#registerButton").delay(1000).fadeIn(1000);
    });

    $("#loginButton").on("click", function () {
        $("#registerButton").fadeOut().finish();
        $("#loginButton").fadeOut().finish();
        $("#registerId").fadeIn().finish();
        $("#registerPassword").fadeIn().finish();
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

    $("#confirmLogin").on("click", function(){
        console.log($("#loginId").val());
        console.log($("#loginPassword").val());
    });

    $("#confirmRegister").on("click", function(){
        const registerForm = $("#registerForm").serialize();
        $.ajax({
            url:"./php/register.php",
            type:"post",
            data: {
                registerForm
            },
            success: function(result) {
                $("#registerId").fadeOut().finish();
                $("#registerPassword").fadeOut().finish();
                $("#retryRegister").before("<h2>" + result + "</h2>");
                $("#confirmRegister").hide();
            }
        });
    });
});