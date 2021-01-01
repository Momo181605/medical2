package cn.why.servlet;

import cn.why.dao.MedicalDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();

        MedicalDAO medicalDAO = new MedicalDAO();
        //如果销售成功
        if(medicalDAO.sellingMedicl(request.getParameter("name"))){
            //重定向
            response.sendRedirect("MedicalListServlet");

        }else{
            out.print("<script type='text/javascript'>");
            out.print("alert('购买失败，货物已下架');");
            out.print("location='MedicalListServlet'");
            out.print("</script>");
//            response.sendRedirect("MedicalListServlet");
        }


    }
}
