package servlet;

import bean.FlightBean;
import factory.Factory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ASServlet")
public class ASServlet extends HttpServlet {
    public ASServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init();
    }

    public void destroy() {
        // TODO Auto-generated method stub
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String from = request.getParameter("from2");
        String to = request.getParameter("to2");
        String date = request.getParameter("go-off2");
        List<FlightBean> list = new ArrayList<FlightBean>();
        try
        {
            list = Factory.getFlightInstance().getFlight(from,to,date);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        session.setAttribute("airlinelist",list);
        request.getRequestDispatcher("AirlineStatus.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
