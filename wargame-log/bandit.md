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

## Bandit Level 13 -> 14
Goal:The password for the next level is stored in /etc/bandit_pass/bandit14 and can only be read by user bandit14.

Command:
```bash
$ ls
sshkey.private
$ cat sshkey.private
-----BEGIN RSA PRIVATE KEY-----
***************************************
-----END RSA PRIVATE KEY-----
# I will use this key on my local machine
$ exit
$ nano sshkey.private # Copy the private key from bandit13 to local
$ chmod 600 sshkey.private # SSH requires this permission
$ ssh -i sshkey.private bandit14@bandit.labs.overthewire.org -p 2220
# connection sucess
$ cat /etc/bandit_pass/bandit14
password #XD
```

Notes:
 - ⚠️ SSH는 개인키가 소유자만 접근 가능할 때만 신뢰하며 이를 보장하기 위해 chmod 600을 요구하는구나
 - 🤖 이 단계의 핵심은 권한이 아닌 신뢰이며, SSH는 개인키가 오직 소유자만 접근 가능할 때만 인증 수단으로 받아들인다.

## Bandit Level 14 -> 15
Goal:The password for the next level can be retrieved by submitting the password of the current level to port 30000 on localhost.

Command:
```bash
$ nc localhost 30000
$ current password
password #EASY!
```

Notes:
 - 🤖 nc는 포트로 입력을 전달해 결과를 받는 가장 단순한 네트워크 도구다.

## Bandit Level 15 -> 16
Goal:The password for the next level can be retrieved by submitting the password of the current level to port 30001 on localhost using SSL/TLS encryption.

Command:
```bash
$ ncat --ssl localhost 30001
$ current password
password #EASY!
```

Notes:
 - 🤖 SSL/TLS가 필요한 서비스는 평문 nc가 아닌 --ssl 옵션으로 통신해야 한다.

## Bandit Level 16 -> 17
Goal:The credentials for the next level can be retrieved by submitting the password of the current level to a port on localhost in the range 31000 to 32000. First find out which of these ports have a server listening on them. Then find out which of those speak SSL/TLS and which don’t. There is only 1 server that will give the next credentials, the others will simply send back to you whatever you send to it.

Command:
```bash
$ nmap localhost -p 31000-32000
Starting Nmap 7.94SVN ( https://nmap.org ) at 2025-12-19 02:17 UTC
Nmap scan report for localhost (127.0.0.1)
Host is up (0.00016s latency).
Not shown: 996 closed tcp ports (conn-refused)
PORT      STATE SERVICE
31046/tcp open  unknown
31518/tcp open  unknown
31691/tcp open  unknown
31790/tcp open  unknown
31960/tcp open  unknown

#Hmm... The initial scan only showed open ports without service details
#So I used -sV to identify which services were running on each port

$ nmap -sV localhost -p 31000-32000
Nmap scan report for localhost (127.0.0.1)
Host is up (0.00017s latency).
Not shown: 996 closed tcp ports (conn-refused)
PORT      STATE SERVICE     VERSION
31046/tcp open  echo
31518/tcp open  ssl/echo
31691/tcp open  echo
31790/tcp open  ssl/unknown
31960/tcp open  echo

$ ncat --ssl localhost 31518
$ current password
current password # Next!

$ ncat --ssl localhost 31790
$ current password
-----BEGIN RSA PRIVATE KEY-----
**********************************
-----END RSA PRIVATE KEY-----
# EUREKA
```

Notes:
 - ⚠️ nmap으로 열린 포트를 확인하고 ncat으로 서비스를 식별하는게 이 단계의 핵심이었을까?
 - 🤖 이 단계의 핵심은 포트 개수를 줄이는 것이 아니라, nmap으로 후보를 걸러낸 뒤 ncat으로 실제로 어떤 서비스가 응답하는지 검증하는 데 있다.

## Bandit Level 17 -> 18
Goal:There are 2 files in the homedirectory: passwords.old and passwords.new. The password for the next level is in passwords.new and is the only line that has been changed between passwords.old and passwords.new

Command:
```bash
$ ls
passwords.new  passwords.old
$ diff passwords.new passwords.old
< password
---
> different letters
# I got it!
```

Notes:
 - ⚠️ 문서를 비교할 땐 diff 명령어를 쓰면 좋겠군
 - 🤖 diff 옵션에는 -u(유니파이드 포맷, 가독성 최고), -y(좌우 나란히 비교) -q(다른지만 알려줌, 내용 안보여줌)이 있다
 - 🤖 -b(연속된 공백 무시), -w(모든 공백 무시), -i(대소문자 무시)

## Bandit Level 18 -> 19
Goal:The password for the next level is stored in a file readme in the homedirectory. Unfortunately, someone has modified .bashrc to log you out when you log in with SSH.

Command:
```bash
$ ssh bandit18@bandit.labs.overthewire.org -p 2220
$ password
Byebye !

#Hmm.. the session exits immediately, so the command must be executed during SSH login

$ ssh bandit18@bandit.labs.overthewire.org -p 2220 cat readme
password #XD
```

Notes:
 - ⚠️.bashrc는 로그인 시 자동 실행되며, 세션을 강제로 종료할 수 있음
 - 🤖 SSH는 원격 명령을 인자로 전달하면 비대화식(non-interactive) 실행이 가능
 - ⚠️ ssh bandit18@bandit.labs.overthewire.org -p 2220 | cat readme 이건 왜 안될까?
 - 🤖 | cat readme는 로컬에서 실행되고, ssh는 원격에서 실행됨.
 - 🤖 즉 [원격 SSH 로그인 결과(stdout)] ──▶ [로컬 cat readme]
 - 🤖 파이프(|)의 본질은 항상 '앞 명령의 출력' -> '뒤 명령의 표준입력' 임!

## Bandit Level 19 -> 20
Goal:To gain access to the next level, you should use the setuid binary in the homedirectory. Execute it without arguments to find out how to use it. The password for this level can be found in the usual place (/etc/bandit_pass), after you have used the setuid binary.

Command:
```bash
$ ls
bandit20-do
$ ./bandit20-do 
Run a command as another user.
  Example: ./bandit20-do whoami
$ whoami
bandit19
$ ./bandit20-do whoami
bandit20 # I got it!
$ ./bandit20-do cat /etc/bandit_pass/bandit20
password #XD
```

Notes:
 - ⚠️ setuid 바이너리는 실행한 사용자가 아니라 파일 소유자의 권한으로 명령을 실행한다는 점이 이 단계의 핵심인듯
 - 🤖 setuid 바이너리는 실행한 사용자가 아니라 파일 소유자의 권한으로 명령을 수행하게 만드는 메커니즘이다.

## Bandit Level 20 -> 21
Goal:There is a setuid binary in the homedirectory that does the following: it makes a connection to localhost on the port you specify as a commandline argument. It then reads a line of text from the connection and compares it to the password in the previous level (bandit20). If the password is correct, it will transmit the password for the next level (bandit21).

Command:
```bash
# I opened another cloud shell tab
$1 nc -l 3333
$2 ./suconnect 3333
$1 current password
$1 password
$2 Read : currentpassword
Password matches, sending next password #Goood
```

Notes:
 - ⚠️ 이 단계는 setuid 바이너리가 네트워크로 받은 입력을 검증한 뒤 조건이 맞으면 정보를 주는 것이 핵심인듯
 - 🤖 이 단계는 setuid 권한과 로컬 네트워크 통신이 결합되면 입력 하나로도 권한 경계가 넘어갈 수 있음을 보여준다.

_Date 2025-12-19_ #20단계까지 CLEAR! 하지만 갈 길이 멀다!!!


## Bandit Level 21 -> 22
Goal:A program is running automatically at regular intervals from cron, the time-based job scheduler. Look in /etc/cron.d/ for the configuration and see what command is being executed.

Command:
```bash
$ cd /etc/cron.d
$ ls
behemoth4_cleanup  cronjob_bandit22  cronjob_bandit24  leviathan5_cleanup    otw-tmp-dir
clean_tmp          cronjob_bandit23  e2scrub_all       manpage3_resetpw_job  sysstat
$ cat cronjob_bandit22
@reboot bandit22 /usr/bin/cronjob_bandit22.sh &> /dev/null
* * * * * bandit22 /usr/bin/cronjob_bandit22.sh &> /dev/null
$ cat /usr/bin/cronjob_bandit22.sh
#!/bin/bash
chmod 644 /tmp/t7O6lds9S0RqQh9aMcz6ShpAoZKF7fgv
cat /etc/bandit_pass/bandit22 > /tmp/t7O6lds9S0RqQh9aMcz6ShpAoZKF7fgv
#So, the password is stored in this path!
$ cat /tmp/t7O6lds9S0RqQh9aMcz6ShpAoZKF7fgv
password #XD
```

Notes:
 - ⚠️ cron이 뭐야?
 - 🤖 cron은 일정 시간마다 자동으로 명령이나 스크립트를 실행해주는 리눅스 스케줄러라, 이 레벨에서는 그 자동 실행 스크립트를 이용해 비밀번호가 저장되는 파일을 찾아 읽는 것이 핵심이다.

## Bandit Level 22 -> 23
Goal:A program is running automatically at regular intervals from cron, the time-based job scheduler. Look in /etc/cron.d/ for the configuration and see what command is being executed.

Command:
```bash
$ cd /etc/cron.d
$ cat cronjob_bandit23
@reboot bandit23 /usr/bin/cronjob_bandit23.sh  &> /dev/null
* * * * * bandit23 /usr/bin/cronjob_bandit23.sh  &> /dev/null
$ cat /usr/bin/cronjob_bandit23.sh
#!/bin/bash

myname=$(whoami)
mytarget=$(echo I am user $myname | md5sum | cut -d ' ' -f 1)

echo "Copying passwordfile /etc/bandit_pass/$myname to /tmp/$mytarget"

cat /etc/bandit_pass/$myname > /tmp/$mytarget

$ whoami
bandit22
#I have to find the password of bandit23, so I change my name bandit23!
$ myname=bandit23
$ mytarget=$(echo I am user bandit23 | md5sum | cut -d ' ' -f 1)
$ cat /tmp/$mytarget
password #XD!
```

Notes:
 - ⚠️ | md5sum | cut -d ' ' -f 1)은 머임?
 - 🤖 | md5sum | cut -d ' ' -f 1 은 문자열을 MD5 해시로 변환한 뒤, 공백 기준으로 잘라 첫 번째 필드만 추출해서 깔끔한 해시 값만 사용하도록 만드는 과정이다.

## Bandit Level 23 -> 24
Goal:A program is running automatically at regular intervals from cron, the time-based job scheduler. Look in /etc/cron.d/ for the configuration and see what command is being executed.

Command:
```bash
$ cd /etc/cron.d
$ cat cronjob_bandit24
@reboot bandit24 /usr/bin/cronjob_bandit24.sh &> /dev/null
* * * * * bandit24 /usr/bin/cronjob_bandit24.sh &> /dev/null
$ cat /usr/bin/cronjob_bandit24.sh
#!/bin/bash

myname=$(whoami)

cd /var/spool/$myname/foo
echo "Executing and deleting all scripts in /var/spool/$myname/foo:"
for i in * .*;
do
    if [ "$i" != "." -a "$i" != ".." ];
    then
        echo "Handling $i"
        owner="$(stat --format "%U" ./$i)"
        if [ "${owner}" = "bandit23" ]; then
            timeout -s 9 60 ./$i
        fi
        rm -f ./$i
    fi
done
# This cron job executes every file inside that directory and then deletes them.
# So I need to create a script that extracts the password and place it in that path so the cron job will execute it for me.
$ cd /tmp
$ mkdir hope
$ cd hope
$ nano script.sh
#!/bin/bash
cat /etc/bandit_pass/bandit24 > /tmp/hope
#saved!
$ ls -l script.sh
-rw-rw-r-- 1 bandit23 bandit23 54 Dec 25 23:27 script.sh
$ chmod o+wx script.sh #Because an external file needs to be placed here, I have to grant write permission to others.
$ cp script.sh /var/spool/bandit24/foo
#Wait a moment
$ ls
script.sh #Wait... what?
$ ls
script.sh
$ ls
script.sh #OMG wait....! Oh I forgot to specify the filename!!!!!! HOLLLLLLLLLLLLLLLY
$ nano
#!/bin/bash
cat /etc/bandit_pass/bandit24 > /tmp/hope/bandit24
#saved
$ chmod 777 script.sh
$ mv script.sh /var/spool/bandit24/foo #SPEEEEEEEEEEEED
#Wait a moment!
$ ls
banddit24
$ cat bandit24
password #Correct!!!!
```

Notes:
 - ⚠️ 너무 다급해서 내가 뭘한지 모르겠다 ㅠ.ㅠ 복습해야겠다.
 - 🤖 chmod 777 은 모든 사용자에게 읽기·쓰기·실행 권한을 전부 열어주는 위험한 설정으로, 보안 환경에서는 불필요한 권한 확장을 초래할 수 있기 때문에 실제 운영 환경에서는 권장되지 않는다. 이 문제에서는 실행만 필요하므로 chmod +x 정도면 충분하다.
_Date 2025-12-26_


## Bandit Level 23 -> 24 
Goal:A program is running automatically at regular intervals from cron, the time-based job scheduler. Look in /etc/cron.d/ for the configuration and see what command is being executed.

Command:
```bash
$ cat /etc/cron.d/cronjob_bandit24
@reboot bandit24 /usr/bin/cronjob_bandit24.sh &> /dev/null
* * * * * bandit24 /usr/bin/cronjob_bandit24.sh &> /dev/null
$ cat /usr/bin/cronjob_bandit24.sh
#!/bin/bash

myname=$(whoami)

cd /var/spool/$myname/foo
echo "Executing and deleting all scripts in /var/spool/$myname/foo:"
for i in * .*;
do
    if [ "$i" != "." -a "$i" != ".." ];
    then
        echo "Handling $i"
        owner="$(stat --format "%U" ./$i)"
        if [ "${owner}" = "bandit23" ]; then
            timeout -s 9 60 ./$i
        fi
        rm -f ./$i
    fi
done
$ cd /tmp
$ mkdir hope
$ cd hope
$ nano script.sh
#!/bin/bash
cat /etc/bandit_pass/bandit24 > /tmp/hope/bandit24
$ chmod o+w script.sh
$ ls -al
total 10020
drwxrwxr-x   2 bandit23 bandit23     4096 Dec 29 03:08 .
drwxrwx-wt 528 root     root     10244096 Dec 29 03:08 ..
-rw-rw-rw-   1 bandit23 bandit23       63 Dec 29 03:08 script.sh
$ chmod o+w /tmp/hope
$ ls -ld
drwxrwxrwx 2 bandit23 bandit23 4096 Dec 29 03:08 .
$ cp script.sh /var/spool/bandit24/foo
# Nothing happened!
# OH I forgot the execution permission!
$ chmod o+x script.sh
$ cp script.sh /var/spool/bandit24/foo
# Wait a moment
$ ls
bandit24 script.sh
$ cat bandit24
password #XD!
```

Notes:
 - ⚠️ 파일 생성 혹은 활용시 권한 항상 확인하기!
 - 🤖 cron 실행 사용자 권한, 파일 소유자 조건, 실행 권한 여부, 출력 경로 접근 권한까지 단계별로 다시 점검할 것

## Bandit Level 24 -> 25
Goal: A daemon is listening on port 30002 and will give you the password for bandit25 if given the password for bandit24 and a secret numeric 4-digit pincode. There is no way to retrieve the pincode except by going through all of the 10000 combinations, called brute-forcing.
You do not need to create new connections each time

Command:
```bash
$ nc localhost 30002
I am the pincode checker for user bandit25. Please enter the password for user bandit24 and the secret pincode on a single line, separated by a space.
$ previous password 0000
Wrong! Please enter the correct current password and pincode. Try again.
#I already knew the previous password, but I have to figure out the pincode!
$ cd /tmp/hope
$ nano hope.sh
#!/bin/bash
password='gb8KRRCsshuZXI0tUuR6ypOFjiZbf3G8'

for i in $(seq -w 0000 9999); do
 echo "$password $i"
done | nc localhost 30002
#Saved!
$ chmod +x hope.sh
$ ./hope.sh
There were too many wrong attempts...!
Correct!
The password of user bandit25 is ************* #XD
```

Notes :
 -⚠️ Wrong! 이거 없이 성공한 값만 뜨게 파일을 만들어보고 싶은데!
 -🤖 Wrong 메시지를 아예 없애긴 어렵고, 전체 출력은 파일로 저장한 뒤 Correct가 들어간 줄만 grep으로 골라 보는 식으로 처리해야 함.
 -⚠️ ./hope.sh | grep 이런식으로 하면 되나? 근데 의미 없긴 하겠다! 패스!

## Bandit Level 25 -> 26
Goal:Logging in to bandit26 from bandit25 should be fairly easy… The shell for user bandit26 is not /bin/bash, but something else. Find out what it is, how it works and how to break out of it.

Command:
```bash
$ ls
bandit26.sshkey
$ cat bandit26.sshkey
-----BEGIN RSA PRIVATE KEY-----
************************
-----END RSA PRIVATE KEY----- 
# I copied the bandit26 private key to my local machine
$ chmod 600 bandit26
$ ssh -i bandit26 bandit26@bandit.labs.overthewire.org -p 2220
Connection to bandit.labs.overthewire.org closed.
# Hmm...? I was kicked back to bandit25
$ cat /etc/passwd | grep bandit26
bandit26:x:11026:11026:bandit level 26:/home/bandit26:/usr/bin/showtext
#I checked /etc/passwd and found that bandit26 doesn’t use /bin/bash but runs /usr/bin/showtext instead.
#Since showtext uses a pager like more/less, I forced it to open the pager and then escaped to a shell from there.
# Back to the local machine
$ stty size 
49 113
$ stty rows 5 cols 20
$ ssh -i bandit26 bandit26@bandit.labs.overthewire.org -p 2220
# bandit26's information was displayed,
--More--(24$) # I got it!
# I pressed the 'v' key
$ :set shell=/bin/bash
$ :shell
bandit26@bandit:~$ cat /etc/bandit_pass/bandit26
password #XD!
```

Notes:
 - ⚠️ 기본 셸이 showtext로 고정되어 있으므로 터미널 크기를 줄여 pager를 강제로 띄운 뒤, pager → vim → shell 순으로 탈출해야하는 문제였다. 하면서 stty나 vim에 대한 기본적인 명령어를 써보았다. 다음에 심화적으로 공부해야겠다.
 - 🤖 제한 셸 구조와 pager·vim 우회 흐름은 잘 해결했으니, 다음엔 stty 옵션과 vim의 외부 명령 실행 메커니즘을 명확히 이해해 “왜 동작하는지”까지 개념적으로 확인할 것.

_Date 2025-12-29_

## Bandit Level 26 -> 27
Goal:Good job getting a shell! Now hurry and grab the password for bandit27!

Command:
```bash
bandit26@bandit:~$ ls
$ bandit27-do text.txt
$ ./bandit27-do cat /etc/bandit_pass/bandit27
password #XD
```

Notes:
 -⚠️ Hurry up!

## Bandit Level 27 -> 28
Goal:There is a git repository at ssh://bandit27-git@bandit.labs.overthewire.org/home/bandit27-git/repo via the port 2220. The password for the user bandit27-git is the same as for the user bandit27.

Clone the repository and find the password for the next level.

Command:
```bash
$ git clone ssh://bandit27-git@bandit.labs.overthewire.org:2220/home/bandit27-git/repo
$ ls
repo
$ cd repo
$ ls
README
$ cat README
The password to the next level is: ****************** #XD
```

Notes:
 -⚠️ SSH기반 git repo에 접근할 때는 포트와 인증을 정확히 지정해야만 원격 저장소를 정상적으로 클론할 수 있음을 보여준다
 -🤖 SSH 포트 설정과 인증 흐름을 이해해야 민감한 정보(패스워드)를 안전하게 저장소에서 가져올 수 있다는 구조를 잘 보여준다.

## Bandit Level 28 -> 29
Goal:There is a git repository at ssh://bandit28-git@bandit.labs.overthewire.org/home/bandit28-git/repo via the port 2220. The password for the user bandit28-git is the same as for the user bandit28.

Clone the repository and find the password for the next level.

Command:
```bash
$ git clone ssh://bandit28-git@bandit.labs.overthewire.org:2220/home/bandit28-git/repo
$ cd repo
$ ls
README.md
$ cat README.md
# Bandit Notes
Some notes for level29 of bandit.

## credentials

- username: bandit29
- password: xxxxxxxxxx

$ git log
commit b5ed4b5a3499533c2611217c8780e8ead48609f6 (HEAD -> master, origin/master, origin/HEAD)
Author: Morla Porla <morla@overthewire.org>
Date:   Tue Oct 14 09:26:24 2025 +0000

    fix info leak

commit 8b7c651b37ce7a94633b7b7b7c980ded19a16e4f
Author: Morla Porla <morla@overthewire.org>
Date:   Tue Oct 14 09:26:24 2025 +0000

    add missing data

commit 6d8e5e607602b597ade7504a550a29ba03f2cca0
Author: Ben Dover <noone@overthewire.org>
Date:   Tue Oct 14 09:26:24 2025 +0000

    initial commit of README.md
# Second one involve missing data!
$ git checkout 8b7c651b37ce7a94633b7b7b7c980ded19a16e4f
$ ls
README.md
$ cat README.md
# Bandit Notes
Some notes for level29 of bandit.

## credentials

- username: bandit29
- password: ********************** #XD
```

Notes:
 -⚠️ git 관련 명령어를 숙지해야겠다.
 -🤖 git 관련 명령어 알려줄게.

 ## Bandit Level 29 -> 30
Goal:There is a git repository at ssh://bandit29-git@bandit.labs.overthewire.org/home/bandit29-git/repo via the port 2220. The password for the user bandit29-git is the same as for the user bandit29.

Clone the repository and find the password for the next level.

Command:
```bash
$ git clone ssh://bandit29-git@bandit.labs.overthewire.org:2220/home/bandit29-git/repo
$ cd repo
$ ls
README.md
$ cat README.md
# Bandit Notes
Some notes for bandit30 of bandit.

## credentials

- username: bandit30
- password: <no passwords in production!>

$ git log
#Nothing special... I have to figure out the branch!
$ git branch --all
* master
  remotes/origin/HEAD -> origin/master
  remotes/origin/dev
  remotes/origin/master
  remotes/origin/sploits-dev
$ git checkout remotes/origin/dev
Note: switching to 'remotes/origin/dev'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

HEAD is now at e50e6cc add data needed for development
$ ls
code README.md
$ cat README.md
# Bandit Notes
Some notes for bandit30 of bandit.

## credentials

- username: bandit30
- password: ******************* #BINGO!
```

Notes:
 -⚠️ git log뿐만 아니라 branch, tag 등 다양하게 확인해야겠다.
 -🤖 이 단계는 master가 항상 진짜 진실이 아니고, 리모트 브랜치 탐색이 정보 수집의 필수 루틴임을 보여준다.

## Bandit Level 30 -> 31
Goal: There is a git repository at ssh://bandit30-git@bandit.labs.overthewire.org/home/bandit30-git/repo via the port 2220. The password for the user bandit30-git is the same as for the user bandit30.

Clone the repository and find the password for the next level.

Command:
```bash
$ git clone ssh://bandit30-git@bandit.labs.overthewire.org:2220/home/bandit30-git/repo
$ cd repo
$ ls
README.md
$ cat README.md
just an epmty file... muahaha
$ git tag
secret
$ git show secret
password #GOOOOOOOOOOOD!
```

## Bandit Level 31 -> 32
Goal: There is a git repository at ssh://bandit31-git@bandit.labs.overthewire.org/home/bandit31-git/repo via the port 2220. The password for the user bandit31-git is the same as for the user bandit31.

Clone the repository and find the password for the next level.

Command:
```bash
$ git clone ssh://bandit31-git@bandit.labs.overthewire.org:2220/home/bandit31-git/repo
$ cd repo
$ cat README.md
This time your task is to push a file to the remote repository.

Details:
    File name: key.txt
    Content: 'May I come in?'
    Branch: master
$ git branch
* master #check the Branch
$ echo 'May I come in?' > key.txt
$ ls
key.txt README.md
$ git add key.txt
The following paths are ignored by one of your .gitignore files:
key.txt
hint: Use -f if you really want to add them.
hint: Disable this message with "git config advice.addIgnoredFile false"
#The file is being ignored by .gitignore, so Git won’t let me add it normally; I need to force-add it with -f.
$ git add -f key.txt
$ git commit -m 'whatever'
Author identity unknown

*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"

to set your account's default identity.
Omit --global to set the identity only in this repository.

fatal: unable to auto-detect email address (got 'hope4849@SandboxHost-639025902645689072.(none)')
$ git config --global user.name 'bandit'
$ git config --global user.email 'bandit@labs.org'
$ git commit -m 'whatever'
$ git push
$ previous password
                         _                     _ _ _   
                        | |__   __ _ _ __   __| (_) |_ 
                        | '_ \ / _` | '_ \ / _` | | __|
                        | |_) | (_| | | | | (_| | | |_ 
                        |_.__/ \__,_|_| |_|\__,_|_|\__|
                                                       

                      This is an OverTheWire game server. 
            More information on http://www.overthewire.org/wargames

backend: gibson-1
bandit31-git@bandit.labs.overthewire.org's password: 
Enumerating objects: 4, done.
Counting objects: 100% (4/4), done.
Delta compression using up to 2 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 315 bytes | 315.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
remote: ### Attempting to validate files... ####
remote: 
remote: .oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.
remote: 
remote: Well done! Here is the password for the next level:
remote: ******************************** #XD
remote: 
remote: .oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.
remote: 
To ssh://bandit.labs.overthewire.org:2220/home/bandit31-git/repo
 ! [remote rejected] master -> master (pre-receive hook declined)
```

Notes:
 -⚠️ 아니 그래서 git 언제 씀?
 -🤖 Git은 코드와 파일의 변화를 안전하게 기록하고, 과거로 되돌릴 수 있게 하며, 여러 사람이 동시에 작업해도 충돌 없이 협업할 수 있도록 관리하는 버전 관리 시스템이다.
 -🤖 이 단계는 .gitignore를 우회해 올바른 내용의 파일을 강제로 추가·커밋·푸시하면, 서버 측 검증 훅이 이를 확인하고 보상을 제공하는 “정상적인 절차를 정확히 수행하는 능력”을 요구하는 문제다.

 ## Bandit Level 32 -> 33
 Goal: After all this git stuff, it’s time for another escape. Good luck!

Command:
```bash
$ ls
sh: 1: LS: Permission denied
$ cat
sh: 1: CAT: Permission denied
#The system converts all commands to uppercase, so normal shell names fail. I need something unaffected by case conversion, which is why $0 works.
$0 #0 means the path of the currently running shell program.
$ ls
uppershell #SUCCESS
$ cat /etc/bandit_pass/bandit33
password #XD
```

Notes:
 -⚠️ 일단 오류나면 의심부터 하자.
 -🤖 이 단계는 대문자 강제 변환이라는 필터를, 문자에 의존하지 않는 $0 같은 쉘 재실행 트릭으로 우회해 환경을 탈출할 수 있음을 보여준다.

 ## Bandit Level 33 -> 34
 Bandit Level 33 → Level 34
At this moment, level 34 does not exist yet.

GG

