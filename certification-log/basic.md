## OSI 7 Layer Mode (1) - Physical/Data Link
 - 컴퓨터 네트워크 및 통신을 7개의 레이어(계층)으로 표현한 모델
 - 각 계층은 하위 계층의 기능을 활용해 역할을 수행하고 상위 계층으로 처리 결과를 전달
 - 낮은 계층부터 높은 계층 순서

## Physical Layer
 - 장치를 연결하기 위한 매체의 물리적인 사항을 정의
 - 전압, 주기, 시간, 전선의 규격, 거리 등
 - 주요 단위 : Bits
 - 대표 구성 요소 : 케이블/안테나/RF 등 전송 매체, 허브, 리피터

## Hub (확성기, 전달만 해주는)
 - Physical Layer 단위에서 다수의 기기들을 연결해주는 장치
 - 특징
 - 에러/충돌(Collision)/디바이스 별 제어 기능 없음
 - 받은 내용을 모두에게 그대로 전달 -> 무조건 Broadcast

## Physical Layer에서 해결하지 못한 문제
 - 충돌
 - Broadcast만 가능 -> 대상을 지정해서 전달 불가능

## Data Link Layer
 - 물리적인 통신을 제어하여 디바이스와 디바이스간의 통신 및 전송을 안정화 하기 위한 프로토콜
 - 주요 단위 : Frame
 - 주요 구성 요소 : Mac Address, Switch
 - 주요 특징
 - CSMA/CD(Carrier-Sense Multiple Access with Collision Detection) 방식을 활용해서 각 디바이스간의 통신을 원할하게 연결
 - 대상을 구별하여 디바이스간의 통신을 지원(Unicast) (Broadcast도 지원)

## MAC(Media Access Control) Address
 - 네트워크 인터페이스에 부여된 고유의 주소
 - 데이터가 지정한 대상에게 잘 전달될 수 있도록 대상 식별에 사용
 - 2개의 Hexadecimal(=byte) 단위로 6개를 나열 = 48 bits = 6bytes
 - ex) 00:1A:2B:3C:4D:5E
 - 두 파트로 구분
 - 첫 3개의 bytes는 OUI(Organizationally Unique Identifier) : 제조사에 부여된 고유 식별자
 - 나머지 3개의 byte는 NIC(Network Interface Controller) : 네트워크 인터페이스 별 고유 번호
 - 네트워크 인터페이스의 MAC Address는 고유의 값이며 변하지 않음 (IP는 변동)

## Data Link Layer에서 해결하지 못한 문제
 - 로컬 네트워크 외부로 통신 불가능

## Network Layer
 - 여러 노드의 경로를 찾고 올바르게 전달 될 수 있는 기능과 수단을 정의
 - 주요 단위 : 패킷
 - 주요 구성 요소 : Router, IP, ARP
 - 주요 특징
 - 서로 떨어진 Local Network간의 통신을 지원
 - "Network 간의" -> Inter Network -> Internet(의 어원)
 - 중간중간 Node들을 거쳐서 목적지 까지 도달할 수 있는 방법을 지원

## IP (Internet Protocol) Address
 - Internet Protocol상에서 통신 주체를 식별하기 위한 아이디
 - 두 가지 종류
 - IPv4 : 32Bits(2^32 = 약 43억개)
 - 아이피를 최대로 활용하기 위해 사설(Private) IP와 공인(Public) IP로 분류
 - IPv6 : 128bits (2^128개) (IPㅍ4qhek 2^96배 더 많음 -> 따라서 사설 IP 개념이 불필요함)
 - MAC Address와 다르게 수시로 변동 가능

## CIDR(Classless Inter Domain Routing)
 - IP는 주소의 영역을 여러 네트워크 영역으로 나누기 위해 IP를 묶는 방식
 - 여러 개의 사설망을 구축하기 위해 망을 나누는 방법
 - CIDR Notation
 - IP 주소의 집합
 - 네트워크 주소와 호스트 주소로 구성
 - 각 호스트 주소 숫자 만큼의 아이피를 가진 네트워크 망 형성 가능
 - A.B.C.D/E 형식
 - ex) 10.0.1.0/24 , 172.16.0.0/12
 - A,B,C,D: 네트워크 주소 + 호스트 주소 표시
 - E : 0~32 : 네트워크 주소가 몇 bit인지 표시

## CIDR Block
 - 호스트 주소 비트만큼 IP 주소를 보유 가능
 - ex) 192.168.2.0/24 -> 네트워크 비트 24 호스트 주소 = 32-24=8
 - 즉 2^8 - 256개의 IP 주소 보유 -> 192.168.2.0~192.168.2.255까지 총 256개 주소를 의미

## Subnet Mask
 - 어느 부분이 호스트 비트인지, 어느 부분이 네트워크 비트인지 구분해주는 Mask
 - AND연산을 활용해 네트워크 주소를 필터링
 - AND 연산 : 두 비트중 둘 다 1일때만 1
 - 네트워크 비트 수만큼 1을 보유한 마스크를 IP에 적용하면 네트워크 비트만 추출 가능

## 라우터(Router)
 - 네트워크간에 패킷을 주고 받는 Layer 3 장치
 - IP 대역별 최적 경로를 수집 및 관리
   - 어떤 경로의 노드를 경유해야 가장 효율적으로 대상에 도착하는지 알고 있음 (Route Table)
   - 이 경로를 바탕으로 특정 IP 주소가 대상인 패킷의 전달을 요청받을 때 해당 경로로 요청
 - 로컬 네트워크는 자신의 로컬 네트워크 주소가 아니라면 라우터로 전달
   - 확인 방법 : 네트워크 주소가 같은지 확인(Subnet mask 등)
 - 이후 Router는 패킷을 Frame안에 넣어서 최적 경로에 따른 다른 Router로 전달
   - IP 주소에 따른 Frame 확인 방법 : ARP

## ARP (Address Resolution Protocol)
 - IP로 MAC 어드레스를 찾는 프로토콜
 - 순서
   - Broadcast (MAC Address FF:FF:FF:FF:FF:FF)로 IP요청
   - 응답 받은 IP MAC Address를 기반으로 MAC 확정 후 테이블에 저장

## Network Layer에서 해결하지 못한 문제
 - 한 번에 하나의 통신만 가능
   - 즉 여러 어플리케이션이 동시에 통신 불가능
 - 패킷 등의 순서 보장 불가능, 유실에 대한 대응 불가능
 - 
