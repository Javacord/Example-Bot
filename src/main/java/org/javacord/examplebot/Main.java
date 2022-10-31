package org.javacord.examplebot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;
import org.javacord.examplebot.command.CopyAvatarCommand;
import org.javacord.examplebot.command.UserInfoCommand;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * The entrance point of our program.
     *
     * @param args The arguments for the program. The first element should be the bot's token.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Please provide a valid token as the first argument!");
            return;
        }

        // Enable debugging, if no slf4j logger was found
        FallbackLoggerConfiguration.setDebug(true);

        // The token is the first argument of the program
        String token = args[0];

        // We login blocking, just because it is simpler and doesn't matter here
        // Also we need all intents to get message content and user activities.
        DiscordApi api = new DiscordApiBuilder().setToken(token).setAllIntents().login().join();

        // Print the invite url of the bot
        logger.info("You can invite me by using the following url: " + api.createBotInvite());

        // Add listeners
        api.addMessageCreateListener(new CopyAvatarCommand());
        api.addMessageCreateListener(new UserInfoCommand());

        // Log a message, if the bot joined or left a server
        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }

}
