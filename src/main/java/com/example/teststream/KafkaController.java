package com.example.teststream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringTokenizer;

@RestController
public class KafkaController {
    @Autowired
    private MessageProducer producer;

    @GetMapping("/send")
    public String sendMessage (@RequestParam("message") String msg) {
        StringTokenizer stringTokenizer = new StringTokenizer(msg, "_");
        while(stringTokenizer.hasMoreElements()) {
            producer.sendMessage("my-topic", stringTokenizer.nextToken());
        }
        return "Message send: " + msg;
    }

}
