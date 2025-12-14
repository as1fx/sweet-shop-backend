package com.asif.sweet_shop_backend.Service;

import com.asif.sweet_shop_backend.Entity.User;
import com.asif.sweet_shop_backend.Repo.UserRepository;
import com.asif.sweet_shop_backend.Security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String email, String password){

        if(userRepository.findByEmail(email).isPresent()){
            throw new RuntimeException("Email already exits");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setAdmin(false);

        userRepository.save(user);
    }
    public String login(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found"));

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return JwtUtil.generateToken(user.getEmail(), user.isAdmin());
    }
}
