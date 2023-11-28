package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.HrDAO;

public class MypageTest {

	@Test
	public void testGetMypage() {
		HrDAO hrDAO = new HrDAO();
		int id = 15;
		
		List<HashMap<String, String>> result = hrDAO.getMypage(id);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	@Test
	public void testGetMypageInvalid() {
		HrDAO hrDAO = new HrDAO();
		int id = -1;
		
		List<HashMap<String, String>> result = hrDAO.getMypage(id);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
}
