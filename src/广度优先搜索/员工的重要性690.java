package 广度优先搜索;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 员工的重要性690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return importance(id);
    }

    private int importance(int id) {
        Employee employee = map.get(id);
        int sum = employee.importance;
        for (int i : employee.subordinates) {
            sum += importance(i);
        }
        return sum;
    }

    /*public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.id == id) {
                sum += importance(employees, employee);
            }
        }
        return sum;
    }

    private int importance(List<Employee> employees, Employee employee) {
        int sum = employee.importance;
        for (Employee e:employees) {
            if (employee.subordinates.contains(e.id)) {
                sum+=importance(employees, e);
            }
        }
        return sum;
    }*/
}
