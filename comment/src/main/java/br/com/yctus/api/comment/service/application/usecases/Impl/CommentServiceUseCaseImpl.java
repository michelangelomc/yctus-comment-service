package br.com.yctus.api.comment.service.application.usecases.Impl;

import br.com.yctus.api.comment.service.application.usecases.CommentServiceUseCase;
import br.com.yctus.api.comment.service.domain.entities.model.CommentService;
import br.com.yctus.api.comment.service.domain.entities.model.CommentServiceID;
import br.com.yctus.api.comment.service.domain.entities.request.CommentRequest;
import br.com.yctus.api.comment.service.domain.entities.request.ModerationRequest;
import br.com.yctus.api.comment.service.domain.entities.response.CommentResponse;
import br.com.yctus.api.comment.service.domain.entities.response.CommentServiceResponse;
import br.com.yctus.api.comment.service.domain.entities.response.ModerationResponse;
import br.com.yctus.api.comment.service.infraestructure.dataproviders.repository.ComentServiceRepository;
import br.com.yctus.api.comment.service.infraestructure.dataproviders.services.ModerationServices;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CommentServiceUseCaseImpl implements CommentServiceUseCase {

    private ComentServiceRepository comentServiceRepository;
    private ModerationServices moderationServices;

    @Override
    public CommentResponse createComment(CommentRequest commentRequest) {
        ModerationResponse response =  new ModerationResponse();

        try {
            ModerationRequest request = ModerationRequest.builder()
                    .postId(commentRequest.getPostId().toString())
                    .comments(commentRequest.getComments())
                    .build();

            response = moderationServices.moderationRequest(request);

            if (response.isApproved()) {

                CommentResponse.builder()
                        .feedback(response.getReasonDescription())
                        .error(response.isApproved() ? " - " : "Comentário contem conteúdo impróprio")
                        .build();

                UUID id = commentRequest.getPostId();
                CommentService commnentService = CommentService.builder()
                        .id(new CommentServiceID(id))
                        .commentDescription(commentRequest.getComments())
                        .author(commentRequest.getAuthor())
                        .createdAt(OffsetDateTime.now())
                        .build();


                comentServiceRepository.saveAndFlush(commnentService);

                return CommentResponse.builder()
                        .error(" - ")
                        .feedback(String.format("Comment %s created successfully.", id))
                        .build();
            }

            throw new IllegalArgumentException();

        } catch (IllegalArgumentException ex) {
            return CommentResponse.builder()
                    .error(String.format("Sua mensagem contém palavra(s) de baixo calão: %s", response.getReasonDescription()))
                    .feedback(String.format("Description of the error: %s", ex.getMessage()))
                    .build();
        }
    }

    @Override
    public CommentServiceResponse getCommentById(String id) {
        CommentServiceID newID = new CommentServiceID(id);
        CommentService responses = comentServiceRepository.findById(newID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return CommentServiceResponse.builder()
                .id(newID.getId().toString())
                .commentDescription(responses.getCommentDescription())
                .author(responses.getAuthor())
                .createdAt(responses.getCreatedAt())
                .build();
    }

    @Override
    public Page<CommentServiceResponse> getAllComments(Pageable pageable) {
        return comentServiceRepository.findAll(pageable)
                .map(commentService ->
                        CommentServiceResponse.builder()
                                .id(commentService.getId().toString())
                                .commentDescription(commentService.getCommentDescription())
                                .author(commentService.getAuthor())
                                .createdAt(commentService.getCreatedAt())
                                .build());
    }
}
