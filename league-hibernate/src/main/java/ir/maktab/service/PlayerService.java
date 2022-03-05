package ir.maktab.service;

import ir.maktab.dao.PlayerDao;
import ir.maktab.entity.Player;

public class PlayerService extends AbstractCrudService<Player, Long> {

    public PlayerService() {
        super(new PlayerDao());
    }

    @Override
    public PlayerDao getBaseDao() {
        return (PlayerDao) super.getBaseDao();
    }
}
