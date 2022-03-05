package ir.maktab.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClubCoachId implements Serializable {

    private Long clubId;
    private Long coachId;
    private Long seasonId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubCoachId that = (ClubCoachId) o;
        return Objects.equals(clubId, that.clubId) && Objects.equals(coachId, that.coachId) && Objects.equals(seasonId, that.seasonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, coachId, seasonId);
    }

}
