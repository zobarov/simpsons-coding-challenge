package com.awg.j20.simpsons.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartoonBabbler {
	private CartoonCharacter character;
	private List<CartoonPhrase> phrases;
	
	private CartoonBabbler() {
	}
	
	public static CartoonBabbler createBabbler(CartoonCharacter character, List<CartoonPhrase> phrases) {
		CartoonBabbler instance = new CartoonBabbler();
		instance.character = character;
		instance.phrases = new ArrayList<>();
		
		if(phrases != null) {
			instance.phrases.addAll(phrases);
		}
		return instance;
	}
	
	public CartoonCharacter character() {
		return character;
	}
	
	public List<CartoonPhrase> phrases() {
		return phrases;
	}
}
