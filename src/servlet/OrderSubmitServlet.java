/*
//版本控制1：导入的jar包出现问题——404
package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order_submit",urlPatterns = "/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user")!=null) {
            request.getRequestDispatcher("/order_submit.jsp").forward(request, response);
        }else {
            request.setAttribute("failMsg", "请登录后，再提交订单！");
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }
    }
}
*/

package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "order_submit",urlPatterns = "/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user")!=null) {
            request.getRequestDispatcher("/order_submit.jsp").forward(request, response);
        }else {
            request.setAttribute("failMsg", "请登录后，再提交订单！");
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        }
    }
}
