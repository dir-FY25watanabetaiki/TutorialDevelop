package com.dirbato.service;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.dirbato.entity.Authentication;
import com.dirbato.repository.AuthenticationRepository;
@Service
public class UserDetailService implements UserDetailsService {
    private final AuthenticationRepository authenticationRepository;
    public UserDetailService(AuthenticationRepository repository) {
        this.authenticationRepository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Authentication> authentication = authenticationRepository.findById(username);
        if (!authentication.isPresent()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new UserDetail(authentication.get().getUser());
    }
}