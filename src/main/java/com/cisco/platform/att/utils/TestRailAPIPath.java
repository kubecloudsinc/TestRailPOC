package com.cisco.platform.att.utils;

public enum TestRailAPIPath {

    GET_TEST_CASE("/get_case/#####"),
    GET_TEST_RUN("/get_run/#RUN-ID#"),
    // project-id
    GET_TEST_SUITES("/get_suites/#####"),
    GET_TEST_SECTIONS("/get_sections/#PRJ-ID#&suite_id=#STE-ID#"),
    GET_TEST_CASES("/get_cases/#PRJ-ID#&suite_id=#STE-ID#"),
    ADD_RESULT_FOR_CASE("/add_result_for_case/#RUN-ID#/#CASE-ID#"),
    ADD_TEST_RUN("/add_run/#PRJ-ID#"),
    ADD_TEST_CASE("/add_case/#SEC-ID#");
    private final String value;
    TestRailAPIPath(String newValue){ value = newValue;}
    public String value(){return value;}
}
