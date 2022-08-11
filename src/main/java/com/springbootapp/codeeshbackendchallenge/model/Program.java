package com.springbootapp.codeeshbackendchallenge.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Program {

    @Id
    private Long id;

    private String url;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<AgencySerializerMini> agencies;

    private String imageUrl;

    private String startDate;

    private String endDate;

    private String infoUrl;

    private String wikiUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<MissionPatch> missionPatches;
}
