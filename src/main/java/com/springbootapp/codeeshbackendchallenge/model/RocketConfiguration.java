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
public class RocketConfiguration {

    @Id
    private Long id;

    private Long launchLibraryId;

    private String url;

    private String name;

    private String family;

    private String fullName;

    private String variant;
}
