package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.HrDAO;

public class EditTest {

	@Test
	public void testGetEdit() {
		HrDAO hrDAO = new HrDAO();
		int id = 15;
		
		List<HashMap<String, String>> result = hrDAO.getEdit(id);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	
	@Test
	public void testGetEditInvalid() {
		HrDAO hrDAO = new HrDAO();
		int id = 0;
		
		List<HashMap<String, String>> result = hrDAO.getEdit(id);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

}
