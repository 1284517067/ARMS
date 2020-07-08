package dao;

import bean.IndentBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IndentDAO {

    public IndentDAO() {
    }

    public boolean newIndent(IndentBean o) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        boolean flag = false;
        String sql = "insert into v_i values(?,?,?,?,?,?,?,?,?,?,?)";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,o.getId());
            ps.setString(2,o.getNumber());
            ps.setString(3,o.getName());
            ps.setString(4,o.getTel());
            ps.setString(5,o.getFlight());
            ps.setString(6,o.getFrom());
            ps.setString(7,o.getTo());
            ps.setString(8,o.getDate());
            ps.setString(9,o.getTime());
            ps.setString(11,o.getStatus());
            ps.setDouble(10,o.getPrice());
            if(ps.executeUpdate()>=1)
            {
                flag = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeUpdate(ps);
        }
        return flag;
    }

    public boolean UpdateIndent(IndentBean o) throws  Exception
    {
        boolean flag = false;
        Connection con  = null;
        PreparedStatement ps = null;
        String sql = "update v_i set number = ?, name = ? , tel = ? , flight = ? , " +
                "from1 = ? , to1 = ? , date = ? ,time = ? , status = ? , price = ? where id = ?";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,o.getId());
            ps.setString(2,o.getNumber());
            ps.setString(3,o.getName());
            ps.setString(4,o.getTel());
            ps.setString(5,o.getFlight());
            ps.setString(6,o.getFrom());
            ps.setString(7,o.getTo());
            ps.setString(8,o.getDate());
            ps.setString(9,o.getTime());
            ps.setString(10,o.getStatus());
            ps.setDouble(11,o.getPrice());
            if (ps.executeUpdate()>=1) {
                flag = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeUpdate(ps);
        }
        return flag;
    }
    public IndentBean getIndent(int id) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_i where id = ?";
        IndentBean o = new IndentBean();
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            //获取结果集对象
            rs = ps.executeQuery();
            //游标向下移动
            if (rs.next())
            {
                o.setId(rs.getInt("id"));
                o.setNumber(rs.getString("number"));
                o.setName(rs.getString("name"));
                o.setTel(rs.getString("tel"));
                o.setFlight(rs.getString("flight"));
                o.setFrom(rs.getString("from1"));
                o.setTo(rs.getString("to1"));
                o.setDate(rs.getString("date"));
                o.setTime(rs.getString("time"));
                o.setStatus(rs.getString("status"));
                o.setPrice(rs.getDouble("price"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        if (o.getNumber()!=null)
        {
            return o;
        }
        else
        {
            return null;
        }
    }

    public boolean serchIndent(String name,String id,String flight ,String date ) throws Exception {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_i where number = ? and name = ? and flight = ? and date = ?";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,flight);
            ps.setString(4,date);
            rs = ps.executeQuery();
            if(rs.next())
            {
                flag = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteIndent(int id) throws Exception {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from v_i where id = ?";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.executeUpdate() >= 1)
            {
                flag = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeUpdate(ps);
        }
        return  flag;
    }

    public List<IndentBean> list() throws Exception
    {
        List<IndentBean> list = new ArrayList<IndentBean>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_i";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                IndentBean o = new IndentBean();
                o.setId(rs.getInt("id"));
                o.setNumber(rs.getString("number"));
                o.setName(rs.getString("name"));
                o.setTel(rs.getString("tel"));
                o.setFlight(rs.getString("flight"));
                o.setFrom(rs.getString("from1"));
                o.setTo(rs.getString("to1"));
                o.setDate(rs.getString("date"));
                o.setTime(rs.getString("time"));
                o.setStatus(rs.getString("status"));
                o.setPrice(rs.getDouble("price"));
               list.add(o);
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

    public List<IndentBean> list(String number) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<IndentBean> list = new ArrayList<IndentBean>();
        String sql = "select * from v_i where number = ?";
        try
        {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,number);
            rs = ps.executeQuery();
            while (rs.next())
            {
                IndentBean o = new IndentBean();
                o.setId(rs.getInt("id"));
                o.setNumber(rs.getString("number"));
                o.setName(rs.getString("name"));
                o.setTel(rs.getString("tel"));
                o.setFlight(rs.getString("flight"));
                o.setFrom(rs.getString("from1"));
                o.setTo(rs.getString("to1"));
                o.setDate(rs.getString("date"));
                o.setTime(rs.getString("time"));
                o.setStatus(rs.getString("status"));
                o.setPrice(rs.getDouble("price"));

                list.add(o);
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

    public int getMaxIndentId() throws Exception {
        int id = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select MAX(id) from v_i";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
            {
                id = rs.getInt("MAX(id)");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return id;
    }
}
