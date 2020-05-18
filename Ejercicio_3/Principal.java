package app.Ejercicio_3;

import java.util.*;

public class Principal {

    private final Scanner santi = new Scanner(System.in);
    private final Tarjeta card1;
    private final Tarjeta card2;
    private String concepto;
    private double precio;

    public Principal() {

        card1 = new Tarjeta("12345", "12/22", "030", 2000);
        card2 = new Tarjeta("00001", "02/23", "111", 100000);

        boolean datos_pago = false;

        while (datos_pago == false) {

           datos_pago = datosPago();
           santi.nextLine();

        }

        boolean datos_tarjeta = false;
        boolean tiene_saldo = false;

        Tarjeta tarjeta = null;

        while (datos_tarjeta == false || tiene_saldo == false) {
            tarjeta = seleccionarTarjeta();
            datos_tarjeta = tarjeta.comprobarDatos();
            tiene_saldo = tarjeta.comprobarSaldo(precio);

        }

        tarjeta.compra(precio);
        mandarMail(tarjeta);

    }

    public Tarjeta seleccionarTarjeta() {

        Tarjeta prueba = null;

        System.out.println("INTRODUCE NUMERO DE TARJETA");
        final String num = santi.nextLine();

        if (num.equals(card1.numero))
            prueba = card1;
        if (num.equals(card2.numero))
            prueba = card2;

        System.out.println(prueba.datos());
        return prueba;

    }

    public boolean datosPago() {

        System.out.println("INTRODUCE CONCEPTO: ");
        concepto = santi.nextLine();
        System.out.println("INTRODUCE CANTIDAD A PAGAR ");
        precio = santi.nextDouble();
        santi.nextLine();

        System.out.println("CONCEPTO: " + concepto + " || PAGO: " + precio + "\n¿DATOS CORRECTO? (1) SI (2) NO");

        final int select = santi.nextInt();
        
        if (select == 1)
            return true;
            else
            return false;
            
    }

    public void mandarMail(final Tarjeta cosa) {

        System.out.println("\n ------EMAIL ENVIADO -----");
        System.out.println("PAGO DE " + concepto + " POR UN VALOR DE " + precio + "€" + "\n" + cosa.datos());
    }

    public static void main(final String[] args) {

        final Principal interfaz = new Principal();
    }

}