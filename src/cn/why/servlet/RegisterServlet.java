package cn.why.servlet;

import cn.why.bean.Applicant;
import cn.why.dao.ApplicantDAO;
import cn.why.bean.Applicant;
import cn.why.dao.ApplicantDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置和请求响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取请求参数
       String applicantUsername = request.getParameter("applicantUsername");
       String applicantPwd = request.getParameter("applicantPwd");
       String applicantStatus = request.getParameter("applicantStatus");

       System.out.println(applicantStatus);
        //插入到数据库中，对数据进行封装，自己封装成一个对象
        Applicant applicant = new Applicant(null,applicantUsername,applicantPwd,applicantStatus);
        //保存applicant到数据库
        ApplicantDAO applicantDAO = new ApplicantDAO();
        //flag是否注册成功
        boolean flag = applicantDAO.saveApplicant(applicant);

        if(flag){
            //注册成功就跳转到登录页面
            out.print("<script type='text/javascript'>");
            out.print("alert('注册成功！');");
            out.print("location='html/login.html'");
            out.print("</script>");
//            response.sendRedirect("/medicalMS/html/login.html");
        }else{
            //注册失败就返回注册页面 请求转发
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/html/register.html");
//            dispatcher.forward(request,response);
          response.sendRedirect("/medicalMS/html/register.html");
        }








//        PrintWriter out = response.getWriter();
//        //判断用户名是否被注册
//        ApplicantDAO dao = new ApplicantDAO();
//        boolean flag = dao.isExistUsername(applicantEmail);
//        if(flag){
//            //用户名已注册，进行错误提示
//            out.print("<script type='text/javascript'>");
//            out.print("alert('用户名已经被注册，请重新输入！');");
//            out.print("window.location = 'html/register.html';");
//            out.print("</script>");
//
//        }else{
//            //邮箱未被注册，保存注册用户信息
//            dao.save(applicantEmail,applicantPwd);
//            //注册成功重定向到登录界面
//            response.sendRedirect("html/login.html");
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置和请求响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
