package cn.why.servlet;

import cn.why.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccountCancellationServlet")
public class AccountCancellationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String)request.getSession().getAttribute("username");
        ApplicantDAO applicantDAO = new ApplicantDAO();
        if(applicantDAO.deleteAccount(username)){
            response.sendRedirect("html/login.html");
        }
    }
}
