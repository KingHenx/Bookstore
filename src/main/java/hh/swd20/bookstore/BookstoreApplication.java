package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return(args) ->{
			Book a = new Book("Lord of the Flies", "Willian Golding", 1954, "0-571-05686-5", 20);
			Book b = new Book("The Egyptian", "Mika Waltari", 1945, "1-55652-441-2", 30);
			Book c = new Book("Purge", "Sofi Oksanen", 2010, "951-0-33973-3", 25);
			
			repository.save(a);
			repository.save(b);
			repository.save(c);
		};
	}

}
