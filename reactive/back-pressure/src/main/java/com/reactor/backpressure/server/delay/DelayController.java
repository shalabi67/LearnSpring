package com.reactor.backpressure.server.delay;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(DelayController.URL)
public class DelayController {
    public static final String URL = "/delay";
    public static  int DELAY = 200;  //delay in milliseconds

    @GetMapping("")
    public int retrieveDelay() {
        return getDelay();
    }

    @PostMapping
    public ResponseEntity<String> setDelay(@RequestBody Integer delay) {
        if(delay != null) {
            DELAY = delay;
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public static int getDelay() {
        return DELAY;
    }
}
