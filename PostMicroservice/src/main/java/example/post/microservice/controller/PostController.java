package example.post.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PostController {

    @Value("${postman.microservice.host.address}")
    private String postmanMicroserviceHostAddress;

    @GetMapping("/availableLetters")
    public ResponseEntity<String> availableLetters(){
        System.out.println("availableLetters mapping works ....");
        return ResponseEntity.ok().body("[Letter1, Letter2, Letter3]");
    }

    @GetMapping("/getDeliveredLettersCountFromPostman")
    public ResponseEntity<Integer> getDeliveredLettersCountFromPostman(){
        RestTemplate restTemplate = new RestTemplate();
        Integer result = restTemplate.getForObject(postmanMicroserviceHostAddress + "/deliveredLettersCount", Integer.class);
        return ResponseEntity.ok().body(result);
    }
}
