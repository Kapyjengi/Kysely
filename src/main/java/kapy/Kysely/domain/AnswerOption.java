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
public class AnswerOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerOptionId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name ="answerId")
	private Answer answer;
	
	@JsonManagedReference
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
