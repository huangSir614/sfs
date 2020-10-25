package regLogin.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkServlet")
public class checkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                response.setContentType("text/html;charset=utf-8");

                String check = request.getParameter("check");
                HttpSession session = request.getSession();
                String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

                Map<String, Object> map = new HashMap<>();

                if (!checkcode_server.equalsIgnoreCase(check)){
                    map.put("codeExist",false);
                    map.put("msg","验证码错误");
                }else {
                    map.put("codeExist",true);
                    map.put("msg","√");
                }


                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(),map);


            }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
