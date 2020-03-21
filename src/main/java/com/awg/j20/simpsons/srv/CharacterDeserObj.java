package com.awg.j20.simpsons.srv;

import java.util.List;

import com.awg.j20.simpsons.domain.CartoonCharacter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CharacterDeserObj {
	
	@JsonProperty("data")
	public List<CartoonCharacter> cartoonCharacters;

}
