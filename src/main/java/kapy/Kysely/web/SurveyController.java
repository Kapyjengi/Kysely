package kapy.Kysely.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kapy.Kysely.domain.Question;
import kapy.Kysely.domain.QuestionRepository;
import kapy.Kysely.domain.Survey;
import kapy.Kysely.domain.SurveyRepository;

@Controller
@CrossOrigin
public class SurveyController {

	@Autowired
	SurveyRepository surveyRepository;

	@Autowired
	QuestionRepository questionRepository;


	// Create new survey, send to template. GET
	@RequestMapping(value = "/addsurvey", method = RequestMethod.GET)
	public String getNewSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "addSurvey";
	}

	// Receive named survey from template, save it. Direct to adding questions. POST
	@RequestMapping(value = "/addsurvey", method = RequestMethod.POST)
	public String saveSurvey(@ModelAttribute Survey survey) {
		surveyRepository.save(survey);
		Long surveyId = survey.getSurveyId(); // Save ID of new survey as path variable for redirect
		System.out.println(survey.getSurveyName()); // log survey name
		return "redirect:surveys/"+ surveyId + "/addquestion"; // direct to create questions for survey
	}

	// Create new question, send to template along with current survey. GET
	// and current questions as list
	@RequestMapping(value = "surveys/{surveyId}/addquestion", method = RequestMethod.GET)
	public String getQuestion(@PathVariable("surveyId") Long surveyId, Model model) {
		Question question = new Question(); 
		
		
		Optional<Survey> survey = surveyRepository.findById(surveyId);
		// link the new Question to the correct Survey
		question.setSurvey(survey.get());
		
		
		// questions as list to display on page
		model.addAttribute("questionlist", survey.get().getQuestions());
		
		model.addAttribute("survey", survey);
		model.addAttribute("question", question);
		model.addAttribute("surveysname", survey.get().getSurveyName());
		return "addQuestion";
	}
	
	// Receive question from template, save it. POST
	// Direct to add another question.
	@RequestMapping(value = "/savequestion", method = RequestMethod.POST)
	public String saveQuestion(@ModelAttribute Question question) {
		System.out.println(question);
		questionRepository.save(question);
		System.out.println(question.getSurvey().getSurveyId());
		Long surveyId = question.getSurvey().getSurveyId(); // get surveyID of question to get the right survey to add questions to
		return "redirect:surveys/"+surveyId+"/addquestion"; // direct back to question template 
		// return "redirect:/addsurvey";
	}

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

}
