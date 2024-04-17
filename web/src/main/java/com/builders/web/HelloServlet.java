package com.builders.web;

import com.builders.services.BuilderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hello = new BuilderService().sayHello();
        InputStream stream = HelloServlet.class.getClassLoader().getResourceAsStream("web_config.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        hello = hello + " " + properties.getProperty("hello");
        req.setAttribute("hello", hello);
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
    }
}
