package com.haas.webview.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Aya M. Ashraf
 */
public class RedirectFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-- in init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getSession(false) != null && req.getSession(false).getAttribute("loggedUser") != null) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("/login.htm").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("-- in destroy filter");
    }

}
