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
public class QuestionType {
	
	private String typeName;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionTypeId;

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionType")
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

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

	@Override
	public String toString() {
		return "QuestionType [typeName=" + typeName + ", questionId=" + questionTypeId+"]";
	}

	public QuestionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionType(String typeName) {
		this.typeName = typeName;
	}
	
	

}
