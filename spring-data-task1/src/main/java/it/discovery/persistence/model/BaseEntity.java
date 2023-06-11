package it.discovery.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
//@Entity
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;


//    @PrePersist
//    void onPersist() {
//        created = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    void onUpdate() {
//        modified = LocalDateTime.now();
//    }

}
