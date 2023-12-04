package com.itheima.interceptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          String url = request.getRequestURL().toString();
          log.info(url);

          if (url.contains("login")) {
              log.info("login request pass");
              return true;
          }

          String jwt = request.getHeader("token");
          if (!StringUtils.hasLength(jwt)) {
              log.info("token is null");
              return false;
          }

          try {
              JwtUtils.parseJWT(jwt);
          } catch (Exception e) {
              e.printStackTrace();
              System.out.println("not valid");
              return false;
          }

          log.info("pass");
          return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle...");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterhandle...");
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
