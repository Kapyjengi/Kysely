package kapy.Kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QuestionType {
	
	private String typeName;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionTypeId;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "questionId")
	private Question question;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getQuestionId() {
		return questionTypeId;
	}

	public void setQuestionId(Long questionId) {
		this.questionTypeId = questionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionType [typeName=" + typeName + ", questionId=" + questionTypeId + ", question=" + question + "]";
	}

	public QuestionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionType(String typeName) {
		this.typeName = typeName;
	}
	
	

}
