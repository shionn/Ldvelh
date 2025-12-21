package shionn.ldvelh.db.dbo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

	private int id;
	private String name;
	private String fullname;
	private GameModel model;
	private boolean close;
	private List<GameAttribute> attributes;
}
