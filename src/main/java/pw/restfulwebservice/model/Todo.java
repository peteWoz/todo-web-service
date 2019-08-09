package pw.restfulwebservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
// If you want to define a different table than Todoo then use -> @Table(name = "student")
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String username, description;
    private Date targetDate;
    private boolean isDone;
    private String time;


    protected Todo(){}

    public Todo(long id, String username, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }
    public Todo(long id, String username, String description, Date targetDate, String isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = Boolean.parseBoolean(isDone);
    }

}
