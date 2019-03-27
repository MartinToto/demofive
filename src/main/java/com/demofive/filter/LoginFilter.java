package com.demofive.filter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by Martin on 2019/3/27.
 */
public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JSONObject jsonObject = new JSONObject();
        request.getQueryString();
        Jedis jedis = new Jedis();
        String token = null;
        Cookie[] cookies = request.getCookies();
        Stream<Cookie> stream = Arrays.stream(cookies);

        String headerToken = request.getHeader("token");
        if(request.getHeader("token")== null){
            jsonObject.put("errorManage", "请求错误,token为null");
            returnErrorResponse(response,jsonObject);
        }
        if(request.getHeader("token")!= null){
            token = jedis.get("token");
        }else {
            token = UUID.randomUUID().toString();
            jedis.set("token",token);
            jedis.expire("token",30*1000);

        };
        if(jedis.exists("token")){
            String cacheToken = jedis.get("token");
            if(token.equals(cacheToken)){
                jsonObject.put("errorManage", "请勿重复提交");
            }
        }else {
            token = UUID.randomUUID().toString();
            jedis.set("token",token);
            jedis.expire("token",30*1000);
        }
        System.out.println("====================="+new Date());





        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("请求之后----"+new Date());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    public void returnErrorResponse(HttpServletResponse response, JSONObject result) throws IOException, UnsupportedEncodingException {
        OutputStream out = null;
        try{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(result.getBytes("utf-8"));
            out.flush();
        } finally{
            if(out!=null){
                out.close();
            }
        }
    }
}
