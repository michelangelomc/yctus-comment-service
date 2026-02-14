package br.com.yctus.api.comment.service.api.controller;

import br.com.yctus.api.comment.service.domain.entities.request.CommentRequest;
import br.com.yctus.api.comment.service.domain.entities.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class commentsController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        return CommentResponse.builder()
                .feedback("Comment created for postId: " + commentRequest.postId)
                .error(" - ")
                .build();
    }

    @GetMapping("{id}")
    public String getCommentById(@PathVariable long id) {
        return "Get comment by id: " + id;
    }

    @GetMapping
    public String getAllComments() {
        return "Get all comments";
    }
}