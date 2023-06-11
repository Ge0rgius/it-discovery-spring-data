package it.discovery.persistence.repository;

import it.discovery.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    /**
//     * Returns all the books with exact name
//     *
//     * @param name
//     * @return
//     */
//    List<Book> find(String name);
//
//    /**
//     * Returns all the books where name contains specified text
//     *
//     * @param text
//     * @return
//     */
//    List<Book> findContaining(String text);
//
//    /**
//     * Returns all the books where number of pages is greater than pages parameter
//     *
//     * @param pages
//     * @return
//     */
//    List<Book> findWithPagesGreaterThan(int pages);
//
//    /**
//     * Returns overall number of pages for all the books
//     *
//     * @return
//     */
//    int findTotalPages();
//
//    Book findWithHits(int id);
//
//    List<BookInfo> find();
}
