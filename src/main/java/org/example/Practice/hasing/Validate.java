package org.example.Practice.hasing;

import org.mindrot.jbcrypt.BCrypt;

public class Validate {

    public String hashPassword(String password){
return BCrypt.hashpw(password,BCrypt.gensalt(12));
    }

    public boolean checkPassword(String password,String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }




}
