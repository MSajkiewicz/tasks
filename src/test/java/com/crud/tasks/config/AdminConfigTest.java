package com.crud.tasks.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"admin.mail=test@test.com"})
public class AdminConfigTest {
    @Autowired
    private AdminConfig adminConfig;

    @Test
    public void testGetAdminMail() {
        // Given & When & Then
        assertEquals("test@test.com", adminConfig.getAdminMail());
    }
}