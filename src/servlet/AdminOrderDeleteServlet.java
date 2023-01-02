package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;

import java.io.IOException;

@WebServlet(name = "admin_order_delete",urlPatterns = "/admin/order_delete")
public class AdminOrderDeleteServlet extends HttpServlet {

    private OrderService oService = new OrderService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //获取订单id参数
        int id = Integer.parseInt(request.getParameter("id"));
        //删除该订单id
        oService.delete(id);
        //请求转发页面
        request.getRequestDispatcher("/admin/order_list").forward(request, response);
    }
}
