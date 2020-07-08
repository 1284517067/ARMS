package servlet;

import bean.FlightBean;
import bean.IndentBean;
import bean.UserBean;
import factory.Factory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
    public PayServlet() {
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
        IndentBean i = new IndentBean();
        UserBean u = (UserBean) session.getAttribute("usr");
        FlightBean d = new FlightBean();
        i = (IndentBean) session.getAttribute("indent");
        i.setStatus("已支付");
        try{
            d = Factory.getFlightInstance().getflight(i.getFlight());
            Factory.getIndentDAOInstance().UpdateIndent(i);
            int credit = u.getCredit() + d.getMileage();
            u.setCredit(credit);
            Factory.getUserDAOInstance().UpdateUser(u);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        session.setAttribute("indent",i);
        request.getRequestDispatcher("PayFinsh.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
