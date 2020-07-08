package factory;

import dao.FlightDAO;
import dao.IndentDAO;
import dao.UserDAO;

public class Factory {

    public static UserDAO getUserDAOInstance() throws Exception
    {
        return new UserDAO();
    }

    public static IndentDAO getIndentDAOInstance() throws Exception
    {
        return new IndentDAO();
    }

    public static FlightDAO getFlightInstance() throws Exception
    {
        return new FlightDAO();
    }
}
