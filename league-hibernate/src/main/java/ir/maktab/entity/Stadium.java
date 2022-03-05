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
public class Stadium extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int capacity;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "stadium", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Game> games = new HashSet<>();

    public Stadium(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void setCity(City city) {
        city.getStadiums().add(this);
        this.city = city;
    }


    public void setGames(Set<Game> games) {
        games.forEach(this::addGame);
        this.games = games;
    }

    public void addGame(Game game) {
        game.setStadium(this);
    }

    public void removeGame(Game game) {
        this.games.remove(game);
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", city=" + city.getName() +
                '}';
    }

}
