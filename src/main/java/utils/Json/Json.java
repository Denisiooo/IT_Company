package utils.Json;

import hierarchy.Financing;
import hierarchy.Investors;
import hierarchy.Programmers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Json {

    private static final Logger LOGGER = LogManager.getLogger(Json.class);

    public static void main(String[] args) throws IOException {
        String json = (new BufferedReader(new FileReader("Programmers.json"))).readLine();
        Programmers programmers = new Programmers(1, "Fursevich", "Denis",
                "Eugenievich", 132, "2000-08-08");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(programmers);
        System.out.println(result);

        String json2 = (new BufferedReader(new FileReader("Financing.json"))).readLine();
        Financing financing = new Financing(1, 1, 2, "Prog", 500);
        result = mapper.writeValueAsString(financing);
        System.out.println(result);

        String json3 = (new BufferedReader(new FileReader("Investors.json"))).readLine();
        Investors investors = new Investors(1, "Denis", "Minsk", 159);
        result = mapper.writeValueAsString(investors);
        System.out.println(result);

    }
}
