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
public class ClubCoach extends BaseEntity<ClubCoachId> {

    @EmbeddedId
    private ClubCoachId id = new ClubCoachId();

    @ManyToOne
    @MapsId("clubId")
    private Club club;

    @ManyToOne
    @MapsId("coachId")
    private Coach coach;

    @ManyToOne
    @MapsId("seasonId")
    private Season season;

    private Double contractValue;

    private Double salary;

    public void setClub(Club club) {
        club.getClubCoaches().add(this);
        this.club = club;
    }

    public void setCoach(Coach coach) {
        coach.getClubCoaches().add(this);
        this.coach = coach;
    }

    public void setSeason(Season season) {
        season.getClubCoaches().add(this);
        this.season = season;
    }

    @Override
    public String toString() {
        return "SeasonCoach{" +
                "season=" + season +
                ", coach=" + coach +
                ", club=" + club +
                '}';
    }

}
