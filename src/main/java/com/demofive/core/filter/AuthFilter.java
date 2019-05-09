package com.demofive.core.filter;


        import java.io.IOException;
        import java.util.Random;
        import java.util.UUID;

        import javax.servlet.Filter;
        import javax.servlet.FilterChain;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRequest;
        import javax.servlet.ServletResponse;
        import javax.servlet.annotation.WebFilter;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.BeansException;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.ApplicationContextAware;
        import org.springframework.core.annotation.Order;
        import org.springframework.stereotype.Component;



/**
 * 验证用户过滤器，保存当前用户信息，必须第一个执行
 *
 * @author zhaojh
 * @date 2019年2月21日
 */
@Component
//@WebFilter(urlPatterns = "/*", filterName = "authFilter")
public class AuthFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        filterChain.doFilter(servletRequest, response);

    }



}

