package com.booleanuk.core;

import com.booleanuk.core.alphabets.Alphabet_Greek;
import com.booleanuk.core.alphabets.Alphabet_RU;
import com.booleanuk.core.alphabets.Alphabet_UK;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

class ScrabbleTest {
    Alphabet alphabet_uk = new Alphabet_UK();
    Alphabet alphabet_greek = new Alphabet_Greek();
    Alphabet alphabet_ru = new Alphabet_RU();

    @BeforeAll
    public static void setUp() {
        Locale.setDefault(Locale.UK);
    }

    @Test
    public void shouldGive0ForEmptyWords() {
        Scrabble scrabble = new Scrabble(alphabet_uk);
        Assertions.assertEquals(0, scrabble.score(""));
    }

    @Test
    public void shouldGive0ForWhiteSpace() {
        Scrabble scrabble = new Scrabble(alphabet_uk);
        Assertions.assertEquals(0, scrabble.score("\n\r\t\b\f"));
    }

    @Test
    public void shouldScore1ForA() {
        Scrabble scrabble = new Scrabble(alphabet_uk);
        Assertions.assertEquals(1, scrabble.score("a"));
    }

    @Test
    public void shouldScore4ForF() {
        Scrabble scrabble = new Scrabble(alphabet_uk);
        Assertions.assertEquals(4, scrabble.score("f"));
    }

    @Test
    public void shouldScore6ForStreet() {
        Scrabble scrabble = new Scrabble(alphabet_uk);
        Assertions.assertEquals(6, scrabble.score("street"));
    }

    @Test
    public void shouldScore22ForQuirky() {
        Scrabble scrabble = new Scrabble(alphabet_uk);
        Assertions.assertEquals(22, scrabble.score("quirky"));
    }

    @Test
    public void shouldScoreRussianLetters() {
        Scrabble scrabble = new Scrabble(alphabet_ru);
        Assertions.assertEquals(18, scrabble.score("дврфъ"));
    }

    @Test
    public void shouldScoreGreekLetters() {
        Scrabble scrabble = new Scrabble(alphabet_greek);
        Assertions.assertEquals(20, scrabble.score("φεψωλ"));
    }
}
