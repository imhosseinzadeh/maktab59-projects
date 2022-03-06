package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.PatientDao;
import ir.maktab.hospital.entity.PatientEntity;

public class PatientService extends AbstractCrudService<PatientEntity, Long> {

    public PatientService() {
        super(new PatientDao());
    }
}
