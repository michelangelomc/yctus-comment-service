package br.com.yctus.api.comment.service.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class commentsController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createComment() {
        return "Create comment";
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