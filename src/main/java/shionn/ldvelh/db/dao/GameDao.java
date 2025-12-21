package shionn.ldvelh.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import shionn.ldvelh.db.dbo.Game;
import shionn.ldvelh.db.dbo.GameAttribute;

public interface GameDao {

	@Select("SELECT id, name, fullname FROM game WHERE close IS false ORDER BY name")
	List<Game> listActive();

	@Select("SELECT * FROM game WHERE id = #{id}")
	@Results({ @Result(column = "id", property = "id"),
			@Result(column = "id", property = "attributes", many = @Many(select = "readAttributes")) })
	Game read(int id);

	@Select("SELECT * FROM game_attribute WHERE game = #{id}")
	List<GameAttribute> readAttributes(int id);

	@Insert("""
			INSERT INTO game_attribute (game, id, value) VALUES (#{game.id}, #{attr.id}, #{attr.value})
			ON DUPLICATE KEY UPDATE value = #{attr.value}
			""")
	int save(@Param("game") Game game, @Param("attr") GameAttribute attribute);

}
