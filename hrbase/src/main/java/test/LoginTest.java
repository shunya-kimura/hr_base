package test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import dao.HrDAO;

public class LoginTest {

    @Test
    public void testGetUserId() throws NoSuchAlgorithmException, SQLException {
        HrDAO hrDAO = new HrDAO();
        String username = "kimura";
        String password = "1234";
        
        int[] result = hrDAO.getUserId(username, password);
        assertNotNull(result);
      }
    }
