package az.developia.bookshopping_veliyev_perviz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@NotEmpty(message = "Bos qoymaq olmaz")
	@Size(min = 2,message = "Minimum 2 simvol yazmaq lazimdir")
	
	@Column(columnDefinition = "VARCHAR(50)")
	private String name;
	
	private String description;
	
	@Min(value =0,message = "Minimum 0 yazmaq olar")
	@NotNull(message = "Bos qoymaq olmaz")
	private Double price;
	
	@Column(columnDefinition = "VARCHAR(30)")
	@Size(max =100,message = "Maximum 30 simvol yazmaq lazimdir")
	private String author;

	@Min(value =10,message = "Minimum 10 yazmaq olar")
	private String pageCount;
	
	private String image;
	private String userName; 
	
	// Get and Set Methods
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

	
	
	
}
