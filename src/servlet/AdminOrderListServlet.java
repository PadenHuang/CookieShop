package servlet;

import model.Page;
import service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin_order_list",urlPatterns = "/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int status = 0;  //订单状态
        if(request.getParameter("status") != null) { //获取请求参数status——状态——从jsp获取
            status=Integer.parseInt(request.getParameter("status") ) ; /*将字符串参数解析为带符号的十进制整数。*/
        }
        request.setAttribute("status", status); //设置订单状态

        int pageNumber = 1;//页码
        if(request.getParameter("pageNumber") != null) { //获取请求参数pageNumber——页码
            try {
                pageNumber=Integer.parseInt(request.getParameter("pageNumber") ) ;/*将字符串参数解析为带符号的十进制整数。*/
            }
            catch (Exception e)
            {

            }
        }
        if(pageNumber<=0) //强制页码必须从1开始
            pageNumber=1;

     //设置页码
        Page p = oService.getOrderPage(status,pageNumber);
        if(p.getTotalPage()==0) //如果获取到的页码为0，则必须强制设置页码为1
        {
            p.setTotalPage(1);
            p.setPageNumber(1);
        }
        else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = oService.getOrderPage(status,pageNumber);
            }
        }

        request.setAttribute("p", p);
        request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
    }
}
