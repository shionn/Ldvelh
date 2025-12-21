package shionn.ldvelh;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import shionn.ldvelh.db.dao.GameDao;
import shionn.ldvelh.db.dbo.Game;
import shionn.ldvelh.db.dbo.GameAttribute;
import shionn.ldvelh.db.dbo.GameAttributeModel;

@Controller
@RequiredArgsConstructor
public class GameController {

	final private SqlSession session;

	@RequestMapping(method = RequestMethod.GET, path = "/{id:\\d+}")
	public ModelAndView viewGame(@PathVariable("id") int id) {
		return new ModelAndView("game").addObject("game", session.getMapper(GameDao.class).read(id));
	}

	@RequestMapping(method = RequestMethod.POST, path = "/{id:\\d+}")
	public String saveGame(@PathVariable("id") int gameId, @RequestParam Map<String, String> form) {
		GameDao dao = session.getMapper(GameDao.class);
		Game game = dao.read(gameId);
		form.entrySet().stream().forEach((e) -> {
			GameAttributeModel model = game.getModel().attribute(e.getKey());
			GameAttribute attribute = game.attribute(model);
			attribute.setValue(e.getValue());
			dao.save(game, attribute);
		});
		session.commit();
		return "redirect:/" + gameId;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/{id:\\d+}/{modelId}/add")
	public String add(@PathVariable("id") int gameId, @PathVariable("modelId") String modelId) {
		return alter(gameId, modelId, 1);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/{id:\\d+}/{modelId}/sub")
	public String sub(@PathVariable("id") int gameId, @PathVariable("modelId") String modelId) {
		return alter(gameId, modelId, -1);
	}

	private String alter(int gameId, String modelId, int mod) {
		GameDao dao = session.getMapper(GameDao.class);
		Game game = dao.read(gameId);
		GameAttributeModel model = game.getModel().attribute(modelId);
		GameAttribute attribute = game.attribute(model);
		attribute.setValue(model.addInt(attribute.getValue(), mod));
		dao.save(game, attribute);
		session.commit();
		return "redirect:/" + gameId;
	}

}
