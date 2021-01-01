package cn.why.servlet;

import cn.why.bean.Applicant;
import cn.why.dao.ApplicantDAO;
import cn.why.utils.DBUtils;
import cn.why.bean.Applicant;
import cn.why.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");


        PrintWriter out = response.getWriter();
        //根据name获得值
        //获取请求参数
        String applicantUsername = request.getParameter("applicantUsername");
        String applicantPwd = request.getParameter("applicantPwd");

        //根据用户名查找到对象
        ApplicantDAO applicantDAO = new ApplicantDAO();
        Applicant applicant = applicantDAO.getApplicant(applicantUsername);

        boolean flag = applicantDAO.loginJudge(applicantUsername,applicantPwd);
        System.out.println(applicantUsername);
        System.out.println(applicantPwd);
        System.out.println(flag);
        if(flag){
//            out.print("<script type='text/javascript'>");
//            out.print("alert('登录成功！');");
//            //重定向
//            out.print("location ='MedicalListServlet'");
//            out.print("</script>");
//            request.getRequestDispatcher("MedicalListServlet").forward(request,response);

            //获取到用户的类型
             String applicantUsertype = applicant.getType();

             request.getSession().setAttribute("username",applicantUsername);
             request.getSession().setAttribute("usertype",applicantUsertype);
            //重定向,到doGet方法里，doPost方法只有Ajax和表单能进
             response.sendRedirect("MedicalListServlet");

            //请求转发
//            request.getRequestDispatcher("MedicalListServlet").forward(request,response);

            //用户名密码输入正确，判断是否有简历
           // boolean isExis = applicantDAO.isExistResume(per.getApplicantId());
//           boolean isExis = true;
//
//            if(isExis){
//                response.sendRedirect("index.html");
//            }else{
//                response.sendRedirect("applicant/resume.html");
//            }

        }else{
            out.print("<script type='text/javascript'>");
            out.print("alert('登录失败，请检查输入！');");
            out.print("location='html/login.html'");
            out.print("</script>");
        }




        // boolean flag = dao.login(username, password);
        //flag为true则用户密码正确
//        if(flag){
//            out.print("<script type='text/javascript'>");
//            out.print("alert('登录成功！');");
//            //out.print("window.location = 'http://bilibili.com';");
//            out.print("</script>");
//        }else{
//            out.print("<script type='text/javascript'>");
//            out.print("alert('登录失败，请检查输入！');");
//            out.print("window.location = 'html/login.html';");
//            out.print("</script>");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //
//
//
//        List<Applicant> list = null;
//        list = DBUtils.getList(Applicant.class,"select APPLICANT_EMAIL from tb_applicant where APPLICANT_EMAIL = ?",applicantEmail);
//        System.out.println(list.isEmpty());
//        Applicant per = list.get(0);
//        System.out.println(per);
}
