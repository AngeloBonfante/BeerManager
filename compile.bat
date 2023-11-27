@echo off

set SOURCE_DIR=src
set OUTPUT_DIR=out
set CLASSPATH=%SOURCE_DIR%

if not exist %OUTPUT_DIR% mkdir %OUTPUT_DIR%

for /r %SOURCE_DIR% %%f in (*.java) do (
    javac -d %OUTPUT_DIR% -cp %CLASSPATH% %%f
)

if %errorlevel% equ 0 (
    echo Compilation successful
) else (
    echo Compilation failed
)