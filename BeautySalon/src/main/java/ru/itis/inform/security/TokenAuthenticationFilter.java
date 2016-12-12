package ru.itis.inform.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.inform.exceptions.TokenAuthenticationException;
import ru.itis.inform.validation.Validation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 05.12.2016.
 *
 * @author Maxim Romanov
 */
@Order(2)
public class TokenAuthenticationFilter extends GenericFilterBean {

    @Autowired
    private final UserDetailsService userDetailsService;
    @Autowired
    private TokenAuthenticationEntryPoint tokenAuthenticationEntryPoint;
    @Autowired
    private Validation verification;

    public TokenAuthenticationFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
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
        /**Obtain Auth-Token from request*/
        String token = request.getHeader("Auth-Token");
        /**Check: is this method secured or not*/
        if (!isSecuredMethod(request)) {
            /**If not call next filter in chain(allow access)*/
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            /**If yes check token existence in db and check for null and empty*/
            if (null != token && !token.isEmpty() && verification.customerExistenceByToken(token)) {
                /**If token is existing and not null and not empty fill user model with data from db*/
                UserDetails user = userDetailsService.loadUserByUsername(token);
                    /**Add user to context holder and allow access*/
                    Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    filterChain.doFilter(request, response);
            } else {
                /**If token is incorrect call commence*/
                tokenAuthenticationEntryPoint.commence(request, response, new TokenAuthenticationException("Token not found"));
            }
        }


    }

    /**
     * Check if method is secured
     */
    private boolean isSecuredMethod(HttpServletRequest request) {
        return !((request.getRequestURI().endsWith("/login") && request.getMethod().equals("POST"))
                || (request.getRequestURI().contains("/users") && request.getMethod().equals("POST")));
    }

    /**
     * Check if method is for admin only
     */
    private boolean isAdminMethod(HttpServletRequest request) {
        return (request.getRequestURI().contains("/admin"));
    }

}
