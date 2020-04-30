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
import kapy.Kysely.domain.QuestionType;
import kapy.Kysely.domain.QuestionTypeRepository;
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
	public CommandLineRunner surveyDemo(QuestionRepository questionRepository, SurveyRepository surveyRepository, 
			AnswerRepository answerRepository, QuestionTypeRepository questionTypeRepository) {
		return (args) -> {
			log.info("save surveys and questions");
			
			///////////////////
			// KYSELYTYYPIT ///
			//////////////////
			log.info("question types");
			QuestionType type1 = new QuestionType("textField");
			questionTypeRepository.save(type1);
			QuestionType type2 = new QuestionType("radioButton");
			questionTypeRepository.save(type2);
			QuestionType type3 = new QuestionType("checkBox");
			questionTypeRepository.save(type3);
			

			////////////////////
			// TESTIKYSELY 1 //
			//////////////////

			log.info("test survey1");
			Survey survey1 = new Survey("SWD4TN022-3007", "Ohjelmistoprojekti 1 opintojakson kurssipalautekysely, kevät 2020.");
			surveyRepository.save(survey1);

			log.info("test questions for survey1");
			Question question1 = new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey1, type1);
			questionRepository.save(question1);

			Question question2 = new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey1, type1);
			questionRepository.save(question2);

			Question question3 = new Question("Kerro kokemuksesti ryhmätyöskentelystä.", survey1, type1);
			questionRepository.save(question3);

			Question question4 = new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey1, type1);
			questionRepository.save(question4);

			Question question5 = new Question("Mitä hyvää opintojaksossa oli?", survey1, type1);
			questionRepository.save(question5);

			Question question6 = new Question("Miten kehittäisit opintojaksoa?", survey1, type1);
			questionRepository.save(question6);

			log.info("test answers for survey1");
			Answer answer1 = new Answer("Asia1, asia2 ja asia3. Juu.",question1 );
			answerRepository.save(answer1);

			Answer answer2 = new Answer("Asiat aa, bee ja cee.",question2 );
			answerRepository.save(answer2);
			Answer answer14 = new Answer("Asiat YKKÖNE, bee ja cee.",question2 );
			answerRepository.save(answer14);
			Answer answer15 = new Answer("Asiat KAKKONE, bee ja cee.",question2 );
			answerRepository.save(answer15);

			Answer answer3 = new Answer("Ryhmätyöskentely toimi hyvin tuttujen opiskelelukaveiden kanssa.",question3);
			answerRepository.save(answer3);

			Answer answer4 = new Answer("Asian, toisen ja kolmannen.",question4);
			answerRepository.save(answer4);

			Answer answer5 = new Answer("Tämä, tuo ja se.",question5);
			answerRepository.save(answer5);

			Answer answer6 = new Answer("Sillain, tälläin ja tollain.",question6);
			answerRepository.save(answer6);

			////////////////////
			// TESTIKYSELY 2 //
			//////////////////

			log.info("test survey2");
			Survey survey2 = new Survey("SWD4TN020-3006", "Palvelinohjelmointi opintojakson kurssipalautekysely, kevät 2020");
			surveyRepository.save(survey2);

			log.info("test questions for survey2");
			Question question8 = new Question("Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?", survey2, type1);
			questionRepository.save(question8);

			Question question9 = new Question("Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?", survey2, type1);
			questionRepository.save(question9);

			Question question10 = new Question("Kerro kokemuksesti ryhmätyöskentelystä.", survey2, type1);
			questionRepository.save(question10);

			Question question11 = new Question("Mitä olisit voinut opintojaksolla tehdä toisin?", survey2, type1);
			questionRepository.save(question11);

			Question question12 = new Question("Mitä hyvää opintojaksossa oli?", survey2, type1);
			questionRepository.save(question12);

			Question question13 = new Question("Miten kehittäisit opintojaksoa?", survey2, type1);
			questionRepository.save(question13);

			log.info("test answers for survey1");
			Answer answer8 = new Answer("Tää, toi ja se.",question8);
			answerRepository.save(answer8);

			Answer answer9 = new Answer("Asia1 ja asia2.",question9 );
			answerRepository.save(answer9);

			Answer answer10 = new Answer("Kurssilla ei toteutettu ryhmätyötä.",question10);
			answerRepository.save(answer10);

			Answer answer11 = new Answer("Tän ja ton.",question11);
			answerRepository.save(answer11);

			Answer answer12 = new Answer("Joku ja joku.",question12);
			answerRepository.save(answer12);

			Answer answer13 = new Answer("Tälläin ja tollain.",question13);
			answerRepository.save(answer13);

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
