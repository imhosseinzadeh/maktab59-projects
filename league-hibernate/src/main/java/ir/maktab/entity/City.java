package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class City extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Club> clubs = new HashSet<>();

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Stadium> stadiums = new HashSet<>();

    public City(String name) {
        this.name = name;
    }

    public void setClubs(Set<Club> clubs) {
        clubs.forEach(this::addClub);
        this.clubs = clubs;
    }

    public void setStadiums(Set<Stadium> stadiums) {
        stadiums.forEach(this::addStadium);
        this.stadiums = stadiums;
    }

    public void addClub(Club club) {
        club.setCity(this);
    }

    public void removeClub(Club club) {
        clubs.remove(club);
    }

    public void addStadium(Stadium stadium) {
        stadium.setCity(this);
    }

    public void removeStadium(Stadium stadium) {
        stadiums.remove(stadium);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
