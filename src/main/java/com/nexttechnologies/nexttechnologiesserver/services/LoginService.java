package com.nexttechnologies.nexttechnologiesserver.services;

import com.nexttechnologies.nexttechnologiesserver.repositories.AppUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final AppUserRepository userRepository;

    /*public AppUser loadUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception());
    }*/

    @SneakyThrows
	@Override
	public UserDetails loadUserByUsername(String username) {
		return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
	}
}
