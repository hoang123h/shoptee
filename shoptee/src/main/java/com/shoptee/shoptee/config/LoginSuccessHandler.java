package com.shoptee.shoptee.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
   /* @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        CustomerDetails customerDetails = (CustomerDetails) authentication.getPrincipal();
        String redirectURL = request.getContextPath();
        if (customerDetails.hasRole("Product")) {
            redirectURL = "product";
        } else if (customerDetails.hasRole("Category")) {
            redirectURL = "category";
        } else if (customerDetails.hasRole("User")) {
            redirectURL = "users";
        }
        response.sendRedirect(redirectURL);
    }*/
}
