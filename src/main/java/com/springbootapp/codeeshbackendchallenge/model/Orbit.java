package com.springbootapp.codeeshbackendchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orbit {

    @Id
    private Long id;

    private String name;

    private String abbrev;
}
