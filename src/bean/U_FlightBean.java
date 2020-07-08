package bean;

public class U_FlightBean {
    private String flight;//航班编号
    private String from;//始发地
    private String to;//目的地
    private String date;//日期
    private String time;//时间

    public U_FlightBean() {
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

    public void setAll(String flight , String from ,String to,String date , String time)
    {
        setFlight(flight);
        setFrom(from);
        setTo(to);
        setDate(date);
        setTime(time);
    }

    public String getAll()
    {
        return "flight = "+ flight + " from = "+ from + " to = "+ to +" date = "+ date +" time ="+ time;
    }
}
