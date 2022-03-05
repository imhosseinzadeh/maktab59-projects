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
public class Season extends BaseEntity<Long> {

    @Id
    private Long id;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Game> games = new HashSet<>();

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClubCoach> clubCoaches = new HashSet<>();

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClubPlayer> clubPlayers = new HashSet<>();

    public Season(Long id) {
        this.id = id;
    }

    public void setGames(Set<Game> games) {
        games.forEach(this::addGame);
        this.games = games;
    }

    public void addGame(Game game) {
        game.setSeason(this);
    }

    public void removeGame(Game game) {
        this.games.remove(game);
    }

    public void setClubCoaches(Set<ClubCoach> clubCoaches) {
        clubCoaches.forEach(this::addClubCoach);
        this.clubCoaches = clubCoaches;
    }

    public void setClubPlayers(Set<ClubPlayer> clubPlayers) {
        clubPlayers.forEach(this::addClubPlayer);
        this.clubPlayers = clubPlayers;
    }

    public void addClubCoach(ClubCoach clubCoach) {
        clubCoach.setSeason(this);
    }

    public void removeClubCoach(ClubCoach clubCoach) {
        this.clubCoaches.remove(clubCoach);
    }

    public void addClubPlayer(ClubPlayer clubPlayer) {
        clubPlayer.setSeason(this);
    }

    public void removeClubPlayer(ClubPlayer clubPlayer) {
        this.clubPlayers.remove(clubPlayer);
    }

    @Override
    public String toString() {
        return "Season{" +
                "year=" + id +
                '}';
    }

}
