package ru.itis.inform.security;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kamil Karimov on 25.11.2016.
 */
public class CORSFilter implements Filter {

    public CORSFilter() {
    }

    /**Allowing our domain use resources from other domains: adding special headers to every response
     * @param req - default ServletRequest which is gonna be adduct into HttpServletRequest
     * @param res - default ServletResponse which is gonna be adduct into HttpServletResponse
     * @param chain - default filter chain*/
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("ORIGIN"));
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "Confirm-Code , Content-Type");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, access-control-allow-origin , Auth-Token, Password, Identifier");
        if (!request.getMethod().equals("OPTIONS")) {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
