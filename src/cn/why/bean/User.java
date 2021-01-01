package cn.why.bean;

import java.util.Date;

public class User {
    public User() {
        System.out.println("----------------asdfasdfasd ");
    }

    //和数据库中的Users表的列对应
    private Integer id;
    private String username;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
