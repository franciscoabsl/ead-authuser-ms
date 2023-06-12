package com.ead.authuser.dtos;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.data.domain.*;

import java.util.*;

public class ResponsePageDto<T> extends PageImpl<T> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ResponsePageDto(
            @JsonProperty("content") List<T> content,
            @JsonProperty("number") int number,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") Long totalElements,
            @JsonProperty("pageable") JsonNode pageable,
            @JsonProperty("last") boolean last,
            @JsonProperty("totalPages") int totalPages,
            @JsonProperty("sort") JsonNode sort,
            @JsonProperty("first") boolean first,
            @JsonProperty("empty") boolean empty
            ) {
        super(content, PageRequest.of(number, size), totalElements);
    }

    public ResponsePageDto(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public ResponsePageDto(List<T> content) {
        super(content);
    }
}
