package com.awg.j20.simpsons.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartoonPhrase {
	@JsonProperty("_id")
	private String cartoonPhraseId;
	@JsonProperty("character")
	private String cartoonCharacterId;
	@JsonProperty("phrase")
	private String phrase;
	

	public String getCartoonPhraseId() {
		return cartoonPhraseId;
	}
	public void setCartoonPhraseId(String cartoonPhraseId) {
		this.cartoonPhraseId = cartoonPhraseId;
	}
	public String getCartoonCharacterId() {
		return cartoonCharacterId;
	}
	public void setCartoonCharacterId(String cartoonCharacterId) {
		this.cartoonCharacterId = cartoonCharacterId;
	}
	public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	
	

}
