package Commands;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Listeners extends ListenerAdapter{
    //This creates the List and hold CommandData as a data type.
    private final List<CommandData> commands;
    //I think this checks to see if a command was updated or not and starts as a default
    // of false
    private boolean updated = false;
    //This try's to hear if a command was done. "This." tells java this is an object.

    public Listeners(@NotNull List<CommandData> commands) {
        this.commands = commands;
    }
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        if (updated) return; // Return if already updated
        updated = true;
        //This adds and updates the commands as well as what parameters to look for.
        event.getJDA().updateCommands().addCommands(
                Commands.slash("dmme","sends you a message"),
                Commands.slash("randomloadout","Gives Random Load Out"),
                Commands.slash("semirandomloadout","Gives more fair loadout"),
                Commands.slash("new","test"),
                Commands.slash("solorules","Rules for randomizer as a solo player"),
                Commands.slash("grouprules","Rules for randomizer as a group")
        ).queue();
    }

}

