package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import org.apache.commons.beanutils.BeanUtils;
import service.TypeService;

import java.io.IOException;

@WebServlet(name = "admin_type_edit",urlPatterns = "/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {
    private TypeService tService = new TypeService();
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Type t = new Type(); //创建新的Type实体
        try {                        /*浅拷贝：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝，此为浅拷贝
                                      深拷贝：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容*/
            BeanUtils.copyProperties(t, request.getParameterMap());//BeanUtils.copyProperties 为深度拷贝,复制对象的一切属性
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tService.update(t);//更新类目名
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
