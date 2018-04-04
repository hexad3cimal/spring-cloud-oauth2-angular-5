package com.jovin.webapp.auth;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hexad3cimal on 9/4/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter extends OncePerRequestFilter {

    public CORSFilter () {
        super();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, authorization, Origin, Content-Type, Version,username,password");
        response.setHeader("Access-Control-Expose-Headers", "X-Requested-With, authorization, Origin, Content-Type");

        if (request.getMethod() != "OPTIONS") {
            chain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Override
    public void destroy() {

    }


}