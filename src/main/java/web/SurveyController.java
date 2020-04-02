package web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
