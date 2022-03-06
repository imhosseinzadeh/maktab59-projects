package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.DoctorDao;
import ir.maktab.hospital.entity.DoctorEntity;

public class DoctorService extends AbstractCrudService<DoctorEntity, Long> {

    public DoctorService() {
        super(new DoctorDao());
    }

}
