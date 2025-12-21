package shionn.ldvelh;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import shionn.ldvelh.db.dao.GameDao;

@Controller
@RequiredArgsConstructor
public class GameController {

	final private SqlSession session;

	@RequestMapping(method = RequestMethod.GET, path = "/{id:\\d+}")
	public ModelAndView viewGame(@PathVariable("id") int id) {
		return new ModelAndView("game").addObject("game", session.getMapper(GameDao.class).read(id));
	}

}
