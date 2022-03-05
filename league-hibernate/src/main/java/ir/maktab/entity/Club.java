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
public class Club extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClubCoach> clubCoaches = new HashSet<>();

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClubPlayer> clubPlayers = new HashSet<>();

    @OneToMany(mappedBy = "hostClub", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Game> hostGames = new HashSet<>();

    @OneToMany(mappedBy = "guestClub", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Game> guestGames = new HashSet<>();

    public Club(String clubName) {
        this.name = clubName;
    }

    public void setCity(City city) {
        city.getClubs().add(this);
        this.city = city;
    }

    public void setClubCoaches(Set<ClubCoach> clubCoaches) {
        clubCoaches.forEach(this::addClubCoach);
        this.clubCoaches = clubCoaches;
    }

    public void setClubPlayers(Set<ClubPlayer> clubPlayers) {
        clubPlayers.forEach(this::addClubPlayer);
        this.clubPlayers = clubPlayers;
    }

    public void setHostGames(Set<Game> hostGames) {
        hostGames.forEach(this::addHostGame);
        this.hostGames = hostGames;
    }

    public void setGuestGames(Set<Game> guestGames) {
        guestGames.forEach(this::addGuestGame);
        this.guestGames = guestGames;
    }

    public void addClubCoach(ClubCoach clubCoach) {
        clubCoach.setClub(this);
    }

    public void removeClubCoach(ClubCoach clubCoach) {
        this.clubCoaches.remove(clubCoach);
    }

    public void addClubPlayer(ClubPlayer clubPlayer) {
        clubPlayer.setClub(this);
    }

    public void removeClubPlayer(ClubPlayer clubPlayer) {
        this.clubPlayers.remove(clubPlayer);
    }

    public void addHostGame(Game hostGame) {
        hostGame.setHostClub(this);
    }

    public void removeHostGame(Game hostGame) {
        this.hostGames.remove(hostGame);
    }

    public void addGuestGame(Game guestGame) {
        guestGame.setGuestClub(this);
    }

    public void removeGuestGame(Game guestGame) {
        this.guestGames.remove(guestGame);
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city.getName() +
                '}';
    }

}
