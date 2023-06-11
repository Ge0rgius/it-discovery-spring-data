package it.discovery.persistence.repository;

import it.discovery.persistence.model.Book;
import it.discovery.persistence.model.tuple.BookInfo;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Window;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BookRepository extends ListCrudRepository<Book, Integer> {

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

    //FIXME
    //@Query("SELECT b FROM Book b left join fetch b.hits")
    //Page<Book> findWithHits(Pageable pageable);

    Window<Book> findBy(ScrollPosition scrollPosition);

    List<BookInfo> findBy();
}
