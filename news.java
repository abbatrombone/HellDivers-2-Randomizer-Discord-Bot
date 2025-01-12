package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import javax.swing.event.MenuListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static java.util.logging.Level.parse;

public class news extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("plant")) {
            //https://helldiverstrainingmanual.com/api/v1/war/status
            //https://helldiverstrainingmanual.com/api/v1/war/info
            //https://helldiverstrainingmanual.com/api/v1/war/news
            //https://helldiverstrainingmanual.com/api/v1/war/campaign
            //https://helldiverstrainingmanual.com/api/v1/war/history/[planetIndex]
            //https://helldiverstrainingmanual.com/api/v1/war/major-orders
            //https://helldiverstrainingmanual.com/api/v1/planets

            String URL = "https://helldiverstrainingmanual.com/api/v1/planets";


            OptionMapping userinput = event.getOption("planet");
            final String planet = userinput.getAsString() == null ? "" : userinput.getAsString();

            try {
               String answer = String.valueOf(getPlanetId(planetLists(URL),planet));
               if(planet.equals("Super Earth") || userinput.getAsString().equals("Super Earth")){
                   event.reply("Please report to your highest ranking officer Helldiver").setEphemeral(true).queue();
               }else{
                   event.reply(getPlantInfo(URL,answer)).setEphemeral(true).queue();
               }
            } catch (IOException e) {
                throw new RuntimeException(e);
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

    public static JSONObject planetList(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        ArrayList<String> planetList = new ArrayList<>();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            for (int i = 0; i < 260; i++) {

                JSONObject planetDetails = (JSONObject)json.get(String.valueOf(i));
                String planetName = (String) planetDetails.get("name");
                planetList.add(planetName);
            }
            //System.out.println(planetList.indexOf("Zagon Prime"));
            return (JSONObject) json.get("0");
        } finally {
            is.close();
        }

    }
    public static ArrayList<String>planetLists(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        ArrayList<String> planetList = new ArrayList<>();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            for (int i = 0; i < 260; i++) {

                JSONObject planetDetails = (JSONObject)json.get(String.valueOf(i));
                String planetName = (String) planetDetails.get("name");
                planetList.add(planetName);
            }
            //System.out.println(planetList.indexOf("Zagon Prime"));
            return planetList;
        } finally {
            is.close();
        }

    }

    public static int getPlanetId(ArrayList<String> planetList, String planetName){
        int planetId = planetList.indexOf(planetName);
            return planetId;

    }

    public static String getPlantInfo(String url, String planetNumber)throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            JSONObject planetDetails = (JSONObject)json.get(planetNumber);
            String planetName = (String) planetDetails.get("name");
            String sector = (String) planetDetails.get("sector");
            ArrayList<String> enviromentDetails = new ArrayList<>();

            JSONObject biome = (JSONObject) planetDetails.get("biome");
            String elevation;
            String biomedescription;
            if(biome != null){
                elevation = (String) biome.get("slug");
                biomedescription = (String) biome.get("description");
            }else{
                elevation = "";
                biomedescription = "";
            }


            JSONArray environmentals = (JSONArray) planetDetails.get("environmentals");
            int envCount = environmentals.length();

            for (int i = 0; i < envCount; i++) {
                JSONObject envType = (JSONObject) environmentals.get(i);
                String envName = (String) envType.get("name");
                String envDesc = (String) envType.get("description");
                enviromentDetails.add(envName + ": " + envDesc);
            }

            String message = "Sector: " + sector + "\nPlanet Name: " + planetName +  "\n" + elevation + ": " +biomedescription + "\n" + enviromentDetails.toString().replace("[","").replace("]","").replace(",","\n");

            return message;
        } finally {
            is.close();
        }
    }
    private EmbedBuilder planetEmbed(String planet){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Test Title");
        embedBuilder.setDescription("Test Desc");
        embedBuilder.setFooter("Test Footer");

        return embedBuilder;
    }

}






