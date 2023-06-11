package it.discovery.persistence.repository;

import it.discovery.persistence.model.Publisher;
import org.springframework.data.repository.ListCrudRepository;

public interface PublisherRepository extends ListCrudRepository<Publisher, Integer> {

}
