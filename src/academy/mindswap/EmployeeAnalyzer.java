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

        return employees.stream()
                .filter(employee -> employee.getSalary() >= salary)
                .map(employee -> employee.getFirstName()+" "+ employee.getLastname())
                .collect(Collectors.toList());  //muito importante para acabar o exercicio
    }

    public List<String> findOldestEmployees(List<Employee> employees, int numberOfEmployees) {

        /* List<Employee> result = employees.stream()
                .map(employee -> employee.getFirstName()+" "+ employee.getLastname())
                .sorted()
                .collect(Collectors.toList());
        return
         */
        return employees.stream()
                .filter(employee -> employee.getStartingYear() >= numberOfEmployees)
                .map(employee -> employee.getFirstName()+" "+ employee.getLastname())
                .collect(Collectors.toList());
    }

    public Optional<Employee> findFirstEmployeeByAge(List<Employee> employees, int age) {
        //temos que filtrar do grupo empregado mais antigo o mais velho.


        return Optional.empty();
    }

    public Double findAverageSalary(List<Employee> employees) {
        //salario medio por departamento.

        return 0.0;
    }

    public List<String> findCommonNames(List<Employee> firstDepartment, List<Employee> secondDepartment) {
        //counter para os nomes e comparar o que aparece mais

        /*ong count = Arrays.stream(tongueTwister.split("\\W+"))
                .count();

         */


        return new ArrayList<>();
    }
}
