package br.com.arc.studyaws;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest (properties = "spring.main.lazy-initialization=true",
		classes = {StudyawsApplicationTests.class})
class StudyawsApplicationTests {

	@Test
	void contextLoads() {
	}
}
