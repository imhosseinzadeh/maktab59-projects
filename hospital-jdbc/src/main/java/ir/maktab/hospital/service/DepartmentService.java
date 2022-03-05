package ir.maktab.hospital.service;

import ir.maktab.hospital.dao.DepartmentDao;
import ir.maktab.hospital.entity.DepartmentEntity;

public class DepartmentService extends AbstractCrudService<DepartmentEntity> {

    public DepartmentService() {
        super(new DepartmentDao());
    }

}
