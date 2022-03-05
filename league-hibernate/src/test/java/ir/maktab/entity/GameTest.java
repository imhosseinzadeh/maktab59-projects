package ir.maktab.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    static Game game;
    static Club hostClub;
    static Club guestClub;
    static City city;
    static Stadium stadium;
    static Season season;

    @BeforeAll
    private static void setUp() {
        game = new Game();
        hostClub = new Club();
        guestClub = new Club();
        city = new City();
        stadium = new Stadium();
        season = new Season();
    }

    @Test
    void test_set_host_club() {
        game.setHostClub(hostClub);

        assertEquals(hostClub, game.getHostClub());
        assertTrue(hostClub.getHostGames().contains(game));
    }

    @Test
    void test_set_guest_club() {
        game.setGuestClub(guestClub);

        assertEquals(guestClub, game.getGuestClub());
        assertTrue(guestClub.getGuestGames().contains(game));
    }

    @Test
    void test_set_stadium() {
        game.setStadium(stadium);

        assertEquals(stadium, game.getStadium());
        assertTrue(stadium.getGames().contains(game));
    }

    @Test
    void test_set_season() {
        game.setSeason(season);

        assertEquals(season, game.getSeason());
        assertTrue(season.getGames().contains(game));
    }
}