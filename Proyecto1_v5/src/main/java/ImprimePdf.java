import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * En esta Clase se genera una documento pdf y se almacena en
 * el directorio de la aplicacion
 * @author: Pedro Luis de Jesus Hernandez, Angel Magdiel Pineda Cruz
 * @version: 2021/08/31/E
 */

public class ImprimePdf {

    public ImprimePdf(){

    }

    /**
     * Este metodo genera un archivo pdf
     * @param imp   array de String que contiene las lineas que se van a imprimir
     * @param cNombre  nombre del documento que se concatenara a un numero aleatorio para que no halla archivos duplicados
     */
    public static void imprime(String[] imp,String cNombre){

        try {
            Document docu = new Document();

            int numero = (int)(Math.random()*1000000+1);

            String destino = cNombre+numero+".pdf";
            PdfWriter.getInstance(docu,new FileOutputStream(destino));
            docu.open();

            Paragraph p;
            int nSize = imp.length;



            for(int i = 0; i < nSize;i++ ){
                p = new Paragraph(imp[i],new Font(Font.FontFamily.COURIER, 12, Font.BOLD, new BaseColor(0, 0, 0)) );
                docu.add(p);
            }

            docu.close();

            System.out.println("PDF Creado Exitosamente!!!");

        } catch(DocumentException | FileNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }


    }


}
