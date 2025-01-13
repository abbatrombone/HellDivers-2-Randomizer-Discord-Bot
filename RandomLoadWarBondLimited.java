package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RandomLoadWarBondLimited extends ListenerAdapter {

    private JDABuilder SelectionMenu;


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getInteraction().getName().equals("warbond")) {
            StringSelectMenu menu = StringSelectMenu.create("menu:class")
                    .setPlaceholder("Choose your WarBonds")
                    .setRequiredRange(1, 14)
                    .addOption("Killzone","Killzone")
                    .addOption("Pre-Order","Pre-Order")
                    .addOption("Super Store","Super Store")
                    .addOption("Chemical Agents", "Chemical Agents")
                    .addOption("Cutting Edge", "Cutting Edge")
                    .addOption("Democratic Detonation", "Democratic Detonation")
                    .addOption("Freedom's Flame", "Freedom's Flame")
                    .addOption("Helldivers Mobilize", "Helldivers Mobilize")
                    .addOption("Polar Patriots", "Polar Patriots")
                    .addOption("Steeled Veterans", "Steeled Veterans")
                    .addOption("Truth Enforcers", "Truth Enforcers")
                    .addOption("Urban Legends", "Urban Legends")
                    .addOption("Viper Commandos", "Viper Commandos")
                    .setDefaultValues("Chemical Agents","Cutting Edge","Democratic Detonation","Freedom's Flame","Helldivers Mobilize","Polar Patriots","Steeled Veterans","Truth Enforcers","Urban Legends","Viper Commandos") //Maybe Default to everyone
                    .build();

            event.replyEmbeds(menuEmbed().build())
                    .setEphemeral(true)
                    .addActionRow(menu)
                    .queue();

        }
    }

    private EmbedBuilder menuEmbed(){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Select Your Warbonds");
        embedBuilder.setDescription("This adds the items in the war bond to the randomizer");
        embedBuilder.setFooter("Democracy");

        return embedBuilder;
    }
}
