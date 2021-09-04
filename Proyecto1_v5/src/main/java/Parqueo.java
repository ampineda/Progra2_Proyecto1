//package Proyecto1;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;

/**
 * En esta clase se definen las propiedades que tiene un Parqueo para
 * registrar los vehiculos que le sean enviados, asi como la capacidad
 * maxima de parqueos para Automoviles, Motos y Camiones
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */
public class Parqueo {
  // atributos de la clase
  private ArrayList<Vehiculo> miParqueo = new ArrayList<Vehiculo>();
  private int maxParqueoAuto;
  private int maxParqueoMoto;
  private int maxParqueoCamion;
  private int numeroParqueo=0;

  /**
   * Contructor de la clase sin parametros
   */
  public Parqueo(){
    this.maxParqueoAuto = 0;
    this.maxParqueoMoto = 0;
    this.maxParqueoCamion = 0;
  }

  /**
   * Metodo para agregar un vehiculo de cualquier tipo y
   * Imprime el Ticket de Parqueo
   * a la lista de espacios disponibles en el parqueo
   * @param vehi  Vehiculo que se va a gregar al parqueo
   */
   public void agregarVehiculo(Vehiculo vehi){

       miParqueo.add(vehi);

       DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
       DateFormat formateadorHoraMedia  = DateFormat.getTimeInstance(DateFormat.MEDIUM);
       String fechaIng = formateadorFechaLarga.format(vehi.getFechaIngreso())+" "+formateadorHoraMedia.format(vehi.getFechaIngreso());

       /*
       System.out.println("--- TICKET DE PARQUEO ---");

       System.out.println("NUMERO DE PARQUEO: "+String.format("%03d",vehi.getNumeroParqueo()));
       System.out.println(vehi.getTipo().name()+" PLACA: "+vehi.getPlaca());
       System.out.println("FECHA DE INGRESO: "+fechaIng);
       System.out.println("TARIFA: Q. "+vehi.getTarifaPrecio()+" por cada "+vehi.getTarifaTiempo()+" segundos");
       System.out.println("");
       */


       String[] imprime = new String[6];
       imprime[0] = "----- TICKET DE PARQUEO -----";
       imprime[1] = "\n";
       imprime[2] = "NUMERO DE PARQUEO: "+String.format("%03d",vehi.getNumeroParqueo());
       imprime[3] = vehi.getTipo().name()+" PLACA: "+vehi.getPlaca();
       imprime[4] = "FECHA DE INGRESO: "+fechaIng;
       imprime[5] = "TARIFA: Q. "+vehi.getTarifaPrecio()+" por cada "+vehi.getTarifaTiempo()+" segundos";

       System.out.println("");
       System.out.println("Imprimiendo el Ticket de Parqueo. Espere un momento por favor...");
       ImprimePdf.imprime(imprime,"Ticket");

       System.out.println("");



   }

  /**
   * En este metodo se obtiene el numero maximo de parqueos de Automoviles
   * @return maxParqueoAuto numero de parqueos asignados a los automoviles
   */
    public int getMaxParqueoAuto() {

      return maxParqueoAuto;

    }

  /**
   * En este metodo asigna el numero maximo de parqueos de Automoviles
   * @param maxParqueoAuto numero de parqueos asignados a los automoviles
   */
  public void setMaxParqueoAuto(int maxParqueoAuto) {

      this.maxParqueoAuto = maxParqueoAuto;

    }

  /**
   * En este metodo se obtiene el numero maximo de parqueos de Motos
   * @return  numero de parqueos asignados a las Motos
   */
    public int getMaxParqueoMoto() {

      return maxParqueoMoto;

    }

  /**
   * En este metodo asigna el numero maximo de parqueos de Motos
   * @param maxParqueoMoto numero de parqueos asignados a las Motos
   */
  public void setMaxParqueoMoto(int maxParqueoMoto) {

        this.maxParqueoMoto = maxParqueoMoto;

    }

  /**
   * En este metodo se obtiene el numero maximo de parqueos de Camiones
   * @return numero de parqueos asignados a los Camiones
   */
  public int getMaxParqueoCamion() {

      return maxParqueoCamion;

    }

  /**
   * En este metodo asigna el numero maximo de parqueos de Camiones
   * @param maxParqueoCamion numero de parqueos asignados a los Camiones
   */
  public void setMaxParqueoCamion(int maxParqueoCamion) {

      this.maxParqueoCamion = maxParqueoCamion;

    }

  /**
   * Metodo que devuelve un numero de parqueo disponible para el tipo
   * de vehiculo indicado (Automovil, Moto o Camion)
   * si no hubiera disponible un parqueo para el tipo de vehiculo
   * se devuelve el numero -1
   * @param tipoParqueo tipo de vehiculo que se quiere el parqueo
   * @return numero de parqueo asignado al vehiculo
   */
  public int getNumeroParqueo(TipoVehiculo tipoParqueo){
      int nRetorno = 0;

      String tipoSolicitado = tipoParqueo.getCodigo();

      this.numeroParqueo = 1;


      miParqueo.forEach((movil) -> {

        // System.out.println(movil);

        String tipoActual = movil.getTipo().getCodigo();
        int numeroActual = movil.getNumeroParqueo();

        if(tipoSolicitado.equalsIgnoreCase(tipoActual) ){


          if(this.numeroParqueo == numeroActual){
            this.numeroParqueo = this.numeroParqueo+1;
          }

        }

      });


      switch (tipoSolicitado){
        case "1":

          if(this.numeroParqueo<=this.maxParqueoMoto){
            nRetorno = this.numeroParqueo;
          } else{
            nRetorno = -1;
          }

          break;
        case "2":
          if(this.numeroParqueo<=this.maxParqueoAuto){
            nRetorno = this.numeroParqueo;
          } else{
            nRetorno = -1;
          }

          break;
        case "3":
          if(this.numeroParqueo<=this.maxParqueoCamion){
            nRetorno = this.numeroParqueo;
          } else{
            nRetorno = -1;
          }

          break;
      }


      return nRetorno;
    }


  /**
   * Este metodo recorre los vehiculos que esten en el parqueo
   * y muestra en pantalla la informacion de cada vehiculo
   */
  public void MostrarParqueo(){
        miParqueo.forEach((movil) -> {
            System.out.println(movil);
        });
    }

  /**
   * Este metodo saca un Vehiculo del parqueo y
   * Imprime la factura por el parqueo
   * para esto recorre toda la lista de vehiculos y busca
   * el numero de placa, si lo encuentra lo saca del parqueo
   * @param placa numero de placa
   */
  public void SacaVehiculoParqueo(String placa){

      int nEliminar = -1;
      int nSize = 0;

      nSize = miParqueo.size();
      Vehiculo movil = new Vehiculo();

      if(nSize>0){

        for(int i=0;i<nSize;i++){

          movil = miParqueo.get(i);

          if(movil.getPlaca().equalsIgnoreCase(placa)){
            nEliminar = i;
            break;
          }

        }

      }

      if(nEliminar>=0){
        //System.out.println("el vehiculo es: "+movil.toString());
        miParqueo.remove(nEliminar);

        // Calculo de la tarifa a pagar
        Date fechaSalida = new Date();
        float segundosCobrar = (float) ((fechaSalida.getTime()/1000) - (movil.getFechaIngreso().getTime()/1000));

        //System.out.println("pasaron "+segundosCobrar+" cantidad de segundos entre una fecha y otra");

        // calculo de tarifas
        TipoVehiculo tipo = movil.getTipo();

        int segundosPorPeriodo = 0;
        double tarifaPorPeriodo = 0.00;
        double periodosPorCobrar = 0.00;
        double periodosExtra = 0.00;
        double subTotal = 0.00;
        double descuento = 0.00;
        double recargo = 0.00;
        double total = 0.00;

        segundosPorPeriodo = movil.getTarifaTiempo();
        tarifaPorPeriodo = movil.getTarifaPrecio();

        if(segundosPorPeriodo > 0){
           periodosPorCobrar = (segundosCobrar/segundosPorPeriodo);
        }

        subTotal = periodosPorCobrar * tarifaPorPeriodo;

          switch (tipo.getCodigo()){
              case "1":
                  descuento = subTotal * 0.10;
                  break;
              case "2":

                  break;
              case "3":

                  periodosExtra = periodosPorCobrar - 1;

                  if(periodosExtra>0.00){
                      recargo = periodosExtra * 5.00;
                  }

                  break;
              default:
                  break;
          }

          total = (subTotal + recargo) - descuento;


          String cImprimir = Utilidades.pideString("¿Desea imprimir la Factura?\nIngrese Si o No",
                  "ERROR: Ingrese Si o No");

          if(cImprimir.equalsIgnoreCase("si")){

              String cNit = "C/F";

              String cPedirNit = Utilidades.pideString("¿Desea ingresar el NIT para la Factura?\nIngrese Si o No",
                      "ERROR: Ingrese Si o No");

              if(cPedirNit.equalsIgnoreCase("si")){
                  cNit = Utilidades.validaNit("Ingrese un numero de NIT o Ingrese C/F",
                          "ERROR: Ingrese un numero de NIT valido o ingrese C/F");

              }

              String cNombre = Utilidades.pideString("Ingrese el Nombre del Cliente:",
                      "ERROR: el nombre esta vacio");

              DateFormat formateadorFechaLarga = DateFormat.getDateInstance(DateFormat.LONG);
              DateFormat formateadorHoraMedia  = DateFormat.getTimeInstance(DateFormat.MEDIUM);
              String fechaIng = formateadorFechaLarga.format(movil.getFechaIngreso())+" "+formateadorHoraMedia.format(movil.getFechaIngreso());
              String fechaSal = formateadorFechaLarga.format(fechaSalida)+" "+formateadorHoraMedia.format(fechaSalida);

              /*
              System.out.println("--- FACTURA ---");

              System.out.println("NIT: "+cNit);
              System.out.println("CLIENTE: "+cNombre);
              System.out.println("NUMERO DE PARQUEO: "+String.format("%03d",movil.getNumeroParqueo()));
              System.out.println("FECHA DE INGRESO: "+fechaIng);
              System.out.println("FECHA DE SALIDA:    "+fechaSal);
              System.out.println(TipoVehiculo.MOTO.name()+" PLACA: "+placa);
              System.out.println("--- RESUMEN DE LA FACTURA ---");
              System.out.println("TIEMPO TOTAL EN EL PARQUEO: "+segundosCobrar+" segundos");
              System.out.println("SUB-TOTAL  (+): "+String.format("%.2f", subTotal));
              System.out.println("RECARGO    (+): "+String.format("%.2f", recargo));
              System.out.println("DESCUENTOS (-): "+String.format("%.2f", descuento));
              System.out.println("TOTAL:          "+String.format("%.2f", total));
              */

              String[] imprime = new String[15];
              imprime[0] = "--- FACTURA ---";
              imprime[1] = "\n";
              imprime[2] = "NIT: "+cNit;
              imprime[3] = "CLIENTE: "+cNombre;
              imprime[4] = "NUMERO DE PARQUEO: "+String.format("%03d",movil.getNumeroParqueo());
              imprime[5] = "FECHA DE INGRESO: "+fechaIng;
              imprime[6] = "FECHA DE SALIDA:    "+fechaSal;
              imprime[7] = TipoVehiculo.MOTO.name()+" PLACA: "+placa;
              imprime[8] = "\n";
              imprime[9] = "--- RESUMEN DE LA FACTURA ---";
              imprime[10] = "TIEMPO TOTAL EN EL PARQUEO: "+segundosCobrar+" segundos";
              imprime[11] = "SUB-TOTAL  (+): "+String.format("%.2f", subTotal);
              imprime[12] = "RECARGO    (+): "+String.format("%.2f", recargo);
              imprime[13] = "DESCUENTOS (-): "+String.format("%.2f", descuento);
              imprime[14] = "TOTAL:          "+String.format("%.2f", total);

              System.out.println("Imprimiendo la Factura. Espere un momento por favor...");
              ImprimePdf.imprime(imprime,"Factura");

              System.out.println("");

          }

      }
      else{
          System.out.println("ERROR: NO SE ENCONTRO UN VEHICULO CON EL NUMERO DE PLACA "+placa);
      }



      // Pedro aca se calculan la cantidad de segundos entre la hora de entrada y de salida del vehiculo
      // fecha de salida del parqueo
      /*
      Date fechaSalida = new Date();
      float segundosCobrar = (float) ((fechaSalida.getTime()/1000) - (movil.getFechaIngreso().getTime()/1000));

      System.out.println("pasaron "+segundosCobrar+" cantidad de segundos entre una fecha y otra");



       */
      /// Aqui debe ir codigo que calcule el total a pagar por el cliente //
      // la clase que tiene los datos del vehiculo es
      // movil
      /*
      // los tipos de vehiculo son los siguientes
      String tipoCamion = TipoVehiculo.CAMION.getCodigo();
      String tipoCarro = TipoVehiculo.AUTOMOVIL.getCodigo();
      String tipoMoto = TipoVehiculo.MOTO.getCodigo();
      // TipoVehiculo

      // TarifaMoto

      // la clase vehiculo tiene
      // tarifaTiempo es la base de calculo en segundos
      // tarifaPrecio es la base de calculo en dinero por segundos
      if(tipo.equalsIgnoreCase("3")){

      }
      */



    }

}



