package br.com.yctus.api.comment.service.infraestructure.dataproviders.repository;

import br.com.yctus.api.comment.service.domain.entities.model.CommentServiceID;
import br.com.yctus.api.comment.service.domain.entities.model.CommentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentServiceRepository extends JpaRepository<CommentService, CommentServiceID> {
}
