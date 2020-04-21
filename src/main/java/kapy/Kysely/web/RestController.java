package kapy.Kysely.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kapy.Kysely.domain.Answer;
import kapy.Kysely.domain.AnswerRepository;
import kapy.Kysely.domain.Question;
import kapy.Kysely.domain.QuestionRepository;
import kapy.Kysely.domain.Survey;
import kapy.Kysely.domain.SurveyRepository;

@Controller
@CrossOrigin
public class RestController {
	
	@Autowired
	SurveyRepository surveyRepository;

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	//Restful haetaan kysely id-numeron mukaan
	@RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("surveyId") Long surveyId){
		return surveyRepository.findById(surveyId);
	}
	
	//Restful haetaan kaikkien kyselyiden haku
	@RequestMapping(value = "/surveys", method = RequestMethod.GET)
	public @ResponseBody List<Survey>surveyListRest(){
		return (List<Survey>)surveyRepository.findAll();
	}
	
	//REST-metodi kyselyn lisäämiseen
	@PostMapping("/surveys")
	public @ResponseBody Survey addNewSurvey(@RequestBody Survey survey) {
		surveyRepository.save(survey);
		return survey;
	}
		
	//REST homepage
	@RequestMapping(value = "/resthome", method = RequestMethod.GET)
	public String restHome() {
		return "resthome";
	}
	
	// RESTful service for adding an answer
	// 
	/*1. endpoint on /submitanswer
	 * 2. Saadaan vastausolio JSONIna
	 * 3. LIitetään vastausolio kysymysID:n perusteella kysymysolioon
	 * 		Answer answer = new Answer();
	 * answer.setAnswerText();
		Question question = answer.getQuestion();
		question.addAnswer(answer);
	 */
	
	@PostMapping("/submitanswer")
	public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
		answerRepository.save(answer);
		return answer;
	}
	
	//Restful kaikki vastaukset
	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer>giefAnswersRest(){
		return (List<Answer>)answerRepository.findAll();
	}
	
	
	
	
	//surveys/' + props.surveyId + '/questions
	// RESTful get all questions in survey
	@RequestMapping(value = "/surveys/{surveyId}/question", method = RequestMethod.GET)
	public @ResponseBody List<Question>getQuestionsOfSurveyEKA(@PathVariable("surveyId") Long surveyId){
		return (List<Question>)surveyRepository.findById(surveyId).get().getQuestions();
	}
	
	// RESTful get question texts only
	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.GET)
	public @ResponseBody List<String>getQuestionsOfSurvey(@PathVariable("surveyId") Long surveyId){
		List<Question> questions = surveyRepository.findById(surveyId).get().getQuestions();
		List<String> questionTexts = new ArrayList<String>();
		for(int i=0; i<questions.size(); i++){
	        questionTexts.add(questions.get(i).getQuestionText());
	    }  
		return questionTexts;
	}

}
