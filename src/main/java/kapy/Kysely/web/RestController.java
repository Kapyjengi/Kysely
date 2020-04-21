package kapy.Kysely.web;

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
	

}
