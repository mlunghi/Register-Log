package login.submit.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String submitType = request.getParameter("submit");

        CustomerImplementation cImplementation = new CustomerImplementation();
        Customer c = cImplementation.getCustomer(username, password);

        if(submitType.equals("Login") && c != null && c.getName() != null) {
            request.setAttribute("message3", c.getName());
            request.getRequestDispatcher("welcome.jsp").forward(request,response);

        } else if(submitType.equals("Register")){

            c.setName(request.getParameter("name"));
            c.setPassword(password);
            c.setUsername(username);
            cImplementation.insertCustomer(c);

            request.setAttribute("message2", "Thanks for registering. You may now log in.");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        } else {
            request.setAttribute("message", "User not found. Please register before attemping to log in.");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
