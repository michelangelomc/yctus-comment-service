package br.com.yctus.api.comment.service.domain.entities.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentServiceID {
    private UUID id;

    public CommentServiceID(UUID id) {
        Objects.requireNonNull(id);
        this.id = id;
    }

    public CommentServiceID(String id) {
        Objects.requireNonNull(id);
        this.id = UUID.fromString(id);
    }

    public CommentServiceID(Long id) {
        Objects.requireNonNull(id);
        this.id = new UUID(id, id);
    }
}
