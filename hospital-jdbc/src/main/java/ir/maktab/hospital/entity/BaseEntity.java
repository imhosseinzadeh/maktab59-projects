package ir.maktab.hospital.entity;

import java.io.Serializable;

public interface BaseEntity<I extends Serializable> extends Serializable {

    I getId();

    void setId(I id);

}
