package it.discovery.persistence.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    void save_validPublisher_success() {
    }

    @Test
    void save_publisherWithoutName_error() {
    }


}