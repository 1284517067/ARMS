package dao;

import bean.IndentBean;
import bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public UserDAO() {
    }

    public boolean newUser(UserBean u) throws Exception
    {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into v_u values(?,?,?,?,?,?,?,?)";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,u.getUser());
            ps.setString(2,u.getPwd());
            ps.setString(3,u.getNumber());
            ps.setString(4,u.getName());
            ps.setString(5,u.getSex());
            ps.setString(6,u.getTel());
            ps.setString(7,u.getSite());
            ps.setInt(8,u.getCredit());
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
        return  flag;
    }

    public boolean UpdateUser(UserBean u) throws Exception
    {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update v_u set pwd = ?,number = ? , name = ?,sex = ?,tel = ?,site = ?,credit = ? where usr = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,u.getPwd());
            ps.setString(2,u.getNumber());
            ps.setString(3,u.getName());
            ps.setString(4,u.getSex());
            ps.setString(5,u.getTel());
            ps.setString(6,u.getSite());
            ps.setInt(7,u.getCredit());
            ps.setString(8,u.getUser());
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
        return flag;
    }

    public UserBean getUser(String user) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_u where usr = ?";
        UserBean u  = new UserBean();
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            //获取结果集对象
            rs = ps.executeQuery();
            //游标向下移动
            if (rs.next())
            {
                u.setUser(rs.getString("usr"));
                u.setPwd(rs.getString("pwd"));
                u.setNumber(rs.getString("number"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                u.setTel(rs.getString("tel"));
                u.setSite(rs.getString("site"));
                u.setCredit(rs.getInt("credit"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return u;
    }

    public  boolean deleteUser(String user) throws Exception
    {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from v_u where usr = ?";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            if (ps.executeUpdate() >= 1)
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

    public List<UserBean> list() throws Exception
    {
        List<UserBean> list = new ArrayList<UserBean>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from v_u";
        try {
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                UserBean u = new UserBean();
                u.setUser(rs.getString("usr"));
                u.setPwd(rs.getString("pwd"));
                u.setNumber(rs.getString("number"));
                u.setName(rs.getString("name"));
                u.setSex(rs.getString("sex"));
                u.setTel(rs.getString("tel"));
                u.setSite(rs.getString("site"));
                u.setCredit(rs.getInt("credit"));
                list.add(u);
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

    public boolean searchUser(String user) throws Exception {
        boolean flag = false;
        String sql = "select usr from v_u where usr = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
            if (rs.next()){
                flag = true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return flag;
    }

    public boolean searchUserForNum(String number) throws Exception {
        boolean flag = false;
        String sql = "select usr from v_u where number = ?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1,number);
            rs = ps.executeQuery();
            if (rs.next()){
                flag = true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            DBUtils.closeQuery(rs);
        }
        return flag;
    }
}
