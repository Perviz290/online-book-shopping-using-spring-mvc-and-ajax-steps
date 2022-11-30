package az.developia.bookshopping_veliyev_perviz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshopping_veliyev_perviz.model.Book;


public interface BookDAO extends JpaRepository<Book, Integer> {
	
	

}