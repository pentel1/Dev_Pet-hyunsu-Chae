# Dev_Pet-hyunsu-Chae_Blog
## 기술 스택
 * Java8
 * Android Studio
 * Cloud Firestore
 
## 개인 주제
 * 3가지 주제 중 Blog주제를 발전시켜 기존의 1:N 방식의 통신이 아닌 N:N 방식의 통신을 구현한 앱을 제작
 
### 앱 구조
![앱 구조](https://user-images.githubusercontent.com/108280167/209457505-23b06a23-4e53-4e0b-8529-4908c91a905e.png)
***

### 사용 아키텍처 (클린아키텍처와 MVP를 결합)
![클린 아키텍처](https://user-images.githubusercontent.com/108280167/209457878-bf456bf0-10fd-437e-b9fb-df2e4290cc71.png)
***
            

### 진행도
 * 전체적인 뷰 화면
    * ~메인화면(개인 시간표, 참여하는 방 리스트)~
    * ~시간표 제작화면~(~고정 일정표~, 추가 일정표)
    * ~참여 방 화면(공유 시간표, 최근 채팅 내역, 채팅방, 방 참여인원 리스트)~
 
 * 시간표
    * ~고정시간표 제작 후 갱신~ 및 저장
    * 추가 시간표 제작 후 고정시간표에 추가 및 저장
    * ~시간표를 메인 상태와 리스트 상태로 나누는 알고리즘~
     
 * 방
    * ~방 생성~ 및 저장
    * 팀원 초대 및 강퇴 기능
    * 채팅방 채팅 기능
    * 합쳐진 시간표에서 해당 팀원들을 제외하고 보여주는 기능
    * 방장이 방 인원의 시간표에 공통된 일정을 추가하는 기능
 
 
 ### 코드 중 확인받고 싶은 부분
  * 데이터를 저장하기 위해 Presentation -> Domain -> Data로 접근하는 과정에서 Domain 레이어와 Data 레이어의 Repository 부분의 구현에 어려움을 겪고 있습니다.   
  Domain 레이어에서 Data 레이어로 접근하는 방법 혹은 Domain 레이어가 아닌 Presentation 레이어에서 Data 레이어로 바로 접근하는 것인지 알고 싶습니다.
  * 인터페이스와 전체적인 파일 이름에서 해당 내용들을 어느 정도까지 유추할 수 있는지 확인받고 싶습니다.
  
 ### 개발관련 과정에서 궁금했던 부분 등
  * 아키텍처를 처음 적용해 보았습니다. 이런 방식으로 분리하는 게 맞는지 궁금합니다.
  * 서버에서 데이터를 가져오는 과정에서 예상 시간보다 더 오래 걸릴 경우 어떤 방식으로 해결하는지 궁금합니다.   
  이 프로젝트에서는 무한 반복문을 통해 데이터를 가져올 때까지 다음 코드를 실행하지 않았습니다. 
  
  
  


