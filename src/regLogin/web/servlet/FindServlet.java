package regLogin.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import regLogin.domain.User;
import regLogin.service.impl.userServiceImpl;
import regLogin.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");


        String name = request.getParameter("name");
        System.out.println(name);
        Map<String, Object> map = new HashMap<String, Object>();
        userService service = new userServiceImpl();
        User u_user = service.find(name);
        if (u_user!=null){
            map.put("userExsit",true);
            map.put("msg","已存在用户");
        }else if (name.equals("")){
            map.put("userExsit",true);
            map.put("msg","用户名不能为空");
        } else {
            map.put("userExsit",false);
            map.put("msg","√");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
