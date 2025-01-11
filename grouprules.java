package Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class grouprules extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("grouprules")) {
            event.reply("""
                    You must use the load out given, difficulty and operation type if possiable.
                    If you do not have that weapon, thrown, armor, etc. Use the closet thing to it.
                    For example Gas mines would be incinerarry mines. Go into a random lobby or your own lobby.
                    Use every part of your build, and you cannot pick up random dropped weapons. You can however, 
                    get one from your team should they be able to share.
                    you find. You are given 4 boosters, pick the first one that is avaiable starting with 1. Completing the mission is victory! 
                    """).queue();

        }
    }
}
