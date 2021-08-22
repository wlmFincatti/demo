package br.com.example.demo.config.security.filter;

import br.com.example.demo.config.token.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    private final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        TokenUtils.isAuthorizationValid(httpServletRequest.getHeader(AUTHORIZATION_HEADER));
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
