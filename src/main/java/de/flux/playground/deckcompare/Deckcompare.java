package de.flux.playground.deckcompare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.flux.playground.deckcompare.analyze.CardConflictAnalyzer;
import de.flux.playground.deckcompare.analyze.DeckConflictAnalyzer;

@SpringBootApplication
public class Deckcompare {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Deckcompare.class, args);
    }

    @Bean
    public DeckConflictAnalyzer deckConflictAnalyzer() {
        return new DeckConflictAnalyzer(cardConflictAnalyzer());
    }

    @Bean
    public CardConflictAnalyzer cardConflictAnalyzer() {
        return new CardConflictAnalyzer();
    }

}
