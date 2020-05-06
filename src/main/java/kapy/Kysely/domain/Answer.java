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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerId;

	private String answerText;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "questionId")
	private Question question;
	
	/*
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
	private List<Option> options;
	*/
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Answer_Option", 
        joinColumns = { @JoinColumn(name = "optionId") }, 
        inverseJoinColumns = { @JoinColumn(name = "answerId") }
    )
    Set<Option> options = new HashSet<>();
    
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
	

	public Answer(Answer answerText) {
		super();
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	public void addOption(Option option) {
		this.options.add(option);
	}

	public Answer() {
		super();
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", question=" + question + ", answerText=" + answerText + "]";
	}
}
