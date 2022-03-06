package ir.maktab.entity;

import java.io.Serializable;

public abstract class BaseEntity<I extends Serializable> implements Serializable {

    private I id;

    public BaseEntity() {
    }

    public BaseEntity(I id) {
        this.id = id;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }


}
