package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.ReceptionDao;
import ir.maktab.hospital.entity.ReceptionEntity;

public class ReceptionService extends AbstractCrudService<ReceptionEntity, Long> {

    public ReceptionService() {
        super(new ReceptionDao());
    }

}
