package org.tn.zitouna.configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTTokenUtil {

	@Value("${jwt.secretKey}")
	private String secretKey;
	
	
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		Claims claims = this.getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
		
	}
	
	public List<GrantedAuthority> getAuthoritiesClaimFromToken(String token){
		Claims claims = this.getAllClaimsFromToken(token);
		List<GrantedAuthority> returnValue = null;
		List<String>  authorities = (List)claims.get("authorities");
		
		if(authorities == null) return returnValue;
		
		returnValue = new ArrayList<>();
		
		return authorities.stream().map(SimpleGrantedAuthority :: new) .collect(Collectors.toList());
		
	}
	
	public String getUserNameFromToken(String token) {
		return this.getClaimFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationDateFromToken(String token) {
		return this.getClaimFromToken(token, Claims::getExpiration);
	}
	
	private Boolean isTokenExpired(String token) {
		
		Date expiration = this.getExpirationDateFromToken(token);
		
		return expiration.before(new Date());
	}
	
	public Boolean validatToken(String token, String principal) {
		String userName = this.getUserNameFromToken(token);
		return StringUtils.isNotBlank(userName) && userName.equals(principal) && !this.isTokenExpired(token);
		
	}
	
public Authentication getAthentication(String userName, List<GrantedAuthority> authorities, HttpServletRequest request) {
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, null, authorities);
		
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		
		return authenticationToken;
	}

}