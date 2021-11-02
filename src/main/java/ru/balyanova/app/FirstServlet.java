package ru.balyanova.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    private List<Product> productList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Bread", 100),
                new Product(2, "Bread Luxury", 200),
                new Product(3, "Apple", 100),
                new Product(4, "Milk", 70),
                new Product(5, "Eggs", 100),
                new Product(6, "Cookies", 150),
                new Product(7, "Tea Bags", 150),
                new Product(8, "Coffee", 400),
                new Product(9, "Beer", 200),
                new Product(10, "Cheese", 1200)
        ));
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            resp.getWriter().printf("<h1>" + product.toString() + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}
