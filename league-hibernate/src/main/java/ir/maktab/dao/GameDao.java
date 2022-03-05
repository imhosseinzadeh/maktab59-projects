package ir.maktab.dao;

import ir.maktab.entity.Game;

public class GameDao extends BaseDao<Game, Long> {

    @Override
    protected Class<Game> getEntityClass() {
        return Game.class;
    }
}
