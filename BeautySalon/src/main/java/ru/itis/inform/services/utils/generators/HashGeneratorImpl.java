package ru.itis.inform.services.utils.generators;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
@Component
public class HashGeneratorImpl implements HashGenerator {
    private PasswordEncoder encoder;

    public HashGeneratorImpl() {
        encoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean match(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
