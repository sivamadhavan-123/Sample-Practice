package org.example.Session;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class App extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        PrintWriter out = resp .getWriter();

        String userName = req.getParameter("userName");
        String name=req.getParameter("name");
        int password= Integer.parseInt(req.getParameter("password"));


        CheckValidate checke =new CheckValidate();

        if (checke.isValid(userName, password)) {
            HttpSession session = req.getSession();

            session.setAttribute("username", userName);
            session.setAttribute("name", name);
            out.println("login success");

        }else{
            out.println("Invalid username or password");
        }


    }
}
