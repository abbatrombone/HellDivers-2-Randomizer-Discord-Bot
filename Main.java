package me.abbatrombone.traz;

import Commands.*;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.apache.commons.lang.SystemUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<CommandData> commands = new ArrayList<>();
        commands.add(Commands.slash("randomloadout","Gives Random Load Out"));
        commands.add(Commands.slash("dmme", "bot messages you"));
        commands.add(Commands.slash("semirandomloadout","Gives more fair loadout"));
        commands.add(Commands.slash("solorules","Rules for randomizer as a solo player"));
        commands.add(Commands.slash("grouprules","Rules for randomizer as a group"));

        JDA bot = JDABuilder.createDefault(ApiController.key())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .setActivity(Activity.playing("Helping Super Earth"))
                .addEventListeners(new Listeners(commands))
                .addEventListeners(new RandomLoadOut())
                .addEventListeners(new semirandomloadout())
                .addEventListeners(new dmme())
                .addEventListeners(new news())
                .addEventListeners(new SoloRules())
                .addEventListeners(new grouprules())
                .addEventListeners(new RandomLoadWarBondLimited())
                .addEventListeners(new StringSelectionInteractionListener())
                .build();
    }
}

//https://discordapp.com/oauth2/authorize?&client_id=1325577071698903111&permissions=277025458240&scope=bot
//To add bot replace [CLIENTID] with client Id in the server with what the discord devlopers page
//https://discordapp.com/oauth2/authorize?&client_id=[CLIENTID]&permissions=277025458240&scope=bot