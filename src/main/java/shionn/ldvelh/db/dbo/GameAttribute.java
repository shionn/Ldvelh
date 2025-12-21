package shionn.ldvelh.db.dbo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameAttribute {
	private String id;
	private String value;

	public boolean is(GameAttributeModel model) {
		return model.getId().equals(id);
	}
}
