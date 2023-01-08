package az.developia.bookshopping_veliyev_perviz.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import az.developia.bookshopping_veliyev_perviz.model.User;

@Component
public class UersDAO {
	
	@Autowired
	private DataSource dataSource;
	
	public String createUser(User user) {
		String result="";
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	

}
