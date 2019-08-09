package pw.restfulwebservice.persistance;

import java.util.List;

import pw.restfulwebservice.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{

    List<Todo> findAllByUsername(String username);


}
