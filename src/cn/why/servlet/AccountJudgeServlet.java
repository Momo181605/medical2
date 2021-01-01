package cn.why.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/AccountJudgeServlet")
public class AccountJudgeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");

        PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
        String flag = "0";

        String pattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(userid);

        String msg = null;
        //如果存在@字符，返回它的下标，如果不存在返回-1
        if(m.matches()) {
//            out.print("1");
            flag = "1";
        }else{
//            out.print("0");
            flag = "0";
        }

        ObjectMapper om = new ObjectMapper();
        om.writeValue(out,flag);

        out.flush();
        out.close();

    }
}
