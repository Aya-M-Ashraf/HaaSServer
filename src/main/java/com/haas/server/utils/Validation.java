package com.haas.server.utils;


public class Validation {

    public static boolean nameValidation(String name) {
        if (name.matches("[A-Za-z\\s]+")) {
            return true;
        }
        return false;

    }
    
    public static boolean eMailValidation(String email) {

        if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            return true;
        }

        return false;
    }
    
     public static boolean passwordValidation(String pass) {

        if (pass.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])[^\\s]{8,}$")) {
            return true;
        }

        return false;
     }
     
     public static boolean mobileValidation(String phone) {

        if (phone.matches("\\d{11}")) {
            return true;
        }

        return false;
     }
    
    
}
