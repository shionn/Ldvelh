package shionn.ldvelh.db.dbo;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum GameModel {

	DF("Défis Fantastique", GameAttributeModel.builder().name("Habilité").build(),
			GameAttributeModel.builder().name("Endurance").build(), GameAttributeModel.builder().name("Chance").build(),
			GameAttributeModel.builder().name("Equipement").build(),
			GameAttributeModel.builder().name("Or").build(),
			GameAttributeModel.builder().name("Bijoux").build(), GameAttributeModel.builder().name("Potions").build(),
			GameAttributeModel.builder().name("Provisons").build());

	final private String name;
	final private List<GameAttributeModel> attrs;

	private GameModel(String name, GameAttributeModel... attrs) {
		this.name = name;
		this.attrs = Arrays.asList(attrs);
	}


}
