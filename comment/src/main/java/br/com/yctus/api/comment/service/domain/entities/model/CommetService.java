package br.com.yctus.api.comment.service.domain.entities.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CommetService {

    @Id
    @AttributeOverride(name="id", column = @jakarta.persistence.Column(name = "id", columnDefinition = "BIGINT"))
    private CommestServiceID id;
    private String commentDescription;
    private String author;
}
