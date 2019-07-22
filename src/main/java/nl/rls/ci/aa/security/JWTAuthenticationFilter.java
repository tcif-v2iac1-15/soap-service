package nl.rls.ci.aa.security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static nl.rls.ci.aa.security.SecurityConstants.EXPIRATION_TIME;
import static nl.rls.ci.aa.security.SecurityConstants.HEADER_STRING;
import static nl.rls.ci.aa.security.SecurityConstants.SECRET;
import static nl.rls.ci.aa.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.rls.ci.aa.domain.License;
import nl.rls.ci.aa.dto.UserDtoLogin;
import nl.rls.ci.aa.repository.LicenseRepository;

/**
 * 
 * @author berend.wilkens
 * 
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	private LicenseRepository licenseRepository;
	private static final Logger log = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, LicenseRepository licenseRepository) {
		this.authenticationManager = authenticationManager;
		this.licenseRepository = licenseRepository;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			UserDtoLogin userDtoLogin = new ObjectMapper().readValue(req.getInputStream(), UserDtoLogin.class);

			log.info("UserDtoLogin: " + userDtoLogin);
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDtoLogin.getEmail(),
					userDtoLogin.getPassword(), new ArrayList<>());
			if (authentication.isAuthenticated()) {
				License license = licenseRepository.validLicenseByUsername(userDtoLogin.getEmail(), new Date());
				if (license != null) {
					System.out.println(license);
					return authenticationManager.authenticate(authentication);
				}
				System.out.println("CredentialsExpiredException");
				authentication.setAuthenticated(false);
				return authentication;
			}
			System.out.println("BadCredentialsException");
			return authenticationManager.authenticate(authentication);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		if (auth.isAuthenticated()) {
			String token = JWT.create()
					.withSubject(
							((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
					.sign(HMAC512(SECRET.getBytes()));
			res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		}
	}
}