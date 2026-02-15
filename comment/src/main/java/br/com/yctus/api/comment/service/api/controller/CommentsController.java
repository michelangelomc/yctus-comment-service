package br.com.yctus.api.comment.service.api.controller;

import br.com.yctus.api.comment.service.application.usecases.CommentServiceUseCase;
import br.com.yctus.api.comment.service.domain.entities.request.CommentRequest;
import br.com.yctus.api.comment.service.domain.entities.response.CommentResponse;
import br.com.yctus.api.comment.service.domain.entities.response.CommentServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentServiceUseCase commentServiceUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        return commentServiceUseCase.createComment(commentRequest);
    }

    @GetMapping
    public Page<CommentServiceResponse> getAllComments(@PageableDefault Pageable pageable) {
        return commentServiceUseCase.getAllComments(pageable);
    }

    @GetMapping("{id}")
    public CommentServiceResponse getCommentById(@PathVariable String id) {
        return commentServiceUseCase.getCommentById(id);
    }
}