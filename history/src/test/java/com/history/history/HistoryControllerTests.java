package com.history.history;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.history.history.model.HistoryModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HistoryControllerTests {

    @Autowired
    private MockMvc mvc ;

    @Test
    public void testGetHistoryById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/history/{id}","ObjectId(\"61e1d99504749212e8ce54e6\")")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetHistoryByPatId() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .get("/historys/{patId}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveHistory() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                .post("/history/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new HistoryModel(null,"2","test","One note from practitionner")))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateHistory() throws Exception{
        mvc.perform(MockMvcRequestBuilders
                        .put("/history/{id}",2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new HistoryModel("ObjectId(\"61e1d99504749212e8ce54e6\"","1","Test"," Patient states that they are 'feeling terrific' Weight at or below recommended level")))
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
