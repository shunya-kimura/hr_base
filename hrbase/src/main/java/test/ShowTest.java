package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.HrDAO;

public class ShowTest {

	@Test
	public void testGetShow() {
		HrDAO hrDAO = new HrDAO();
		int id = 15;
		
		List<HashMap<String, String>> result = hrDAO.getShow(id);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	//無効なID
	@Test
	public void testGetShowInvalid() {
		HrDAO hrDAO = new HrDAO();
		int id = 0;
		
		List<HashMap<String, String>> result = hrDAO.getShow(id);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

}
