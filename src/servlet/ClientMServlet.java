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

@WebServlet("/ClientMServlet")
public class ClientMServlet extends HttpServlet {
    public ClientMServlet() {
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
        response.setContentType("text/html;charset=utf-8");
        createIndent(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void createIndent( HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        HttpSession session = request.getSession();
        try{
            FlightBean flight = new FlightBean();
            flight = (FlightBean) session.getAttribute("flight");
            String Cname = request.getParameter("Cname");
            String Cid = request.getParameter("Cid");
            String Ltel = request.getParameter("Ltel");
            int id = Factory.getIndentDAOInstance().getMaxIndentId();
            IndentBean i = new IndentBean();
            i.setId(id+1);
            i.setName(Cname);
            i.setNumber(Cid);
            i.setTel(Ltel);
            i.setFlight(flight.getFlight());
            i.setFrom(flight.getFrom());
            i.setTo(flight.getTo());
            i.setDate(flight.getDate());
            i.setTime(flight.getTime());
            i.setStatus("未支付");
            double price;
            if (flight.getDiscount()==0.0)
            {
               price = flight.getPrice();
            }
            else {
                price = flight.getDiscount();
            }
            i.setPrice(getUserDiscount(price,request,response));
            boolean flag = Factory.getIndentDAOInstance().serchIndent(i.getName(),i.getNumber(),i.getFlight(),i.getDate());
            if (flag)
            {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html;charset=utf-8");
                out.println("<script>alert('请不要重复提交订单');window.location.href='SkipServlet?skip=officalsite'; </script>");
                out.flush();
            }
            else {
                UserBean usr = (UserBean) session.getAttribute("usr");
                if(usr != null)
                {
                    int mileage = flight.getMileage();
                    mileage = usr.getCredit() + mileage;
                    usr.setCredit(mileage);
                    boolean flag1 =Factory.getUserDAOInstance().UpdateUser(usr);
                }
                boolean flag2 = Factory.getIndentDAOInstance().newIndent(i);
                session.setAttribute("indent",i);
                request.getRequestDispatcher("PayIndent.jsp").forward(request,response);
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    protected double getUserDiscount(double price,HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        UserBean u = (UserBean) session.getAttribute("usr");
        if(u == null){
            return price;
        }else
        {
            int c = u.getCredit();
            price = getCreditDiscount(price,c);
            return price;
        }
    }

    protected double getCreditDiscount(double price,int credit)
    {
        if(credit>=0||credit<2000){
            price = 0.95*price;
        }
        else if (credit>=2000||credit<5000)
        {
            price = 0.9*price;
        }
        else if(credit>=5000)
        {
            price = 0.85*price;
        }
        return price;
    }
}