package example.boot.magic.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.boot.magic.entity.SubType;
import example.boot.magic.service.SubTypeRepository;

@Controller
@RequestMapping(value="subtypes")
public class SubTypeController {
	@Autowired
	SubTypeRepository repo;
	
	@RequestMapping("")
	public @ResponseBody List<SubType> getAllSubType() {
		List<SubType> subtypes = new ArrayList<SubType>();
		Iterable<SubType> results = repo.findAll();
		for (SubType subtype : results) {
			subtypes.add(subtype);
		}
		return subtypes;
	}

}
