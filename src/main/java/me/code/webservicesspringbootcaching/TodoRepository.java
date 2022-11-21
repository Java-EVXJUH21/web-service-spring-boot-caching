package me.code.webservicesspringbootcaching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TodoRepository {

    private final Map<String, Todo> todos = new HashMap<>();

    @Cacheable("todos")
    public Optional<Todo> findById(String id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(todos.get(id));
    }

    @CacheEvict(value = "todos", key = "#todo.name")
    public void delete(Todo todo) {
        todos.remove(todo.getName());
    }

    @CacheEvict(value = "todos", key = "#todo.name")
    public void save(Todo todo) {
        todos.put(todo.getName(), todo);
    }

    public Collection<Todo> findAll() {
        return todos.values();
    }
}
