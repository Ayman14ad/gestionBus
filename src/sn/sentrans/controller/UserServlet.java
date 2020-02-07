package sn.sentrans.controller;

import sn.sentrans.dao.IUser;
import sn.sentrans.dao.UserImpl;
import sn.sentrans.entities.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/User", name = "user")
public class UserServlet extends HttpServlet {
IUser iUser= null;

@Override

public void init(ServletConfig  config) throws ServletException {

    iUser = new UserImpl();
}


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("Ok page trouvee");
        req.getRequestDispatcher("accueil.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("pass");

      /*  User user = iUser.getLogin(email,password);
        if (user != null){
            resp.sendRedirect("accueil");
        }else {
            resp.sendRedirect("User");
        }*/


      req.getRequestDispatcher("accueil.jsp").forward(req,resp);
 }

}
