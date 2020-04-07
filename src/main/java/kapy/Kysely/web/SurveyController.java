package kapy.Kysely.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println(survey.getSurveyName()); // log survey name
		return "redirect:/addquestion";
	}

	// Create new question, send to template along with list of surveys. GET
	@RequestMapping(value = "/addquestion", method = RequestMethod.GET)
	public String getQuestion(Model model) {
		model.addAttribute("question", new Question());
		model.addAttribute("surveys", surveyRepository.findAll());
		return "addQuestion";
	}
	// Receive question from template, save it. POST
	// Direct to add another question.
	@RequestMapping(value = "/addquestion", method = RequestMethod.POST)
	public String saveQuestion(@ModelAttribute Question question) {
		questionRepository.save(question);
		return "redirect:/addquestion";
	}

	//Restful haetaan kysely id-numeron mukaan
	@RequestMapping(value = "/surveys/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("surveyid") Long surveyid){
		return surveyRepository.findById(surveyid);
	}
	//Restful haetaan kaikkien kyselyiden haku
	@RequestMapping(value = "/surveys", method = RequestMethod.GET)
	public @ResponseBody List<Survey>surveyListRest(){
		return (List<Survey>)surveyRepository.findAll();
	}

}
