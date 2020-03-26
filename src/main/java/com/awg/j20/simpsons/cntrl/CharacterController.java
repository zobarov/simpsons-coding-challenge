package com.awg.j20.simpsons.cntrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.awg.j20.simpsons.domain.CartoonCharacter;
import com.awg.j20.simpsons.srv.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {
	private Logger logger = LoggerFactory.getLogger("CharacterController");
	@Autowired
	private CharacterService characterService;
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartoonCharacter> allCharacters() {
		return characterService.allCharacters();
	}
	
	@GetMapping(value="/{characterId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CartoonCharacter findCharacter(@PathVariable(value="characterId", required = true)String characterId) {
		return characterService.characterByKey(characterId);
	}
	
	@PostMapping(value="/")
	public @ResponseBody String addCharacter(Model model,
										@ModelAttribute(value="CartoonCharacter") CartoonCharacter character,
										BindingResult result, HttpServletRequest request) {
		
		logger.info("Adding cartoon character request here." + character);
		boolean res = characterService.addCharacter(character);
		
		return res ? "ADDED" : "FAIL";
	}

}
