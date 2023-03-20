package com.mashurova;

import java.security.KeyStore;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Person, List<Fine>> fineMap = new HashMap<>();
//        Fine fine1 = new Fine("Delay",254);
//        Fine fine2 = new Fine("Not bay",360);
        List<Fine> fines1 = new ArrayList<>();
        fines1.add(new Fine("Delay", 256));
        fines1.add(new Fine("Not bay", 360));
        List<Fine> fines2 = new ArrayList<>();
        fines2.add(new Fine("Entry", 210));
        fines2.add(new Fine("Delay", 410));
        fines2.add(new Fine("K", 310));
        List<Fine> fines3 = new ArrayList<>();
        fines3.add(new Fine("Wor", 210));
        fines3.add(new Fine("Delay", 410));
        fines3.add(new Fine("K", 310));
        List<Fine> fines4 = new ArrayList<>();
        fines4.add(new Fine("Entry", 210));
        fines4.add(new Fine("Quart", 410));
        List<Fine> fines5 = new ArrayList<>();
        fines5.add(new Fine("Not bay", 360));


        fineMap.put(new Person("uk14387", "Aok", "Valery", "Dnipro"), fines1);
        fineMap.put(new Person("uk14389", "Miu", "Fredy", "Dnipro"), fines2);
        fineMap.put(new Person("uk14340", "Dok", "Tim", "Kiev"), fines3);
        fineMap.put(new Person("uk14341", "Times", "Mike", "Dnipro"), fines4);
        fineMap.put(new Person("uk14342", "Tom", "Andrew", "Odessa"), fines5);
        Scanner scanner = new Scanner(System.in);

        int t = -1;
        exit:
        while (t != 0) {
            System.out.println("Choose action");
            System.out.println("[1]-print database");
            System.out.println("[2]-code printout");
            System.out.println("[3]-print of data by type of fine");
            System.out.println("[4]-city printout");
            System.out.println("[5]-adding new client");
            System.out.println("[6]-adding new fines to client");
            System.out.println("[7]-removing fines");
            System.out.println("[8]- editing data of client and fines");
            System.out.println("[0]-exit");
            t = scanner.nextInt();
            switch (t) {
                case 1 -> {
                    print(fineMap);
                    break;
                }
                case 2 -> {
                    printCode(fineMap);
                    break;
                }
                case 3 -> {
                    printNameFine(fineMap);
                    break;
                }
                case 4 -> {
                    printCity(fineMap);
                    break;
                }
                case 5 -> {
                    addNewPerson(fineMap);
                    break;
                }
                case 6 -> {
                    addNewFine(fineMap);
                    break;
                }
                case 7 -> {
                    removeFine(fineMap);
                    break;
                }
                case 8 -> {
              editFine(fineMap);
                    break;
                }
                case 0 -> {
                    t = 0;
                    continue exit;
                }
                default -> {
                    System.out.println("Wrong action!!!");
                    break;
                }
            }

        }


//        addNewFine(fineMap);//TODO
//        printNameFine(fineMap);//TODO
        removeFine(fineMap);

        print(fineMap);


    }

    static void printNameFine(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of the fine: ");
        String nameFine = scanner.next();
        List<Fine> fineList = new ArrayList<>();
        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            for (Fine fine : entry.getValue()) {
                if (fine.getNameFine().equals(nameFine)) {
                    Person person = entry.getKey();
                    System.out.println(person + " " + fine);
                }
            }

        }

    }


    static void printCity(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city: ");
        String city = scanner.next();
        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            if (entry.getKey().getCityName().equals(city)) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    static void printCode(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter code:");
        String code = scanner.next();
        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            if (entry.getKey().getIdentCode().equals(code)) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    static void print(Map<Person, List<Fine>> fineMap) {
        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void addNewPerson(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city: ");
        String city = scanner.next();
        System.out.println("Enter code:");
        String code = scanner.next();
        System.out.println("Enter surname: ");
        String surname = scanner.next();
        System.out.println("Enter first name: ");
        String firstName = scanner.next();
        Person p = new Person(code, surname, firstName, city);
        fineMap.put(p, null);

    }

    static void addNewFine(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the code of te client: ");
        String code = scanner.next();
        List<Fine> fines = new ArrayList<>();
        boolean bool = false;
        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            if (entry.getKey().getIdentCode().equals(code)) {
                System.out.println("Enter name of the fine: ");
                String nameFine = scanner.next();
                System.out.println("Enter amount of the fine: ");
                int amount = scanner.nextInt();
                Fine fine = new Fine(nameFine, amount);
                fines = entry.getValue();
                fines.add(fine);
                bool = true;
            } else {
                bool = false;
            }
        }
        if (bool) {
            System.out.println("Added the fine!");
        } else {
            System.out.println("There is no such client!");
        }
    }

    static void removeFine(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the code of te client: ");
        String code = scanner.next();
        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            if (entry.getKey().getIdentCode().equals(code)) {
                System.out.println("Enter name of the fine: ");
                String nameFine = scanner.next();
                for (Fine fine : entry.getValue()) {
                    if (fine.getNameFine().equals(nameFine)) {
                        fineMap.remove(fine);
                    }
                }
            }
        }
    }

    static void editFine(Map<Person, List<Fine>> fineMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the code of te client: ");
        String code = scanner.next();

        for (Map.Entry<Person, List<Fine>> entry : fineMap.entrySet()) {
            if (entry.getKey().getIdentCode().equals(code)) {
                System.out.println("Choose action: ");
                System.out.println("[1]-change information about a person");
                System.out.println("[2]-change a fine");
                int w = scanner.nextInt();
                switch (w) {
                    case 1 -> {
                        System.out.println("Enter city: ");
                        String city = scanner.next();
                        System.out.println("Enter surname: ");
                        String surname = scanner.next();
                        System.out.println("Enter first name: ");
                        String firstName = scanner.next();
                        Person p = new Person(code, surname, firstName, city);
                        fineMap.remove(entry.getKey());
                        fineMap.put(p, entry.getValue());
                    }
                    case 2 -> {
                        System.out.println("Enter name of the fine: ");
                        String nameFine = scanner.next();
                        List<Fine> fines= new ArrayList<>();
                        for (Fine f: entry.getValue()) {
                            fines.add(f);
                            if (f.getNameFine().equals(nameFine)){
                                System.out.println("Enter new name of the fine: ");
                                String name = scanner.next();
                                System.out.println("Enter new amount of the fine: ");
                                int amount = scanner.nextInt();
                                Fine fine = new Fine(name,amount);
                               fines.remove(f);
                               fines.add(fine);
                            }else {
                                fines.add(f);
                            }
                        }
                        fineMap.remove(entry.getValue());
                        fineMap.put(entry.getKey(),fines);
                    }


                }


            }
        }
    }
}

