package ir.maktab.entity.bank;

import ir.maktab.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BranchHead extends BaseEntity<Long> {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nationalId;

    private String firstname;

    private String lastname;

    @OneToOne(optional = false)
    @MapsId
    private Branch branch;

    @Override
    public String toString() {
        return "BranchHead{" +
                "id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", branch=" + branch +
                '}';
    }

}
