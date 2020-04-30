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
			Answer answer1 = new Answer("Oppimistavoitteeni kurssille oli oppia työskentelemään ryhmässä ja toteuttamaan toimivan vaatimukset täyttävän sovelluksen. Saavutimme kurssille annetut tavoitteet.",question1 );
			answerRepository.save(answer1);

			Answer answer2 = new Answer("Osaan paremmin hahmottaa, kuinka ohjelmistoprojektin työstäminen ryhmässä toimii.",question2 );
			answerRepository.save(answer2);

			Answer answer3 = new Answer("Ryhmätyöskentely toimi hyvin tuttujen opiskelelukaveiden kanssa.",question3);
			answerRepository.save(answer3);

			Answer answer4 = new Answer("Olisin joissakin tilanteissa voinut aktiivisemmin tuoda mielipiteeni esiin.",question4);
			answerRepository.save(answer4);

			Answer answer5 = new Answer("Opintojaksolla opin uusia koodaamistaitoja sekä sain hieman kokemusta, kuinka ohjelmiston kehitys ryhmässä toimii.",question5);
			answerRepository.save(answer5);

			Answer answer6 = new Answer("Ei tule mitään mieleen.",question6);
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
			Answer answer8 = new Answer("Tärkein oppimistavoite kurssille oli oppia, kuinka tehdä toimiva backend nettisivulle. Kyllä, ymmärrän nyt mitä backendiltä halutaan ja mitä se tekee.",question8);
			answerRepository.save(answer8);

			Answer answer9 = new Answer("Opin tekemään backendin verkkosivulle.",question9 );
			answerRepository.save(answer9);

			Answer answer10 = new Answer("Kurssilla ei toteutettu ryhmätyötä.",question10);
			answerRepository.save(answer10);

			Answer answer11 = new Answer("Eipä oikeastaan mitään.",question11);
			answerRepository.save(answer11);

			Answer answer12 = new Answer("Opintojaksossa oli hyvä, kun kurssilla toteutettiin omalle verkkosivuille yksilötyönä backend.",question12);
			answerRepository.save(answer12);

			Answer answer13 = new Answer("Ei tule mitään mieleen",question13);
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
