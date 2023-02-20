import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import static javax.swing.JOptionPane.*;


class POSTDB {

}







public class Main {

    public static void main(String[] args) throws Exception{

        String inpCountry = showInputDialog(null, "What country do you want to search for? \n(use the shortened name, example 'nor' for norway or 'swe' for sweden) ");


        URL url = new URL("https://restcountries.com/v2/alpha/" + inpCountry + "/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();


        int responseCode = con.getResponseCode();

        // Responsecode 200 == successful connection

        if (responseCode != 200){
            throw new RuntimeException("HttpResponseCode: " + responseCode);

        } else {

            // Oppretter stringbuilder for å bedre behandle strings

            StringBuilder data = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            // Legger til data til stringbuilder variabelen

            while (scanner.hasNextLine()){
                data.append(scanner.nextLine());
            }
            scanner.close();

            String dataToString = data.toString();
            String dataReplace = dataToString.replaceAll("([\",:{}])", " ").replaceAll("([\\]])", " ").replaceAll("([\\[])", "").replaceAll(" ", "-");
            String[] dataSplit = dataReplace.split("-");

            String name = null;
            String population = null;
            String area = null;
            String currency = null;
            String language = null;
            String capital = null;
            
            loop: for (int i =1; i < dataSplit.length; i++){
                switch (dataSplit[i]) {
                    case "name" -> {
                        name = dataSplit[i + 3];
                        //System.out.println("Name: " + name);

                    }
                    case "population" -> {
                        population = dataSplit[i + 2];
                        //System.out.println("Population: "+population);

                    }
                    case "area" -> {
                        area = dataSplit[i + 2];
                        //System.out.println("Area: " + area);

                    }
                    case "currencies" -> {
                        currency = dataSplit[i + 7];
                        //System.out.println("Currencies: " + currency);
                    }
                    case "languages" -> {
                        language = dataSplit[i + 19];
                        //System.out.println("Languages: " + language);
                        break loop;
                    }

                    case "capital" -> {
                        capital = dataSplit[i+3];
                        //System.out.println("Capital: " + capital);

                    }
                }

            }

            double popDouble = Double.parseDouble(population);
            float intArea = Float.parseFloat(area);

            Country newCountry = new Country(name, capital, popDouble, intArea, language, currency);


            showMessageDialog(null, "Name: " + newCountry.getName()
                              +"\nCapital: " + newCountry.getCapital()
                              +"\nPopulation: " + newCountry.getPopulation()
                              +"\nArea: " + newCountry.getArea()
                              +"\nLanguage: " + newCountry.getLanguage()
                              +"\nCurrency: " + newCountry.getCurrency());


        }
    }
}
