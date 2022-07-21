package com.tests;

import com.cisco.platform.att.utils.TestRailUtility;
import com.examples.Calculator;
import com.gurock.testrail.APIException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAddition {

    Calculator aCalculator;
    @BeforeTest
    public void setUp(){
        aCalculator = new Calculator();

    }
    @Test
    public void testAddTwoPositiveNumbers() throws APIException, IOException {
        Assert.assertEquals(aCalculator.add(5,3), 8);
        // test case creation
        // test run creation
        // add test case to test run
        // update test result
//        JSONObject jsonObj = TestRailUtility.getTestRun("32");
//        TestRailUtility.getTestCase("328");
//        System.out.println("the project id is: "+testRun.get("project_id"));
//          JSONArray testSuites = TestRailUtility.getTestSuites();
//          JSONObject testSections = TestRailUtility.getTestSections();
//          JSONObject jsonObj = TestRailUtility.getTestCases();
        JSONObject jsonObj = TestRailUtility.addTestCase("AddPositiveNumbers");
        Integer testCaseID = Integer.parseInt(jsonObj.get("id").toString());
        jsonObj = TestRailUtility.addTestRun("New Test run",testCaseID);
        Integer testRunID = Integer.parseInt(jsonObj.get("id").toString());
        System.out.println(jsonObj.toJSONString());
        jsonObj = TestRailUtility.addResultToCase(testRunID, testCaseID);

    }
}
