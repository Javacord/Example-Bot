package de.btobastian.examplebot;

import de.btobastian.javacord.DiscordApi;
import de.btobastian.javacord.DiscordApiBuilder;

public class Main {

    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide a valid token as the first argument!");
            return;
        }

        String token = args[0];

        // We login blocking, just because it is simpler and doesn't matter here
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Add listeners
        api.addMessageCreateListener(new CopyAvatarCommand());
    }

}
