package academy.mindswap;

import academy.mindswap.employee.Employee;

import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeAnalyzer {

    public long countEmployees(List<Employee> employees, int years) {
        Year year = Year.now();
        int currentYear = year.getValue();
        Stream<Employee> employeeStream = employees.stream();

        long count = employeeStream
                .filter(employee -> (currentYear - employee.getStartingYear()) == years)
                .count();
        return count;
    }

    public List<String> findEmployeeBySalary(List<Employee> employees, int salary) {

        return employees.stream()
                .filter(employee -> employee.getSalary() >= salary)
                .map(employee -> employee.getFirstName() + " " + employee.getLastname())
                .collect(Collectors.toList());  //muito importante para acabar o exercicio
    }

    public List<Employee> findOldestEmployees(List<Employee> employees, int numberOfEmployees) {

        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                //.map(employee -> employee.getFirstName() + " " + employee.getLastname())
                .limit(numberOfEmployees)
                .collect(Collectors.toList()); // Como mudar para returnar uma List<Employee>
    }

    public Optional<Employee> findFirstEmployeeByAge(List<Employee> employees, int age) {
        //temos que filtrar do grupo empregado mais antigo o mais velho.

        Optional<Employee> result =
                employees.stream()
                        .filter(employee -> employee.getAge() == age)
                        .findFirst();

        return result.isPresent() ? result : Optional.empty();
    }

    public Double findAverageSalary(List<Employee> employees) {
        //salario medio por departamento.
        OptionalDouble average = employees.stream()
                .mapToDouble(employee -> employee.getSalary())
                .average();


        return average.isPresent() ? average.getAsDouble() : 0;
    }

    public List<String> findCommonNames(List<Employee> firstDepartment, List<Employee> secondDepartment) {
        //counter para os nomes e comparar o que aparece mais

        List<String> result = firstDepartment.stream()
                .filter(two -> secondDepartment.stream()
                        .anyMatch(one -> one.getFirstName().equals(two.getFirstName())))
                .map(element -> element.getFirstName())
                .collect(Collectors.toList());


        return result;
    }
}
