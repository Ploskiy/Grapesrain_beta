package by.grapesrain.entitys;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.*;

/**
 * Created by Daynekoa on 27.05.2017.
 */

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "body")
    private String body;

    @Getter
    @Setter
    @Column(name = "req_create")
    private LocalDateTime create;

    @Getter
    @Setter
    @Column(name = "req_close")
    private LocalDateTime close;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creator;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "executor_user_id")
    private User executor;

    @Getter
    @Setter
    @Column(name = "status")
    private String status;

    @Getter
    @Setter
    @Column(name = "prioritet")
    private String prioritet;
}