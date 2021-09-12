package in.co.rahogata.preauthrestapi;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class ExampleUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        if ("fail".equals(token.getPrincipal())) {
            throw new UsernameNotFoundException(token.getPrincipal().toString());
        }
        return new User(token.getPrincipal().toString(), token.getPrincipal().toString(), Collections.singleton(new SimpleGrantedAuthority("trees")));
    }
    
}
