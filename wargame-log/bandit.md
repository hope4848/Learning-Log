## Bandit Level 0 -> 1

Command:
```bash
ssh bandit@bandit.labs.overthewire.org -p 2220
cat readme
```
Notes:
- ⚠️윈도우랑 달리 리눅스 SSH 환경에서는 비밀번호를 입력해도 화면에 표시되지 않음
- 🤖보안을 위해 SSH에서는 비밀번호 입력이 화면에 표시되지 않음

_Date : 2025 - 12 - 15_

## Bandit Level 1 -> 2
Goal:
The password for the next level is stored in a file called - located in the home directory

Command:
```bash
$ls
- # A file named '-' 
cat -
# No response OMG
cat ./-
password XD
```
Notes:
- ⚠️ 리눅스에서 Ctrl + D를 누르면 터미널에서 입력이 종료되어 무반응 상태에서 나올 수 있음
- 🤖 -는 쉘에서 옵션으로 해석되기 때문에, '-'라는 이름의 파일을 읽으려면 ./ 같이 경로를 명시해야 함
