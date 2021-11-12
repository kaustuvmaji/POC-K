/**
 * 
 */
package com.ml.survey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ml.survey.entity.Answer;
import com.ml.survey.entity.AnswerPK;
import com.ml.survey.repository.AnswerRepository;
import com.ml.survey.repository.SurveyRepository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
public class SurveyControllerTest {

	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AnswerRepository mockAnswerRepository;

	@Before
	public void init() {
		Answer mockAnswer = new Answer();
		mockAnswer.setId(new AnswerPK(new BigInteger("1"), null));
		mockAnswer.setContent("My Name is Kaustuv");
		mockAnswer.setViewCount(new BigInteger("1"));
		when(mockAnswerRepository.findById(new AnswerPK(new BigInteger("1"), null))).thenAnswer((org.mockito.stubbing.Answer<?>) Optional.of(mockAnswer).orElse(null));
	}
	
    @Test
    public void find_answerId_OK() throws Exception {

        mockMvc.perform(get("/survey/answers/1"))
                /*.andDo(print())*/
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

//        verify(mockAnswerRepository, times(1)).findById(new AnswerPK(new BigInteger("1"), null));

    }

}
