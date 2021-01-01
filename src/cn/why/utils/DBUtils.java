package cn.why.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class DBUtils {

    /**
     *
     * @return 数据库连接
     */
    public static Connection getConnection() throws SQLException {
        DataSource ds = null;
        try {
            //读取配置文件
            Properties pro = new Properties();
            InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("config/db.properties");
            pro.load(in);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%% 获取连接错误  %%%%%%%%%%%%%%");
        }
        return ds.getConnection();
    }

    /**
     *
     * @param clazz 业务主体类
     * @param sql   mysql查询语句
     * @param args  语句参数
     * @param <T>   业务主体
     * @return 结果集
     */
    public static <T> List<T> getList(Class<T> clazz,String sql,Object...args){
        List<T> list = new ArrayList<T>();
        Connection con = null;
        PreparedStatement pdsm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pdsm= con.prepareStatement(sql);

                for (int i = 0; i < args.length; i++) {
                    //设置args参数
                    pdsm.setObject(i + 1, args[i]);
                }

            rs = pdsm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int size = rsmd.getColumnCount();
            while(rs.next()) {
                Map<String,Object> map = new HashMap<String,Object>();
                for (int i = 1; i <= size; i++) {
                    String title = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(title);
                    map.put(title, value);
                }
                T temp = clazz.newInstance();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object values = entry.getValue();
                    String methodname = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                    Method method = clazz.getMethod(methodname, values.getClass());
                    method.invoke(temp,values);
                }
                list.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           close(con, pdsm, rs);
        }
        return list;
    }

    public static <T> T getSingle(Class<T> clazz,String sql,Object...args) {

        Connection con = null;
        PreparedStatement pdsm = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pdsm = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //设置args参数
                pdsm.setObject(i + 1, args[i]);
            }

            //rs是数据
            rs = pdsm.executeQuery();

            //表头
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int size = rsmd.getColumnCount();

            if (rs.next()) {

                T temp = clazz.newInstance();
                for (int i = 1; i <= size; i++) {
                    String key = rsmd.getColumnLabel(i);
                    Object values = rs.getObject(i);
                    String methodname = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
                    //查找方法，方法可能有很多个重名的，所以要配合参数查找
                    Method method = clazz.getMethod(methodname, values.getClass());
                    //调用temp里刚查到的方法，就如同 temp.setApplicantUsername(values);
                    method.invoke(temp, values);

                }
                return temp;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pdsm, rs);
        }
        return null;
    }


    public static <T> boolean insertList(Class<T> clazz, String sql, Object... args){
        return false;
    }

    /**
     * 关闭数据库资源
     * @param conn
     * @param stm
     * @param rs
     */
    public static void close(Connection conn, Statement stm, ResultSet rs)
    {
        try {
            if(conn!=null) conn.close();
            if(stm!=null) stm.close();
            if(rs!=null) rs.close();
        } catch (Exception e) {
            System.out.println("%%%%%%%%%%%% 关闭连接错误  %%%%%%%%%%%%%%");
            e.printStackTrace();
        }
    }

    //保存对象方法
    public static boolean save(String sql, Object...args){
        //数据库连接
        Connection conn = null;
        //预编译的sql语句
        PreparedStatement ps = null;

        Integer count = null;

        try{

            conn = getConnection();

            ps = conn.prepareStatement(sql);

            if(args!=null && args.length>0){
                for(int i = 0; i<args.length ;i++){
                    ps.setObject(i+1,args[i]);
                }
            }
            //返回更新的记录数
            count= ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps,null);
        }
        return count!=null&&count>0?true:false;
    }
}