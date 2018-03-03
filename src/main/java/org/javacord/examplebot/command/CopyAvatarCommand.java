package org.javacord.examplebot.command;

import org.javacord.event.message.MessageCreateEvent;
import org.javacord.listener.message.MessageCreateListener;

public class CopyAvatarCommand implements MessageCreateListener {

    /*
     * This command can be used to set the bot's avatar.
     * It can only be used by the bot's owner.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        // Check if the message content equals "!copyAvatar"
        if (event.getMessage().getContent().equalsIgnoreCase("!copyAvatar")) {

            // Check if the author is the creator of the bot (you!).
            // You don't want that everyone can set the bot's avatar.
            if (!event.getMessage().getAuthor().isBotOwner()) {
                event.getChannel().sendMessage("You are not allowed to use this command!");
                return;
            }

            event.getApi()
                    .updateAvatar(event.getMessage().getAuthor().getAvatar()) // Update the avatar
                    .thenAccept(aVoid -> event.getChannel().sendMessage("Ok, I'm now using your avatar :-)")) // Send the user a message if the update was successful
                    .exceptionally(throwable -> {
                        // Send the user a message, if the update failed
                        event.getChannel().sendMessage("Something went wrong: " + throwable.getMessage());
                        return null;
                    });
        }
    }

}
