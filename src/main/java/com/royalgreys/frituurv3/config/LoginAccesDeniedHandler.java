package com.royalgreys.frituurv3.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAccesDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if(auth != null){
           System.out.println("Access denied error");
       }
       httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/access-denied");
    }
}
