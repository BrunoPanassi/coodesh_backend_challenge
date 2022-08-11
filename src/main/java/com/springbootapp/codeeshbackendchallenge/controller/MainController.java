package com.springbootapp.codeeshbackendchallenge.controller;

import com.springbootapp.codeeshbackendchallenge.enums.StatusImported;
import com.springbootapp.codeeshbackendchallenge.model.Launcher;
import com.springbootapp.codeeshbackendchallenge.service.LauncherService;
import com.springbootapp.codeeshbackendchallenge.service.MainService;
import com.springbootapp.codeeshbackendchallenge.model.LauncherWrapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class MainController {

    private final MainService mainService;
    private final LauncherService launcherService;

    @Autowired
    public MainController(MainService mainService, LauncherService launcherService) {
        this.mainService = mainService;
        this.launcherService = launcherService;
    }

    @GetMapping()
    public String helloWorld() {
        return "REST Back-end Challenge 20201209 Running";
    }

    @Scheduled(cron = "0 56 19 * * ?")
    public void getHelloWorld() throws Exception {
        String uri = "launch";
        LauncherWrapper launcherBody = mainService.launcherRestCall(uri);
        List<Launcher> results = launcherBody.getResults();

        for(Launcher result : results) {
            Optional<Launcher> launcher = launcherService.getLauncerById(String.valueOf(result.getId()));

            if (!launcher.isPresent()) {
                result.setImported_t(new Date());
                result.setStatus_imported(StatusImported.PUBLISHED);
                launcherService.saveLauncher(result);
            }
        }
    }

    @GetMapping("launchers")
    public Page<Launcher> getPagedLaunchers(Pageable pageable) {
        return launcherService.getPagedLaunchers(pageable);
    }

    @GetMapping("launchers/{launcherId}")
    public ResponseEntity<Launcher> getLauncherById(@PathVariable("launcherId") String launchId) throws Exception {
        try {
            Optional<Launcher> launcher = launcherService.getLauncerById(launchId);
            if (launcher.isPresent()) {
                return ResponseEntity.ok(launcher.get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @PutMapping("launchers/{launcherId}")
    public ResponseEntity<Launcher> updateLauncherById(@PathVariable("launcherId") String launchId,
                                                       @RequestBody Launcher launcher) {
        Optional<Launcher> findedLauncher = launcherService.getLauncerById(launchId);
        if (findedLauncher.isPresent()) {
            return new ResponseEntity<>(launcherService.saveLauncher(launcher), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("launchers/{launcherId}")
    public ResponseEntity<String> deleteLauncherById(@PathVariable("launcherId") String launchId) {
        Optional<Launcher> findedLauncher = launcherService.getLauncerById(launchId);
        if (findedLauncher.isPresent()) {
            launcherService.deleteLauncher(findedLauncher.get().getId());
            return new ResponseEntity<>("Launcher deleted: " + findedLauncher.get().getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Launcher not founded by id.", HttpStatus.NOT_FOUND);
    }
}
