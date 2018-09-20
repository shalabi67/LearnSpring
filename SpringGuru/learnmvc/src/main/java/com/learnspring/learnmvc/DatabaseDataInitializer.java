package com.learnspring.learnmvc;

import com.learnspring.learnmvc.model.Author;
import com.learnspring.learnmvc.model.Book;
import com.learnspring.learnmvc.model.Publisher;
import com.learnspring.learnmvc.repositories.AuthorRepository;
import com.learnspring.learnmvc.repositories.BookRepository;
import com.learnspring.learnmvc.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DatabaseDataInitializer(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		Publisher publisher = Publisher.create("mohammad");
		publisherRepository.save(publisher);

		Book book1 = Book.create("book1", "123", publisher);
		Book book2 = Book.create("book2", "123", publisher);

		Author author1 = Author.create("mohammad", "author1");
		Author author2 = Author.create("mohammad", "author2");

		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);

		author2.getBooks().add(book2);

		authorRepository.save(author1);
		authorRepository.save(author2);

		bookRepository.save(book2);
		bookRepository.save(book1);

	}
}
