package com.example.kodillaspring.portfolio;
import com.example.portfolio.Board;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {
    private Board board;

    @Test
    public void testTaskAdd() {
        // given
        String taskToDo = "Task to do";
        String taskInProgress = "Task in progress";
        String taskDone = "Task done";

        // when
        board.getToDoList().getTasks().add(taskToDo);
        board.getInProgressList().getTasks().add(taskInProgress);
        board.getDoneList().getTasks().add(taskDone);

        // then
        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals(taskToDo, board.getToDoList().getTasks().get(0));

        assertEquals(1, board.getInProgressList().getTasks().size());
        assertEquals(taskInProgress, board.getInProgressList().getTasks().get(0));

        assertEquals(1, board.getDoneList().getTasks().size());
        assertEquals(taskDone, board.getDoneList().getTasks().get(0));
    }
}