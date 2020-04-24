package kapy.Kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Long> {

	List<Survey>findBySurveyName(String surveyName);

}
