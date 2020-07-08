$(".dropdown").mouseover(function () {
    $(this).addClass("show").find(".dropdown-menu").addClass("show");
});
$(".dropdown .dropdown-menu").mouseout(function () {
    $(this).removeClass("show").parent(".dropdown").removeClass("show")
});
function signout() {
    alert("您已退出登录");
    window.location.href="/SkipServlet?skip=logout"
}
function change() {
    var from = document.getElementById("from").value;
    var to = document.getElementById("to").value;
    document.getElementById("from").value = to;
    document.getElementById("to").value = from;
}
$(function () {
    $('#go-off').datetimepicker({
        format:'yyyy-mm-dd',
        language:'zh-CN',
        autoclose:'true',
        minView:'month'
    });
    $('#go-off2').datetimepicker({
        format:'yyyy-mm-dd',
        language:'zh-CN',
        autoclose:'true',
        minView:'month'
    });
});
function click() {
    
}
$().ready(function()
{
    validate();
})
function validate(){

    $("#register").validate({

        errorElement:'span',
        errorPlacement: function(error, element) {
            error.appendTo(element.parent());
        },
        rules:{
            usr:{
                required:true,
                minlength:6,
                maxlength:20
            },
            name:{
                required:true,
                minlength:2,
                maxlength:8
            },
            pwd:{
                required:true,
                minlength:6,
                maxlength:20
            },
            cpwd:{
                required:true,
                minlength:6,
                maxlength:20,
                equalTo:"#pwd"
            },
            tel:{
                required:true,
                minlength:11,
                maxlength:11
            },
            number:{
                required:true,
                minlength:18,
                maxlength:18
            },
            site:{
                required:true
            },
            agree:"required"
        },
        messages:{
            usr:{
                required:"请输入用户名",
                minlength:"用户名长度不能小于6位",
                maxlength:"用户名长度不能大于20位"
            },
            name:{
                required:"请输入姓名",
                minlength:"姓名长度不能小于2位",
                maxlength:"姓名长度不能大于15位"
            },
            pwd:{
                required:"请输入密码",
                minlength:"密码长度不能小于6位",
                maxlength:"密码长度不能大于20位"
            },
            cpwd:{
                required:"请确认密码",
                minlength:"密码长度不能小于6位",
                maxlength:"密码长度不能大于20位",
                equalTo:"两次密码输入不一致"
            },
            tel:{
                required:"请输入电话号码",
                minlength:"请输入正确的电话号码",
                maxlength:"请输入正确的电话号码"
            },
            number:{
                required:"请输入身份证号",
                minlength:"请输入正确的身份证号码",
                maxlength:"请输入正确的身份证号码"
            },
            site:{
                required:"请输入地址"
            },
            agree:""
        }
    })
}