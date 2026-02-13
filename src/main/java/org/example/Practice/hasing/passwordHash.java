package org.example.Practice.hasing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hash/login")
public class passwordHash extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Validate validate = new Validate();
        String hashedPassword = validate.hashPassword("siva@1431");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        if(name != null && !name.isEmpty() && password != null  && !password.isEmpty() ){
            if (validate.checkPassword(password, hashedPassword)) {

                out.println(name +" login successfully");

            }else  {
                out.println("login failed");
            }

        }else{
            out.println("Invalid credentials");
        }



    }
}