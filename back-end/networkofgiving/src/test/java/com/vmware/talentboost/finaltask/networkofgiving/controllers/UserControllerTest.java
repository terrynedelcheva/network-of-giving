package com.vmware.talentboost.finaltask.networkofgiving.controllers;

import com.vmware.talentboost.finaltask.networkofgiving.model.Charity;
import com.vmware.talentboost.finaltask.networkofgiving.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void create() {
        User user = new User();
        user.setUsername("radonedelchev");
        user.setPassword("duron600");
        user.setAge(24);
        user.setFirstName("Radoslav");
        user.setLastName("Nedelchev");
        user.setGender("Male");
        user.setLocation("Yambol, Bulgaria");
        ResponseEntity<Void> responseEntity = restTemplate.postForEntity("/users", user, Void.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT, responseStatus);
    }

    @Test
    void getAll() {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("/users", HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {});
        HttpStatus responseStatus = responseEntity.getStatusCode();
        List<User> userList = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseStatus);
        assertFalse(userList.isEmpty());
        assertNotNull(userList);
    }

    @Test
    void getUserById() {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("/users/1", User.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        User user = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(user);
    }

    @Test
    void deleteUser() {
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/users/4", HttpMethod.DELETE, null, Void.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT, responseStatus);
    }
}