package utils;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import models.Currency;

public class Api {

    public static Currency checkConvertionRate(String currencyBaseCode,
                                               String convertedCurrencyCode, Scanner scan) {
        try {
            String apiKey = "b277d7a83ed06784170a5624";
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currencyBaseCode;

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            String req_lasUpdate = jsonobj.get("time_next_update_utc").getAsString();
            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

            if ( !conversionRates.has(convertedCurrencyCode)) {
                System.out.println("Moéda Inválida.");
                return null;
            }

            System.out.println("Digite quanto de " + currencyBaseCode
                    + " você deseja converter para "+ convertedCurrencyCode + ": ");
            double amountToConvert = scan.nextDouble();

            double convertedAmountCurrent = amountToConvert * conversionRates
                    .get(convertedCurrencyCode).getAsDouble();

            return new Currency( currencyBaseCode, convertedCurrencyCode,
                    amountToConvert, convertedAmountCurrent, req_lasUpdate);

        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro! Incapaz de conectar com o servidor.");
        }
    }
}
