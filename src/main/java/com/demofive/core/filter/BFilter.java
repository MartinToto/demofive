package com.demofive.core.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * Created by Martin on 2019/4/10.
 */
@Component
//@WebFilter(urlPatterns = "/*",filterName = "aFilter")
public class BFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("BFilter=====2222=========start");
        chain.doFilter(request,response);
    }

}
