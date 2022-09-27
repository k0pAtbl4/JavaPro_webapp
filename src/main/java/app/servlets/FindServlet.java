package app.servlets;


import fileWork.WordProcessor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("forJsp/find.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String word = req.getParameter("word");
        PrintWriter out = resp.getWriter();

        WordProcessor proc = new WordProcessor("D:\\polytechnic\\text-for-word.txt");
        proc.read();
        out.println(proc);
        out.println(proc.findWord(word));
    }
}
