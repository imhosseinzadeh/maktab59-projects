package ir.maktab.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClubTest {

    static Club club;
    static City city;

    @BeforeAll
    static void setUp() {
        club = new Club();
        city = new City();
    }

    @Test
    void test_set_city() {
        club.setCity(city);

        assertEquals(city, club.getCity());
    }
}