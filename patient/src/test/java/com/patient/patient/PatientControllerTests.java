package com.patient.patient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.patient.model.PatientModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PatientControllerTests {

    @Autowired
    private MockMvc mvc ;

    @Test
    public void testGetPatients() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/patients")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPatient() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                        .get("/patient/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testSavePatient() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .post("/patient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new PatientModel(null,"TestFromCode","TestFromCode","1989-01-09","M", "Somewhere", "666-999-777")))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdatePatient() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .put("/patient/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new PatientModel(1L,"Test2","Test2","1989-01-09","M", "Somewhere", "666-999-789")))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
