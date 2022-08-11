package com.springbootapp.codeeshbackendchallenge.service;

import com.springbootapp.codeeshbackendchallenge.model.Launcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LauncherService {
    Launcher saveLauncher(Launcher launcher);
    Page<Launcher> getPagedLaunchers(Pageable pageable);

    Optional<Launcher> getLauncerById(String id);

    void deleteLauncher(String id);
}
