package ir.maktab.dao;

import ir.maktab.entity.ClubPlayer;
import ir.maktab.entity.ClubPlayerId;

public class ClubPlayerDao extends BaseDao<ClubPlayer, ClubPlayerId> {
    @Override
    protected Class<ClubPlayer> getEntityClass() {
        return ClubPlayer.class;
    }
}
