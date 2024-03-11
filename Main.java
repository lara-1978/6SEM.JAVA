    

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Huawei", 16, 512, "Windows", "Silver"));
        laptops.add(new Laptop("Apple", 8, 256, "MacOS", "Silver"));
        laptops.add(new Laptop("Asus", 32, 1024, "Windows", "Black"));

        Map<String, Object> filters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the criteria to filter:");
        System.out.println("1 - ram");
        System.out.println("2 - amount hdd");
        System.out.println("3 -operating system ");
        System.out.println("4 - Color");
        System.out.println("0 - complete the selection:");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("minimum amount of ram ?");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("minimum amount of hdd ?");
                    filters.put("hdd", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("operating system?");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Color?");
                    filters.put("color", scanner.next());
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }

        Set<Laptop> filteredLaptops = laptops.stream()
                .filter(laptop -> filters.getOrDefault("ram", 0) instanceof Integer && laptop.ram >= (int) filters.getOrDefault("ram", 0))
                .filter(laptop -> filters.getOrDefault("hdd", 0) instanceof Integer && laptop.hdd >= (int) filters.getOrDefault("hdd", 0))
                .filter(laptop -> filters.getOrDefault("os", "").equals("") || laptop.os.equalsIgnoreCase((String) filters.getOrDefault("os", "")))
                .filter(laptop -> filters.getOrDefault("color", "").equals("") || laptop.color.equalsIgnoreCase((String) filters.getOrDefault("color", "")))
                .collect(Collectors.toSet());

        System.out.println("Filtered laptops:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}