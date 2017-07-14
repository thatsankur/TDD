# TDD
 Android TDD Demo using Unit Test (Junit), Robolectric(Integration) , Android UI Integration Test(Espresso) and Publising reports on sonarqube 


Use 

./gradlew clean jacocoTestReport sonarqube 

To Execute 

1) AndroidTest(An Running emulator or connected device is required)
2) Roboelectric and Junit Test (this will run on system vm)

and this will generate .exec and .ec report files which will be uploaded to sonarqube instance (localhost running on same matchine ) download from https://www.sonarqube.org/
