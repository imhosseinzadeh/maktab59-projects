package ir.maktab.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {


    static City city;
    static Club club;
    static Stadium stadium;

    @BeforeAll
    private static void setUp() {
        club = new Club();
        city = new City();
        stadium = new Stadium();
    }

    @Test
    void test_add_club() {
        city.addClub(club);

        assertTrue(city.getClubs().contains(club));
        assertEquals(city, club.getCity());
    }

    @Test
    void test_remove_club() {
        city.addClub(club);
        city.removeClub(club);

        assertFalse(city.getClubs().contains(club));
    }

    @Test
    void test_add_stadium() {
        city.addStadium(stadium);

        assertTrue(city.getStadiums().contains(stadium));
        assertEquals(city, stadium.getCity());
    }

    @Test
    void test_remove_stadium() {
        city.addStadium(stadium);
        city.removeStadium(stadium);

        assertFalse(city.getStadiums().contains(stadium));
    }

}