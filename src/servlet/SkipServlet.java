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
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/SkipServlet")
public class SkipServlet extends HttpServlet {
    public SkipServlet() {
        super();
        // TODO Auto-generated constructor stub
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
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String skip = request.getParameter("skip");
        if("officalsite".equals(skip))
        {
            List<FlightBean> list = new ArrayList<FlightBean>();
            try {
                list = Factory.getFlightInstance().getDiscountList();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("DiscountList",list);
            request.getRequestDispatcher("OfficalSite.jsp").forward(request,response);
        }
        else if("airchoice".equals(skip))
        {
            request.getRequestDispatcher("AirlineChoice.jsp").forward(request,response);
        }
        else if("clientmassage".equals(skip))
        {
            String flight = request.getParameter("id");
            FlightBean d = new FlightBean();
            try
            {
                d = Factory.getFlightInstance().getflight(flight);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("flight",d);
            request.getRequestDispatcher("ClientMassage.jsp").forward(request,response);
        }
        else if("login".equals(skip))
        {
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }
        else if("logout".equals(skip))
        {
            session.removeAttribute("usr");
            request.getRequestDispatcher("OfficalSite.jsp").forward(request,response);
        }
        else if("account".equals(skip))
        {
            List<IndentBean> list = new ArrayList<IndentBean>();
            try{
                UserBean u = (UserBean) session.getAttribute("usr");
                list = Factory.getIndentDAOInstance().list(u.getNumber());
                Collections.reverse(list);

            }catch (Exception e){
                e.printStackTrace();
            }
            session.setAttribute("orderlist",list);
            request.getRequestDispatcher("OrderManagement.jsp").forward(request,response);
        }
        else if("basicMess".equals(skip))
        {
            request.getRequestDispatcher("BasicMessage.jsp").forward(request,response);
        }
        else  if("contactMess".equals(skip))
        {
            request.getRequestDispatcher("ContactMessage.jsp").forward(request,response);
        }
        else  if("TicketOrder".equals(skip))
        {
            List<IndentBean> list = new ArrayList<IndentBean>();
            try{
                UserBean u = (UserBean) session.getAttribute("usr");
                list = Factory.getIndentDAOInstance().list(u.getNumber());
                Collections.reverse(list);

            }catch (Exception e){
                e.printStackTrace();
            }
            session.setAttribute("orderlist",list);
            request.getRequestDispatcher("TicketOrder.jsp").forward(request,response);
        }
        else if("gotopay".equals(skip))
        {
            String id = request.getParameter("id");
            int i = Integer.parseInt(id);
            IndentBean ind = new IndentBean();
            FlightBean d = new FlightBean();
            try
            {
                ind = Factory.getIndentDAOInstance().getIndent(i);
                d = Factory.getFlightInstance().getflight(ind.getFlight());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("flight",d);
            session.setAttribute("indent",ind);
            request.getRequestDispatcher("PayIndent.jsp").forward(request,response);
        }
        else if("refund".equals(skip))
        {
            UserBean u = (UserBean) session.getAttribute("usr");
            if(u == null)
            {
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            else
            {
                List<IndentBean> list = new ArrayList<IndentBean>();
                List<IndentBean> list1 = new ArrayList<IndentBean>();
                try{
                    list = Factory.getIndentDAOInstance().list(u.getNumber());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(new Date());

                    for(IndentBean i : list)
                    {
                        int c = daysBetween(date,i.getDate());
                        if(c > 0)//订单未过期
                        {
                            if(i.getStatus().equals("已支付")){
                                list1.add(i);
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                session.setAttribute("ablelist",list1);
                request.getRequestDispatcher("Refund.jsp").forward(request,response);
            }

        }
        else if("ref".equals(skip)){
            String id = request.getParameter("id");
            int i = Integer.parseInt(id);
            IndentBean ib = new IndentBean();
            try
            {
                ib = Factory.getIndentDAOInstance().getIndent(i);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("order",ib);
            request.getRequestDispatcher("ref.jsp").forward(request, response);
        }
        else  if("change".equals(skip))
        {
            String id = request.getParameter("id");
            int i = Integer.parseInt(id);
            IndentBean ib = new IndentBean();
            try {
                ib = Factory.getIndentDAOInstance().getIndent(i);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("order",ib);
            request.getRequestDispatcher("change.jsp").forward(request,response);
        }
        else if("getref".equals(skip))
        {
            IndentBean i = (IndentBean) session.getAttribute("order");
            i.setStatus("已退款");
            try{
                Factory.getIndentDAOInstance().UpdateIndent(i);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            PrintWriter out = response.getWriter();
            out.println("<script>alert('退款成功')</script>");
            out.flush();
            request.getRequestDispatcher("OrderManagement.jsp").forward(request,response);
        }
        else if("time".equals(skip))
        {
            List<FlightBean> list = new ArrayList<FlightBean>();
            try {
                list = Factory.getFlightInstance().getAirlineList();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("flightlist",list);
            request.getRequestDispatcher("AirlineTimes.jsp").forward(request,response);
        }
        else if("promotion".equals(skip))
        {
            List<FlightBean> list = new ArrayList<FlightBean>();
            try {
                list = Factory.getFlightInstance().getDiscountList();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            session.setAttribute("DiscountList",list);
            request.getRequestDispatcher("Discount.jsp").forward(request,response);
        }
        else if("bookticket".equals(skip))
        {
            request.getRequestDispatcher("CheckAirline.jsp").forward(request,response);
        }
        else if("credit".equals(skip))
        {
            request.getRequestDispatcher("CreditMessage.jsp").forward(request,response);
        }
        else if("register".equals(skip))
        {
            request.getRequestDispatcher("Register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public static int daysBetween(String smdate,String bdate) throws ParseException {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        cal.setTime(sdf.parse(smdate));

        long time1 = cal.getTimeInMillis();

        cal.setTime(sdf.parse(bdate));

        long time2 = cal.getTimeInMillis();

        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));

    }

}
