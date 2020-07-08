package bean;

import java.io.Serializable;

public class IndentBean implements Serializable {
    private int id;//订单编号
    private String number;//身份证号
    private String name;//姓名
    private String tel;//电话号码
    private String flight;//航班编号
    private String from;//始发地
    private String to;//目的地
    private String date;//日期
    private String time;//时间
    private String status;//订单状态
    private double price;//价格

    public IndentBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String  getAll()
    {
        return "id = "+ id +", number = " + number +", name = " + name + ", tel = " + tel
                 + ", flight = " + flight + ", from = " + to +
                ", date = " + date + ", time = " + time  + " status = " + status + " price = " + price;
    }

    public void setAll(int id,String number,String name,String tel,
                              String flight,String seat,String from,String to,String date,
                              String time,String status,double price)
    {
        setId(id);
        setNumber(number);
        setName(name);
        setTel(tel);
        setFlight(flight);
        setFrom(from);
        setTo(to);
        setDate(date);
        setTime(time);
        setStatus(status);
        setPrice(price);
    }
}
