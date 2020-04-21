package kapy.Kysely.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kapy.Kysely.domain.Answer;
import kapy.Kysely.domain.AnswerRepository;
import kapy.Kysely.domain.QuestionRepository;
import kapy.Kysely.domain.SurveyRepository;

@Controller
@CrossOrigin
public class AnswerController {
	
	@Autowired
	SurveyRepository surveyRepository;

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

//	// Answer to a question
//	@RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
//	public String saveAnswer(Model model, Answer answer, Question question,
//			@RequestParam(name = "questionText", required = false) String text,
//			@RequestParam(name = "questionid", required = false) Long textid) { 
//		// model.addAttribute("answers", new Answer());
//		System.out.println(question);
//		System.out.println(text);
//		System.out.println(textid);
//
//		return "redirect:questionlist";
//	}
	
//	// save answer
//	@RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
//	public String saveAnswer(@ModelAttribute("answer") Answer answer, BindingResult bindingResult, Model model) {
//
//		System.out.println(model);
//		System.out.println(answer);
//		System.out.println("savemetodi");
//		if (!bindingResult.hasErrors()) {
//			answerRepository.save(answer);
//		} else {
//			return "questionlist";
//		}
//		return "redirect:index";
//	}
	
//	// Create new answer, send to template along with current question. GET
//	// and current answers as list
//	@RequestMapping(value = "surveys/{surveyId}/addquestion", method = RequestMethod.GET)
//	public String getQuestion(@PathVariable("surveyId") Long surveyId, Model model) {
//		Question question = new Question(); 
//
//
//		Optional<Survey> survey = surveyRepository.findById(surveyId);
//		// link the new Question to the correct Survey
//		question.setSurvey(survey.get());
//
//
//		// questions as list to display on page
//		model.addAttribute("questionlist", survey.get().getQuestions());
//
//		model.addAttribute("survey", survey);
//		model.addAttribute("question", question);
//		model.addAttribute("surveysname", survey.get().getSurveyName());
//		return "addQuestion";
//	}
}
