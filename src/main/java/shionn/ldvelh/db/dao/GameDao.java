package shionn.ldvelh.db.dao;

import java.util.List;

import shionn.ldvelh.db.dbo.Game;

public interface GameDao {

	List<Game> listActive();

}
