package com.cisco.platform.att.model.request;

import com.cisco.platform.att.utils.TestRailUtility.TestRailConstants;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestRun {

    private Integer suite_id;
    private String name;
    private String refs;
    private Boolean include_all;
    private List<Integer> case_ids;

    public TestRun(String testRunName,Integer caseID) {
        name = testRunName;
        suite_id = Integer.parseInt(TestRailConstants.DEFAULT_SUITE_ID.value());
        refs= "SAN-1, SAN-2";
        include_all=false;
        case_ids = new ArrayList<>();
        case_ids.add(caseID);
    }
}
