package shionn.ldvelh.db.dbo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GameAttributeModel {

	private final String id;
	private final String name;
	private final AttributeType type;
	private final String defolt;

	public String addInt(String value, int mod) {
		return type.addInt(value, mod);
	}

}
