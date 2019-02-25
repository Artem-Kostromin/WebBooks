package com.books.WebBooks;

import com.books.WebBooks.Entity.Books;
import com.books.WebBooks.Repo.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MyRepository booksRepos;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Books> books = booksRepos.findAll();
        model.put("books", books);
        return "greeting";
    }

    @PostMapping("/")
    public String add(@RequestParam String title,@RequestParam String author, Map<String, Object> model){
        Books book = new Books(title, author);
        booksRepos.save(book);

        Iterable<Books> books = booksRepos.findAll();
        model.put("books", books);

        return "greeting";
    }

}
