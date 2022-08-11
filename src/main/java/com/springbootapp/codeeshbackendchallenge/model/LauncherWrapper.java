package com.springbootapp.codeeshbackendchallenge.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class LauncherWrapper {

    private Long count;

    private String next;

    private String previous;

    private List<Launcher> results;
}
