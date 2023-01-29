package ch.bbw.m151.liquibasedemo.repository;

import ch.bbw.m151.liquibasedemo.datamodel.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<ArticleEntity, Long> {
}
