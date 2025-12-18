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
