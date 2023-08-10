package config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.skillassess.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		
		String userName = null;
		String jwtToken = null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				userName = this.jwtUtils.extractUsername(jwtToken);
			}catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("jwt token expired");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Invalid token, not starts with bearer");
		}
		
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
			if(this.jwtUtils.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}else {
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);
		
	}

}
