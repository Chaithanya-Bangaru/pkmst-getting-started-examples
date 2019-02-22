/**
 * 
 */
package com.prokarma.pkmst.pkmst.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.prokarma.pkmst.pkmst.config.Constants;

import io.jsonwebtoken.Jwts;

/**
 * @author prokarma
 *
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	/**
	 * @param authenticationManager
	 */
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req,

			HttpServletResponse res,

			FilterChain chain) throws IOException, ServletException {

		String header = req.getHeader(Constants.HEADER_STRING);

		if (header == null || !header.startsWith(Constants.TOKEN_PREFIX)) {

			chain.doFilter(req, res);

			return;

		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(req, res);

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

		String token = request.getHeader(Constants.HEADER_STRING);

		if (token != null) {

			// parse the token.

			String user = Jwts.parser()

					.setSigningKey(Constants.SECRET)

					.parseClaimsJws(token.replace(Constants.TOKEN_PREFIX, ""))

					.getBody()

					.getSubject();

			if (user != null) {

				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());

			}

			return null;

		}

		return null;

	}
}