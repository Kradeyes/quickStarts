package com.example.h2memorytest.service;

import com.example.h2memorytest.controller.PersonController;
import com.example.h2memorytest.db.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class PersonServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private PersonController personController;

    @Test
    void create() throws Exception {
        Person person = new Person();
        person.setName("Roma");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String jsonText = mapper.writeValueAsString(person);

        mvc.perform(post("/persons")
                .contentType(MediaType.APPLICATION_JSON).content(jsonText))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        Person person = new Person();
        person.setName("updatedUser");


        ObjectMapper mapper = new ObjectMapper();
        String jsonPerson = mapper.writeValueAsString(person);

        mvc.perform(put("/persons/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPerson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void deleteById() throws Exception {
        mvc.perform(delete("/persons/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mvc.perform(get("/persons/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Roma"));
    }

    @Test
    void getAll() throws Exception {
        mvc.perform(get("/persons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(1)));

    }
}