package com.skypyb.security.model.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skypyb.security.util.Result;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ResultResponse {

    @JsonIgnore
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private Result result;

    public ResultResponse() {
    }

    public ResultResponse(Result result) {
        this.result = result;
    }

    public String toJson() throws IOException {
        return MAPPER.writeValueAsString(result);
    }
}
