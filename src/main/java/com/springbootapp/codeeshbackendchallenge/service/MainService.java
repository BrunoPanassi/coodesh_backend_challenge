package com.springbootapp.codeeshbackendchallenge.service;

import com.springbootapp.codeeshbackendchallenge.model.LauncherWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class MainService {
    private final WebClient webclient;

    public MainService(WebClient.Builder webClientBuilder) {
        this.webclient = webClientBuilder.baseUrl("https://ll.thespacedevs.com/2.0.0").build();
    }

    public ResponseEntity<LauncherWrapper> restCall(String name) {
        return this.webclient.get()
                .uri("/{name}/", name)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(new ParameterizedTypeReference<LauncherWrapper>() {
                }).block();
    }

    public LauncherWrapper launcherRestCall(String uri) {
        ResponseEntity<LauncherWrapper> wrapper = this.restCall(uri);
        return wrapper.getBody();
    }
}
