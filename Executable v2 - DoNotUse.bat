@echo off
title Automated Maven Tester
pause

title Automated Maven Tester - Executing
echo Starting Automated test using executable file
echo This test has started >> ./Results.txt
cd Project\AutomaticTestForDemo
mvn test

title Automated Maven Tester - Finished
echo This test has reached its end >> ./Results.txt
pause >nul