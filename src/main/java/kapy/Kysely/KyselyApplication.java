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
			
			// question 1
			// Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?
			Answer answer1 = new Answer("Oppimistavoitteeni kurssille oli oppia työskentelemään ryhmässä ja toteuttamaan toimivan vaatimukset täyttävän sovelluksen. Saavutimme kurssille annetut tavoitteet.",question1 );
			answerRepository.save(answer1);

			Answer answer2 = new Answer("Syventää rajapintojen käyttöä frontin ja backin kesken. Kyllä saavutin. ",question1 );
			answerRepository.save(answer2);
			
			Answer answer3 = new Answer("Syventää versiohallintaosaamista. Kyllä saavutin. ",question1 );
			answerRepository.save(answer3);
			
			Answer answer4 = new Answer("Oppia toimimaan aktiivisemmin ryhmässä. Kyllä saavutin.. ",question1 );
			answerRepository.save(answer4);
			
			// question 2
			// Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?
			Answer answer5 = new Answer("Git-versiohallinnan käytön oppiminen.",question2 );
			answerRepository.save(answer5);

			Answer answer6 = new Answer("Frontin ja backin liittäminen toisiinsa.",question2);
			answerRepository.save(answer6);

			Answer answer7 = new Answer("Opin tärkeitä yhteistyö- ja ryhmätyötaitoja.",question2);
			answerRepository.save(answer7);

			Answer answer8 = new Answer("Opintojaksolla opin uusia koodaamistaitoja sekä sain hieman kokemusta, kuinka ohjelmiston kehitys ryhmässä toimii.",question2);
			answerRepository.save(answer8);

			// question 3
			// Kerro kokemuksesti ryhmätyöskentelystä.
			Answer answer9 = new Answer("Ei tule mitään mieleen.",question3);
			answerRepository.save(answer9);
			
			Answer answer10 = new Answer("Ryhmätyöskentely toimi hyvin tuttujen opiskelelukaveiden kanssa.",question3);
			answerRepository.save(answer10);

			Answer answer11 = new Answer("Olisin joissakin tilanteissa voinut aktiivisemmin tuoda mielipiteeni esiin.",question3);
			answerRepository.save(answer11);

			Answer answer12 = new Answer("Ihan ok, vaikka olisinkin toivonut enemmän aktiivisuutta muilta jäseniltä.",question3);
			answerRepository.save(answer12);

			Answer answer13 = new Answer("Yleisesti olen ollut tyytyväinen ryhmän jäsenten panokseen.",question3);
			answerRepository.save(answer13);
			
			// question 4
			// Mitä olisit voinut opintojaksolla tehdä toisin?
			Answer answer14 = new Answer("Olisin voinut perehtyä enemmän backiin.",question4 );
			answerRepository.save(answer14);

			Answer answer15 = new Answer("Olisin voinut keskittyä enemmän fronttiin.",question4 );
			answerRepository.save(answer15);
			
			Answer answer16 = new Answer("Olisin voinut olla oma-aloitteisempi.",question4 );
			answerRepository.save(answer16);
			
			Answer answer17 = new Answer("Olisin voinut olla aktiivisempi.",question4 );
			answerRepository.save(answer17);
			
			Answer answer18 = new Answer("Olisin voinut juoda vähemmän kahvia.",question4 );
			answerRepository.save(answer18);

			// question 5
			// Mitä hyvää opintojaksossa oli?
			Answer answer19 = new Answer("Opin scrumista ja sen menetelmistä enemmän sen vuoksi, että projekti toteutettiin scrumin avulla.",question5);
			answerRepository.save(answer19);

			Answer answer20 = new Answer("Konkreettisen kyselyapplikaation tekeminen oli mieluisaa.",question5);
			answerRepository.save(answer20);

			Answer answer21 = new Answer("Opintojaksolla opin uusia koodaamistaitoja sekä sain hieman kokemusta, kuinka ohjelmiston kehitys ryhmässä toimii.",question5);
			answerRepository.save(answer21);

			Answer answer22 = new Answer("Pääsimme toteuttamaan mielenkiintoisen projektin.",question5);
			answerRepository.save(answer22);
			
			// question 6
			// Miten kehittäisit opintojaksoa?
			Answer answer23 = new Answer("Lisää demoja ja malliesimerkkejä.",question6);
			answerRepository.save(answer23);

			Answer answer24 = new Answer("Opettaja voisi kiertää Zoom-huoneita aktiivisesti ja käydä kyselemässä avuntarvetta.",question6);
			answerRepository.save(answer24);

			Answer answer25 = new Answer("Opettaja voisi antaa enemmän konreettisia vinkkejä.",question6);
			answerRepository.save(answer25);

			Answer answer26 = new Answer("Ei tule mitään mieleen.",question6);
			answerRepository.save(answer26);

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
			
			// question 8
			// Mitkä olivat tärkeimmät oppimistavoitteesi aloittaessasi opintojaksoa ja saavutitko ne?
			Answer answer27 = new Answer("Tärkein oppimistavoite kurssille oli oppia, kuinka tehdä toimiva backend nettisivulle. Kyllä, ymmärrän nyt mitä backendiltä halutaan ja mitä se tekee.",question8);
			answerRepository.save(answer27);

			Answer answer28 = new Answer("Tavoitteenani oli oppia tekemään backend verkkosivulle. Kyllä saavutin.",question8 );
			answerRepository.save(answer28);

			Answer answer29 = new Answer("Halusin oppia yhden kokonaisen stackin perusteet. Kyllä saavutin.",question8);
			answerRepository.save(answer29);

			Answer answer30 = new Answer("Halusin ymmärtää api-kutsuja. Kyllä.",question8);
			answerRepository.save(answer30);
			
			// question 9
			// Mitkä ovat tärkeimmät opintojaksolla oppimasi taidot?
			Answer answer31 = new Answer("Opin  REST-metodeita.",question9);
			answerRepository.save(answer31);

			Answer answer32 = new Answer("Opin paljon Spring Bootista ja osaan toteuttaa yksinkertaisen CRUD-sovelluksen, jossa on user ja admin käyttäjäluokat ja niille annetut käyttöoikeudet.",question9);
			answerRepository.save(answer32);
			
			Answer answer33 = new Answer("Ymmärsin validoinnin periaatteen ja tärkeyden.",question9);
			answerRepository.save(answer33);

			Answer answer34 = new Answer("Opin tekemään backendin verkkosivulle.",question9 );
			answerRepository.save(answer34);

			// question 10
			// Kerro kokemuksesti ryhmätyöskentelystä.
			Answer answer35 = new Answer("Kurssilla ei toteutettu ryhmätyötä.",question10);
			answerRepository.save(answer35);

			Answer answer36 = new Answer("Emme tehneet mitään ryhmässä.",question10);
			answerRepository.save(answer36);

			Answer answer37 = new Answer("Teimme omaehtoisesti ryhmässä töitä, mikä oli kivaa. Kurssiin ei kuulunut ryhmätyötä.",question10);
			answerRepository.save(answer37);

			Answer answer38 = new Answer("Ei ryhmätyötä. Ryhmätyö olisi auttanut oppimisen kannalta paljon.",question10);
			answerRepository.save(answer38);
			
			// question 11
			// Mitä olisit voinut opintojaksolla tehdä toisin?
			Answer answer39 = new Answer("Olisin voinut aloittaa lopputyön tekemisen paljon aiemmin.",question11);
			answerRepository.save(answer39);

			Answer answer40 = new Answer("Olisin voinut paneutua paremmin opettajan demoihin ja materiaaleihin.",question11 );
			answerRepository.save(answer40);

			Answer answer41 = new Answer("Olisin voinut käyttää enemmän työtunteja kurssin ja varsinkin lopputyön eteen.",question11);
			answerRepository.save(answer41);

			Answer answer42 = new Answer("Olisi pitänyt käyttää monipuolisempia toimintoja lopputyössäni.",question11);
			answerRepository.save(answer42);

			// question 12
			// Mitä hyvää opintojaksossa oli?
			Answer answer43 = new Answer("Opettajan materiaalit olivat hyvät ja selkeät.",question12);
			answerRepository.save(answer43);

			Answer answer44 = new Answer("Ei tule mitään hyvää mieleen lol.",question12);
			answerRepository.save(answer44);
			
			Answer answer45 = new Answer("Oli mielenkiintoista toteuttaa spring boot crud-projekti haluamastaan aiheesta.",question12);
			answerRepository.save(answer45);

			Answer answer46 = new Answer("Kurssilla oli mieltä avartava sisältö.",question12 );
			answerRepository.save(answer46);

			// question 13
			// Miten kehittäisit opintojaksoa?
			Answer answer47 = new Answer("Ei mitään kehitettävää. Kiitos.",question13);
			answerRepository.save(answer47);

			Answer answer48 = new Answer("Vapaaehtoisia syventäviä ja soveltavia tehtäviä, joita voi soveltaa esimerkiksi lopputyöhön.",question13);
			answerRepository.save(answer48);

			Answer answer49 = new Answer("Kurssin sisältö oli tosi hyvä lol ei kehitettävää.",question13);
			answerRepository.save(answer49);

			Answer answer50 = new Answer("Vähän lisää vinkkejä ja vippaskonsteja kiitos.",question13);
			answerRepository.save(answer50);

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
