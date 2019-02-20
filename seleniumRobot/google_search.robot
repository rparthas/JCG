*** Settings ***
Documentation     A test suite with tests for google search.
...
...               This test has a workflow that is created using keywords in
...               the imported resource file.
Resource          google_resource.robot

*** Test Cases ***
Open Search
    Open Browser To Search Page
    Search Page Should Be Open
    [Teardown]    Close Browser

Search Keyword
    Open Browser To Search Page
    Input Search Term  hi
    [Teardown]    Close Browser

Search Image
    Open Browser To Search Page
    Input Search Term  hi
    Perform Image Search
    [Teardown]    Close Browser