import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public  class Principal {
     public static void main(String[] args) throws IOException, InterruptedException {
          Scanner teclado = new Scanner(System.in);
          System.out.println("Ingrese en mayuscula las iniciales de la moneda");
          var tiposDeCambio = teclado.nextLine();
          String moneda ="https://v6.exchangerate-api.com/v6/" + "b9d3f34a09fa50078a373291" + "/latest/" + tiposDeCambio ;

          HttpClient client = HttpClient.newHttpClient();
          HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create(moneda))
                  .build();
          HttpResponse<String> response = client
                  .send(request, HttpResponse.BodyHandlers.ofString());
          String json = response.body();
          System.out.println(json);
          Gson gson = new Gson();
          Monedas monedas1 = gson.fromJson(json, Monedas.class);
          System.out.println(monedas1.getDolarEstadounidense());


     }
}