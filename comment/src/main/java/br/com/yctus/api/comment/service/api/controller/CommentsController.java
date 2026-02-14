package br.com.yctus.api.comment.service.api.controller;

import br.com.yctus.api.comment.service.domain.entities.request.CommentRequest;
import br.com.yctus.api.comment.service.domain.entities.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentsController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest) {
        return CommentResponse.builder()
                .feedback("Comment created for postId: " + commentRequest.postId)
                .error(" - ")
                .build();
    }

    @GetMapping
    public Page<CommentResponse> getAllComments(@PageableDefault Pageable pageable) {
        List<CommentResponse> comments =
                Arrays.asList(
                        CommentResponse.builder()
                                .feedback("Comment with id: 1254")
                                .error(" - ")
                                .build(),
                        CommentResponse.builder()
                                .feedback("Comment with id: 125478" )
                                .error(" - ")
                                .build());

        return new PageImpl<>(comments, pageable, comments.size());
    }


    @GetMapping("{id}")
    public CommentResponse getCommentById(@PathVariable long id) {
        return CommentResponse.builder()
                .feedback("Comment with id: " + id)
                .error(" - ")
                .build();
    }
}