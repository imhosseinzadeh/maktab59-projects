package ir.maktab.service;

import ir.maktab.dao.SeasonDao;
import ir.maktab.entity.Season;

public class SeasonService extends AbstractCrudService<Season, Long> {

    public SeasonService() {
        super(new SeasonDao());
    }

    @Override
    public SeasonDao getBaseDao() {
        return (SeasonDao) super.getBaseDao();
    }
}
