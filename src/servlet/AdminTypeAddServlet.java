package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;

import java.io.IOException;

@WebServlet(name = "admin_type_add",urlPatterns = "/admin/type_add")
public class AdminTypeAddServlet extends HttpServlet {

    private TypeService tService = new TypeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //获取从表单得到的新的类目名
        tService.insert(new Type(name)); //创建新的Type实体并添加类目
        request.getRequestDispatcher("/admin/type_list").forward(request, response);//转发页面
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
