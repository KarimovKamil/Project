package ru.itis.inform.exceptions;

/**
 * Created by Kamil Karimov on 18.11.2016.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String string){
            super(string);
    }
}
