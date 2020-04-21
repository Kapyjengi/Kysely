package kapy.Kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerId;
	
	@ManyToOne
    //@JsonBackReference
    //@JsonManagedReference
    @JoinColumn(name = "questionId")
	private Question question;
	
    private String answerText;

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
	
	public Answer(Answer answerText) {
		super();
	}
		
	public Answer() {
		super();
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", question=" + question + ", answerText=" + answerText + "]";
	}
    
    

}
