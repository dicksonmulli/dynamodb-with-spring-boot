# AWS DynamoDB with SpringBoot

## Steps
### 1. Create IAM Group
- Create Group in AWS
- Attaching policies policies 
  - Give Full access to DynamoDB
  - You can add other policies
### 2. Create User
Create a user with progmatic credentials
### 3. Attach the user to group
Add user to a group

### 5. Create DynamoDB Table
** DynamoDB is a key-value, NoSQL database, therefore we would  
essentially need only one table(to be confirmed)
- Create table
- Add primary key
### 5. Connect Spring Boot to the DynamoDB
