/*package br.com.yctus.api.comment.service.infraestructure.configurations.web;

import br.com.yctus.api.comment.service.infraestructure.configurations.web.exception.CommentSeviceClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class ApiExceptionHandler  extends ResponseStatusExceptionHandler {

    @ExceptionHandler({
            SocketTimeoutException.class,
            ConnectException.class,
            TimeoutException.class,
            ClosedChannelException.class
    })
    public ProblemDetail handler(IOException ioException) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.GATEWAY_TIMEOUT);
        problemDetail.setTitle("Serviço Indisponível");
        problemDetail.setDetail("O serviço de monitoramento de sensores está indisponível no momento. Por favor, tente novamente mais tarde.");
        problemDetail.setType(URI.create("/erros/gateway-timeout"));
        return problemDetail;
    }

    @ExceptionHandler(CommentSeviceClientException.class)
    public ProblemDetail handleSensorMonitoringClientException(CommentSeviceClientException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.SERVICE_UNAVAILABLE);
        problemDetail.setTitle("Erro no Cliente de Monitoramento de Sensores");
        problemDetail.setDetail("Ocorreu um erro ao comunicar com o serviço de monitoramento de sensores. Por favor, tente novamente mais tarde.");
        problemDetail.setType(URI.create("/erros/bad-gateway"));
        return problemDetail;
    }
}
*/
