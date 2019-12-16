:runRuncrud.bat
call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openChrome
echo.
echo Running runcrud.bat failed.
goto fail

:openChrome
call "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Opening Chrome failed.
goto fail

:fail
echo.
echo Something failed.
goto end

:end
echo.
echo Task is finished.


