package cn.why.servlet;

import cn.why.bean.Applicant;
import cn.why.bean.Medical;
import cn.why.dao.ApplicantDAO;
import cn.why.dao.MedicalDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DrugServlet")
public class DrugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicalDAO medicalDAO = new MedicalDAO();
        Medical medical = medicalDAO.getMedicl(request.getParameter("name"));
        request.setAttribute("medical",medical);
        String usertype = (String) request.getSession().getAttribute("usertype");
        if(usertype.equals("用户")) {
            //请求转发
            request.getRequestDispatcher("jsp/userdrugpage.jsp").forward(request, response);
        }else if(usertype.equals("管理员")) {
            //请求转发
            request.getRequestDispatcher("jsp/admindrugpage.jsp").forward(request, response);
        }

    }
}
