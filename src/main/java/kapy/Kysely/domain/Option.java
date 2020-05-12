package kapy.Kysely.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Option {
	
	private String optionText;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long optionId;
	
	@ManyToOne
	//@JsonIgnore
	@JsonBackReference(value="question-options")
	@JoinColumn(name = "questionId")
	private Question question;
	/*
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "answerId")
	private Answer answer;
	*/
	
	//@JsonBackReference(value="option-answerOption")
	@JsonManagedReference(value="option-answerOption")
	//@JsonIgnore
	@JsonIgnoreProperties("options")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "option")
	private List<AnswerOption> answerOptions;
	
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	@Override
	public String toString() {
		return "Option [optionText=" + optionText + ", optionId=" + optionId + "]";
	}

	public Option(String optionText) {
		this.optionText = optionText;
	}

	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	public List<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}
	public void setAnswerOptions(List<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}
	// constructor
	public Option(String optionText, Question question) {
		this.optionText = optionText;
		this.question = question;
	}
	
	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
