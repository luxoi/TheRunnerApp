package com.luxoi.therunnerapp.therunnerapp.user;

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
}
