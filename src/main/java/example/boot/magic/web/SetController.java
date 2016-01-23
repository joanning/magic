package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Set;
import example.boot.magic.service.SetRepository;

@Controller
@RequestMapping(value="set")
public class SetController {
	@Autowired
	SetRepository repo;
	
	@RequestMapping("")
	public @ResponseBody List<Set> getAllSet() {
		List<Set> sets = new ArrayList<Set>();
		Iterable<Set> results = repo.findAll();
		for (Set set : results) {
			sets.add(set);
		}
		return sets;
	}

}
