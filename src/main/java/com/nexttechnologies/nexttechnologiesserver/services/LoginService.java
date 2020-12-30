package com.nexttechnologies.nexttechnologiesserver.services;

import com.nexttechnologies.nexttechnologiesserver.models.AppUser;
import com.nexttechnologies.nexttechnologiesserver.repositories.AppUserRepository;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
@Service
public class LoginService {

    //@Autowired
    private final AppUserRepository userRepository;

    public LoginService(AppUserRepository userRepository) {
        this. userRepository = userRepository;
    }

    //@SneakyThrows
    public AppUser loadUser(String username) throws Exception {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception());
    }
}
