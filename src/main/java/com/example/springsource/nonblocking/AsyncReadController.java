package com.example.springsource.nonblocking;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/aread")
public class AsyncReadController {

    class AsyncWrite implements WriteListener{
        AsyncContext context = null;
        ServletOutputStream output = null;
        InputStream inputStream = null;

        public AsyncWrite(AsyncContext context, ServletOutputStream output, InputStream inputStream) {
            this.context = context;
            this.output = output;
            this.inputStream = inputStream;
        }

        @Override
        public void onWritePossible() throws IOException {
            if(output.isReady() && inputStream.available() > 0){
                int read = 0;
                byte[] buffer = new byte[1024];
                while ((read = inputStream.read(buffer)) != -1){
                    output.write(buffer,0, read);
                }
            }
            if(inputStream.available() <= 0){
                context.complete();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println(throwable);
        }
    }
    InputStream inputStream = null;
    @GetMapping("/baidu")
    public Callable baidu(HttpServletRequest request, HttpServletResponse response) throws Exception {


        URL url = new URL("http://www.baidu.com");
        URLConnection urlConnection = url.openConnection();
        inputStream = urlConnection.getInputStream();
        ServletOutputStream output = response.getOutputStream();

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                int read = 0;
                byte[] buffer = new byte[1024];
                while ((read = inputStream.read(buffer)) != -1){
                    output.write(buffer,0, read);
                }
                return null;
            }
        };
        return callable;

    }

    @GetMapping
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter output = response.getWriter();
            output.println("<html>");
            output.println("<head>");
            output.println("<title>Reading asynchronously</title>");

            output.println("<meta charset=\"utf-8\"></meta>");
            output.println("<title>Servlet 3.1 WAS Classic tests</title>");
            output.println("<style>");
            output.println(".frm1{padding: 15px;background-color: #9666af; margin-bottom: 10px;}");
            output.println(".frm2{padding-left: 25px; font-family: Verdana; color: #440055;}");
            output.println(".big{font-size: 26px; color: white;}");
            output.println(".small{font-size: 12px;}");
            output.println("button, select{padding: 5px; padding-left: 20px; padding-right: 20px; margin:10px; width: 270px}");
            output.println("</style>");
            output.println("</head>");
            output.println("<body>");
            output.println("<body>");
            output.println("<div class=\"frm1\">");
            output.println("<div class=\"big\"> WAS Java EE 7 Sample - Non-blocking I/O using Servlet 3.1</div>");
            output.println("</div>");
            output.println("<div class=\"frm2\">");
            output.println("</div>");
            output.println("</head>");
            output.println("<body>");
            output.println("<h3>The following post data was read asynchronously using a Servlet 3.1 readListener</h3>");

            AsyncContext context = request.startAsync();
            ServletInputStream input = request.getInputStream();
            input.setReadListener(new MyReadListener(input, context, output));

        } catch (IOException ex) {
            Logger.getLogger(ReadTestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
