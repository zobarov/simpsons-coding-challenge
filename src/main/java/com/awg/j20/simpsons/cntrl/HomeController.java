package com.awg.j20.simpsons.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.awg.j20.simpsons.srv.CharacterService;

@Controller
public class HomeController {
	
	@Autowired
	private CharacterService srv;
	
	@GetMapping("/")
	public String home(Model model) {
		//List<> srv.allCharacters();
		model.addAttribute("allCharacters", srv.allCharacters());
		model.addAttribute("characterPhrases", srv.phrasesForCharacter("1"));
		return "home";
	}

}
