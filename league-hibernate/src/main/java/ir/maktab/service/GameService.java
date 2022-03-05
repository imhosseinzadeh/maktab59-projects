package ir.maktab.service;

import ir.maktab.dao.GameDao;
import ir.maktab.entity.Game;

public class GameService extends AbstractCrudService<Game, Long> {

    public GameService() {
        super(new GameDao());
    }

    @Override
    public GameDao getBaseDao() {
        return (GameDao) super.getBaseDao();
    }
}
