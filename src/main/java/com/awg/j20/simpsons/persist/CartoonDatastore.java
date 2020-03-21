package com.awg.j20.simpsons.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.awg.j20.simpsons.domain.CartoonBabbler;
import com.awg.j20.simpsons.domain.CartoonCharacter;
import com.awg.j20.simpsons.domain.CartoonPhrase;

/**
 * 
 *
 */
@Repository
public class CartoonDatastore {
	private Logger logger = LoggerFactory.getLogger("CartoonDatastore");
	
	private Map<String, CartoonBabbler> babblers = new HashMap<>();
	
	public int loadAsBabblers(List<CartoonCharacter> characters, List<CartoonPhrase> phrases) {
		logger.info("Loading " + characters.size() + " characters and " + phrases.size() + " phrases...");
		
		int characterKey = 1;
		for(CartoonCharacter character : characters) {
			List<CartoonPhrase> phrasesBelongToCharacter = new ArrayList<>();
			character.setKey(Integer.toString(characterKey));
			
			for(CartoonPhrase phrase : phrases) {
				if(character.dbId().equals(phrase.getCartoonCharacterId())) {
					phrasesBelongToCharacter.add(phrase);
				}
			}
			CartoonBabbler babbler = CartoonBabbler.createBabbler(character, phrasesBelongToCharacter);
			babblers.put(character.getKey(), babbler);
			
			characterKey++;
		}
		
		return characterKey;
		
	}
	
	public CartoonBabbler babblerByKey(String key) {
		
		CartoonBabbler babbler = babblers.get(key);
		//TODO: checks:
		return babbler;
	}
	
	public List<CartoonCharacter> listAllCharacters() {
		List<CartoonCharacter> characters = new ArrayList<>();
		
		for(CartoonBabbler b : babblers.values()) {
			characters.add(b.character());
		}
		
		return characters;
	}
	

}
