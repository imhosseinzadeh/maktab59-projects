package ir.maktab.entity.bank;

import ir.maktab.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nationalId;

    private String firstname;

    private String lastname;

    @ManyToOne(optional = false)
    private Branch branch;

    public void setBranch(Branch branch) {
        this.branch = branch;
        branch.getEmployees().add(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", branch=" + branch +
                '}';
    }

}

