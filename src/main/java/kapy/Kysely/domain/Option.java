package kapy.Kysely.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Option {
	
	private String optionText;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long optionId;
	
	@ManyToMany(mappedBy = "options")
    private Set<Question> questions = new HashSet<>();

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	@Override
	public String toString() {
		return "Option [optionText=" + optionText + ", optionId=" + optionId + "]";
	}

	public Option(String optionText) {
		this.optionText = optionText;
	}

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
