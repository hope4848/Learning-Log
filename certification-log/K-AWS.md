## AWS (Amazon Web Services))
 - 전 세계적으로 분포한 데이터 센터에서 300개가 넘는 완벽한 기능의 서비스를 제공하는, 세계적으로 가장 포괄적이며, 널리 채택되고 있는 클라우드
 - Amazon에서 제공하는 클라우드 컴퓨팅 플랫폼
 - 국내 점유율 1위
 - 전세계 점유율 1위 (지역에 따라 다름)\

## 공부 할 서비스 티어 정리
 - 필수 - Amazon EC2 , AWS IAM + 계정/빌링 설정 ex)EBS, ELB, Auto Scaling, Budgets, Cost & Usage Report
 - 매우 중요 - Amzaon VPC, Amazon S3, Amazon RDS ex) Amazon Aurora
 - 중요 - Amazon SQS, Amazon CloudFornt, AWS CloudFormation, Amazon CloudWatch, Amazon Route t3, Amazon SNS, AWS Systems Manager, AWS Cloud Trail
 - 필수랑 매우 중요한 부분 일단 집중 ㄱㄱ

## Amazon EC2
 - Amazon Elastic Compute Cloud(EC2)는 안전하고 크기 조정이 가능한 컴퓨팅 파워를 클라우드에서 제공하는 웹 서비스.
 - 클라우드 : 빌려 쓰기
 - 클라우드 컴퓨팅 : 컴퓨팅 빌려 쓰기
 - EC2 : 컴퓨팅을 빌려 쓰는 서비스
 - AWS에서 가장 중요한 서비스로 컴퓨팅 파워를 빌리는 서비스
 - 서버를 빌리는 서비스
 - 거의 모든 AWS 서비스는 직 간접적으로 EC2와 연결

## AWS IAM
 - AWS Identity And Access Management(IAM)을 사용하면 AWS 서비스와 리소스에 대한 액세스를 안전하게 관리할 수 있음.
 - 또한 AWS 사용자 및 그룹을 만들고 관리하며 AWS 리소스에 대한 액세스를 허용 및 거부할 수 있음.
 - AWS의 보안 및 관리를 담당하는 글로벌 서비스
 - 주요 기능 - AWS 어카운트 관리 및 리소스/사용자/서비스의 권한 제어, 임시 권한 부여, 서비스 사용을 위한 인증 정보 부여, 사용자 생성, 관리, 보안

## Amazon VPC
 - Virtual Private Cloud(VPC)는 사용자의 AWS 계정 전용 가상 네트워크. VPC는 AWS 클라우드에서 다른 가상 네트워크와 논리적으로 분리되어 있음.
 - VPC = 가상으로 존재하는 데이터 센터
 - 원하는 대로 사설망 구축 가능
 - 부여된 IP 대역을 분할하여 사용 가능
 - VPC의 사용 사례 - EC2, RDS, Lambda등의 AWS 컴퓨팅 서비스 실행, 다양한 서브넷 구성, 보안 설정(IP Block, 인터넷에 노출되지 않는 EC2 등 구성)

## Amazon S3
 - Amazon Simple Storage Service(Amazon S3)는 업계 최고의 확장성과 데이터 가용성 및 보안과 성능을 제공하는 객체 스토리지 서비스.
 - 객체 스토리지 서비스 : 파일 보관만 가능 (어플리케이션 설치 불가능)
 - 무제한 용량
 - 99.999999999% 내구성 (9가 11개라 일레븐 나인으로 부름)
 - *내구성 : 파일을 잃어버리지 않는 능력, 가용성 : 내가 원할 때 그 파일을 사용할 수 있는 능력

## AWS RDS
 - Amazon Relational Database Service(RDS)를 사용하면 클라우드에서 관계형 데이터베이스를 간편하게 설정, 운영 및 확장할 수 있음.
 - 관계형 데이터베이스를 서비스로 제공하는 서비스
 - 암호화 지원, 자동 백원 지원

