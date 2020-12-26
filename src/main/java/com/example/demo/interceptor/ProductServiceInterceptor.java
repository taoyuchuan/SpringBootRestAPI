package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Interceptor class to handle operations before send request, before send response, and before request complete.
 */
@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

    /**
     * Before sending a request.
     * @param request not used.
     * @param response not used.
     * @param handler not used.
     * @return information message.
     * @throws Exception when failed.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method is Calling");
        return true;
    }

    /**
     * Before sending a response.
     * @param request not used.
     * @param response not used.
     * @param handler not used.
     * @param modelAndView not used.
     * @throws Exception when failed.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is Calling");
    }

    /**
     * Before request complete.
     * @param request not used.
     * @param response not used.
     * @param handler not used.
     * @param exception not used.
     * @throws Exception when failed.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        System.out.println("Request and Response is completed");
    }
}
