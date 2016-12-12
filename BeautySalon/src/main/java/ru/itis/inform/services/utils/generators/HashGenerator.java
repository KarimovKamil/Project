package ru.itis.inform.services.utils.generators;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
public interface HashGenerator {

    /**
     * Encode the raw password
     * @param password Raw password
     * @return Encoded password
     */
    String encode(String password);

    /**
     * Verify the raw password matches the encoded password
     * @param rawPassword Raw password
     * @param encodedPassword Encoded password
     * @return True if the passwords match, false if they do not.
     */
    boolean match(String rawPassword, String encodedPassword);
}
