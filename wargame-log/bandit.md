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
password #XD
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
password #XD
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
#(no output)
$ ls -all
total 12
drwxr-xr-x 2 root    root    4096 Oct 14 09:26 .
drwxr-xr-x 3 root    root    4096 Oct 14 09:26 ..
-rw-r----- 1 bandit4 bandit3   33 Oct 14 09:26 ...Hiding-From-You
#EUREKA
$ cat ./...Hiding-From-You
password #XD
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
password #XD
```
Notes:
- ⚠️ ASCII text가 뭐지? 왜 이것만 인간이 읽을 수 있지?
- 🤖 ASCII text는 American Standard Code for Information Interchange의 약자이며, 일반적인 텍스트 파일 형식 중 하나. 사람이 쉽게 읽을 수 있는 문자들만 포함, 각 문자는 7비트로 표현 ASCII는 영문 알파벳, 숫자, 구두점, 그리고 기타 제어 문자들만 지원함.
- 🤖 ASCII text 외의 파일들은 바이너리 파일이거나 특수한 형식으로 저장되어 있어서, 사람이 읽기에 그 내용이 이해되지 않거나 무작위의 데이터로 보일 수 있음.
- 🤖 사람이 읽을 수 있는 파일 : 텍스트 파일(.txt .csv .log), 마크업 언어 파일(.html .xml), 스크립트 파일(.sh .py), 소스 코드 파일(.c .java .js) 등
  
_Date 2025-12-17_


## Bandit Level 5 -> 6 
Goal:
The password for the next level is stored in a file somewhere under the inhere directory and has all of the following properties:
 - human-readable
 - 1033 bytes in size
 - not executable

Command:
```bash
$ cd inhere
$ ls -al
total 88
drwxr-x--- 22 root bandit5 4096 Oct 14 09:26 .
drwxr-xr-x  3 root root    4096 Oct 14 09:26 ..
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere00
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere01
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere02
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere03
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere04
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere05
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere06
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere07
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere08
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere09
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere10
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere11
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere12
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere13
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere14
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere15
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere16
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere17
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere18
drwxr-x---  2 root bandit5 4096 Oct 14 09:26 maybehere19
#Hmm... maybe I should use 'find'

$ find . -type f -size 1033c -readable
./maybehere07/.file2 #Got it
$ cat ./maybere07/.file2
password #XD
```

Notes:
- ⚠️ Find랑 File을 구분 잘해야겠구나.
- 🤖 find . -type f -size 1033c -readable ! -executable (조건 하나 빠짐)
- 🤖 find [어디서] [조건(테스트)] [행동(액션)]
- 🤖 자주 쓰는 조건 : -name(이름), -type(타입), -size(크기)

## Bandit Level 6 -> 7
Goal:The password for the next level is stored somewhere on the server and has all of the following properties:

- owned by user bandit7
- owned by group bandit6
- 33 bytes in size

Command:
```bash
$ find / -user bandit7 -group bandit6 -size 33c #The file could be anywhere, so I searched from root(/)
So many numbers of paths #Hmm...!
$ find / -user bandit7 -group bandit6 -size 33c 2>/dev/null
/var/lib/dpkg/info/bandit7.password #EUREKA
$ cat /var/lib/dpkg/info/bandit7.password
password #XD
```

Notes:
- ⚠️ Find와 같은 명령어 사용시 오류를 제외한 내용을 보고 싶을 때 2>/dev/null을 쓰면 되겠군
- 🤖 find 명령어는 탐색 범위가 넓을수록 권한 오류가 빈번하므로, 2>/dev/null을 함께 사용하는 것이 실전에서 유용하다.

_Date 2025-12-18_

## Bandit Level 7 -> 8
Goal:The password for the next level is stored in the file data.txt next to the word millionth

Command:
```bash
$ ls
data.txt
$ cat data.txt
So many letters......................... #Hollllllllllllllllly My computer almost shut down
$ cat data.txt | grep 'millionth'
millionth      password #XD
```

## Bandit Level 8 -> 9
Goal:The password for the next level is stored in the file data.txt and is the only line of text that occurs only once

Command:
```bash
$ ls
data.txt
$ cat data.txt
so many letters...
$ sort data.txt
#After sorting the file, each line appears ten times, except for one unique line
#So I need to find the line that appears only once
$ sort data.txt | uniq -u
password #EUREKA XD
```

Notes:
- ⚠️ uniq도 많은 옵션이 있음 -u(한 줄) -d(2번 이상 나온 줄) -c(등장 횟수 세기) -i(대소문자 무시), 등
- 🤖 uniq -u는 인접한 중복만 비교하므로, 정확한 결과를 위해 sort와 함께 사용하는 것이 필수다.

## Bandit level 9 -> 10
Goal:The password for the next level is stored in the file data.txt in one of the few human-readable strings, preceded by several ‘=’ characters.

Command:
```bash
$ ls
data.txt
$ cat data.txt
?????????????????? #I couldn't read
$ strings data. txt | grep '='
FB`=
c\5D=
========== the
?/=l
=Uc1
=vG*2P
========== password
k=ezG
E========== is
=%r_
.?=Dm
O&A=n
5========== ***********************
=*^Y
=L3jT
q<=,
'QHE=
+=NBf
#XD
```

## Bandit Level 10 -> 11
Goal:The password for the next level is stored in the file data.txt, which contains base64 encoded data

Command:
```bash
$ ls
data.txt
$ cat data.txt
VGhlIHBhc3N3b3JkIGlzIGR0UjE3M2ZaS2IwUlJzREZTR3NnMlJXbnBOVmozcVJyCg== #I should try to decode it.
$ base64 -d data.txt
The password is *********** #XD
```

Notes:
 - ⚠️ 만약 base64라는게 주어지지 않아도 base64로 인코딩 되어 있는 걸 어떻게 알 수 있을까?
 - 🤖 base64는 쓸 수 있는 문자셋이 제한됨(A-Z, a-z, 0-9 + /) 그리고 패딩으로 = 또는 == 즉 특수문자가 섞이면 base64 아님
 - 🤖 또한 base64 문자열 길이는 항상 4의 배수, 끝에 = 또는 ==로 길이 맞춤

## Bandit Level 11 -> 12
Goal:The password for the next level is stored in the file data.txt, where all lowercase (a-z) and uppercase (A-Z) letters have been rotated by 13 positions

Command:
```bash
$ ls
data.txt
$ cat data.txt
Gur cnffjbeq vf 7k16JArUVv5LxVuJfsSVdbbtaHGlw9D4 # I should try to translate it.
$ cat data.txt | tr 'A-Za-z' 'N-ZA-Mn-za-m'
The password is ****************** #Goooooooooood
```

Notes:
 - ⚠️ 인코딩 방식이 매우 다양하다는 걸 체감했다. 이후 암호나 인코딩을 마주쳤을 때 정확히 구분하려면 개념 정리가 필수!!!
 - 🤖 인코딩은 base64 계열, 문자 치환 계열, 문자 체계, 압축+인코딩, CTF용 변형 등으로 나뉘며, 유형별로 접근해야 한다.

## Bandit Level 12 -> 13
Goal: The password for the next level is stored in the file data.txt, which is a hexdump of a file that has been repeatedly compressed. For this level it may be useful to create a directory under /tmp in which you can work.

Command:
```bash
$ ls
data.txt
$ cat data.txt
00000000: 1f8b 0808 2817 ee68 0203 6461 7461 322e 
...etc # # I looked up hexdump and compression formats (gzip, bzip2, tar, xxd).
$ cd /tmp/hope
$ cp ~/data.txt .
$ xxd -r data.txt data
$ ls
data data.txt
$ file data
data: gzip compressed data, was "data2.bin", last modified: Tue Oct 14 09:26:00 2025, max compression, from Unix, original size modulo 2^32 572 # I got it!
$ mv data data.gz # To use gzip, I renamed the file
$ gunzip data.gz
$ ls
data data.txt
$ file data
data: bzip2 compressed data, block size = 900k # I got it!
$ mv data data.bz2 # To use bunzip2, I renamed the file
$ bunzip2 data.bz2
$ ls
data data.txt
$ file data
data: gzip compressed data, was "data4.bin", last modified: Tue Oct 14 09:26:00 2025, max compression, from Unix, original size modulo 2^32 20480
$ mv data data.gz
$ gunzip data.gz
$ ls
data data.txt
$ file data
data: POSIX tar archive (GNU)
$ tar -xf data
$ ls
data data5.bin data.txt
$ file data5.bin
data5.bin: POSIX tar archive (GNU)
$ tar -xf data5.bin
$ ls
data data5.bin data6.bin data.txt
$ file data6.bin
data6.bin: bzip2 compressed data, block size = 900k
$ mv data6.bin data6.bz2
$ bunzip2 data6.bz2
$ ls
data data5.bin data6 data.txt
$ file data6
data6: POSIX tar archive (GNU)
$ tar -xf data6
$ ls
data  data5.bin  data6  data8.bin  data.txt
$ file data8.bin
data8.bin: gzip compressed data, was "data9.bin", last modified: Tue Oct 14 09:26:00 2025, max compression, from Unix, original size modulo 2^32 49
$ mv data8.bin data8.gz
$ gunzip data8.gz
$ ls
data  data5.bin  data6  data8  data.txt
$ file data8
data8: ASCII text # YES!!! EUREKA!!!
$ cat data8
The password is ******************* 
```

Notes:
 - ⚠️ 솔직히 이정도면 실제에선 난이도 매우 쉬움이겠지? 나중에 이것 보다 훨씬 더 복잡한 파일을 다루게 되겠지?
 - 🤖 실무 기준에선 입문 난이도지만, 파일 정체를 판별하고 단계별로 검증하는 지금의 접근 방식은 이후 훨씬 복잡한 파일 분석에서도 그대로 쓰이는 핵심 루틴임

_Date 2025-12-19_
