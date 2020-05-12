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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;

	private String questionText;

	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "questionTypeId")
	private QuestionType questionType;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "surveyId")
	private Survey survey;

	// Managed reference = Näyttää vastaukset, kun listataan kysymykset
	//@JsonManagedReference(value="question-answer")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;

	// List of options
	@JsonManagedReference(value="question-options")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnore
	private List<Option> options;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

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
	// constructor with type included
	public Question(String questionText, Survey survey, QuestionType questionType) {
		super();
		this.questionText = questionText;
		this.survey = survey;
		this.questionType = questionType;
	}

	public Question(Survey survey, QuestionType questionType) {
		super();
		this.survey = survey;
		this.questionType = questionType;
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


	public QuestionType getQuestiontype() {
		return questionType;
	}

	public void setQuestiontype(QuestionType questiontype) {
		this.questionType = questiontype;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + "]";
	}
}
