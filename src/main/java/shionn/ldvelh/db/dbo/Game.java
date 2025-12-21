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

	public String value(GameAttributeModel model) {
		return attribute(model).getValue();
	}

	public GameAttribute attribute(GameAttributeModel model) {
		return attributes
				.stream()
				.filter(a -> a.is(model))
				.findAny()
				.orElseGet(() -> GameAttribute.builder().id(model.getId()).value(model.getDefolt()).build());
	}
}
