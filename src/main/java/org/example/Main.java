package org.example;

import org.example.classes.Administrative;
import org.example.classes.WarehouseWaiter;
import org.example.classes.Schedule;
import org.example.classes.Worker;

import java.util.*;

public class Main {

    static WarehouseWaiter waiter1 = new WarehouseWaiter("Francisco","Martínez Gutierrez","01/01/2000","Mozo de almacén", Schedule.NIGTH,Arrays.asList("Carné de carretilla","Carné de manipulador"));
    static Administrative admin1 = new Administrative("Pedro","Gómez Fernández","17/02/1970","Administrativo",Arrays.asList("Excel","Word","Power Point","ContaPlus","NominaPlus","Teams","Outlook","Visual Basic"));
    static WarehouseWaiter waiter2 = new WarehouseWaiter("María","Alfajores","10/11/1990","Mozo de almacén",Schedule.MORNING,Arrays.asList("Carné de carretilla"));
    static WarehouseWaiter waiter3 = new WarehouseWaiter("Pedro","Gómez Hernández","03/03/1999","Mozo de almacén",Schedule.AFTERNOON,Arrays.asList());
    static Administrative admin2 = new Administrative("Marta","Sánchez García","04/07/1997","Administrativa",Arrays.asList("Excel","Word","Power Point","ContaPlus","NominaPlus","Teams","Outlook"));
    static Worker manager = new Worker("Allan","McKenzie","29/09/1970","Gerente",Schedule.MORNING) ;

    static List<Worker> workers = Arrays.asList(waiter1,admin1, waiter2, waiter3,admin2,manager);
    static List<Worker> admins = new ArrayList<>();
    static List<Worker> waiters = new ArrayList<>();

    public static void main(String[] args) {
        addWorkers();
        showWorkers();
    }

    private static void addWorkers() {
        workers.stream().forEach(worker -> {
            if (worker.getClass() == Administrative.class) addAdmin(worker,admins);
            else if (worker.getClass() == WarehouseWaiter.class) addMozo(worker, waiters);
            else System.out.println("El trabajador con nombre "+worker.getName()+" "+worker.getSurnames()+" no pertenece a ningún grupo de trabajo porque su cargo es: "+worker.getPosition());
        });
    }

    private static void showWorkers() {
        System.out.println("\n-------ADMINISTRATIVOS-------\n");
        admins.forEach(System.out::println);
        System.out.println("\n-------MOZOS DE ALMACÉN-------\n");
        waiters.forEach(System.out::println);
    }

    private static void addMozo(Worker worker, List<Worker> mozos) {
        mozos.add(worker);
        System.out.println("El trabajador con nombre "+worker.getName()+" "+worker.getSurnames()+" añadido a la lista de mozos de almacén");
    }

    private static void addAdmin(Worker worker, List<Worker> admins) {
        admins.add(worker);
        System.out.println("El trabajador con nombre "+worker.getName()+" "+worker.getSurnames()+" añadido a la lista de administrativos");
    }


}