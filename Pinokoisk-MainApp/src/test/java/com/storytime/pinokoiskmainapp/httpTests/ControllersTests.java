package com.storytime.pinokoiskmainapp.httpTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebMvcTest
public class ControllersTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomeRedirect_expect200() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(
                        containsString("<!DOCTYPE html>")
                ));
    }

    @Test
    public void testFilmsRedirect_expect200() throws Exception {
        mockMvc.perform(get("/films"))
                .andExpect(status().isOk())
                .andExpect(view().name("collections/shows"))
                .andExpect(content().string(
                        containsString("<!DOCTYPE html>")
                ));
    }

    @Test
    public void testSeriesRedirect_expect200() throws Exception {
        mockMvc.perform(get("/series"))
                .andExpect(status().isOk())
                .andExpect(view().name("collections/shows"))
                .andExpect(content().string(
                        containsString("<!DOCTYPE html>")
                ));
    }

    @Test
    public void testFilmsCollectionsRedirect_expect200() throws Exception {
        mockMvc.perform(get("/collections/films"))
                .andExpect(status().isOk())
                .andExpect(view().name("collections/collections"))
                .andExpect(content().string(
                        containsString("<!DOCTYPE html>")
                ));
    }

    @Test
    public void testSeriesCollectionsRedirect_expect200() throws Exception {
        mockMvc.perform(get("/collections/series"))
                .andExpect(status().isOk())
                .andExpect(view().name("collections/collections"))
                .andExpect(content().string(
                        containsString("<!DOCTYPE html>")
                ));
    }

    @Test
    public void testSearchRedirect_expect200() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("search"))
                .andExpect(content().string(
                        containsString("<!DOCTYPE html>")
                ));
    }

}
