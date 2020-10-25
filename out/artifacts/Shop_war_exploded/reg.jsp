<%--
  Created by IntelliJ IDEA.
  User: huangbinggong
  Date: 2020/5/26
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>reg</title>

    <link href="css/reg.css" type="text/css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <%--     提交判断规范--%>
    <script language="JavaScript">
        <%int checkSum = 0;%>
        function checkExist() {
            if (document.getElementById("u457_input").value=="")
            {
                alert("用户名不能为空");
               document.getElementById("u457_input").focus();
                return false;
            }
            if (document.getElementById("u458_input").value=="")
            {
                alert("密码不能为空");
               document.getElementById("u458_input").focus();
                return false;
            }
            if (document.getElementById("u459_input").value!=document.getElementById("u458_input").value)
            {
                alert("两次密码不一样");
               document.getElementById("u459_input").focus();
                return false;
            }
            if (document.getElementById("u460_input").value=="")
            {
                alert("地址不能为空");
               document.getElementById("u460_input").focus();
                return false;
            }
            if (document.getElementById("u462_input").value=="")
            {
                alert("电话不能为空");
               document.getElementById("u462_input").focus();
                return false;
            }
            if (document.getElementById("check_code").value=="")
            {
                alert("验证码不能为空");
                document.getElementById("check_code").focus();
                return false;
            }
            <% if (checkSum==1){%>
                alert("输入错误");
                document.getElementById("check_code").focus();
                return false;
            <%}%>


            return true;
        }

    </script>


    <%--    判断是否已存在用户--%>
    <script>
        $(function () {
            $("#u457_input").blur(function () {
                var name = $(this).val();

                $.get("findServlet",{name:name},function (data) {
                    var  span = $("#s_username");
                    if (data.userExsit){
                        span.css("color","red");
                        span.html(data.msg);
                    }else {
                        span.css("color","green");
                        span.html(data.msg);
                    }


                },"json");


            });
        });
    </script>

    <%--    密码判断--%>
    <script>
        $(function () {
            $("#u458_input").blur(function () {
                var pwd = $(this).val();

                $.get("pwdServlet",{pwd:pwd},function (data) {
                    var  span_pwd = $("#s_pwd");
                    if (data.pwdExsit){
                        span_pwd.css("color","red");
                        span_pwd.html(data.msg);
                    }else {
                        // span_pwd.css("color","green");
                        span_pwd.html(data.msg);
                    }


                },"json");


            });
        });
    </script>
    <%--    确认密码判断--%>
    <script>
        $(function () {
            $("#u459_input").blur(function () {
                var pwdl = $(this).val();
                var pwd = $("#u458_input").val();

                $.get("pwdlServlet",{pwdl:pwdl,pwd:pwd},function (data) {
                    var  span = $("#s_pwdl");
                    if (data.pwdlExsit){
                        span.css("color","red");
                        span.html(data.msg);
                    }else {
                        span.css("color","green");
                        span.html(data.msg);
                    }


                },"json");



            });
        });

    </script>

    <%--    地址不为空处理--%>
    <script>
        $(function () {
            $("#u460_input").blur(function () {
                var dizhi = $(this).val();

                $.get("addressServlet",{dizhi:dizhi},function (data) {
                    var  span = $("#s_dizhi");
                    if (data.addressExsit){
                        span.css("color","red");
                        span.html(data.msg);
                    }else {
                        span.css("color","green");
                        span.html(data.msg);
                    }


                },"json");



            });
        });

    </script>
    <%--    手机号判断--%>
    <script>
        $(function () {
            $("#u462_input").blur(function () {
                var tel = $(this).val();

                $.get("telServlet",{tel:tel},function (data) {
                    var span_tel = $("#s_tel");
                    if (data.telExsit){
                        span_tel.css("color","red");
                        span_tel.html(data.msg);
                    }else {
                        span_tel.css("color","green");
                        span_tel.html(data.msg);
                    }
                },"json");

            });

        })



    </script>
    <%--验证码切换--%>
    <script>

        function Cocheck() {
            var img = document.getElementById("code");
            var date = new Date().getTime();
            img.onclick=function () {
                img.src="${pageContext.request.contextPath}/checkCodeServlet?"+date;
            }
        }
    </script>
    <%--验证码判断--%>
    <script>
        $(function () {
            $("#check_code").blur(function () {
                var check = $(this).val();

                $.get("checkServlet",{check:check},function (data) {
                    var  span = $("#s_check");
                    if (data.codeExsit){
                        span.css("color","red");
                        span.html(data.msg);
                        <%checkSum=0;%>
                    }else {
                        span.css("color","green");
                        span.html(data.msg);
                        <%checkSum=1;%>
                    }


                },"json");

            });
        });
    </script>




</head>
<body>


<div class="reg_bg">
    <div class="reg_left">
        <img src="images/购物车/u22.png">

    </div>

    <div class="reg_cen">
        <form action="regServlet" method="post">

            <table>

                <tr>

                    <td colspan="2" align="center">
                        <!-- 标题 -->
                        <div id="biaoqian">用户注册</div>
                    </td>

                </tr>
                <tr>
                    <td class="td_left">
                        <!-- 账号 -->
                        <p><span>账号：</span></p>
                    </td>
                    <td class="td_right">
                        <!-- 账号 (文本框) -->
                        <input id="u457_input" type="text" value="" name="name" placeholder="请输入"/>
                    </td>
                    <td><span id="s_username"></span></td>

                </tr>
                <%--    密码--%>
                <tr>
                    <td class="td_left">
                        密码：
                    </td>
                     <td class="td_right">
                <!-- 密码 (文本框) -->
                         <input id="u458_input" type="text" value="" name="pwd" placeholder="请输入"/>
                     </td>
                     <td><span id="s_pwd" style="display: block"></span></td>
                 </tr>
                 <tr>
                      <td class="td_left">
                     确认密码：
                     </td>
                      <td class="td_right">
                    <!-- 确认密码 (文本框) -->
                    <input id="u459_input" type="text" value="" name="pwdl" placeholder="请再输入密码"/>
                    </td>
                     <td><span id="s_pwdl"></span></td>
                </tr>

            <%--    地址--%>
                <tr>
                    <td class="td_left">
                        <!-- 地址 -->
                        地址：
                    </td>
                    <td class="td_right">
                        <!-- 地址 (文本框) -->
                        <input id="u460_input" type="text" value="" name="dizhi" placeholder="请输入"/>
                    </td>
                    <td><span id="s_dizhi"></span></td>
                </tr>

            <%--    手机号--%>
                <tr>
                    <td class="td_left">
                        <!-- 手机号 -->
                        手机号：
                    </td>
                    <td class="td_right">
                        <!-- 电话 (文本框) -->
                        <input id="u462_input" type="text" value="" name="tel" placeholder="请输入"/>
                    </td>
                    <td><span id="s_tel"></span></td>
                </tr>
                <%--    验证码--%>
                <tr>
                    <td class="td_left">
                        <!-- 验证码 -->
                        验证码：
                    </td>
                    <td class="td_right">
                        <!-- 验证码 (文本框) -->
                        <input id="check_code" type="text" value="" name="check" placeholder="请输入"/>
                        <a href="javascript:Cocheck();">
                            <img src="${pageContext.request.contextPath}/checkCodeServlet" id="code">
                        </a>

                    </td>
                    <td><span id="s_check"></span></td>
                </tr>

            <%--    注册按钮--%>
                <tr>
                    <td colspan="2" align="center"><!-- 注册按钮 -->
                        <input id="u463_input" type="submit" value="注册" onclick="return checkExist()" />
                    </td>
                </tr>

            </table>

            </form>

        </div>


</div>





</body>
</html>
