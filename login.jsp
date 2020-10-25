<%--
  Created by IntelliJ IDEA.
  User: huangbinggong
  Date: 2020/5/16
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/login/styles.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<div id="base" class="">

    <%
        Object mess = request.getAttribute("message");
        if (mess != null && !"".equals(mess)){
    %>
    <script language="JavaScript">
        alert("<%=mess%>")
    </script>

    <%}%>


    <!-- Unnamed (矩形) -->
    <div id="u465" class="ax_default box_2">
        <div id="u465_div" class=""></div>
    </div>

    <!-- Unnamed (图片) -->
    <div id="u466" class="ax_default image">
        <img id="u466_img" class="img " src="images/login/u466.jpg"/>
    </div>

    <!-- Unnamed (矩形) -->
    <div id="u467" class="ax_default box_1">
        <div id="u467_div" class=""></div>
    </div>

    <!-- Unnamed (矩形) -->
    <div id="u468" class="ax_default label">
        <div id="u468_div" class=""></div>
        <div id="u468_text" class="text ">
            <p><span>账号</span></p>
        </div>
    </div>

    <!-- Unnamed (矩形) -->
    <div id="u469" class="ax_default label">
        <div id="u469_div" class=""></div>
        <div id="u469_text" class="text ">
            <p><span>密码</span></p>
        </div>
    </div>


    <form action="findUserServlet" method="post">
        <!-- 账号 (文本框) -->
        <div id="u470" class="ax_default text_field">
            <input id="u470_input" type="text" value="" name="name"/>
        </div>

        <!-- 密码 (文本框) -->
        <div id="u471" class="ax_default text_field">
            <input id="u471_input" type="text" value="" name="pwd"/>
        </div>


        <!-- 登录 (提交按钮) -->
        <div id="u474" class="ax_default html_button">
            <input id="u474_input" type="submit" value="登录"/>
        </div>
    </form>

    <!-- 注册 (提交按钮) -->
    <div id="u475" class="ax_default html_button">
        <a href="reg.jsp"><input id="u475_input" type="submit" value="注册"/></a>
    </div>

    <!-- Unnamed (图片) -->
    <div id="u476" class="ax_default image">
        <img id="u476_img" class="img " src="images/login/u476.png"/>
    </div>
</div>
</body>
</html>
