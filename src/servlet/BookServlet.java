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

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    public BookServlet() {
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
        book(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void book(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        List<FlightBean> list = new ArrayList<FlightBean>();
        try {
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String date = request.getParameter("go-off");
            list = Factory.getFlightInstance().getFlight(from,to,date);
            if (list.isEmpty())
            {
                session.setAttribute("from",from);
                session.setAttribute("to",to);
                session.setAttribute("date",date);
                session.setAttribute("airlinelist",null);
                request.getRequestDispatcher("/SkipServlet?skip=airchoice").forward(request,response);
            }
            else
            {
                session.setAttribute("from",from);
                session.setAttribute("to",to);
                session.setAttribute("date",date);
                session.setAttribute("airlinelist",list);
                request.getRequestDispatcher("/SkipServlet?skip=airchoice").forward(request,response);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
