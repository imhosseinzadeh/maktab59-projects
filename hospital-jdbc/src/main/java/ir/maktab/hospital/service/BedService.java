package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.BedDao;
import ir.maktab.hospital.entity.BedEntity;

public class BedService extends AbstractCrudService<BedEntity> {

    public BedService() {
        super(new BedDao());
    }

}
