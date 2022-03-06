package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.SurgeryDoctorDao;
import ir.maktab.hospital.entity.SurgeryDoctor;

public class SurgeryDoctorService extends AbstractCrudService<SurgeryDoctor, Long> {

    public SurgeryDoctorService() {
        super(new SurgeryDoctorDao());
    }

}
