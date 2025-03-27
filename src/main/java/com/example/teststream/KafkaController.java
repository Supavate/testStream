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

    @GetMapping("/send2")
    public String sendMessage2 (@RequestParam("w") String w, @RequestParam("h") String h) {
        String message = "your BMI: " + bmiCal(Double.parseDouble(w), Double.parseDouble(h));
        producer.sendMessage("input-topic", message);
        return "Message send: " + message;
    }

    public double bmiCal(double w, double h) {
        if (h == 0) throw new ArithmeticException("divide by zero");
        return w / Math.pow(h, 2);
    }
}
