package kapy.Kysely.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	
	
	private String questionText;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "surveyId")
    private Survey survey;


	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Question(Long questionId, String questionText) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
	}
	
	public Question(String questionText) {
		super();
		this.questionText = questionText;
	}
	
	// default constructor
	public Question(String questionText, Survey survey) {
		super();
		this.questionText = questionText;
		this.survey = survey;
	}


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}


	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + "]";
	}
	
	
	
	
	

}
