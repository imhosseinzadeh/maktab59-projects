package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.ReceptionDao;
import ir.maktab.hospital.entity.ReceptionEntity;

public class ReceptionService extends AbstractCrudService<ReceptionEntity> {

    public ReceptionService() {
        super(new ReceptionDao());
    }

}
