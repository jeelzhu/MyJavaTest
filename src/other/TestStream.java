package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(33);
        Employee employee2 = new Employee(44);
        Employee employee3 = new Employee(3234);
        Employee employee4 = new Employee(4);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        List list = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary))
                .limit(3).map(employee -> employee.getSalary()).collect(Collectors.toList());

        System.out.println();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

// 1st argument, init value = 0
        int sum = Arrays.stream(numbers).sum();

        System.out.println("sum : " + sum); // 55



    }
}

class Employee {

    private int salary;

    Employee(int salary){
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
