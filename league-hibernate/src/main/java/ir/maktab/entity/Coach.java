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
public class Coach extends Person {

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ClubCoach> clubCoaches = new HashSet<>();

    public void setClubCoaches(Set<ClubCoach> clubCoaches) {
        clubCoaches.forEach(this::addClubCoach);
        this.clubCoaches = clubCoaches;
    }

    public void addClubCoach(ClubCoach clubCoach) {
        clubCoach.setCoach(this);
    }

    public void removeClubCoach(ClubCoach clubCoach) {
        this.clubCoaches.remove(clubCoach);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", seasons=" +
                '}';
    }

}
