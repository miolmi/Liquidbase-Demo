package ch.bbw.m151.liquibasedemo;

import ch.bbw.m151.liquibasedemo.datamodel.ArticleEntity;
import ch.bbw.m151.liquibasedemo.datamodel.CategoryEntity;
import ch.bbw.m151.liquibasedemo.datamodel.CommentEntity;
import ch.bbw.m151.liquibasedemo.repository.ArticleRepository;
import ch.bbw.m151.liquibasedemo.repository.CategoryRepository;
import ch.bbw.m151.liquibasedemo.repository.CommentRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(properties = "spring.liquibase.drop-first=true")
class LiquibaseDemoApplicationTests implements WithAssertions {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void setupAndTestDatabase() {
		var article = new ArticleEntity();
		article.setTitle("a title");
		article.setText("some text");
		article = articleRepository.saveAndFlush(article);
		assertThat(article.getId()).isNotNull();
	}

	@Test
	void contextLoads() {
		assertThat(articleRepository.findAll()).isNotNull();
		assertThat(commentRepository.findAll()).isNotNull();
		assertThat(categoryRepository.findAll()).isNotNull();
	}
}
