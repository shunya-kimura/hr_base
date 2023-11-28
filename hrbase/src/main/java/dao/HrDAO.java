package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.HashGenerator;

public class HrDAO {
    private final String url = "jdbc:mysql://localhost/hrbase";
    private final String user = "root";
    private final String password = "";
    
    

    public List<HashMap<String, String>> getHrs() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
        List<HashMap<String, String>> hrs = new ArrayList<>();
        
        String sql = "SELECT h.id, d.department_name, p.position_name, h.employee, h.username, h.userpassword "
            	+ "FROM hrs h "
            	+ "INNER JOIN departments d ON h.department_id = d.id "
            	+ "INNER JOIN positions p ON h.position_id = p.id;";
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
        	
            while (resultSet.next()) {
                HashMap<String, String> hr1 = new HashMap<>();
                hr1.put("id", resultSet.getString("id"));
                hr1.put("department_name", resultSet.getString("department_name"));
                hr1.put("employee", resultSet.getString("employee"));
                hr1.put("position_name", resultSet.getString("position_name"));
                hr1.put("username", resultSet.getString("username"));
                hr1.put("userpassword", resultSet.getString("userpassword"));
                hrs.add(hr1);		
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hrs;
    }
    
    public List<HashMap<String, String>> getShow(int id) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
        List<HashMap<String, String>> hrs = new ArrayList<>();
        
        String sql = "SELECT h.id, h.department_id, h.position_id, d.department_name, p.position_name, h.employee, h.username, h.userpassword "
                + "FROM hrs h "
                + "INNER JOIN departments d ON h.department_id = d.id "
                + "INNER JOIN positions p ON h.position_id = p.id "
                + "WHERE h.id = ?";
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
        	
            while (resultSet.next()) {
                HashMap<String, String> hr1 = new HashMap<>();
                hr1.put("id", resultSet.getString("id"));
                hr1.put("department_name", resultSet.getString("department_name"));
                hr1.put("employee", resultSet.getString("employee"));
                hr1.put("position_name", resultSet.getString("position_name"));
                hr1.put("username", resultSet.getString("username"));
                hr1.put("userpassword", resultSet.getString("userpassword"));
                hrs.add(hr1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hrs;
    }
    
    public List<HashMap<String, String>> getEdit(int id) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
        List<HashMap<String, String>> hrs = new ArrayList<>();
        
        String sql = "SELECT h.id, h.department_id, h.position_id, d.department_name, p.position_name, h.employee, h.username, h.userpassword "
                + "FROM hrs h "
                + "INNER JOIN departments d ON h.department_id = d.id "
                + "INNER JOIN positions p ON h.position_id = p.id "
                + "WHERE h.id = ?";
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
        	
            while (resultSet.next()) {
                HashMap<String, String> hr1 = new HashMap<>();
                hr1.put("id", resultSet.getString("id"));
                hr1.put("department_name", resultSet.getString("department_name"));
                hr1.put("employee", resultSet.getString("employee"));
                hr1.put("position_name", resultSet.getString("position_name"));
                hr1.put("username", resultSet.getString("username"));
                hr1.put("userpassword", resultSet.getString("userpassword"));
                hrs.add(hr1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hrs;
    }
    
    public void updateHr(int id, int department_id, String employee, int position_id, String username, String userpassword) {
    	String sql = "UPDATE hrs SET department_id = ?, employee = ?, position_id = ?, username = ?, userpassword = ? WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String hashedPassword = HashGenerator.generateHash(userpassword);
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, department_id);
            statement.setString(2, employee);
            statement.setInt(3, position_id);
            statement.setString(4, username);
            statement.setString(5, hashedPassword);
            statement.setInt(6, id);
                    
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void destroyHr(int id) {
        String sql = "DELETE FROM hrs WHERE id =?";
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, id);
            
			int number = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void createHr(int department_id, String employee, int position_id, String username, String userpassword) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	// パスワードが8文字未満の場合、処理を中止してエラーを出力する
        if (userpassword.length() < 8) {
            System.out.println("8文字以上入力されていません");
            return;
        }
    	
    	String sql = "INSERT INTO hrs (department_id, employee, position_id, username, userpassword) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	String hashedPassword = HashGenerator.generateHash(userpassword);
            PreparedStatement statement = connection.prepareStatement(sql);
       
			statement.setInt(1, department_id);
			statement.setString(2, employee);
			statement.setInt(3, position_id);
			statement.setString(4, username);
            statement.setString(5, hashedPassword);
			    
			int number = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int[] getUserId(String username, String userpassword) throws SQLException, NoSuchAlgorithmException {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	int[] result = new int[]{-1, -1};
    	
    	
    	//パスワードが8文字以上必要
    	if (userpassword.length() < 8) {
            return result;
        }
    	
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String hashedPassword = HashGenerator.generateHash(userpassword);
            String sql = "SELECT id, position_id FROM hrs WHERE username=? AND userpassword=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, hashedPassword);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                	result[0] = rs.getInt("id");
                    result[1] = rs.getInt("position_id");
                }
            }
        }
        return result;
    }
    
    public List<HashMap<String, String>> getMypage(int id) {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
        List<HashMap<String, String>> hrs = new ArrayList<>();
        
        String sql = "SELECT h.id, d.department_name, p.position_name, h.employee, h.username, h.userpassword "
                + "FROM hrs h "
                + "INNER JOIN departments d ON h.department_id = d.id "
                + "INNER JOIN positions p ON h.position_id = p.id "
                + "WHERE h.id = ?";
        
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
        	
            while (resultSet.next()) {
                HashMap<String, String> hr1 = new HashMap<>();
                hr1.put("id", resultSet.getString("id"));
                hr1.put("department_name", resultSet.getString("department_name"));
                hr1.put("employee", resultSet.getString("employee"));
                hr1.put("position_name", resultSet.getString("position_name"));
                hr1.put("username", resultSet.getString("username"));
                hr1.put("userpassword", resultSet.getString("userpassword"));
                hrs.add(hr1);		
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hrs;
    }
    
}
