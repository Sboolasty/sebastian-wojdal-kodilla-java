package com.example.kodillaspring.forum;



import com.example.forum.ForumUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ForumUserTestSuite {

    @Autowired
    private ForumUser forumUser;

    @Test
    void testGetUsername() {
        // When
        String username = forumUser.getUsername();

        // Then
        assertEquals("John Smith", username);
    }
}