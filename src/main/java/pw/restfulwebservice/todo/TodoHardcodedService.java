package pw.restfulwebservice.todo;


import pw.restfulwebservice.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private List<Todo> todos = new ArrayList();
    private static int idCounter = 0;


    {
        todos.add(new Todo(++idCounter, "Pete", "Ask Ryan", new Date(), true));
        todos.add(new Todo(++idCounter, "Pete", "Tell a joke to Ismail", new Date(), false));
        todos.add(new Todo(++idCounter, "Pete", "Sing the national anthem", new Date(), false));
        todos.add(new Todo(++idCounter, "Pete", "Fart twice", new Date(), false));
    }

    public List<Todo> findAll(){
        System.out.println("Size of store on init is: " + this.todos.size());
        return todos;
    }

    public Todo save(Todo newNote) {
        newNote.setId(todos.size()+1);
        System.out.println("New id is: " + newNote.getId());
        this.todos.add(newNote);
        return newNote;
    }
}
