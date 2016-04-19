package com.singplayground.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter {
	//private static final Log LOG = LogFactory.getLog(CORSFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println("--------cors ******* ");
		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			//LOG.trace("Sending Header....");
			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			//			response.addHeader("Access-Control-Allow-Headers", "Authorization");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			response.addHeader("Access-Control-Max-Age", "1");

		}

		if (request.getHeader("Test") != null) {
			System.out.println("have header");
			System.out.println("Test : " + request.getHeader("Te.st"));

			String token = request.getHeader("Test");
			List<GrantedAuthority> grantedAuths = new ArrayList<>();
			// add the role to the 
			grantedAuths.add(new GrantedAuthorityImpl("ROLE_FOO"));
			//grantedAuths.add(user.getAuthorities());
			//return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
			//new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
			CustomUser user = new CustomUser();
			String name = "username1";
			String password = "thisisPass";

			user.setUsername(name);
			user.setPassword(password);
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, password, grantedAuths));
			System.out.println("thsi is name : " + SecurityContextHolder.getContext().getAuthentication().getName());
		} else {
			System.out.println(request.getHeader("Test"));
		}

		filterChain.doFilter(request, response);
	}

}
