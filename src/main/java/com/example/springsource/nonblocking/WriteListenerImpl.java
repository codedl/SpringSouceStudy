package com.example.springsource.nonblocking;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * The implementation of WriteListener
 *
 * @author Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
 */
public class WriteListenerImpl implements WriteListener {

    private ServletOutputStream output;
    private AsyncContext context;

    public WriteListenerImpl(ServletOutputStream output, AsyncContext context) {
        this.context = context;
        this.output = output;
    }

    /**
     * do when the data is available to be written
     */
    @Override
    public void onWritePossible() throws IOException {

        if (output.isReady()) {
            output.println("<p>Server is sending back 5 hello...</p>");
            output.flush();
        }

        for (int i = 1; i <= 5 && output.isReady(); i++) {
            output.println("<p>Hello " + i + Thread.currentThread().getName() + ".</p>");
            output.println("<p>Sleep 3 seconds simulating data blocking.<p>");
            output.flush();

            // sleep on purpose
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // ignore
            }
        }
        output.println("<p>Sending completes.</p>");
        output.flush();
        context.complete();
    }

    /**
     * do when error occurs.
     */
    @Override
    public void onError(Throwable t) {
        context.complete();
        t.printStackTrace();
    }

}
