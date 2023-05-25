package com.example.springsource.nonblocking;


import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This Servlet sets the WriteListener for ServletInputStream, illustrates the
 * usage of servlet 3.1 API for non-blocking IO.
 *
 * @author Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
 */
@WebServlet(name = "ServerServlet", urlPatterns = {"/server"}, asyncSupported = true)
public class ServerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName());
        response.setContentType("text/html;charset=UTF-8");
        // async write
        final AsyncContext context = request.startAsync();
        final ServletOutputStream output = response.getOutputStream();
        output.setWriteListener(new WriteListenerImpl(output, context));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}