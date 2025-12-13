package com.asif.sweet_shop_backend.Service;

import com.asif.sweet_shop_backend.Entity.User;
import com.asif.sweet_shop_backend.Repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(String email, String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(false);

        userRepository.save(user);
    }
    public String login(String email, String password){
        return "token";
    }
}
