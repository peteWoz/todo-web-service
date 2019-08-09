package pw.restfulwebservice.todo;

import pw.restfulwebservice.model.Todo;
import pw.restfulwebservice.persistance.TodoRepository;
import pw.restfulwebservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private TodoRepository service;

    @Autowired
    private TodoService storeService = new TodoService(service);
    //private TodoHardcodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return storeService.readTable(username);
    }

    // returns 1 on success and 0 on failure
    @PostMapping("/users/{username}/add")
    public ResponseEntity<Long> newTodo(@RequestBody Todo newNote, @PathVariable String username) {
        storeService.addEntry(newNote);
        System.out.println("Got this:" + newNote);

        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newNote.getId()).toUri();
        //return ResponseEntity.created(uri).build();
        //return ResponseEntity.ok(newNote.getId());
        //return new ResponseEntity<>(newNote.getId(), HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK)
                .body(newNote.getId());
    }
    // returns 1 on success and 0 on failure
    @PutMapping("/users/{username}")
    public ResponseEntity<Integer> updateNote(@RequestBody Todo newNote, @PathVariable String username){
        System.out.println("Received and update request for note id: " + newNote.getId());
        return ResponseEntity.status(HttpStatus.OK).body(storeService.updateEntry(newNote));
    }

    // returns 1 on success and 0 on failure
    @DeleteMapping("/users/{username}/todos/{index}")
    public ResponseEntity<Integer> deleteNote(@PathVariable String username, @PathVariable long index){
        System.out.println("Trying to delete index: " + index);
        return ResponseEntity.status(HttpStatus.OK).body(storeService.deleteEntry(index));
    }

}
