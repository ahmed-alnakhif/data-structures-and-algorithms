package Companies.google.duplicateEmployees;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DuplicateEmployees {

    private List<String> getDuplicateEmployees(String filePath) {
        List<List<String>> employees = getEmployees(filePath);
        HashMap<String, String> employeesMap = new HashMap<>();
        Set<String> duplicateEmployees = new HashSet<>();

        for (List<String> employee : employees) {
            String name = employee.get(0);
            String id = employee.get(1);
            if (employeesMap.containsKey(id)) {
                duplicateEmployees.add(name);
                duplicateEmployees.add(employeesMap.get(id));
            } else {
                employeesMap.put(id, name);
            }
        }

        return new ArrayList<>(duplicateEmployees);
    }

    private List<List<String>> getEmployees(String filePath) {
        List<List<String>> records = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error while opening " + filePath + ", " + e);
        }

        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> record = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                record.add(rowScanner.next());
            }
        }
        return record;
    }

    public static List<String> duplicateEmployees(String file) {
        HashSet<String> duplicateEmployeesSet = new HashSet<>();
        HashMap<String, String> employeesMap = new HashMap<>();

        // try {
        // CSVReader reader = new CSVReaderBuilder(new FileReader(file)).build();

        // reader.readAll().stream().forEach((record) -> {
        // if (employeesMap.containsKey(record[1])) {
        // duplicateEmployeesSet.add(record[0]);
        // duplicateEmployeesSet.add(employeesMap.get(record[1]));
        // }

        // employeesMap.put(record[1], record[0]);
        // });
        // } catch (Exception e) {
        // System.out.println(e);
        // }

        // JSONParser parser = new JSONParser();

        // try {
        //     Object obj = parser.parse(new FileReader("c:\\file.json"));

        //     JSONObject jsonObject = (JSONObject) obj;

        //     String name = (String) jsonObject.get("name");
        //     System.out.println(name);

        //     String city = (String) jsonObject.get("city");
        //     System.out.println(city);

        //     String job = (String) jsonObject.get("job");
        //     System.out.println(job);

        //     // loop array
        //     JSONArray cars = (JSONArray) jsonObject.get("cars");
        //     Iterator<String> iterator = cars.iterator();
        //     while (iterator.hasNext()) {
        //         System.out.println(iterator.next());
        //     }
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }

        return new ArrayList<>(duplicateEmployeesSet);

    }

    public static void main(String[] args) {
        DuplicateEmployees dEmployees = new DuplicateEmployees();
        System.out.println(dEmployees.getDuplicateEmployees("src/Companies/google/duplicateEmployees/employees.csv"));
    }
}
