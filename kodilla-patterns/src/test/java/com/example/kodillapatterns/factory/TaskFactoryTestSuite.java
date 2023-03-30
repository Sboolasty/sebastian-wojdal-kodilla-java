package com.example.kodillapatterns.factory;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    private final TaskFactory factory = new TaskFactory();

    @Test
    void testShoppingTask() {
        // given
        String taskType = TaskFactory.SHOPPING;

        // when
        Task task = factory.makeTask(taskType);

        // then
        assertEquals("Grocery shopping", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        // given
        String taskType = TaskFactory.PAINTING;

        // when
        Task task = factory.makeTask(taskType);

        // then
        assertEquals("Painting the room", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        // given
        String taskType = TaskFactory.DRIVING;

        // when
        Task task = factory.makeTask(taskType);

        // then
        assertEquals("Driving to the airport", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testUnsupportedTaskType() {
        // given
        String taskType = "Unsupported";

        // then
        assertThrows(IllegalArgumentException.class, () -> factory.makeTask(taskType));
    }
}