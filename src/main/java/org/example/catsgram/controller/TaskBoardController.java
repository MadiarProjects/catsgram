package org.example.catsgram.controller;

import org.apache.catalina.Group;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
public class TaskBoardController {
//    @GetMapping
//    public Board getBoard() {
//        // Обработка GET-запроса по пути "/api/v1/board"
//    }
    @RequestMapping(path = "/tasks", method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        // Обработка GET-запроса по пути "/api/v1/board/tasks"
        return List.of();
    }
    @GetMapping("/groups")
    public List<Group> getGroups() {
        // Обработка GET-запроса по пути "/api/v1/board/groups"
        return List.of();
    }
}

