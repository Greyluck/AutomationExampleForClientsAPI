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
ECHO  1 - Execute Game API test (API REST)
ECHO  2 - Execute Food API test (API REST)
ECHO. 
set choice=
set /p choice=Type the number of the suite you want to test, an press enter 
if not '%choice%'=='' set choice=%choice:~0,1%
if '%choice%'=='1' goto GAME
if '%choice%'=='2' goto FOOD
ECHO "%choice%" is not valid, try again
ECHO.
goto selector

:GAME
ECHO Executing just API test 
call mvn clean install test -Dtest=AppTest
goto selector

:FOOD
ECHO Executing just API test 
call mvn clean install test -Dtest=DietTest
goto selector


:end
goto start