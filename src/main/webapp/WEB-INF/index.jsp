<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/lib/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/lib/layui/css/layui.css"/>
    <style type="text/css">
        .header{
            background-image: url("<%=basePath%>/img/color.jpeg");
            background-size: 100%;
            height: 240px;
        }
        #code{
            font-family:Arial;
            font-style:italic;
            font-weight:bold;
            letter-spacing:2px;
            color: #393D49;
            width: 70px;
        }
        #content{
            width:40%;
            margin: 6% 30% 0 30%;
            height: 53%;
        }

    </style>
</head>
<body>
<div class="header">
    <div style="margin: 0 45% 0 45%;padding-top:5%;text-align:center;">
        <div style="height:39px;width:167px;background:black;text-align:center;">
            <h3 style="font-family: Menlo;color:white;padding-top:6px;"><strong>TyCoding</strong></h3>
        </div>
        <h4 style="margin-top:45px;">
            &nbsp;
            <span style="font-size:20px;" class="fa fa-github fa-fw"></span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size:20px;" class="fa fa-home fa-fw"></span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="font-size:20px;" class="fa fa-linkedin fa-fw"></span>
            <br/>
            <label><a href="https://github.com/TyCoding">GitHub</a></label>
            &nbsp;&nbsp;&nbsp;
            <label><a href="www.tycoding.cn">Blog</a></label>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label><a href="https://www.zhihu.com/people/tomo-83-82/activities">ZhiHu</a></label>
        </h4>
    </div>
</div>

<div class="container">
    <div id="content">
        <h2 class="text-nowrap" style="color: #393D49;text-align:center;padding-top:20px;font-family: Menlo">文章管理系统</h2>
        <div style="text-align: center;">
            <br/>
            <br/>
            <label style="font-size:20px;color:white;padding-right:50px;">
                <a href="#" id="login" style="text-decoration: none;border-bottom:2px solid #009688;color:#009688">登录</a>
            </label>
            <label style="font-size:20px;color:white;padding-left:50px;">
                <a href="#" id="register" style="text-decoration:none;">注册</a>
            </label>
        </div>
        <hr style="color: #484848;text-align:center;"/>
        <!-- 登录的表单 -->
        <form action="<%=basePath%>/admin/login.do" id="loginform" method="post" class="layui-form" style="text-align: center;margin-right:58px;margin-top:40px;">
            <input name="a_id" hidden="hidden" value="${a_id}"/>
            <div>
                <div class="layui-form-item layui-inline" style="width:110%">
                    <label class="layui-form-label" style="margin-left:58px;"><i class="fa fa-user fa-fw"></i></label>
                    <div class="layui-input-inline">
                        <input type="text" name="a_name" class="layui-input" style="background:none;border: none;border-bottom:1px solid white;" placeholder="Username"/>
                    </div>
                </div>

                <br/>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">
                        <span class="fa fa-lock fa-fw"></span>
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" name="a_password" class="layui-input" style="background:none;border: none;border-bottom:1px solid white;" placeholder="Password"/>
                    </div>
                </div>
                <br/>
                <br/>
                <div style="text-align:center;color: #009688;background-color: #01AAED;width:48%;margin-left:138px;">
                    <input type="submit" class="layui-btn layui-btn-lg" style="background: none;" value="Sing in"/>
                </div>
            </div>
        </form>
        <!-- 注册的表单 -->
        <form action="<%=basePath%>/admin/register.do" id="registerform" method="post" class="layui-form" hidden="hidden" style="text-align: center;margin-right:58px;margin-top:40px;">
            <div>
                <div class="layui-form-item layui-inline" style="width:110%">
                    <label class="layui-form-label" style="margin-left:58px;"><i class="fa fa-user fa-fw"></i></label>
                    <div class="layui-input-inline">
                        <input type="text" name="a_name" id="a_name" onblur="return checkName();" class="layui-input" style="background:none;border: none;border-bottom:1px solid white;" placeholder="Username"/>
                    </div>
                    <span id="info"></span>
                </div>
                <br/>
                <div class="layui-form-item layui-inline">
                    <label class="layui-form-label">
                        <span class="fa fa-lock fa-fw"></span>
                    </label>
                    <div class="layui-input-inline">
                        <input type="password" name="a_password" id="a_password" class="layui-input" style="background:none;border: none;border-bottom:1px solid white;" placeholder="Password"/>
                    </div>
                </div>
                <br/>
                <div class="layui-form-item layui-inline" style="margin-left: 58px;">
                    <label class="layui-form-label">
                        <span class="fa fa-envelope fa-fw"></span>
                    </label>
                    <div class="layui-input-inline" style="width: 32%;">
                        <input type="text" id="check" class="layui-input" style="background:none;border: none;border-bottom:1px solid white;"/>
                    </div>
                    <div class="layui-input-inline">
                        <input id="code" onclick="createCode()" type="button" style="background:none;border: none;margin-left:198px;margin-top:-27px;"/>
                    </div>
                </div>
                <br/>
                <br/>
                <div style="text-align:center;color: #009688;background-color: #01AAED;width:48%;margin-left:138px;">
                    <input type="button" class="layui-btn layui-btn-lg" style="background: none;" value="Sing up" onclick="validate()"/>
                </div>
            </div>
        </form>

    </div>
</div>
</body>
<script src="<%=basePath%>/lib/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>/lib/layui/layui.all.js"></script>
<script type="text/javascript">
    layui.use(['layer','element'], function(){
        var layer = layui.layer;
        var element = layui.element;
    });
    $("#register").click(function(){
        $("#login").css({'border':'none','color':'#393D49'});
        $(this).css({'border-bottom':'2px solid #009688','color':'#009688'});
        $("#loginform").hide();
        $("#registerform").show();
    });
    $("#login").click(function(){
        $("#register").css({'border':'none','color':'#393D49'});
        $(this).css({'border-bottom':'2px solid #009688','color':'#009688'});
        $("#registerform").hide();
        $("#loginform").show();
    });
    function checkName(){
        var a_name = $("#a_name").val();
        if(a_name != ''){
            $.ajax({
                url: '<%=basePath%>/admin/findByName.do',
                type: 'post',
                dataType: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({"a_name": a_name}),
                success: function(data){
                    if(data == null){
                        $("#info").text("可以注册").css({'color':'green','font-size':'1px'});
                        return true;
                    }
                    if(data != null){
                        $("#info").text("该用户名已注册").css({'color':'red','font-size':'1px'});
                        return false;
                    }
                },
                error: function(){
                    alert("错误");
                    return false;
                }
            });
        }
        if(a_name == ''){
            $("#info").text("");
        }
    }
</script>
<script type="text/javascript">
    //设置一个全局的变量，便于保存验证码
    var code;
    function createCode(){
        //首先默认code为空字符串
        code = '';
        //设置长度，这里看需求，我这里设置了4
        var codeLength = 4;
        var codeV = document.getElementById('code');
        //设置随机字符
        var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
        //循环codeLength 我设置的4就是循环4次
        for(var i = 0; i < codeLength; i++){
            //设置随机数范围,这设置为0 ~ 36
            var index = Math.floor(Math.random()*36);
            //字符串拼接 将每次随机的字符 进行拼接
            code += random[index];
        }
        //将拼接好的字符串赋值给展示的Value
        codeV.value = code;
    }

    //下面就是判断是否== 的代码，无需解释
    function validate(){
        var oValue = document.getElementById('check').value.toUpperCase();
        if(oValue == 0){
            layer.open({
                title: '警告信息',
                content: '请输入验证码'
            });
        }else if(oValue != code){
            $("#check").val("");
            layer.open({
                title: '警告信息',
                content: '您输入的验证码不正确，请重新输入'
            });
            createCode();
        }else if(checkName()){
            layer.open({
                title: '警告信息',
                content: '您输入的用户名有误，请重新输入'
            });
        }else{
            $("#registerform").submit();
        }
    }
    //设置此处的原因是每次进入界面展示一个随机的验证码，不设置则为空
    window.onload = function (){
        createCode();
    }
</script>

</html>
