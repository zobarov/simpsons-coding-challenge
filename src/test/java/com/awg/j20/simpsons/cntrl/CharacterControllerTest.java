package com.awg.j20.simpsons.cntrl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.awg.j20.simpsons.domain.CartoonCharacter;
import com.awg.j20.simpsons.srv.CharacterService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CharacterController.class)
public class CharacterControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private CharacterService mockCharacterService;
	
	@DisplayName("Main contract for endpoint")
    @Test
    void shouldDisplay_TwoCharacters() throws Exception {
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
				
		Mockito
			.when(mockCharacterService.allCharacters())
			.thenReturn(characters);
		
		//when:
        mockMvc.perform(get("/characters")
        			.accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0]").exists())
        .andExpect(jsonPath("$[1]").exists())
        
        .andExpect(jsonPath("$[0].id").exists())
        .andExpect(jsonPath("$[0].id").value("1"))
        .andExpect(jsonPath("$[0].firstName").exists())
        .andExpect(jsonPath("$[0].firstName").value("Homer"))   
        .andExpect(jsonPath("$[0].lastName").exists())
        .andExpect(jsonPath("$[0].lastName").value("Simpson"))
        .andExpect(jsonPath("$[0].pictureUrl").exists())
        .andExpect(jsonPath("$[0].pictureUrl").value("http://www.trbimg.com/img-573a089a/turbine/ct-homer-simpson-live-pizza-debate-met-0517-20160516"))
        .andExpect(jsonPath("$[0].age").exists())
        .andExpect(jsonPath("$[0].age").value("43"))
        //second:
        .andExpect(jsonPath("$[1].id").exists())
        .andExpect(jsonPath("$[1].id").value("2"))
        .andExpect(jsonPath("$[1].firstName").exists())
        .andExpect(jsonPath("$[1].firstName").value("Ned"))   
        .andExpect(jsonPath("$[1].lastName").exists())
        .andExpect(jsonPath("$[1].lastName").value("Flanders"))
        .andExpect(jsonPath("$[1].pictureUrl").exists())
        .andExpect(jsonPath("$[1].pictureUrl").value("https://vignette.wikia.nocookie.net/simpsons/images/8/84/Ned_Flanders.png/revision/latest?cb=20100513160156"))
        .andExpect(jsonPath("$[1].age").exists())
        .andExpect(jsonPath("$[1].age").value("50"));
    }

}
