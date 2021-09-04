//package Proyecto1;
import java.util.Date;

/**
 * En esta clase se definen las propiedades que tiene un vehiculo de tipo Camion para
 * ser registrado en un parqueo (en este caso el vehiculo solo puede ser un Camion)
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class Camion extends Vehiculo {

    /**
     * constructor de la clase Automovil, sin parametros
     */
    public Camion(){

        super();

    }

    /**
     * Constructor para inicializar las propiedades de un Vehiculo de tipo Camion
     * @param placa numero de placa del Camion
     * @param numeroParqueo numero de parqueo asignado al Camion
     * @param fecha fecha de ingreso del Camion al parqueo
     * @param tari  tarifa para aplicar al parqueo del Camion
     */
    /*
    public Camion(String placa, int numeroParqueo,Date fecha, Tarifas tari){

        super(placa, TipoVehiculo.CAMION, tari,numeroParqueo,fecha);

    }
    */

    /**
     * Contructor para inicializar las propiedades de un Vehiculo de tipo Camion
     * @param placa numero de placa del Camion
     * @param numeroParqueo numero de parqueo asignado al Camion
     * @param fecha fecha de ingreso del Camion al parqueo
     */
    public Camion(String placa, int numeroParqueo,Date fecha){

        super(placa, TipoVehiculo.CAMION, TarifasVehiculos.getSegundosCamion(), TarifasVehiculos.getTarifaCamion(),numeroParqueo,fecha);
    }

}
