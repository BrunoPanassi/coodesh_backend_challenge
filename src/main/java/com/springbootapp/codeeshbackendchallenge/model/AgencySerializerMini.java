package com.springbootapp.codeeshbackendchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AgencySerializerMini {

    @Id
    private Long id;

    private String url;

    private String name;

    private String type;
}
