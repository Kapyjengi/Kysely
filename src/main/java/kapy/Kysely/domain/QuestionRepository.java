package kapy.Kysely.domain;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	//List<Question>
}
