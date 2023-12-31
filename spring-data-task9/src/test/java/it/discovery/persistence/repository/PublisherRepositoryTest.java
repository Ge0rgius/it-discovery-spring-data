package it.discovery.persistence.repository;

import it.discovery.persistence.model.Address;
import it.discovery.persistence.model.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Testcontainers
class PublisherRepositoryTest {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8")
            .withUsername("admin")
            .withPassword("admin")
            .withDatabaseName("admin")
            .withReuse(true);

//    @DynamicPropertySource
//    static void mapProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", () -> mysql.getJdbcUrl());
//        registry.add("spring.datasource.username", () -> mysql.getUsername());
//        registry.add("spring.datasource.password", () -> mysql.getPassword());
//    }

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    void save_validPublisher_success() {
        Publisher publisher = new Publisher();
        publisher.setName("Packt");
        publisher.setAddress(new Address("Odesa", "Gretska", 100, "65000"));

        publisherRepository.save(publisher);

        List<Publisher> publishers = publisherRepository.findAll();
        assertEquals(1, publishers.size());
        Publisher publisher2 = publishers.get(0);
        assertEquals(publisher.getName(), publisher2.getName());
        assertNotNull(publisher2.getCreated());
    }

    @Test
    void save_publisherWithoutName_error() {
    }


}