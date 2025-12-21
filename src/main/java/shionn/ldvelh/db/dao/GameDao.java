package shionn.ldvelh.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import shionn.ldvelh.db.dbo.Game;

public interface GameDao {

	@Select("SELECT id, name, fullname FROM game WHERE close IS false ORDER BY name")
	List<Game> listActive();

	@Select("SELECT * FROM game")
	Game read(int id);

}
