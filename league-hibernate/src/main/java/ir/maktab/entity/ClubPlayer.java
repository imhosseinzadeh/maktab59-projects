package ir.maktab.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ClubPlayer extends BaseEntity<ClubPlayerId> {

    @EmbeddedId
    private ClubPlayerId id = new ClubPlayerId();

    @ManyToOne
    @MapsId("clubId")
    private Club club;

    @ManyToOne
    @MapsId("playerId")
    private Player player;

    @ManyToOne
    @MapsId("seasonId")
    private Season season;

    private Double contractValue;

    private Double salary;

    public void setClub(Club club) {
        club.getClubPlayers().add(this);
        this.club = club;
    }

    public void setPlayer(Player player) {
        player.getClubPlayers().add(this);
        this.player = player;
    }

    public void setSeason(Season season) {
        season.getClubPlayers().add(this);
        this.season = season;
    }

    @Override
    public String toString() {
        return "ClubPlayer{" +
                "id=" + id +
                ", club=" + club +
                ", player=" + player +
                ", season=" + season +
                ", contractValue=" + contractValue +
                ", salary=" + salary +
                '}';
    }

}
