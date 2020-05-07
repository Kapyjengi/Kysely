package kapy.Kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class AnswerOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerOptionId;
	
	@JsonBackReference(value="answer-answerOption")
	@ManyToOne
	@JoinColumn(name ="answerId")
	private Answer answer;
	
	@JsonManagedReference(value="option-answerOption")
	@ManyToOne
	@JoinColumn(name ="optionId")
	private Option option;
	
	

	public AnswerOption() {
		super();
	}

	public AnswerOption(Answer answer, Option option) {
		this.answer = answer;
		this.option = option;
	}

	public Long getAnswerOptionId() {
		return answerOptionId;
	}

	public void setAnswerOptionId(Long answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}
	
	
	
	
	
	

}
