package de.flux.playground.deckcompare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.flux.playground.deckcompare.analyze.CardConflictAnalyzer;
import de.flux.playground.deckcompare.analyze.DeckConflictAnalyzer;

@SpringBootApplication
@Configuration
public class Deckcompare {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Deckcompare.class, args);
    }

    @Bean
    public DeckConflictAnalyzer deckConflictAnalyzer() {
        return new DeckConflictAnalyzer();
    }

    @Bean
    public CardConflictAnalyzer cardConflictAnalyzer() {
        return new CardConflictAnalyzer();
    }

}
