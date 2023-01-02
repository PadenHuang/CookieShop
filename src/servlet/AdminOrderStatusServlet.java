package servlet;

import service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ 该类用于管理订单状态
 * */
@WebServlet(name = "admin_order_status",urlPatterns = "/admin/order_status")
public class AdminOrderStatusServlet extends HttpServlet {

    private OrderService oService = new OrderService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取订单id
        int id = Integer.parseInt(request.getParameter("id"));
        //获取订单状态
        int status = Integer.parseInt(request.getParameter("status"));
        oService.updateStatus(id, status);//更新订单状态
        //response.sendRedirect("/admin/order_list?status="+status);
        request.getRequestDispatcher("/admin/order_list?status="+status).forward(request, response); //请求转发页面并更新订单状态
    }
}