package pj.com.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 30)
    private String writer;

    private String content;

    private Date createdDate = new Date();

    private Date modifiedDate = new Date();

    @Column(nullable = false)
    private int views = 0;

    private String category;

    @Column(nullable = false)
    private int recommends = 0;
}
