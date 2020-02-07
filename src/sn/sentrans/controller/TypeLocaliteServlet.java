package sn.sentrans.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/TypeLocalite", name = "typelocalite")
public class TypeLocaliteServlet extends HttpServlet {

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //   resp.getWriter().println("Ok page trouve 2");

            req.getRequestDispatcher("vues/typelocalite/list.jsp").forward(req, resp);

        }

}
