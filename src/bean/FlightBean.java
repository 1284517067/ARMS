package bean;

import java.io.Serializable;

public class FlightBean implements Serializable {
    private String flight;
    private String from;
    private String to;
    private double price;
    private double discount;
    private String date;
    private String time;
    private String arrivetime;
    private int mileage;
    private String status;

    public FlightBean() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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


    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAll(String flight, String from, String to, double price, double discount, String date , String arrivetime , String time, int mileage,String status) {
        setFlight(flight);
        setFrom(from);
        setTo(to);
        setPrice(price);
        setDiscount(discount);
        setDate(date);
        setTime(time);
        setArrivetime(arrivetime);
        setMileage(mileage);
        setStatus(status);
    }

    public String getAll()
    {
        return "flight = "+ flight + " from = " + from + " to = " + to + " price = " + price + " discount = " + discount + " date = " + date + " time = " + time + " arrivetime = " + arrivetime + " mileage = " + mileage + " status = " + status;
    }
}
