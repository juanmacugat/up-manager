package repository;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.assertTrue;

public class UserRepositoryTest {

    @Test
    public void testHashedPassword(){
        String pass = "admin";
        String hashedPasword = BCrypt.hashpw(pass, BCrypt.gensalt());
        System.out.printf(hashedPasword);
        assertTrue(BCrypt.checkpw(pass, hashedPasword));
    }
}
