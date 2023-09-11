package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.services.MockBookService;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private MockBookService mockBookService = new MockBookService();
    private Book book = new Book();
    @RequestMapping("/")
    public MockBookService showAllBooks() {
        return mockBookService;
    }

    @GetMapping("/{id}")
    public Book showBookById(@PathVariable Long id) {
        return mockBookService.get(id).orElse(null);
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String isbn,
                          @RequestParam String title,
                          @RequestParam String publisher,
                          @RequestParam String type,
                          @RequestParam String author) {
        if (mockBookService.getBooks()==null) {
            book.setId(1L);
        } else {
            book.setId((long) (mockBookService.getBooks().size() + 1));
        }
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setType(type);
        book.setAuthor(author);

        mockBookService.add(book);
        return "Dodano!";
    }
    @PutMapping("/update")
    public String updateBook(@RequestParam Long id,
                             @RequestParam String isbn,
                             @RequestParam String title,
                             @RequestParam String publisher,
                             @RequestParam String type,
                             @RequestParam String author) {
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setType(type);
        book.setAuthor(author);
        mockBookService.getBooks().set(Math.toIntExact(id), book);
        return "Zaktualizowano!";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        mockBookService.delete(id);
        return "book deleted!";
    }
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
}

