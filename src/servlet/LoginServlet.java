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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        UserBean u ;
        try {

            if(Factory.getUserDAOInstance().searchUser(username))
            {
                u = Factory.getUserDAOInstance().getUser(username);
                if(pwd.equals(u.getPwd())){
                    session.setAttribute("usr",u);
                    request.getRequestDispatcher("/SkipServlet?skip=account").forward(request,response);
                }
                else{
                    out.println("<script>alert('密码错误');window.location.href='SkipServlet?skip=login';</script>");
                    out.flush();
                }
            }
            else
            {
                out.println("<script>alert('用户名不存在');window.location.href='SkipServlet?skip=login';</script>");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
