package com.example.kodillahibernate.tasklist.dao;


import com.example.kodillahibernate.tasklist.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    @Transactional
    public void testFindByListName() {
        // Given
        TaskList taskList1 = new TaskList("List 1", "Description 1");
        TaskList taskList2 = new TaskList("List 2", "Description 2");
        taskListDao.save(taskList1);
        taskListDao.save(taskList2);

        // When
        List<TaskList> result = taskListDao.findByListName("List 1");

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(taskList1));

        // Cleanup
        taskListDao.deleteAll();

        // When
        result = taskListDao.findByListName("List 1");

        // Then
        assertTrue(result.isEmpty());
    }
}