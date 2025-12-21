package shionn.ldvelh.db.dbo;

import java.util.function.BiFunction;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AttributeType {
	stat((value, mod) -> {
		String[] split = value.split("/");
		return Integer.toString(Integer.parseInt(split[0]) + mod) + "/" + split[1];
	}),
	text((value, mod) -> value),
	integer((value, mod) -> Integer.toString(Integer.parseInt(value) + mod));

	private final BiFunction<String, Integer, String> addIntValueFunc;

	public String addInt(String value, int mod) {
		return addIntValueFunc.apply(value, mod);
	}

}
