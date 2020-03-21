package com.awg.j20.simpsons.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awg.j20.simpsons.domain.CartoonPhrase;
import com.awg.j20.simpsons.srv.CharacterService;

@RestController
@RequestMapping("/characters")
public class PhrasesController {
	@Autowired
	private CharacterService characterService;
	
	@GetMapping(value="/{characterId}/phrases", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartoonPhrase> findBabbler(@PathVariable(value="characterId", required = true)String characterId) {
		return characterService.phrasesForCharacter(characterId);
	}

}
