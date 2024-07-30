package uz.pdp.maven.jakartashoppingproject.servlet.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.maven.jakartashoppingproject.dao.UserDAO;
import uz.pdp.maven.jakartashoppingproject.entity.user.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signup")
public class SignUpServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/user/signup.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        Map<String, String> errors = new HashMap<>();

        if (email == null || email.isBlank() || email.isEmpty()) {
            errors.put("email_error", "Email is invalid");
        } else {
            Optional<User> userByEmail = userDAO.findByEmail(email);
            userByEmail.ifPresent(
                    user -> errors.put("email_error", "Email Already Taken"));
        }
        if (username == null || username.isBlank() || username.isEmpty()) {
            errors.put("password_error", "Password is invalid");
        } else {
            Optional<User> userByUsername = userDAO.findByUserName(username);
            userByUsername.ifPresent(
                    user -> errors.put("username", "Username Already Exists"));
        }

        if (password == null || password.isBlank() || password.isEmpty()) {
            errors.put("password_error", "Password is invalid");
        }
        if (fullName == null || fullName.isBlank() || fullName.isEmpty()) {
            errors.put("fullname_error", "fullName is invalid");
        }
        if (!Objects.equals(confirmPassword, password)) {
            errors.put("password_error", "Passwords are not matches");
        }

        errors.forEach((K, V) -> System.out.println(K + "\n " + V));

        if (!errors.isEmpty()) {
            errors.forEach(req::setAttribute);
            RequestDispatcher rd = req.getRequestDispatcher("/views/user/signup.jsp");
            rd.forward(req, resp);
        } else {
            User user = User.childBuilder()
                    .role(User.UserRole.USER)
                    .status(User.UserStatus.IN_ACTIVE)
                    .isActive(true)
                    .fullName(fullName)
                    .email(email)
                    .password(password)
                    .username(username)
                    .build();

            userDAO.persist(user);

            RequestDispatcher rd = req.getRequestDispatcher("/views/product/product_list.jsp");
            rd.forward(req, resp);
        }
    }
}
