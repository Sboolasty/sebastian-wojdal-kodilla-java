package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {
    @Mock
    private Statistics statisticsMock;

    private List<String> generateListOfUsers(int Users) {
        List<String> usersList = new ArrayList<>();
        if (Users > 0) {
            for (int n = 1; n <= Users; n++) {
                usersList.add("User " + n);
            }
        }
        return usersList;
    }
    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        System.out.println("Testing: " + displayName);
    }
    @Test
    @DisplayName("0 users 0 posts 0 comments")
    void test0user0post0comments()
    {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(0));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getAverageCommentsUser());
        assertEquals(0, forumStatistics.getAveragePostsUser());
        assertEquals(0, forumStatistics.getAverageCommentsPost());
        forumStatistics.showStatistics();
    }
    @Test
    @DisplayName("100 users 0 posts 0 comments")
    void test100user0post0comments()
    {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getAverageCommentsUser());
        assertEquals(0, forumStatistics.getAveragePostsUser());
        assertEquals(0, forumStatistics.getAverageCommentsPost());
        forumStatistics.showStatistics();
    }
    @Test
    @DisplayName("100 users 1000 posts 0 comments")
    void test100user1000post0comments()
    {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getAverageCommentsUser());
        assertEquals(10, forumStatistics.getAveragePostsUser());
        assertEquals(0, forumStatistics.getAverageCommentsPost());
        forumStatistics.showStatistics();
    }
    @Test
    @DisplayName("100 users 1000 posts 10 comments")
    void test100user1000post10comments()
    {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0.1, forumStatistics.getAverageCommentsUser());
        assertEquals(10, forumStatistics.getAveragePostsUser());
        assertEquals(0.01, forumStatistics.getAverageCommentsPost());
        forumStatistics.showStatistics();
    }
    @Test
    @DisplayName("100 users 1000 posts 10000 comments")
    void test100user1000post10000comments()
    {
        // Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.usersNames()).thenReturn(generateListOfUsers(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10000);

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(100, forumStatistics.getAverageCommentsUser());
        assertEquals(10, forumStatistics.getAveragePostsUser());
        assertEquals(10, forumStatistics.getAverageCommentsPost());
        forumStatistics.showStatistics();
    }

}