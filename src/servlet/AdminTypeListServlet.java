package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "admi_type_list",urlPatterns = "/admin/type_list")
public class AdminTypeListServlet extends HttpServlet {

    private TypeService tService = new TypeService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> list= tService.GetAllType(); //设置List集合变量list接受查询到的类目信息
        request.setAttribute("list", list); //设置参数
		this.getServletContext().removeAttribute("typeList");
        this.getServletContext().setAttribute("typeList",list); //移除参数原先参数typelist并设置成新参数list
        request.getRequestDispatcher("/admin/type_list.jsp").forward(request, response);//请求转发页面
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
