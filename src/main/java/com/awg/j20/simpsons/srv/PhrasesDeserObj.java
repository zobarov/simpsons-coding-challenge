package com.awg.j20.simpsons.srv;

import java.util.List;

import com.awg.j20.simpsons.domain.CartoonPhrase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class PhrasesDeserObj {
	
	@JsonProperty("data")
	public List<CartoonPhrase> cartoonPhrases;

}
