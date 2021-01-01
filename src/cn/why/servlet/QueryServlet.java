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

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");

        String drugname = request.getParameter("drugname");
        MedicalDAO medicalDAO = new MedicalDAO();
        List<Medical> medicals = medicalDAO.getMedicls(drugname);
        request.setAttribute("medicals",medicals);
        //请求转发
        request.getRequestDispatcher("jsp/homepage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
