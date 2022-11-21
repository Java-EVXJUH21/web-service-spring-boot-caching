package me.code.webservicesspringbootcaching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private final TodoRepository repository;

    @Autowired
    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todo/{name}")
    public ResponseEntity<Todo> getTodo(
            @PathVariable String name
    ) {
        var todo = repository.findById(name);
        return todo
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/todo")
    public ResponseEntity<Todo> addTodo(
            @RequestBody Todo todo
    ) {
        repository.save(todo);
        return ResponseEntity.ok(todo);
    }

}
