package honest.sign.document.validator.controller;

import honest.sign.document.validator.vo.Document;
import honest.sign.document.validator.vo.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class DocumentControllerIT {
    @Autowired
    TestRestTemplate restTemplate;

    Document document;
    @BeforeEach
    void setUp() {
        List<Product> products = Arrays.asList(new Product("milk", "2364758363594"),
                new Product("water", "3656352437590"));
        document = new Document("123534351", "648563524", products);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void acceptDocument_Valid() {
        String rqdBody = "{\"seller\":\"123534351\",\"customer\":\"648563524\",\"products\"" +
                ":[{\"name\":\"milk\",\"code\":\"2364758363594\"}," +
                "{\"name\":\"water\",\"code\":\"3656352437590\"}]}";
        HttpHeaders headers = new HttpHeaders();

        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> entity = new HttpEntity<>(rqdBody, headers);
        ResponseEntity<Document> responseEntity = restTemplate.exchange("/v1/documentAcceptor",
                HttpMethod.POST, entity, Document.class);
        System.out.println("I'm execute");
        assertEquals(document.getCustomer(), responseEntity.getBody().getCustomer());
    }
}