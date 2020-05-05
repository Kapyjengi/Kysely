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
	
	//Find survey by ID
	@RequestMapping(value = "/surveys/{surveyId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Survey> findSurveyById(@PathVariable("surveyId") Long surveyId){
		return surveyRepository.findById(surveyId);
	}
	
	//Get all surveys as list
	@RequestMapping(value = "/surveys", method = RequestMethod.GET)
	public @ResponseBody List<Survey>getSurveyList(){
		return (List<Survey>)surveyRepository.findAll();
	}
	
	//Save survey
	@PostMapping("/surveys")
	public @ResponseBody Survey saveSurvey(@RequestBody Survey survey) {
		surveyRepository.save(survey);
		return survey;
	}
		
	//REST homepage
	@RequestMapping(value = {"/resthome", "/", "/api"}, method = RequestMethod.GET)
	public String restHome() {
		return "resthome";
	}
	
	// Save an answer
	@PostMapping("/submitanswer")
	public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
		answerRepository.save(answer);
		return answer;
	}
	
	//Get list of all Questions
	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer>getAllAnswers(){
		return (List<Answer>)answerRepository.findAll();
	}
	
	// Get all answers to specified quuestion
	// questions/{questionId}/answers/
	@RequestMapping(value= "questions/{questionId}/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer>getAnswersOfQuestion(@PathVariable("questionId") Long questionId){
		return (List<Answer>)questionRepository.findById(questionId).get().getAnswers();
	}
	
	// Get all text-field of all answers for a specified question
		@RequestMapping(value= "questions/{questionId}/answertexts", method = RequestMethod.GET)
		public @ResponseBody List<String>getAnswerTextsOfQuestion(@PathVariable("questionId") Long questionId){
			List<Answer> answers = questionRepository.findById(questionId).get().getAnswers();
			List<String> answerTexts = new ArrayList<String>();
			for(int i=0; i<answers.size(); i++){
		        answerTexts.add(answers.get(i).getAnswerText());
		    }  
			return answerTexts;
		}
	
	// Get all questions in a specified survey
	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question>getQuestionsOfSurvey(@PathVariable("surveyId") Long surveyId){
		return (List<Question>)surveyRepository.findById(surveyId).get().getQuestions();
	}
	
	// Get questionText of all questions of a specific survey
	@RequestMapping(value = "/surveys/{surveyId}/questiontexts", method = RequestMethod.GET)
	public @ResponseBody List<String>getQuestionsOfSurveyAsText(@PathVariable("surveyId") Long surveyId){
		List<Question> questions = surveyRepository.findById(surveyId).get().getQuestions();
		List<String> questionTexts = new ArrayList<String>();
		for(int i=0; i<questions.size(); i++){
	        questionTexts.add(questions.get(i).getQuestionText());
	    }  
		return questionTexts;
	}
	

}
