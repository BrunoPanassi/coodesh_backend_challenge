package com.springbootapp.codeeshbackendchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LaunchServiceProvider {

    @Id
    private Long id;

    private String url;

    private String name;

    private String type;
}
