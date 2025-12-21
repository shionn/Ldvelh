package shionn.ldvelh.db.dbo;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum GameModel {

	DF("Défis Fantastique",
			GameAttributeModel.builder().id("hability").name("Habilité").type(AttributeType.stat).defolt("9/9").build(),
			GameAttributeModel
					.builder()
					.id("endurance")
					.name("Endurance")
					.type(AttributeType.stat)
					.defolt("17/17")
					.build(),
			GameAttributeModel.builder().id("luck").name("Chance").type(AttributeType.stat).defolt("9/9").build(),
			GameAttributeModel.builder().id("equipment").name("Equipement").type(AttributeType.text).build(),
			GameAttributeModel.builder().id("gold").name("Or").type(AttributeType.integer).defolt("0").build(),
			GameAttributeModel.builder().id("treasure").name("Bijoux").type(AttributeType.text).defolt("").build(),
			GameAttributeModel.builder().id("potion").name("Potions").type(AttributeType.text).defolt("").build(),
			GameAttributeModel.builder().id("provisons").name("Provisons").type(AttributeType.text).defolt("").build());

	final private String name;
	final private List<GameAttributeModel> attrs;

	private GameModel(String name, GameAttributeModel... attrs) {
		this.name = name;
		this.attrs = Arrays.asList(attrs);
	}

	public GameAttributeModel attribute(String modelId) {
		return attrs.stream().filter(a -> a.getId().equals(modelId)).findAny().get();
	}

}
