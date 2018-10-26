package com.learn.petclinic.owners;

import com.learn.petclinic.controllers.PersonController;
import com.learn.petclinic.facade.data.PersonsData;
import com.learn.petclinic.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
public class GetOwnersTest {
	@Mock
	private PersonService personService;

	private PersonController personController;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		//MockitoAnnotations.initMocks(this);
		personController = new PersonController(personService);
		mockMvc = MockMvcBuilders.standaloneSetup(personController).build();

		Mockito.when(personService.getOwners()).thenReturn(PersonsData.getOwnersSet());
	}

	@Test
	public void testGetOwners() throws Exception {
		mockMvc.perform(get(PersonController.OWNER_BEGIN))
				.andExpect(status().isOk())
				.andExpect(view().name(PersonController.OWNER_URL + PersonController.MODEL))
				.andExpect(model().attributeExists(PersonController.OWNER_URL))
				.andExpect(model().attribute(PersonController.OWNER_URL, hasSize(PersonsData.getOwners().length)));
	}


}
