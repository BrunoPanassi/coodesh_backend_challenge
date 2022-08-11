package com.springbootapp.codeeshbackendchallenge.service;

import com.springbootapp.codeeshbackendchallenge.model.Launcher;
import com.springbootapp.codeeshbackendchallenge.repository.LauncherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional
public class LauncherServiceImpl implements LauncherService{

    @Autowired
    private LauncherRepo launcherRepo;

    @Override
    public Launcher saveLauncher(Launcher launcher) {
        return launcherRepo.save(launcher);
    }

    @Override
    public Page<Launcher> getPagedLaunchers(Pageable pageable) {
        return launcherRepo.getPagedLaunchers(pageable);
    }

    @Override
    public Optional<Launcher> getLauncerById(String id) {
        return Optional.ofNullable(launcherRepo.getLauncherById(id));
    }

    @Override
    public void deleteLauncher(String id) {
        launcherRepo.deleteLauncherById(id);
    }
}
