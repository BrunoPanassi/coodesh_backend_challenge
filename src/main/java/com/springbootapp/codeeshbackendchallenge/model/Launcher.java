package com.springbootapp.codeeshbackendchallenge.model;

import com.springbootapp.codeeshbackendchallenge.enums.StatusImported;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Launcher {

    @Id
    private String id;

    private String url;

    private Long launchLibrayId;

    private String slug;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Status status;

    private String net;

    private String windowEnd;

    private String windowStart;

    private Boolean inhold;

    private Boolean tbdTime;

    private Boolean tbdDate;

    private Long probability;

    private String holdReason;

    private String failReason;

    private String hashtag;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private LaunchServiceProvider launchServiceProvider;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Rocket rocket;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Mission mission;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Pad pad;

    private Boolean webcastLive;

    private String image;

    private String infographic;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Program> program;

    private Date imported_t;

    private StatusImported status_imported;
}
