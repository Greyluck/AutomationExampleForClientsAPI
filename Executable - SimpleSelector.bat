@ECHO off
cls

:start
echo ==============================================
echo Automatic Test Executable by Emilio Ontiveros
echo ==============================================
cd Project\AutomaticTestForDemo
ECHO. 

:SELECTOR
ECHO Choose the number of the test you want to execute
ECHO  1 - Execute API test (API REST)
ECHO. 
set choice=
set /p choice=Type the number to print text, an press enter 
if not '%choice%'=='' set choice=%choice:~0,1%
if '%choice%'=='1' goto API
ECHO "%choice%" is not valid, try again
ECHO.
goto selector

:API
ECHO Executing just API test 
call mvn clean install test -Dtest=AppTest
goto selector

:end
goto start