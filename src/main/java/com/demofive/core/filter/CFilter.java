package com.demofive.core.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


/**
 * Created by Martin on 2019/4/10.
 */
@Component
//@WebFilter(urlPatterns = "/*",filterName = "aFilter")
public class CFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("CFilter=====33333=========start");
        chain.doFilter(request,response);
    }

}
