@echo off
set JAVA_HOME=C:\Program Files\Microsoft\jdk-21.0.11.10-hotspot
set PATH=%USERPROFILE%\maven\bin;%JAVA_HOME%\bin;%PATH%
echo Starting MEEZAJ backend (dev mode with H2 database)...
cd /d %~dp0
mvn spring-boot:run -Dspring-boot.run.profiles=dev
pause
