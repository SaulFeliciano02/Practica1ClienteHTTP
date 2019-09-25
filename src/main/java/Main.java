import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException
    {
        System.out.println("Introduzca una URL válida (debe agregar un espacio al final de la URL para poder introducirla)");
        Scanner scan = new Scanner(System.in);
        String url = scan.next();
        Document d = Jsoup.connect(url).get();

       //Apartado dos (Parrafos)
        int pValue = 0;
        Elements parrafos = d.select("p");
        for (Element ele: parrafos
             ) {
            pValue++;
        }
        System.out.println("Número de párrafos en el documento HTML: " + pValue);

        //Apartado tres imagenes dentro de parrafos
        int imgValue = 0;
        Elements images = d.select("p img");
        for (Element ele: images
        ) {
            imgValue++;
        }
        System.out.println("Número de imágenes dentro de párrafos en el documento HTML: " + imgValue);

        //Apartado cuatro formularios POST y GET

        int formValue = 0;
        Elements formsPOST = d.select("form[method=post]");
        for (Element ele: formsPOST
        ) {
            formValue++;
        }
        System.out.println("Número de formularios de método POST en el documento HTML: " + formValue);

        int formValue2 = 0;
        Elements formsGET = d.select("form[method=get]");
        for (Element ele: formsGET
        ) {
            formValue2++;
        }
        System.out.println("Número de formularios de método GET en el documento HTML: " + formValue2);

        //Apartado cinco Inputs en formularios y su respectivo tipo
        int inputValue = 0;
        Elements inputs = d.select("form input");
        for (Element ele: inputs
        ) {
            inputValue++;
            String tipo = ele.attr("type");
            System.out.println("Input " + inputValue + " tipo: " + tipo);
        }

    }
}
