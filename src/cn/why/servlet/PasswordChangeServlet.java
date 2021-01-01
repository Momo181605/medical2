package cn.why.servlet;

import cn.why.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PasswordChangeServlet")
public class PasswordChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");

        PrintWriter out = response.getWriter();

        //根据name获得值
        //获取请求参数
        String username = (String) request.getSession().getAttribute("username");
        String oldapplicantPwd = request.getParameter("oldapplicantPwd");
        String newapplicantPwd = request.getParameter("newapplicantPwd");
        String surenewapplicantPwd = request.getParameter("surenewapplicantPwd");

        ApplicantDAO applicantDAO = new ApplicantDAO();
        //判断是否成功修改密码
        boolean flag = applicantDAO.passwordChange(username,oldapplicantPwd,newapplicantPwd,surenewapplicantPwd);
        if(flag == true){
            response.sendRedirect("/medicalMS/html/login.html");
        }else{
            out.print("<script type='text/javascript'>");
            out.print("alert('修改失败，请仔细核对信息！');");
            //重定向
            out.print("location ='/medicalMS/jsp/passwordchange.jsp'");
            out.print("</script>");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
