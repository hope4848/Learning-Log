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
 - 
