package com.awg.j20.simpsons.srv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.awg.j20.simpsons.domain.CartoonCharacter;

@Service
public class CharacterService {
	
	public List<CartoonCharacter> allCharacters() {
		CartoonCharacter char1 = new CartoonCharacter();
		char1.setId("1");
		char1.setFirstName("Homer");
		char1.setLastName("Simpson");
		char1.setPictureUrl("http://www.trbimg.com/img-573a089a/turbine/ct-homer-simpson-live-pizza-debate-met-0517-20160516");
		char1.setAge(43);
		
		CartoonCharacter char2 = new CartoonCharacter();
		char2.setId("2");
		char2.setFirstName("Ned");
		char2.setLastName("Flanders");
		char2.setPictureUrl("https://vignette.wikia.nocookie.net/simpsons/images/8/84/Ned_Flanders.png/revision/latest?cb=20100513160156");
		char2.setAge(50);
		
		List<CartoonCharacter> characters = new ArrayList<>();
		characters.add(char1);
		characters.add(char2);
		
		return characters;
		
	}

}
