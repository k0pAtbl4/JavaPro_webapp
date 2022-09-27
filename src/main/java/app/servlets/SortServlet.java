package app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SortServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("forJsp/sort.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String array = req.getParameter("array");
        String[] numbersInStr = array.split(",");
        List<Integer> list = Arrays.stream(numbersInStr).map(Integer::parseInt).sorted().toList();
        resp.getWriter().println(list);
    }
}
