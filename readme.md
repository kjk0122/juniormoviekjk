## 1. 초기화 방법
먼저 아래의 3가지를 설치해주셔야합니다.
- Java 11 이상 설치
- Git 설치
- IntelliJ IDEA 설치

그 뒤, IntelliJ IDEA에서 "File" 메뉴 -> "New" -> "Project from Version Control" -> "Git"을 선택하여 프로젝트를 가져옵니다.

## 2. 빌드 방법
프로젝트를 열고, 터미널을 실행하여 다음 명령어를 입력합니다.

    ./gradlew build
## 3. 테스트 방법

1. KjkmovieApplication를 실행해주면 됩니다.
2. API 및 Dto 등 에 대해서는 Swagger를 통해 확인하실 수 있습니다. 


    http://localhost:8080/swagger-ui.html

3. 데이터는 H2 저장소를 통해 확인할수 있습니다.


    http://localhost:8080/h2-console/

아이디:test, 비밀번호는 없이 바로 Connect 눌러주시면 됩니다.
수정 예정

