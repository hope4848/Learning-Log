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
$ ls
- # A file named '-' 
$ cat -
# No response OMG
$ cat ./-
password XD
```
Notes:
- ⚠️ 리눅스에서 Ctrl + D를 누르면 터미널에서 입력이 종료되어 무반응 상태에서 나올 수 있음
- 🤖 -는 쉘에서 옵션으로 해석되기 때문에, '-'라는 이름의 파일을 읽으려면 ./ 같이 경로를 명시해야 함

## Bandit Level 2 -> 3
Goal:
The password for the next level is stored in a file called --spaces in this filename-- located in the home directory

Command:
```bash
$ ls
--spaces in this filename--
$ cat ./--spaces in this filename--
cat: ./--spaces: No such file or directory
cat: in: No such file or directory
cat: this: No such file or directory
cat: filename--: No such file or directory
#Holly Molly
$ cat "--spaces in this filename--"
cat: unrecognized option '--spaces in this filename--'
Try 'cat --help' for more information. #?
#After studying "cat"
$ cat -- "--spaces in this filename--"
password XD
```
Notes:
- ⚠️ cat은 다양한 옵션을 지원한다. 또한 공백이 포함된 파일 이름을 제대로 처리하려면, 파일 이름을 따옴표로 감싸주거나 --를 사용하여 옵션을 무시하고 처리해야 한다.
- 🤖 Good!

## Bandit Level 3 -> 4
Goal:
The password for the next level is stored in a hidden file in the inhere directory.

Command:
```bash
$ ls
inhere
$ cd inhere
$ ls
#no response
$ ls -all
total 12
drwxr-xr-x 2 root    root    4096 Oct 14 09:26 .
drwxr-xr-x 3 root    root    4096 Oct 14 09:26 ..
-rw-r----- 1 bandit4 bandit3   33 Oct 14 09:26 ...Hiding-From-You
#EUREKA
$ cat ./...Hiding-From-You
password XD
```
Notes:
- ⚠️ 리눅스는 파일을 숨길 수도 있구나. 근데 그 숨긴 파일을 명령어로 찾을 수도 있구나!
- 🤖 ls 명령어에서 반응이 없을 때 숨겨진 파일을 확인하려면 ls -a를 사용하면 된다. ls -all도 좋지만 ls -a가 표준 옵션이다.

## Bandit Level 4 -> 5 
Goal:
The password for the next level is stored in the only human-readable file in the inhere directory.

Command:
```bash
$ ls
inhere
$ cd inhere
$ ls
-file00  -file01  -file02  -file03  -file04  -file05  -file06  -file07  -file08  -file09
$ cat ./-file00
�6);/:ˋd�Jhpr��}�k'�� #Hoooooooooooly, wait... human-readable? => text?
$ file ./*
./-file00: data
./-file01: data
./-file02: data
./-file03: data
./-file04: data
./-file05: data
./-file06: data
./-file07: ASCII text
./-file08: data
./-file09: data
#EUREKA
$ cat ./-file07
password XD
```
Notes:
- ⚠️ ASCII text가 뭐지? 왜 이것만 인간이 읽을 수 있지?
- 🤖 ASCII text는 American Standard Code for Information Interchange의 약자이며, 일반적인 텍스트 파일 형식 중 하나. 사람이 쉽게 읽을 수 있는 문자들만 포함, 각 문자는 7비트로 표현 ASCII는 영문 알파벳, 숫자, 구두점, 그리고 기타 제어 문자들만 지원함.
- 🤖 ASCII text 외의 파일들은 바이너리 파일이거나 특수한 형식으로 저장되어 있어서, 사람이 읽기에 그 내용이 이해되지 않거나 무작위의 데이터로 보일 수 있음.
- 🤖 사람이 읽을 수 있는 파일 : 텍스트 파일(.txt .csv .log), 마크업 언어 파일(.html .xml), 스크립트 파일(.sh .py), 소스 코드 파일(.c .java .js) 등
  
_Date 2025-12-17_
