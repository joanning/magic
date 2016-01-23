package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.Type;
import example.boot.magic.service.TypeRepository;

@Controller
@RequestMapping(value="types")
public class TypeController {
	@Autowired
	TypeRepository repo;
	
	@RequestMapping("")
	public @ResponseBody List<Type> getAllType() {
		List<Type> types = new ArrayList<Type>();
		Iterable<Type> results = repo.findAll();
		for (Type type : results) {
			types.add(type);
		}
		return types;
	}

}
