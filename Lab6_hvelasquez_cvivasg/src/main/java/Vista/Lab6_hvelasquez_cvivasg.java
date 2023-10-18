package Vista;

import PaqueteDecorador.PaqueteDecorador;
import PaqueteTuristico.IPaqueteTuristico;
import Paquetes.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class Lab6_hvelasquez_cvivasg {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IPaqueteTuristico paqueteBase = new PaqueteBase();
        PaqueteDecorador paqueteDecorado = null;

        boolean amazingHawaiiAgregado = false;
        boolean natureAgregado = false;
        boolean pearlHarborAgregado = false;

        int opcion = 0;
        do {
            try {
                clearScreen();
                mostrarMenu();
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        if (paqueteDecorado != null) {
                            mostrarPaquete(paqueteDecorado);
                        } else {
                            mostrarPaquete(paqueteBase);
                        }
                        break;
                    case 2:
                        if (!amazingHawaiiAgregado) {
                            paqueteDecorado = new paqueteAmazingHawaii(paqueteDecorado != null ? paqueteDecorado : paqueteBase);
                            amazingHawaiiAgregado = true;
                            paqueteActualizado(paqueteDecorado);
                        } else {
                            System.out.println("El paquete Amazing Hawaii ya ha sido agregado.");
                            pressEnterToContinue();
                        }
                        break;
                    case 3:
                        if (!natureAgregado) {
                            paqueteDecorado = new paqueteNature(paqueteDecorado != null ? paqueteDecorado : paqueteBase);
                            natureAgregado = true;
                            paqueteActualizado(paqueteDecorado);
                        } else {
                            System.out.println("El paquete Nature ya ha sido agregado.");
                            pressEnterToContinue();
                        }
                        break;
                    case 4:
                        if (!pearlHarborAgregado) {
                            paqueteDecorado = new paquetePearlHarbor(paqueteDecorado != null ? paqueteDecorado : paqueteBase);
                            pearlHarborAgregado = true;
                            paqueteActualizado(paqueteDecorado);
                        } else {
                            System.out.println("El paquete Pearl Harbor ya ha sido agregado.");
                            pressEnterToContinue();
                        }
                        break;
                    case 5:
                        if (paqueteBase != null || paqueteDecorado != null) {
                            cotizarPaquete(paqueteDecorado != null ? paqueteDecorado : paqueteBase, scanner);
                        } else {
                            System.out.println("Primero debe decorar el paquete o seleccionar el paquete base.");
                            scanner.nextLine();
                            pressEnterToContinue();
                        }
                        break;
                    case 6:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        scanner.nextLine();
                        pressEnterToContinue();
                }

            } catch (InputMismatchException e) {
                scanner.nextLine(); // Limpiar el búfer completamente
                System.out.println("Ingresa un número válido.");
                pressEnterToContinue();
            }
        } while (opcion != 6);
    }
    
    private static void paqueteActualizado(IPaqueteTuristico paquete){
        clearScreen();
        System.out.println("Paquete actualizado a " + paquete.getNombre());
        pressEnterToContinue();
    }

    private static void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("1. Mostrar Paquete.");
        System.out.println("2. Decorar con paquete Amazing Hawaii.");
        System.out.println("3. Decorar con paquete Nature.");
        System.out.println("4. Decorar con paquete Pearl Harbor.");
        System.out.println("5. Cotizar.");
        System.out.println("6. Salir.");
        System.out.print("Selecciona una opción: ");
    }

    private static void mostrarPaquete(IPaqueteTuristico paquete) {
        clearScreen();
        System.out.println(paquete.getNombre() + " (U$" + paquete.getPrecio() + " y "
                + paquete.getDias() + " días) " + paquete.getDescripcion());
        pressEnterToContinue();
    }

    private static void cotizarPaquete(IPaqueteTuristico paquete, Scanner scanner) {
        int cantidadPersonas = 0;
        int dias = 0;

        clearScreen();
        System.out.println("Cotización de " + paquete.getNombre());
        System.out.print("Ingrese la cantidad de personas (entre 1 y 10): ");
        cantidadPersonas = obtenerEnteroValidado(scanner, 1, 10);

        clearScreen();
        System.out.println("Cotización de " + paquete.getNombre());
        System.out.print("Ingrese la cantidad de días (entre 5 y 20): ");
        dias = obtenerEnteroValidado(scanner, 5, 20);

        Cotizar cotizacion = new Cotizar(paquete, cantidadPersonas, dias);
        clearScreen();
        System.out.println("El " + paquete.getNombre() + " para " + cantidadPersonas + " persona(s) y " + dias + " dia(s) tiene un costo de U$" + cotizacion.valorCotizacion());
        pressEnterToContinue();
    }

    private static int obtenerEnteroValidado(Scanner scanner, int min, int max) {
        int valor = -1;

        while (valor < min || valor > max) {
            try {
                valor = scanner.nextInt();
                if (valor < min || valor > max) {
                    System.out.println("El valor debe estar entre " + min + " y " + max + ".");
                }
            } catch (InputMismatchException e) {
                scanner.next(); // Limpiar el búfer
                System.out.println("Ingresa un número válido.");
                scanner.nextLine();
            }
        }

        return valor;
    }

    private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void pressEnterToContinue() {
        System.out.println("\nPresiona Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
