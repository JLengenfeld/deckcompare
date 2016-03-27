package de.flux.playground.deckcompare;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Deckcompare {

    public static String ROOT = "upload-dir";

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @Bean
    public CommandLineRunner init() {
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Deckcompare.class, args);
    }

}
