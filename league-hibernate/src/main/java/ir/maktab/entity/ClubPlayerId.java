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
public class ClubPlayerId implements Serializable {

    private Long clubId;
    private Long playerId;
    private Long seasonId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubPlayerId that = (ClubPlayerId) o;
        return Objects.equals(clubId, that.clubId) && Objects.equals(playerId, that.playerId) && Objects.equals(seasonId, that.seasonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, playerId, seasonId);
    }

}
