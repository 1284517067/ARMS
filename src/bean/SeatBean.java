package bean;

public class SeatBean {
    private String flight;//航班编号
    private int total;//座位总数
    private  int surplus;//余座

    public SeatBean() {
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public void setAll(String flight,int total,int surplus)
    {
        setFlight(flight);
        setTotal(total);
        setSurplus(surplus);
    }

    public String getAll()
    {
        return "flight = "+ flight + " total = " + total + " surplus = " + surplus;
    }
}
