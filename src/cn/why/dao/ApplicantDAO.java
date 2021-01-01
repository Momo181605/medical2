package cn.why.dao;

import cn.why.bean.Medical;
import cn.why.utils.DBUtils;
import cn.why.bean.Applicant;
import cn.why.utils.DBUtils;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ApplicantDAO {

    /**
     * 根据用户名查找一个用户并返回
     * @param name 用户名
     * @return 用户对象
     */
    public Applicant getApplicant(String name){
        String sql = "select * from user where username = ?";
        Applicant applicant = DBUtils.getSingle(Applicant.class,sql,name);
        return applicant;
    }

    //保存注册对象，新
    public boolean saveApplicant(Applicant applicant) {
        String sql = "insert into user(username,password,type) values(?,?,?)";
        return DBUtils.save(sql,applicant.getUsername(),applicant.getPassword(),applicant.getType());
    }

    /**
     * 登录判断
     * @param username 用户名
     * @param password 密码
     * @return 返回布尔值，登录成功返回true，失败返回false
     */
    public boolean loginJudge(String username,String password){

        String sql = "select * from user where username = ? and password = ?";

        Applicant applicant = DBUtils.getSingle(Applicant.class,sql,username,password);

        if(applicant!=null){
           return true;
        }

        return false;
    }

    /**
     * 修改密码
     * @param username 用户名
     * @param oldapplicantPwd 旧密码
     * @param newapplicantPwd 新密码
     * @param surenewapplicantPwd   确认新密码
     * @return 修改成功返回true，失败返回false
     */
    public boolean passwordChange(String username,String oldapplicantPwd,String newapplicantPwd,String surenewapplicantPwd){

      String sql = "select * from user where username = ?";
       Applicant applicant = DBUtils.getSingle(Applicant.class,sql,username);

       if(applicant.getPassword().equals(oldapplicantPwd)){
           if(newapplicantPwd.equals(surenewapplicantPwd)){
               sql = "update user set password= ? where username= ?";
                return DBUtils.save(sql,newapplicantPwd,username);

           }
       }

        return false;
    }

    public boolean deleteAccount(String username){
        String sql = "delete from user where username = ?";
        if(DBUtils.save(sql,username)){
            return true;
        }
        return false;
    }








    /**输入用户id查询是否有简历
     * 判断是否有简历，有用户id则说明有简历，反之
     * @param applicantId
     * @return 如果有简历返回true ， 无则false
     */
    public  boolean isExistResume(Integer applicantId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String  sql = null;
        sql = "select * from tb_resume_basicinfo where APPLICANT_ID = ?";

        try {
            //获取连接
            conn = DBUtils.getConnection();
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantId);
            //执行查询，得到结果集
            rs =pstmt.executeQuery();
            if(rs.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,pstmt,rs);
        }

        return false;
    }

    /**
     * 求职者信息注册保存
     * @param  username
     * @param  password
     */

    public void save(String username,String password){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String  sql = null;
        sql = "insert into users values(?,?)";

        try {
            //获取连接
            conn = DBUtils.getConnection();
            //创建语句对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            //调用插入语句
            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,pstmt,rs);
        }


    }

//    /**
//     * 注册用户登录 user 表
//     *
//     * @param username
//     * @param password
//     * @return 如果找到用户名和密码都相同的返回true，没找到则返回false
//     */
//    public boolean login(String username,String password){
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        String sql = null;
//        sql = "select * from users where username = ? and password = ?";
//
//        try {
//            conn = DBUtils.getConnection();
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,username);
//            pstmt.setString(2,password);
//            rs = pstmt.executeQuery();
//            if(rs.next()){
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//          DBUtils.close(conn,pstmt,rs);
//        }
//        return false;
//    }

    /**
     * 新注册用户登录
     *
     * @param username
     * @param password
     * @return 如果找到用户名和密码都相同的返回true，没找到则返回false
     */
    public boolean login(String username,String password){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;
        sql = "select * from tb_applicant where APPLICANT_EMAIL = ? and APPLICANT_PWD = ?";

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            if(rs.next()){

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn,pstmt,rs);
        }
        return false;
    }

////根据email和密码查询用户
//    public Applicant getApplicantByEmilAndPass(String applicantEmail, String applicantPwd) {
//        String sql = "select APPLICANT_ID applicantId,APPLICANT_EMAIL applicantEmail,APPLICANT_PWD applicantPwd,APPLICANT_REGISTDATE applicantRegistDate" +
//                "from tb_applicant where APPLICANT_EMAIL=? and APPLICANT_PWD=?";
//
//       return DBUtils.getSingleObj(Applicant.class,sql,applicantEmail,applicantPwd);
//    }


}
