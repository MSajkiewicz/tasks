package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "trello.api.endpoint.prod=test_endpoint",
        "trello.app.key=test_key",
        "trello.app.token=test_token",
        "trello.app.name=test_name"
})
class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void testGetTrelloApiEndpoint() {
        //Given
        //When
        //Then
        assertEquals("test_endpoint" ,trelloConfig.getTrelloApiEndpoint());
    }

    @Test
    void getTrelloAppKey() {
        //Given
        //When
        //Then
        assertEquals("test_key" ,trelloConfig.getTrelloAppKey());
    }

    @Test
    void getTrelloToken() {
        //Given
        //When
        //Then
        assertEquals("test_token" ,trelloConfig.getTrelloToken());
    }

    @Test
    void getTrelloName() {
        //Given
        //When
        //Then
        assertEquals("test_name",trelloConfig.getTrelloName());
    }
}