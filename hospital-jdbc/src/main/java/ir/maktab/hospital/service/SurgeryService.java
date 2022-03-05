package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.SurgeryDao;
import ir.maktab.hospital.entity.SurgeryEntity;

public class SurgeryService extends AbstractCrudService<SurgeryEntity> {

    public SurgeryService() {
        super(new SurgeryDao());
    }

}
