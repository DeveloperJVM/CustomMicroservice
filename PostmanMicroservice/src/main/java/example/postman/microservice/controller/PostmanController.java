package example.postman.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class PostmanController {

    @Value("${post.microservice.host.address}")
    private String postMicroserviceHostAddress;

    @GetMapping("/getAvailableLettersFromPost")
    public ResponseEntity<String> getAvailableLettersFromPost(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(postMicroserviceHostAddress + "/availableLetters", String.class);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/deliveredLettersCount")
    public ResponseEntity<Integer> deliverLettersCount(){
        System.out.println("deliverLettersCount mapping works ....");
        return ResponseEntity.ok().body(new Random().nextInt(100));
    }
}
