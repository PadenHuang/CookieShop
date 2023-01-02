/*
*    版本1：2022.5.26
*           说明：说明该源码存在一定问题*/
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "user_login",urlPatterns = "/user_login")
public class UserLoginServlet extends HttpServlet {

    private UserService uService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ue = request.getParameter("ue"); //获取用户名
        String password = request.getParameter("password"); //获取密码
        User user = uService.login(ue, password); //登录
        if(user==null) {
            request.setAttribute("failMsg", "用户名、邮箱或者密码错误，请重新登录！");
            request.getRequestDispatcher("user_login.jsp").forward(request, response);
        }else {
            request.getSession().setAttribute("user", user);
            //登录成功之后自动跳转到个人中心
            request.getRequestDispatcher("/user_center.jsp").forward(request, response);
            /*如果修改跳转到首页——index.jsp，由于页面没有经过servlet的渲染，页面的图片显示不全——没有焦点图数据，热销图推荐，新品推荐数据*/
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
