package it.discovery.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Book in a library
 *
 * @author morenets
 */
@Getter
@Setter
@Table("BOOKS")
public class Book extends BaseEntity {

//    @Id
//    @GenericGenerator(name = "counter", strategy = "it.discovery.persistence.generator.AutoIncrementGenerator")
//    @GeneratedValue(generator = "counter")
//    private int id;

    private String name;

    private Person author;

    private Publisher publisher;

    private BookState state;

    /**
     * Publishing year
     */
    @Column("publishingYear")
    private Integer year;

    /**
     * Total number of pages
     */
    @Column
    private Integer pages;

    private List<Hit> hits;

    private Integer hitCount;

    public void addHit(Hit hit) {
        if (hits == null) {
            hits = new ArrayList<>();
        }
        hit.setBook(this);
        hits.add(hit);

    }


}
