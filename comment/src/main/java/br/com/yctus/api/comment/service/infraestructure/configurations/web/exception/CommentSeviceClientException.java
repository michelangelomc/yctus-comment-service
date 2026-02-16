package br.com.yctus.api.comment.service.infraestructure.configurations.web.exception;

public class CommentSeviceClientException extends RuntimeException {

    public CommentSeviceClientException() {
        super();
    }

    public CommentSeviceClientException(String message) {
        super(message);
    }

    public CommentSeviceClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
