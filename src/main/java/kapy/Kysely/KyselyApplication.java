package kapy.Kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kapy.Kysely.domain.Answer;
import kapy.Kysely.domain.AnswerRepository;
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
	public CommandLineRunner surveyDemo(QuestionRepository questionRepository, SurveyRepository surveyRepository, AnswerRepository answerRepository) {
		return (args) -> {
			log.info("save surveys and questions");

			log.info("test survey1");
			Survey survey1 = new Survey("SWD4TN022-3007", "Ohjelmistoprojekti 1 opintojakson kurssipalautekysely, kevät 2020.");
			surveyRepository.save(survey1);

			log.info("test questions for survey1");
			Question question1 = new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey1);
			questionRepository.save(question1);

			Question question2 = new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey1);
			questionRepository.save(question2);

			Question question3 = new Question("Kerro kokemuksesti ryhmätyöskentelystä.", survey1);
			questionRepository.save(question3);

			Question question4 = new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey1);
			questionRepository.save(question4);

			Question question5 = new Question("Mitä hyvää opintojaksossa oli?", survey1);
			questionRepository.save(question5);

			Question question6 = new Question("Miten kehittäisit opintojaksoa?", survey1);
			questionRepository.save(question6);

			log.info("test answers for survey1");
			Answer answer1 = new Answer(question1, "Asia1, asia2 ja asia3. Juu.");
			answerRepository.save(answer1);

			Answer answer2 = new Answer(question2, "Asiat aa, bee ja cee.");
			answerRepository.save(answer2);

			Answer answer3 = new Answer(question3, "Vastaus.");
			answerRepository.save(answer3);

			Answer answer4 = new Answer(question4, "Asian, toisen ja kolmannen.");
			answerRepository.save(answer4);

			Answer answer5 = new Answer(question5, "Tämä, tuo ja se.");
			answerRepository.save(answer5);

			Answer answer6 = new Answer(question6, "Sillain, tälläin ja tollain.");
			answerRepository.save(answer6);

			//			Vanha kysymystenlistaustapa			
			//			Poistetaan, jos tää uus tapa toimii hyvin
			//			questionRepository.save(new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey1));
			//			questionRepository.save(new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey1));
			//			questionRepository.save(new Question("Kerro kokemuksesti ryhmätyöskentelystä.", survey1));
			//			questionRepository.save(new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey1));
			//			questionRepository.save(new Question("Mitä hyvää opintojaksossa oli?", survey1));
			//			questionRepository.save(new Question("Miten kehittäisit opintojaksoa?", survey1));
			//			
			
			log.info("test survey2");
			Survey survey2 = new Survey("SWD4TN020-3006", "Palvelinohjelmointi opintojakson kurssipalautekysely, kevät 2020");
			surveyRepository.save(survey2);

			log.info("test questions for survey1");
			Question question8 = new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey2);
			questionRepository.save(question8);

			Question question9 = new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey2);
			questionRepository.save(question9);

			Question question10 = new Question("Kerro kokemuksesti ryhmätyöskentelystä.", survey2);
			questionRepository.save(question10);

			Question question11 = new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey2);
			questionRepository.save(question11);

			Question question12 = new Question("Mitä hyvää opintojaksossa oli?", survey2);
			questionRepository.save(question12);

			Question question13 = new Question("Miten kehittäisit opintojaksoa?", survey2);
			questionRepository.save(question13);

			log.info("test answers for survey1");
			Answer answer8 = new Answer(question8, "Tää, toi ja se.");
			answerRepository.save(answer8);

			Answer answer9 = new Answer(question9, "Asia1 ja asia2.");
			answerRepository.save(answer9);

			Answer answer10 = new Answer(question10, "Jotainjotainjotain.");
			answerRepository.save(answer10);

			Answer answer11 = new Answer(question11, "Tän ja ton.");
			answerRepository.save(answer11);

			Answer answer12 = new Answer(question12, "Joku ja joku.");
			answerRepository.save(answer12);

			Answer answer13 = new Answer(question13, "Tälläin ja tollain.");
			answerRepository.save(answer13);

			//			Vanha kysymystenlistaustapa			
			//			Poistetaan, jos tää uus tapa toimii hyvin
			//			questionRepository.save(new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey2));
			//			questionRepository.save(new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey2));
			//			questionRepository.save(new Question("Kerro kokemuksesti opintojakson ryhmätyöskentelystä.", survey2));
			//			questionRepository.save(new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey2));
			//			questionRepository.save(new Question("Mitä hyvää opintojaksossa oli?", survey2));
			//			questionRepository.save(new Question("Miten kehittäisit opintojaksoa?", survey2));

			log.info("fetch all surveys");
			for (Survey survey : surveyRepository.findAll()) {
				log.info(survey.toString());
			}
			log.info("fetch all questions");
			for (Question question : questionRepository.findAll()) {
				log.info(question.toString());
			}
			log.info("fetch all answers");
			for (Answer answer : answerRepository.findAll()) {
				log.info(answer.toString());
			}
		};
	}

}
