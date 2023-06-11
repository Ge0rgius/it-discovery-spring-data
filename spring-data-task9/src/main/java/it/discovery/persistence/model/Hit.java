package it.discovery.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table("HITS")
public class Hit extends BaseEntity {
    private String ip;

    private String browser;

    private LocalDateTime viewed;

    private Book book;

}
