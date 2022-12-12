package az.developia.bookshopping_veliyev_perviz.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	
	@Size(min = 1,message = "Istifadeci adi min-1 simvol olmalidir!")
	@Size(max = 30,message = "Istifadeci adi max-30 simvol olmalidir!")
	@NotEmpty(message = "Bos qoymaq olmaz!")
	private String username;
	
	@Size(min = 1,message = "Sifre min-1 simvol olmalidir!")
	@Size(max = 30,message = "Sifre max-30 simvol olmalidir!")
	@NotEmpty(message = "Bos qoymaq olmaz!")
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	
	
	
	
	
	
}



