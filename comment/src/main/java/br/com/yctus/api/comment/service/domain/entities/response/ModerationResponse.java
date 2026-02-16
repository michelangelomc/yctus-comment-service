package br.com.yctus.api.comment.service.domain.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModerationResponse {

    @JsonProperty("isApproved")
    private boolean isApproved;

    @JsonProperty("reasonDescription")
    private String reasonDescription;
}
