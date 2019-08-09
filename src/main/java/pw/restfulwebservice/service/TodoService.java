package pw.restfulwebservice.service;

import pw.restfulwebservice.model.Todo;
import pw.restfulwebservice.persistance.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Service for managing todo notes
 */
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> readTable(String username) {
        return todoRepository.findAllByUsername(username);
    }

    public void addEntry(Todo newNote) {
        todoRepository.save(newNote);
    }

    public int updateEntry(Todo newNote) {
        todoRepository.save(newNote);
        return 1;
    }

    public int deleteEntry(Long index) {
        todoRepository.deleteById(index);
        return 1;
    }
}
