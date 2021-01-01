package cn.why.servlet;

import cn.why.bean.Medical;
import cn.why.dao.MedicalDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddDrugServlet")
public class AddDrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("drugname");
        Integer price = Integer.valueOf(request.getParameter("price"));
        Integer number = Integer.valueOf(request.getParameter("number"));
        String status = request.getParameter("status");
        String describe = request.getParameter("describe");

        MedicalDAO medicalDAO = new MedicalDAO();
        if(medicalDAO.addMedicl(name,price,number,status,describe)){
            response.sendRedirect("MedicalListServlet");
        }
    }
}
