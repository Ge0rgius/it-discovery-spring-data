package it.discovery.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

/**
 * Person who can write books, for example
 *
 * @author admin
 */
@Getter
@Setter
@Table("PERSONS")
public class Person extends BaseEntity {

    private String name;

    /**
     * Books that person has written
     */
    private List<Book> books;

}
