package br.com.yctus.api.comment.service.application.usecases;

import br.com.yctus.api.comment.service.domain.entities.request.CommentRequest;
import br.com.yctus.api.comment.service.domain.entities.response.CommentResponse;
import br.com.yctus.api.comment.service.domain.entities.response.CommentServiceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface CommentServiceUseCase {
    CommentResponse createComment(CommentRequest commentRequest);
    CommentServiceResponse getCommentById(String id);
    Page<CommentServiceResponse> getAllComments(@PageableDefault Pageable pageable);
}