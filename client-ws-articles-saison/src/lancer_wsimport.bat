REM click droit open with text editor pour saisir contenu .bat sous eclipse
REM click droit open with system editor pour lancer execution du .bat sous eclipse

cd /d "%~dp0"
set WSDL_URL=http://localhost:7878/articlesSaison/service/serviceClientArticleSaison?wsdl
wsimport -keep -d ./main/java %WSDL_URL%

REM le serveur doit �tre d�marr� pour que ?wsdl soit accessible
REM effectuer un "refresh" sour eclipse sur le projet clientWS

pause