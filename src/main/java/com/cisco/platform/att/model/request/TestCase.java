package com.cisco.platform.att.model.request;

import com.cisco.platform.att.model.CustomStep;
import lombok.Data;

@Data
public class TestCase {
    private String title;
    private Integer type_id;
    private Integer priority_id;
    private String estimate;
    private String refs;
    private CustomStep[] custom_steps_separated;

    public TestCase(String testDescription){
        title = testDescription;
        type_id=6;
        priority_id=4;
        estimate="3m";
        refs="RF-1, RF-2";
        custom_steps_separated = new CustomStep[1];
        custom_steps_separated[0] = new CustomStep();
        custom_steps_separated[0].setContent("Step 1");
        custom_steps_separated[0].setExpected("Expected Result");
    }
}
