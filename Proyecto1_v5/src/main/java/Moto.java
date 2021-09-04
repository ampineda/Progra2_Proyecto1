//package Proyecto1;
import java.util.Date;

/**
 * En esta clase se definen las propiedades que tiene un vehiculo de tipo Moto para
 * ser registrado en un parqueo (en este caso el vehiculo solo puede ser una Moto)
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Moto extends Vehiculo{

    /**
     * constructor de la clase Automovil, sin parametros
     */
    public Moto(){

        super();

    }

    /**
     * Constructor para inicializar las propiedades de un Vehiculo de tipo Moto
     * @param placa numero de placa de la moto
     * @param numeroParqueo numero de parqueo asignado a la moto
     * @param fecha fecha de ingreso de la moto al parqueo
     * @param tari  tarifa para aplicar al parqueo de la moto
     */
    /*
    public Moto(String placa, int numeroParqueo,Date fecha, Tarifas tari){

        super(placa, TipoVehiculo.MOTO, tari,numeroParqueo,fecha);
    }
    */


    /**
     * Contructor para inicializar las propiedades de un Vehiculo de tipo Moto
     * @param placa numero de placa de la moto
     * @param numeroParqueo numero de parqueo asignado a la Moto
     * @param fecha fecha de ingreso de la Moto al parqueo
     */
    public Moto(String placa, int numeroParqueo,Date fecha){

        super(placa, TipoVehiculo.MOTO, TarifasVehiculos.getSegundosMoto(), TarifasVehiculos.getTarifaMoto(),numeroParqueo,fecha);
    }

}
