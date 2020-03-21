package com.awg.j20.simpsons.srv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.awg.j20.simpsons.domain.CartoonCharacter;
import com.awg.j20.simpsons.domain.CartoonPhrase;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileLoader {
	private Logger logger = LoggerFactory.getLogger("FileLoader");
	
	@Value("${data.folder}")
	private String dataDir;
	
	@Value("${data.characters}")
	private String dataFilenameCharacters;
	@Value("${data.phrases}")
	private String dataFilenamePhrases;
	
	public List<CartoonCharacter> loadCharacters() {
		logger.info("Loading data from directory: " + dataDir);
		logger.info("Loading charachters data from: " + dataFilenameCharacters);
		logger.info("Loading phrases data from: " + dataFilenamePhrases);

		ObjectMapper jsonMapper = new ObjectMapper();
		
		try {
			File charFile = ResourceUtils.getFile(dataDir + "/" + dataFilenameCharacters);
			
			logger.info("File found: " + charFile.getAbsolutePath());
			
			
			CharacterDeserObj characters = 
					jsonMapper.readValue(charFile, new TypeReference<CharacterDeserObj>() {});
			
			logger.info("File chars: " + characters.cartoonCharacters.size());
			
			return characters.cartoonCharacters;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CartoonPhrase> loadPhrases() {
		logger.info("Loading data from directory: " + dataDir);
		logger.info("Loading charachters data from: " + dataFilenameCharacters);
		logger.info("Loading phrases data from: " + dataFilenamePhrases);

		ObjectMapper jsonMapper = new ObjectMapper();
		
		try {
			File charFile = ResourceUtils.getFile(dataDir + "/" + dataFilenamePhrases);
			
			logger.info("File found: " + charFile.getAbsolutePath());
			
			
			PhrasesDeserObj phrases = 
					jsonMapper.readValue(charFile, new TypeReference<PhrasesDeserObj>() {});
			
			logger.info("File phrases: " + phrases.cartoonPhrases.size());
			
			return phrases.cartoonPhrases;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
