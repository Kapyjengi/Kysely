package kapy.Kysely.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerId;

	private String answerText;
	
	// @JsonBackReference(value="question-answer")
	@ManyToOne
	@JoinColumn(name = "questionId")
	@JsonIgnore
	private Question question;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer", fetch = FetchType.LAZY)
	@JsonManagedReference(value="answer-answerOption")
	@JsonIgnore
	private List<AnswerOption> answerOptions;
	
	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}	

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	// default constructor without ID
	public Answer(Question question, String answerText) {
		super();
		this.question = question;
		this.answerText = answerText;
	}

	// other way around
	public Answer(String answerText, Question question) {
		super();
		this.question = question;
		this.answerText = answerText;
	}
	
	// constructor with only question
	public Answer(Question question) {
		super();
		this.question = question;
	}
	
	
	public List<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public Answer() {
		super();
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", question=" + question + ", answerText=" + answerText + "]";
	}
}
