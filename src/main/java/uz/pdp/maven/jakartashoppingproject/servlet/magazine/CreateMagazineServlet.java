package uz.pdp.maven.jakartashoppingproject.servlet.magazine;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "CreateMagazineServlet", urlPatterns = "/seller/magazine/create")
public class CreateMagazineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/magazine/create_magazine.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String city = req.getParameter("city");
        String district = req.getParameter("district");
        String street = req.getParameter("street");
        String houseNumber = req.getParameter("houseNumber");

        System.out.println("houseNumber = " + houseNumber);
        System.out.println("name = " + name);
        System.out.println("description = " + description);
        System.out.println("city = " + city);
        System.out.println("district = " + district);
        System.out.println("street = " + street);


    }
}
