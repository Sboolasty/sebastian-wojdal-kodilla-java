package com.example.kodillahibernate.tasklist.dao;

import com.example.kodillahibernate.tasklist.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskListDao extends JpaRepository<TaskList, Long> {
    List<TaskList> findByListName(String listName);
}