package ru.itis.inform.services.utils.generators;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
public interface TokenGenerator {

    /**
     * Generate token depends on time
     * @return token
     */
    String generateToken();
}
