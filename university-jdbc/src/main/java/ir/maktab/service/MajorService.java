package ir.maktab.service;

import ir.maktab.dao.MajorDao;
import ir.maktab.entity.Major;

public class MajorService extends AbstractCrudService<Major, Integer> {

    public MajorService() {
        setBaseDao(new MajorDao());
    }

    @Override
    public MajorDao getBaseDao() {
        return (MajorDao) super.getBaseDao();
    }


}
