package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class news extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("new")) {
            //https://helldiverstrainingmanual.com/api/v1/war/status
            //https://helldiverstrainingmanual.com/api/v1/war/info
            //https://helldiverstrainingmanual.com/api/v1/war/news
            //https://helldiverstrainingmanual.com/api/v1/war/campaign
            //https://helldiverstrainingmanual.com/api/v1/war/history/[planetIndex]
            //https://helldiverstrainingmanual.com/api/v1/war/major-orders
            //https://helldiverstrainingmanual.com/api/v1/planets

            String URL = "https://helldiverstrainingmanual.com/api/v1/planets";
            JSONObject json;
            {
                try {
                    json = readJsonFromUrl(URL);
                    System.out.println(json.toString());
                    event.reply(json.toString()).queue();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    private static String readAll(Reader rd) throws IOException{
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp =rd.read()) != -1){
            sb.append((char)cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    public static JsonNode get(URL url) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(String.valueOf(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String getPlanet(){
       String planet = "";

        return planet;
    }

    JSONObject json;
    {
        try {
            json = readJsonFromUrl("https://helldiverstrainingmanual.com/api/v1/planets");
            System.out.println(getPlanet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}






