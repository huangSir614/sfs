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

@WebServlet("/pwdServlet")
public class pwdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String pwd = request.getParameter("pwd");

        Map<String, Object> map_pwd = new HashMap<String, Object>();

        if (pwd.length()>5 && pwd.length()<10){
            map_pwd.put("pwdExist",true);
            map_pwd.put("msg","√");
        }else {
            map_pwd.put("pwdExist",false);
            map_pwd.put("msg","6到9位密码");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map_pwd);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
