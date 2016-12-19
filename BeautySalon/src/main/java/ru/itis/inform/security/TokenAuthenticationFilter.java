package ru.itis.inform.security;

import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.dao.config.DaoConfig;
import ru.itis.inform.exceptions.TokenAuthenticationException;
import ru.itis.inform.validation.Validation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 05.12.2016.
 *
 * @author Maxim Romanov
 */
@Order(1)
public class TokenAuthenticationFilter extends GenericFilterBean {

    private Validation validation;

    public TokenAuthenticationFilter() {
        validation = new Validation(new DaoConfig().jdbcTemplate());
    }

    /**
     * Main security filter which is processing every incoming request
     *
     * @param servletRequest  - default ServletRequest which is gonna be adduct into HttpServletRequest
     * @param servletResponse - default ServletResponse which is gonna be adduct into HttpServletResponse
     * @param filterChain     - default filter chain
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, AuthenticationException {
        /**Adduct ServletRequest to HttpServletRequest*/
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        /**Adduct ServletResponse to HttpServletResponse*/
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookie = request.getCookies();
        String token = "";
        if (cookie != null) {
            for (Cookie cookie1 : cookie) {
                if (cookie1.getName().equals("Auth-Token")) {
                    token = cookie1.getValue();
                    break;
                }
            }
        }
        /**Check: is this method secured or not*/
        if (!isSecuredMethod(request)) {
            /**If not call next filter in chain(allow access)*/
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            /**If yes check token existence in db and check for null and empty*/
            if (!token.isEmpty() && !token.equals("") && validation.customerExistenceByToken(token)) {
                /**If token is existing and not null and not empty fill user model with data from db*/
                filterChain.doFilter(request, response);
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
            }
        }
    }

    /**
     * Check if method is secured
     */
    private boolean isSecuredMethod(HttpServletRequest request) {
        return ((request.getRequestURI().contains("/profile") && request.getMethod().equals("POST"))
                || (request.getRequestURI().contains("/profile") && request.getMethod().equals("GET")));
    }

}
