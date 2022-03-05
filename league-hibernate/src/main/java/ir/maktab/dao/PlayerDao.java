package ir.maktab.dao;

import ir.maktab.entity.Player;

public class PlayerDao extends BaseDao<Player, Long> {

    @Override
    protected Class<Player> getEntityClass() {
        return Player.class;
    }
}
