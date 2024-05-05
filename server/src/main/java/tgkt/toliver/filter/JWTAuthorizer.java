package tgkt.toliver.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import tgkt.toliver.properties.JWTProperties;

import java.io.IOException;

//@Component
public class JWTAuthorizer extends OncePerRequestFilter {

    //@Resource
    JWTProperties util;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }

    //@Override
    /*
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String auth = request.getHeader("Authorization");

        DecodedJWT dJWT = util.resolveJWT(auth);

        if (dJWT != null) {
            SystemUser user = util.toUser(dJWT);

            System.out.println(user.getName());
            UsernamePasswordAuthenticationToken
                    aToken =
                    new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            user.getAuthorities()
                    );

            aToken.setDetails(new WebAuthenticationDetailsSource()
                    .buildDetails(request));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(aToken);

            //request.setAttribute("id", util.toId(dJWT));
        }

        filterChain.doFilter(request, response);
    }*/
}