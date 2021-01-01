package cn.why.bean;

public class Medical {
    private Integer id;
    private String name;
    private Integer price;
    private Integer number;
    private String status;
    private String describe;

    public Medical() {
    }

    @Override
    public String toString() {
        return
                name + "," + price +  "," + number + "," + status;
    }

    public Medical(String name, Integer price, Integer number, String status, String describe) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.status = status;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
