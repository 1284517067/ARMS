package dao;


import java.sql.*;

public class DBUtils {
    //JDBC驱动名 数据库URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/arms?useUnicode=true&amp&characterEncoding=utf8&amp&useSSL=false&amp&serverTimezone=UTC";
    //数据库用户名及密码
    private static final String USR = "root";
    private static final String PWD = "123456";
    /*
        获取数据库连接
     */
    public static Connection getCon() throws Exception
    {
        Class.forName(JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL,USR,PWD);
        return con;
    }

    /*
        关闭数据库连接
     */
    public static void closeCon(Connection con) throws Exception
    {
        if (!con.isClosed())
        {
            con.close();
        }
    }

    /*
        关闭更新
     */
    public static void closeUpdate(PreparedStatement ps) throws Exception
    {
        try{
            if (ps != null)
            {
                Connection con = ps.getConnection();
                ps.close();
                closeCon(con);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /*
        关闭查询
     */
    public static void closeQuery(ResultSet rs) throws Exception
    {
        try{
            if (rs != null)
            {
                Statement stm = rs.getStatement();
                rs.close();
                if (stm != null)
                {
                    Connection con = stm.getConnection();
                    stm.close();
                    closeCon(con);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
