package org.example.task_1;

import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void testGetMeasure() {
        Employee employee = new Employee("Dima", 1000.0);
        assertEquals(1000.0, employee.getMeasure(), 0.001);
    }

    @Test
    void testAverage() {
        Measurable[] employees = {
                new Employee("Dima", 1000.0),
                new Employee("Ivan", 1500.0),
                new Employee("Nikita", 2000.0)
        };

        double averageSalary = Main.average(employees);
        assertEquals(1500.0, averageSalary, 0.001);
    }

    @Test
    void testAverageWithEmptyArray() {
        Measurable[] employees = new Employee[0];
        double averageSalary = Main.average(employees);
        assertEquals(0.0, averageSalary, 0.001);
    }

    @Test
    void testMaxSalaryEmployeeName() {
        Measurable[] employees = {
                new Employee("Dima", 1000.0),
                new Employee("Ivan", 1500.0),
                new Employee("Nikita", 2000.0)
        };

        String name = ((Employee)Main.largest(employees)).getName();

        assertEquals("Nikita", name);
    }

    @Test
    void testMaxSalaryEmployeeNameWithEmptyArray() {
        Measurable[] employees = new Employee[0];

        Measurable m = Main.largest(employees);

        assertNull(m);
    }
}
