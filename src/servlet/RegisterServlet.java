package servlet;

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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String user = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String sex = request.getParameter("sex");
        System.out.println(sex);
        String tel = request.getParameter("tel");
        String site = request.getParameter("site");
        UserBean u = new UserBean();
        try
        {
            u.setAll(user,pwd,number,name,sex,tel,site,0);
            if(Factory.getUserDAOInstance().searchUser(user))
            {
                out.println("<script>alert('用户名已存在')</script>");
                out.flush();
                request.getRequestDispatcher("Register.jsp").forward(request,response);
            }
            else
            {
                if(Factory.getUserDAOInstance().searchUserForNum(number))
                {
                    out.println("<script>alert('身份证已注册')</script>");
                    out.flush();
                    request.getRequestDispatcher("Register.jsp").forward(request,response);
                }
                else
                {
                    Factory.getUserDAOInstance().newUser(u);
                    session.setAttribute("usr",u);
                    request.getRequestDispatcher("OrderManagement.jsp").forward(request,response);
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
