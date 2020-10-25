package regLogin.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import regLogin.domain.User;
import regLogin.service.impl.userServiceImpl;
import regLogin.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        HttpSession session = request.getSession();
        Map<String, String[]> map = request.getParameterMap();
        //3.封装数据
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用find方法
        userService service = new userServiceImpl();
        User login_user = service.findUser(user);
        User admin_user = service.findAdmin(user);
        //5.跳转
        if (login_user!=null){//用户登录
            response.sendRedirect(request.getContextPath()+"/index.html");
        }else if (admin_user!=null){//管理员登录
            response.sendRedirect(request.getContextPath()+"/back_index.html");
        }else {//登陆失败
            request.setAttribute("message","账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
