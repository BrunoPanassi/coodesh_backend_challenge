package com.springbootapp.codeeshbackendchallenge.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mission {

    @Id
    private Long id;

    private Long launchLibraryId;

    private String name;

    private String description;

    private String launchDesignator;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Orbit orbit;
}
