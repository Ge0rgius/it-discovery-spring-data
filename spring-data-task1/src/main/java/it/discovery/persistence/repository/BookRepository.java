package it.discovery.persistence.repository;

import it.discovery.persistence.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Returns all the books with exact name
     *
     * @param name
     * @return
     */
    List<Book> findByName(String name);

    /**
     * Returns all the books where name contains specified text
     *
     * @param text
     * @return
     */
    List<Book> findByNameLikeIgnoreCase(String text);

    /**
     * Returns all the books where number of pages is greater than pages parameter
     *
     * @param pages
     * @return
     */
    List<Book> findByPagesGreaterThan(int pages);

    /**
     * Returns overall number of pages for all the books
     *
     * @return
     */
    @Query("SELECT SUM(pages) FROM Book")
    int findTotalPages();

    @Query("SELECT b FROM Book b left join fetch b.hits")
    Page<Book> findWithHits(Pageable pageable);

//    List<BookInfo> find();
}
