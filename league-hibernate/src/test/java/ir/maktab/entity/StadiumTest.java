package ir.maktab.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StadiumTest {

    static City city;
    static Stadium stadium;
    static Game game;

    @BeforeAll
    private static void setUp() {
        stadium = new Stadium();
        city = new City();
        game = new Game();
    }

    @Test
    void test_set_city() {
        stadium.setCity(city);

        assertEquals(city, stadium.getCity());
        assertTrue(city.getStadiums().contains(stadium));
    }

    @Test
    void test_add_game() {
        stadium.addGame(game);

        assertTrue(stadium.getGames().contains(game));
        assertEquals(stadium, game.getStadium());
    }

    @Test
    void test_remove_game() {
        stadium.addGame(game);
        stadium.removeGame(game);

        assertFalse(stadium.getGames().contains(game));
    }
}