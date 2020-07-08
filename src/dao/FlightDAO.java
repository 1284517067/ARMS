package dao;

import bean.FlightBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public FlightDAO() {
    }

    public boolean UpdateDiscount(String flight, double discount) throws Exception {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update v_td set discount = ? where flight = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, discount);
            ps.setString(2, flight);
            if (ps.executeUpdate() >= 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeUpdate(ps);
        }
        return flag;
    }

    public boolean UpdatePrice(String flight, double price) throws Exception {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update v_td set price = ? where flight = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, price);
            ps.setString(2, flight);
            if (ps.executeUpdate() >= 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeUpdate(ps);
        }
        return flag;
    }

    public boolean cancelDiscount(String flight) throws Exception {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update v_td set discount = null where flight = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, flight);
            if (ps.executeUpdate() >= 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeUpdate(ps);
        }
        return flag;
    }

    public FlightBean getflight(String flight) throws Exception {
        FlightBean d = new FlightBean();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_td where flight = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,flight);
            rs = ps.executeQuery();
            if (rs.next())
            {
                d.setFlight(rs.getString("flight"));
                d.setFrom(rs.getString("from1"));
                d.setTo(rs.getString("to1"));
                d.setPrice(rs.getDouble("price"));
                d.setDiscount(rs.getDouble("discount"));
                d.setDate(rs.getString("date"));
                d.setTime(rs.getString("time"));
                d.setArrivetime(rs.getString("arrivetime"));
                d.setMileage(rs.getInt("mileage"));
                d.setStatus(rs.getString("status"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return d;
    }

    public List<FlightBean> getAirlineList() throws Exception {
        List<FlightBean> list = new ArrayList<FlightBean>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_td";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                FlightBean d = new FlightBean();
                d.setFlight(rs.getString("flight"));
                d.setFrom(rs.getString("from1"));
                d.setTo(rs.getString("to1"));
                d.setPrice(rs.getDouble("price"));
                d.setDiscount(rs.getDouble("discount"));
                d.setDate(rs.getString("date"));
                d.setTime(rs.getString("time"));
                d.setArrivetime(rs.getString("arrivetime"));
                d.setMileage(rs.getInt("mileage"));
                d.setStatus(rs.getString("status"));
                list.add(d);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return list;
    }

    public List<FlightBean> getDiscountList() throws Exception {
        List<FlightBean> list = new ArrayList<FlightBean>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_td where discount is not null";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                FlightBean d = new FlightBean();
                d.setFlight(rs.getString("flight"));
                d.setFrom(rs.getString("from1"));
                d.setTo(rs.getString("to1"));
                d.setPrice(rs.getDouble("price"));
                d.setDiscount(rs.getDouble("discount"));
                d.setDate(rs.getString("date"));
                d.setTime(rs.getString("time"));
                d.setArrivetime(rs.getString("arrivetime"));
                d.setMileage(rs.getInt("mileage"));
                d.setStatus(rs.getString("status"));
                list.add(d);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return list;
    }

    public List<FlightBean> getFlight(String from, String to, String date) throws Exception {
        List<FlightBean> list = new ArrayList<FlightBean>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_td where from1 = ? and to1 = ? and date = ? ";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,from);
            ps.setString(2,to);
            ps.setString(3,date);
            rs = ps.executeQuery();
            while(rs.next()){
                FlightBean d = new FlightBean();
                d.setFlight(rs.getString("flight"));
                d.setFrom(rs.getString("from1"));
                d.setTo(rs.getString("to1"));
                d.setPrice(rs.getDouble("price"));
                d.setDiscount(rs.getDouble("discount"));
                d.setDate(rs.getString("date"));
                d.setTime(rs.getString("time"));
                d.setArrivetime(rs.getString("arrivetime"));
                d.setMileage(rs.getInt("mileage"));
                d.setStatus(rs.getString("status"));
                list.add(d);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return list;
    }
}
