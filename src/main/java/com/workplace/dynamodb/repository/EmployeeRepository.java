package com.workplace.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.workplace.dynamodb.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    private DynamoDBMapper dynamoDBMapper;

    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployeeById(String employeeId) {
        return dynamoDBMapper.load(Employee.class, employeeId);
    }

    public String deleteEmployee(String employeeId) {
        Employee employee = dynamoDBMapper.load(Employee.class, employeeId);
        dynamoDBMapper.delete(employee);
        return "Employee deleted";
    }

    public String update(String employeeId, Employee employee) {
        dynamoDBMapper.save(
                employee,
                new DynamoDBSaveExpression().withExpectedEntry(
                        "employeeId",
                        new ExpectedAttributeValue(new AttributeValue().withS(employeeId))
                )
        );
        return employeeId;
    }
}
