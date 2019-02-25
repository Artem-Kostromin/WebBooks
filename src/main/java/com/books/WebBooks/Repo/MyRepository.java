package com.books.WebBooks.Repo;

import com.books.WebBooks.Entity.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyRepository extends CrudRepository<Books, Integer> {
    //List<Books> findByAuthor(String author);
}
