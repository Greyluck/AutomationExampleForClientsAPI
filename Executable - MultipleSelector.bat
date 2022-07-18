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
ECHO  1 - Execute Main tests
ECHO  2 - Execute UI tests
ECHO  3 - Execute Interest tests
ECHO. 
set choice=
set /p choice=Type the number to print text, an press enter
if not '%choice%'=='' set choice=%choice:~0,1%
if '%choice%'=='1' goto MAIN
if '%choice%'=='2' goto UI
if '%choice%'=='3' goto INTEREST
ECHO "%choice%" is not valid, try again
ECHO.
goto selector

:MAIN
ECHO Executing MAIN tests
call mvn clean install test
goto selector

:UI
ECHO Executing just UI test
call mvn clean install test -Dtest=”JustUI”
goto selector

:INTEREST
ECHO Executing just REST tests
call mvn clean install test -Dtest=”Interest”
goto selector

:end
goto start