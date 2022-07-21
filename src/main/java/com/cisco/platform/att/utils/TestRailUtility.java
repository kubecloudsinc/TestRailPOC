package com.cisco.platform.att.utils;

import com.cisco.platform.att.model.request.TestCase;
import com.cisco.platform.att.model.request.TestCaseResult;
import com.cisco.platform.att.model.request.TestRun;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class TestRailUtility {

    private static APIClient apiClient;
    public static APIClient getAPIClient(){
        if(apiClient==null) {
            apiClient = new APIClient(TestRailConstants.INSTANCE_URL.value);
            apiClient.setUser(TestRailConstants.USER_NAME.value);
            apiClient.setPassword(TestRailConstants.PASSWORD.value);
        }
        return apiClient;
    }
    public static JSONObject getTestCase(String testCaseId) throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendGet(TestRailConstants.GET_TEST_CASE_PATH.value
                        .replace(TestRailConstants.PROJECT_ID.value,testCaseId));
    }

    public static JSONObject getTestRun(String testRunId) throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendGet(TestRailAPIPath.GET_TEST_RUN.value()
                        .replace(TestRailConstants.RUN_ID.value,testRunId));
    }
    public static JSONArray getTestSuites() throws APIException, IOException {
        return (JSONArray) getAPIClient()
                .sendGet(TestRailAPIPath.GET_TEST_SUITES.value()
                        .replace(TestRailConstants.PROJECT_ID.value
                                ,TestRailConstants.DEFAULT_PROJECT_ID.value()));
    }
    public static JSONObject getTestSections() throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendGet(TestRailAPIPath.GET_TEST_SECTIONS.value()
                        .replace(TestRailConstants.PROJECT_ID.value,TestRailConstants.DEFAULT_PROJECT_ID.value())
                        .replace(TestRailConstants.SUITE_ID.value,TestRailConstants.DEFAULT_SUITE_ID.value())
                );
    }
    public static JSONObject getTestCases() throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendGet(TestRailAPIPath.GET_TEST_CASES.value()
                        .replace(TestRailConstants.PROJECT_ID.value,TestRailConstants.DEFAULT_PROJECT_ID.value())
                        .replace(TestRailConstants.SUITE_ID.value,TestRailConstants.DEFAULT_SUITE_ID.value())
                );
    }
    public static JSONObject addResultToCase(Integer testRunID, Integer testCaseID) throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendPost(TestRailAPIPath.ADD_RESULT_FOR_CASE.value()
                        .replace(TestRailConstants.RUN_ID.value,testRunID.toString())
                        .replace(TestRailConstants.CASE_ID.value,testCaseID.toString()),
                        JSONHelper.getJsonMapFromObject(new TestCaseResult())
                );
    }
    public static JSONObject addTestCase(String testTitle) throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendPost(TestRailAPIPath.ADD_TEST_CASE.value()
                        .replace(TestRailConstants.SEC_ID.value,TestRailConstants.DEFAULT_SECTION_ID.value()),
                        JSONHelper.getJsonMapFromObject(new TestCase(testTitle)));
    }
    public static JSONObject addTestRun(String testRunName, Integer testCaseID) throws APIException, IOException {
        return (JSONObject) getAPIClient()
                .sendPost(TestRailAPIPath.ADD_TEST_RUN.value()
                                .replace(TestRailConstants.PROJECT_ID.value,TestRailConstants.DEFAULT_PROJECT_ID.value()),
                        JSONHelper.getJsonMapFromObject(new TestRun(testRunName,testCaseID)));
    }

    public enum TestRailConstants{
        INSTANCE_URL("https://codetestdev.testrail.io"),
        USER_NAME("user@kubecloudsinc.io"),
        PASSWORD("xxxxxxx"),
        GET_TEST_CASE_PATH("/get_case/#####"),
        GET_TEST_RUN_PATH("/get_run/#####"),
        PROJECT_ID("#PRJ-ID#"),
        SUITE_ID("#STE-ID#"),
        SEC_ID("#SEC-ID#"),
        RUN_ID("#RUN-ID#"),
        CASE_ID("#CASE-ID#"),
        DEFAULT_SECTION_ID("24"),
        DEFAULT_SUITE_ID("4"),
        DEFAULT_PROJECT_ID("2");

        private final String value;
        TestRailConstants(String newValue){ value = newValue;}
        public String value(){return value;}
    }
}
