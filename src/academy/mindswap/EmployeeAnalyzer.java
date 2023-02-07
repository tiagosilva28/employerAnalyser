package academy.mindswap;

import academy.mindswap.employee.Employee;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeAnalyzer {

    public long countEmployees(List<Employee> employees, int years) {
        Year year = Year.now();
        int currentYear = year.getValue();
        Stream<Employee> employeeStream = employees.stream();

                long count = employeeStream
                .filter(employee -> (currentYear - employee.getStartingYear())  == years)
                .count();
        return count;
    }

    public List<String> findEmployeeBySalary(List<Employee> employees, int salary) {

        Stream<Employee> employeeStream = employees.stream();
       // Arrays.stream(employeeStream)




        return new ArrayList<>();
    }

    public List<Employee> findOldestEmployees(List<Employee> employees, int numberOfEmployees) {
        return  new ArrayList<>();
    }

    public Optional<Employee> findFirstEmployeeByAge(List<Employee> employees, int age) {


        return Optional.empty();
    }

    public Double findAverageSalary(List<Employee> employees) {
        return 0.0;
    }

    public List<String> findCommonNames(List<Employee> firstDepartment, List<Employee> secondDepartment) {


        return new ArrayList<>();
    }
}
