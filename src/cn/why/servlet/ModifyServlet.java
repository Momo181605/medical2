package cn.why.servlet;

import cn.why.dao.MedicalDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String flag = "0";
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer price = Integer.valueOf(request.getParameter("price"));
        Integer number = Integer.valueOf(request.getParameter("number"));
        String status = request.getParameter("status");
        String describe = request.getParameter("describe");

        MedicalDAO medicalDAO = new MedicalDAO();
        if(medicalDAO.modifyMedicl(id,name,price,number,status,describe)){
            flag = "1";
        }else{
            flag = "0";
        }

        ObjectMapper om = new ObjectMapper();
        om.writeValue(out,flag);

    }
}
