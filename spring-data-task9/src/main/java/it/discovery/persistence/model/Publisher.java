package it.discovery.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

/**
 * Book publisher
 *
 * @author morenets
 */
@Getter
@Setter
@Table("PUBLISHERS")
public class Publisher extends BaseEntity {

    @Column
    private String name;

    private List<Book> books;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private Address address;

}
