## AWS Cloud Use Cases

Use cases include:
- Enterprise IT, Backup & Storage, Big Data analytics
- Webstie hosting, Mobile & Social Apps
- Gaming

How to choose an AWS Region?
- If you need to launch a new application, where should you do it?
- Compliance with data governance and legal
- requirements:data never leaves a region without your explicit permission
- Proximity to customers: reduced latency
- Available services within a Region: news services and new features aeren't available in every Region
- Pricing: pricing vareis region to region and is transparent in the service pricing page

## IAM: Users & Groups
 - IAM = Identity and Acess Management, Global service
 - Root account created by default, shouldn't be used or shared
 - Users are people within your organization, and can be grouped
 - Groups only contain users, not other groups
 - Users don't have to belong to a group, and user can belong to multiple groups

## IAM: Permisision
 - Users or Groups can be assigned JSON documents called policies
 - These policies define the permissions of the users
 - In AWS you apply the least privilege principle : don't give more permissions than a user needs

   
 ## IAM
  - IAM 역할의 올바른 정의: AWS 서비스에 요청을 생성하기 위한 일련의 권한을 정의하고, AWS 서비스에 의해 사용될 IAM개체
  - IAM 보안 도구에 해당되는 것은? : IAM 자격 증명 보고서
  - IAM 정책이란? : AWS 서비스에 요청을 생성하기 위한 일련의 권한을 정의하며, IAM 사용자, 사용자 그룹 및 IAM 역할에서 사용하게 될 JSON문서
    
