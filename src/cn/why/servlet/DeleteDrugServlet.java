package cn.why.servlet;

import cn.why.bean.Medical;
import cn.why.dao.MedicalDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteDrugServlet")
public class DeleteDrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Integer id = Integer.valueOf(request.getParameter("id"));
        MedicalDAO medicalDAO = new MedicalDAO();
        //如果删除成功
        if(medicalDAO.deleteMedicl(id)){
            response.sendRedirect("MedicalListServlet");
        }else{
            out.print("<script type='text/javascript'>");
            out.print("alert('删除失败！');");
            out.print("</script>");
        }

        out.flush();
        out.close();
    }
}
