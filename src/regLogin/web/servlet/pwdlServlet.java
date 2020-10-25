package regLogin.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/pwdlServlet")
public class pwdlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String pwd = request.getParameter("pwd");
        String pwdl = request.getParameter("pwdl");

        Map<String, Object> map = new HashMap<>();

        if (pwdl.equals(pwd)){
            map.put("pwdlExist",true);
            map.put("msg","√");
        }else {
            map.put("pwdlExist",false);
            map.put("msg","两次密码不一样");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
