package test;

import org.junit.jupiter.api.Test;

import dao.HrDAO;


class DestroyTest {

	@Test
	public void testDestroy() {
		int department_id = 1;
		String employee = "ななしたろう";
		int position_id = 1;
		String username = "nanashi";
		String userpassword = "12345678";
		
		HrDAO hrDAO = new HrDAO();
		hrDAO.createHr(department_id, employee, position_id, username, userpassword);
		
		
	}

}
