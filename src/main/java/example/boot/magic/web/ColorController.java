package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Color;
import example.boot.magic.service.ColorRepository;

@Controller
@RequestMapping(value="colors")
public class ColorController {
	@Autowired
	ColorRepository repo;
	
	@RequestMapping("")
	public @ResponseBody List<Color> getAllColor() {
		List<Color> colors = new ArrayList<Color>();
		Iterable<Color> results = repo.findAll();
		for (Color color : results) {
			colors.add(color);
		}
		return colors;
	}

}
