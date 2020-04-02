package kapy.Kysely.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Survey {
	
	private String surveyName;
	private String surveyDescription;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long surveyId;

	@Override
	public String toString() {
		return "Survey [surveyName=" + surveyName + ", surveyDescription=" + surveyDescription + ", surveyId="
				+ surveyId + "]";
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyDescription() {
		return surveyDescription;
	}

	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public Survey(String surveyName, String surveyDescription, Long surveyId) {
		super();
		this.surveyName = surveyName;
		this.surveyDescription = surveyDescription;
		this.surveyId = surveyId;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Survey(String surveyName, String surveyDescription) {
		super();
		this.surveyName = surveyName;
		this.surveyDescription = surveyDescription;
	}
	

}
