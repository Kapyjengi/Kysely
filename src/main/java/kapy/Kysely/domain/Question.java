package kapy.Kysely.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JsonIgnore
	@JoinColumn(name = "surveyId")
	private Survey survey;

	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "questionTypeId")
	private QuestionType questionType;
	
	// Managed reference = Näyttää vastaukset, kun listataan kysymykset
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answers;
	
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "QuestionOption", 
        joinColumns = { @JoinColumn(name = "questionId") }, 
        inverseJoinColumns = { @JoinColumn(name = "optionId") }
    )
    Set<Option> options = new HashSet<>();

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

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + "]";
	}
}
