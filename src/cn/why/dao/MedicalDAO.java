package cn.why.dao;

import cn.why.bean.Medical;
import cn.why.utils.DBUtils;
import sun.security.pkcs11.Secmod;

import java.util.List;

public class MedicalDAO {

    /**
     * 获取所有的药品
     * @return 返回数据库中的药品集合
     */
    public List<Medical> getMedicls(){
        String sql = "select * from drugs";
        List<Medical> medicals = DBUtils.getList(Medical.class,sql);
        return medicals;
    }

    /**
     * 根据药品名进行查找
     * @param drugname
     * @return 返回查找到的药品集合
     */
    public List<Medical> getMedicls(String drugname){
        String sql = "select * from drugs where name like '%" + drugname + "%'" + "or price like '%" + drugname + "%'";
        List<Medical> medicals = DBUtils.getList(Medical.class,sql);
        return medicals;
    }

    /**
     * 通过药品名获得单个药品对象
     * @param name
     * @return 单个药品对象
     */
    public Medical getMedicl(String name){
        String sql = "select * from drugs where name = ?";
        Medical medical = DBUtils.getSingle(Medical.class,sql,name);
        return medical;
    }

    /**
     * 贩卖药品，其实就是修改药品的数量
     * @param name 根据药品名修改
     * @return 修改成功返回true，失败返回false
     */
    public boolean sellingMedicl(String name){
        Medical medical = getMedicl(name);
        if(medical.getStatus().equals("下架")){
            return false;
        }
        Integer number = medical.getNumber()-1;
        String sql = "update drugs set number = ? where name = ?";
        return DBUtils.save(sql,number,name);

    }

    /**
     * 修改药品信息
     * @param name 药品名
     * @param price 单价
     * @param number 数量
     * @param status 状态
     * @param describe 描述
     * @return 修改成功返回true，修改失败返回false
     */
    public boolean modifyMedicl(Integer id,String name, Integer price, Integer number, String status, String describe) {
        String sql = "update drugs set name = ?, price = ? , number = ? , status = ? , `describe` = ? where id = ? ";
        return DBUtils.save(sql,name,price,number,status,describe,id);
    }

    /**
     * 根据药品信息添加药品
     * @param name 药名
     * @param price 单价
     * @param number 数量
     * @param status 上下架状态
     * @param describe 药品描述
     * @return true是添加成功，false添加失败
     */
    public boolean addMedicl(String name, Integer price, Integer number, String status, String describe){
        String sql = "insert into drugs (name,price,number,status,`describe`) values (?,?,?,?,?)";
        return DBUtils.save(sql,name,price,number,status,describe);
    }

    public boolean deleteMedicl(Integer id){
        String sql = "delete from drugs where id = ?";
        return DBUtils.save(sql,id);
    }
}
