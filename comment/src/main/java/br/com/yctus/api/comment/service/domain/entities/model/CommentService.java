package br.com.yctus.api.comment.service.domain.entities.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CommentService {

    @Id
    @AttributeOverride(name="id", column = @Column(name = "id", columnDefinition = "VARCHAR(MAX)"))
    private CommentServiceID id;
    private String commentDescription;
    private String author;
    private OffsetDateTime createdAt;
}
