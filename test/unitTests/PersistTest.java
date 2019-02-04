package unitTests;

import data.PersistenceDAO;
import data.PersistenceDAOImpl;
import entities.User;

public class PersistTest {

	
	
	public static void main(String[] args) {
		PersistenceDAO dao = new PersistenceDAOImpl();
		
		User u = new User();
		
		dao.createNewUser(u);
	}
	
	
}
