@echo off
echo Starting Automated test using executable file
cd Project\AutomaticTestForDemo
call mvn clean install test
cmd /k