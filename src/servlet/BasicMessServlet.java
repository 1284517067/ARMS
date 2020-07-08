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

@WebServlet("/BasicMessServlet")
public class BasicMessServlet extends HttpServlet {
    public BasicMessServlet() {
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
        String site = request.getParameter("site");
        UserBean u = (UserBean) session.getAttribute("usr");
        u.setSite(site);
        try{
            Factory.getUserDAOInstance().UpdateUser(u);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        session.setAttribute("usr",u);
        out.println("<script>alert('保存成功');window.location.href='/SkipServlet?skip=basicMess';</script>");
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
