*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           SeleniumLibrary

*** Variables ***
${SERVER}         www.google.com
${BROWSER}        Firefox
${DELAY}          0
${SEARCH URL}      http://${SERVER}/

*** Keywords ***
Open Browser To Search Page
    Open Browser    ${SEARCH URL}    ${BROWSER}
    Maximize Browser Window
    Set Selenium Speed    ${DELAY}
    Search Page Should Be Open

Search Page Should Be Open
    Title Should Be    Google 

Input Search Term
    [Arguments]    ${search_term}
    Input Text    q    ${search_term}
    Press Keys  None    ENTER