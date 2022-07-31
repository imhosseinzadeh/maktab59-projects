package ir.maktab.entity;

import lombok.AccessLevel;
import lombok.Getter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseEntity<I extends Serializable> implements Serializable {

    @Version
    @Getter(AccessLevel.NONE)
    private Long version;

    @Column(updatable = false)
    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public abstract I getId();

    public abstract void setId(I id);

    public boolean isNew() {
        return getId() == null;
    }

    @PrePersist
    private void onPersist() {
        createDate = updateDate = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        updateDate = LocalDateTime.now();
    }

}
