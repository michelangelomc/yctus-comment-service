package br.com.yctus.api.comment.service.domain.entities.request;

import br.com.yctus.api.comment.service.infraestructure.configurations.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequest {

    @JsonIgnore
    private UUID postId = IdGenerator.generateID();

    @NotBlank(message = "Preenchimento Obrigatório")
    private String author;

    @NotBlank(message = "Preenchimento Obrigatório")
    @Size(min = 5, max = 100, message = "O tamanho deve ser entre 5 e 100 caracteres.")
    private String comments;
}