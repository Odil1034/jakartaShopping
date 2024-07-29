package uz.pdp.maven.jakartashoppingproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

@WebFilter(filterName = "SecurityFilter", value = "/*")
public class SecurityFilter implements Filter {

    private static final List<String> WHITE_LIST = List.of(
            "/",
            "/product/product_list",
            "/product/product_details",
            "/user/login",
            "/user/signup"
    );

    private static final Predicate<String> isOpen = WHITE_LIST::contains;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String requestURI = request.getRequestURI();

        System.out.println("requestURI = " + requestURI);
        if (!isOpen.test(requestURI)) {
            response.sendError(401, "Unauthorized");
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
