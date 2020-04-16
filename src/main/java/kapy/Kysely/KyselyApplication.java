package kapy.Kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kapy.Kysely.domain.Question;
import kapy.Kysely.domain.QuestionRepository;
import kapy.Kysely.domain.Survey;
import kapy.Kysely.domain.SurveyRepository;

@SpringBootApplication
public class KyselyApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	//testidatan luonti H2-testitietokantaan
	@Bean
	public CommandLineRunner surveyDemo(QuestionRepository questionRepository, SurveyRepository surveyRepository) {
		return (args) -> {
			log.info("save surveys and questions");
		
			log.info("test survey1");	
			Survey survey1 = new Survey("SWD4TN022-3007", "Ohjelmistoprojekti 1 opintojakson kurssipalautekysely, kevät 2020.");
			surveyRepository.save(survey1);
			questionRepository.save(new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey1));
			questionRepository.save(new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey1));
			questionRepository.save(new Question("Kerro kokemuksesti ryhmätyöskentelystä.", survey1));
			questionRepository.save(new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey1));
			questionRepository.save(new Question("Mitä hyvää opintojaksossa oli?", survey1));
			questionRepository.save(new Question("Miten kehittäisit opintojaksoa?", survey1));			
			
			log.info("test survey2");
			Survey survey2 = new Survey("SWD4TN020-3006", "Palvelinohjelmointi opintojakson kurssipalautekysely, kevät 2020");
			surveyRepository.save(survey2);
			questionRepository.save(new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey2));
			questionRepository.save(new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey2));
			questionRepository.save(new Question("Kerro kokemuksesti opintojakson ryhmätyöskentelystä.", survey2));
			questionRepository.save(new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey2));
			questionRepository.save(new Question("Mitä hyvää opintojaksossa oli?", survey2));
			questionRepository.save(new Question("Miten kehittäisit opintojaksoa?", survey2));			
			
			log.info("fetch all surveys");
			for (Survey survey : surveyRepository.findAll()) {
				log.info(survey.toString());
			}
			log.info("fetch all questions");
			for (Question question : questionRepository.findAll()) {
				log.info(question.toString());
			}
		};
	}

}
