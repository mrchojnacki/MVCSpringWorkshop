package pl.coderslab.services;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
@Service
public class MockBookService {
    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion","programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion","programming"));
    }
    public List<Book> getBooks() {
        return list;
    }


    public Optional<Book> get(Long id) {
        return list.stream().filter(n -> n.getId() == id).findFirst();
    }


    public void add(Book book) {
        list.add(book);
    }


    public void delete(Long id) {
        list.removeIf(get(id)::equals);
    }


    public void update(Book book) {
        Long id = book.getId();
        Iterator<Book> itr = getBooks().listIterator();
        while (itr.hasNext()) {
            Book newBook = itr.next();
            if (newBook.getId()==id) {
                newBook.setAuthor(book.getAuthor());
                newBook.setIsbn(book.getIsbn());
                newBook.setPublisher(book.getPublisher());
                newBook.setTitle(book.getTitle());
                newBook.setType(book.getType());
            }
        }
    }
}
