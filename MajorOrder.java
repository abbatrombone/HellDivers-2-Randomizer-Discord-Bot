package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MajorOrder extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("major")){
            try {
                event.reply(majorOrder("https://helldiverstrainingmanual.com/api/v1/war/major-orders")).setEphemeral(true).queue();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException je){
                event.reply("No Major Order").setEphemeral(true).queue();
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
    //THIS WORKS, need to test with new major order to make sure itll still work\
    public static String majorOrder(String url)throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            JSONArray jsonArray = new JSONArray(jsonText);
            String arrayText = jsonArray.toString();
            JSONObject json = new JSONObject(StringUtils.removeEnd(arrayText.substring(1),"]"));

            String id32 = json.get("id32").toString();
            String progress = json.get("progress").toString();
            String expiresIn = json.get("expiresIn").toString();

            String setting = json.get("setting").toString();
            JSONObject settingObj = new JSONObject(setting);

            String type = settingObj.get("type").toString();
            String overrideTitle = settingObj.get("overrideTitle").toString();
            String overrideBrief = settingObj.get("overrideBrief").toString();
            String taskDescription = settingObj.get("taskDescription").toString();
            String tasks = settingObj.get("tasks").toString();
            String rewards = settingObj.get("rewards").toString();
            String reward = settingObj.get("reward").toString();
            String flags = settingObj.get("flags").toString();

            JSONObject rewardArray = new JSONObject(reward.indent(0));
            String rewardtype = rewardArray.get("type").toString();
            String rewardAmount = rewardArray.get("amount").toString();

            //JSONArray settingObj = (JSONArray) json.get("setting");
            //String type = settingObj.get(0).toString();
            return overrideTitle + " " + json.get("id32").toString() + "\n" + overrideBrief + "\ntasks: " + tasks + "\nExpires IN: " + expiresInConverted(expiresIn)  + "\nrewards: " +  rewardAmount + " " +reward(rewardtype) +  "\nflags: " + flags;
        } finally {
            is.close();
        }
    }

    private static String expiresInConverted(String expiresIn){
        int basetimeInSeconds = Integer.parseInt(expiresIn);
        int seconds = basetimeInSeconds%60;
        int minutues = basetimeInSeconds/60;
        int hours = minutues/60;
        if(hours >= 24){
            int days = hours/24;
            int remainingHours = hours%24;
            return days + "day(s) " + remainingHours + "hour(s) ";
        }
        return hours + "h " + seconds + "s";
    }
    private static String reward(String rewardType) {
        String reward;
        switch (rewardType){
            case "1": reward = "Warbond Metals";
                break;
            default: reward = "Reach out to high command for the reward, after completion";
        }
        return reward;
    }

    public void closeResource(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
                System.out.println("\n" + closeable.getClass().getName() + " Closed ");
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
    }
}
