package com.vmware.talentboost.finaltask.networkofgiving.controllers;

import com.vmware.talentboost.finaltask.networkofgiving.model.Charity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.config.Task;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharityControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createCharityTest() {
        Charity charity = new Charity();
        charity.setTitle("Test title");
        charity.setDescription("test description");
        charity.setDonationRequired(230);
        charity.setVolunteersRequired(23);
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/charities", charity, Void.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT, responseStatus);
    }

    @Test
    void getAllCharitiesTest() {
        ResponseEntity<List<Charity>> responseEntity = restTemplate.exchange("/charities", HttpMethod.GET, null, new ParameterizedTypeReference<List<Charity>>(){});
        HttpStatus responseStatus = responseEntity.getStatusCode();
        final List<Charity> charityList = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(charityList);
        assertFalse(charityList.isEmpty());
    }

    @Test
    void getCharityTest() {
        ResponseEntity<Charity> responseEntity = restTemplate.getForEntity("/charities/16", Charity.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        Charity charity = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(charity);
    }

    @Test
    void deleteCharityPositiveTest() {
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/charities/39", HttpMethod.DELETE, null, Void.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT, responseStatus);
    }

    @Test
    void updateCharityTest() {
        Charity charity = new Charity();
        charity.setTitle("Test title2");
        charity.setDescription("test description2");
        charity.setDonationRequired(230);
        charity.setVolunteersRequired(23);
        HttpEntity<Charity> requestUpdate = new HttpEntity<>(charity, new HttpHeaders());
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/charities/52", HttpMethod.PUT, requestUpdate, Void.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT, responseStatus);
    }
}