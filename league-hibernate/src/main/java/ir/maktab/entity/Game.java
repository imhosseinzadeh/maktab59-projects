package ir.maktab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Game extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Club hostClub;

    @ManyToOne
    private Club guestClub;

    private Integer hostGoals;

    private Integer guestGoals;

    private Integer hostPoint;

    private Integer guestPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    private Stadium stadium;

    @ManyToOne(fetch = FetchType.LAZY)
    private Season season;

    public void setHostClub(Club hostClub) {
        hostClub.getHostGames().add(this);
        this.hostClub = hostClub;
    }

    public void setGuestClub(Club guestClub) {
        guestClub.getGuestGames().add(this);
        this.guestClub = guestClub;
    }

    public void setStadium(Stadium stadium) {
        stadium.getGames().add(this);
        this.stadium = stadium;
    }

    public void setSeason(Season season) {
        season.getGames().add(this);
        this.season = season;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", hostClub=" + hostClub +
                ", guestClub=" + guestClub +
                ", hostGoals=" + hostGoals +
                ", guestGoals=" + guestGoals +
                ", hostPoint=" + hostPoint +
                ", guestPoint=" + guestPoint +
                ", season=" + season +
                '}';
    }

}
