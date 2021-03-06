package com.epam.cdp.jee.todo.servlet.filter;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.common.base.Strings;

@WebFilter(urlPatterns = {"/app.jsp", "/new.jsp"})
@Slf4j
public class AuthenticationFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (Strings.isNullOrEmpty(username)) {
                ((HttpServletResponse) servletResponse).sendRedirect(request.getContextPath()
                        + "/errors/unauthorised.jsp");
                filterChain.doFilter(request, servletResponse);
            } else {
                log.debug("User '{}' is authenticated.", username);
                filterChain.doFilter(request, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
