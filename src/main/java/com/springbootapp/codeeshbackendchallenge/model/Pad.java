package com.springbootapp.codeeshbackendchallenge.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pad {

    @Id
    private Long id;

    private String url;

    private Long agencyId;

    private String name;

    private Boolean infoUrl;

    private String wikiUrl;

    private String mapUrl;

    private String latitude;

    private String longitude;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PadLocation location;

    private String mapImage;

    private Long totalLaunchCount;
}
