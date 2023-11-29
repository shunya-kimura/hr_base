package test;

import org.junit.jupiter.api.Test;

import dao.HrDAO;

public class CreateTest {

	@Test
	public void testCreate() {
		
	    HrDAO hrDAO = new HrDAO();
	    
	    int department_id = 1;
	    String employee = "ななしたろう";
	    int position_id = 1;
	    String username = "nanashi";
	    String userpassword = "12345678";

		hrDAO.createHr(department_id, employee, position_id, username, userpassword);

	}
	
	@Test
	public void testCreateInvild() {
		
	    HrDAO hrDAO = new HrDAO();
	    
	    int department_id = 1;
	    String employee = "ななしたろう";
	    int position_id = 1;
	    String username = "nanashi";
	    String userpassword = "";

		hrDAO.createHr(department_id, employee, position_id, username, userpassword);

	}
}
