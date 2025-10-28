package com.example.dictionary;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class DictionaryController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/define/{word}")
    public Map<String, Object> defineWord(@PathVariable String word) {
        String url = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
        try {
            Object data = restTemplate.getForObject(url, Object.class);
            Map<String, Object> response = new HashMap<>();
            response.put("data", data);
            return response;
        } catch (RestClientException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getMessage());
            return error;
        }
    }
}
