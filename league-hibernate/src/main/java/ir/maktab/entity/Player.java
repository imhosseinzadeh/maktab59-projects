package ir.maktab.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Player extends Person {

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClubPlayer> clubPlayers = new HashSet<>();

    public void setClubPlayers(Set<ClubPlayer> clubPlayers) {
        clubPlayers.forEach(this::addClubPlayer);
        this.clubPlayers = clubPlayers;
    }

    public void addClubPlayer(ClubPlayer clubPlayer) {
        clubPlayer.setPlayer(this);
    }

    public void removeClubPlayer(ClubPlayer clubPlayer) {
        this.clubPlayers.remove(clubPlayer);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}';
    }

}
