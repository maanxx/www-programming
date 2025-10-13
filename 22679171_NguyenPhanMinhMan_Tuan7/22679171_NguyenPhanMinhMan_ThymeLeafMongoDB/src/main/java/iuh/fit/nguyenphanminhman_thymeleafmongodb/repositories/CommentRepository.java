package iuh.fit.nguyenphanminhman_thymeleafmongodb.repositories;

import iuh.fit.nguyenphanminhman_thymeleafmongodb.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
