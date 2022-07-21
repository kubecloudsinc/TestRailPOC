package com.cisco.platform.att.model.request;

import lombok.Data;

@Data
public class TestCaseResult {
    private Integer status_id;
    private String comment;
    private String elapsed;
    private String defects;
    private String version;

    public TestCaseResult(){
        status_id=1;
    }
}
