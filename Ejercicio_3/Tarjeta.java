package app.Ejercicio_3;

import java.util.*;

public class Tarjeta {

    private Scanner santi = new Scanner(System.in);
    protected String numero;
    protected String fecha;
    protected String codigo;
    protected double saldo;

    public Tarjeta(String numero, String fecha, String codigo, double saldo) {
        this.numero = numero;
        this.fecha = fecha;
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public Tarjeta() {

        this(null,null,null,0);
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean comprobarDatos() {
        
        System.out.println("INTRODUCE FECHA TARJETA (mm/aa)");
        String fec = santi.nextLine();
        
        System.out.println("INTRODUCE CODIGO TARJETA ");
        String cod = santi.nextLine();

        if (fec.equals(fecha) && cod.equals(codigo)) {
            System.out.println("TARJETA VALIDA");
            return true;
        }

        else {
            System.out.println("TARJETA NO VALIDA");
            return false;
        }

    }

    public boolean comprobarSaldo(double pago) {

        if (pago > saldo) {
            System.out.println("SALDO INSUFICIENTE");
            return false;
        }

        else {
            System.out.println("SALDO SUFICIENTE");
            return true;
        }
    }

    public void compra(double precio) {

        saldo = saldo - precio;
    }

    public String datos () {

        return "NUMERO DE TARJETA: " +numero +", FECHA DE CADUCIDAD: "+fecha +", SALDO " +saldo +"€"; 
    }
}