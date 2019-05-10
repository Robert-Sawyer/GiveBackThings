package com.github.robertsawyer.GiveBackThings.filter;

import com.github.robertsawyer.GiveBackThings.domain.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        User user = (User) session.getAttribute("userId");
        if (user == null) {
            ((HttpServletResponse) resp).sendRedirect("/login");
        } else {
            chain.doFilter(req, resp);
        }
    }
    //pobieramy sesję, rzutujemy na HttpServletrequest, bo nie możemy pobrać tej klasy, bo implementujemy interfejs, któ©y nie posaida metody z HttpServlet, tylko
    //z ServletRequest i ServletResponse. tworzymy Longa i pobieramy do niego z sesji Id zalogowanego usera. jeżeli nie ma id

    public void init(FilterConfig config) throws ServletException {

    }

}
