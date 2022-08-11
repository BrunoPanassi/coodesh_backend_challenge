package com.springbootapp.codeeshbackendchallenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PadLocation {

    @Id
    private Long id;

    private String url;

    private String name;

    private String countryCode;

    private String mapImage;

    private Long totalLaunchCount;

    private Long totalLandingCount;
}
