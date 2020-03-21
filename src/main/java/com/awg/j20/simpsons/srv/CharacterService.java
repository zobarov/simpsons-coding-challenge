package com.awg.j20.simpsons.srv;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awg.j20.simpsons.domain.CartoonBabbler;
import com.awg.j20.simpsons.domain.CartoonCharacter;
import com.awg.j20.simpsons.domain.CartoonPhrase;
import com.awg.j20.simpsons.persist.CartoonDatastore;


@Service
public class CharacterService {
	private Logger logger = LoggerFactory.getLogger("CharacterService");
	@Autowired
	private CartoonDatastore datastore;
	
	public List<CartoonCharacter> allCharacters() {
		return datastore.listAllCharacters();
		
	}
	
	public CartoonCharacter characterByKey(String key) {
		for(CartoonCharacter c : datastore.listAllCharacters()) {
			if(c.getKey().equals(key)) {
				return c;
			}
		}
		return null;
	}
	
	public List<CartoonPhrase> phrasesForCharacter(String key) {
		CartoonBabbler babbler =  datastore.babblerByKey(key);
		logger.info("Found babbler by key " + key + " with " + babbler.phrases().size());
		
		return babbler.phrases();
	}

}
