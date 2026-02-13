package org.example.Session;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out=resp.getWriter();

        HttpSession session = req.getSession(false);



        if (session != null){
            String name= session.getAttribute("name").toString();
            out.println(name+" logout successfully");

            session.removeAttribute("name");
            session.removeAttribute("username");
            session.invalidate();
        }
        else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println("logout failed");
        }
    }
}
