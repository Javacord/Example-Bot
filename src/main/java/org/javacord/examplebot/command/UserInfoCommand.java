package org.javacord.examplebot.command;

import org.javacord.api.entity.activity.Activity;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.stream.Collectors;

public class UserInfoCommand implements MessageCreateListener {

    /*
     * This command can be used to display information about the user who used the command.
     * It's a good example for the MessageAuthor, MessageBuilder and ExceptionLogger class.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        // Check if the message content equals "!userInfo"
        if (event.getMessageContent().equalsIgnoreCase("!userInfo")) {
            MessageAuthor author = event.getMessage().getAuthor();
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("User Info")
                    .addInlineField("Display Name", author.getDisplayName())
                    .addInlineField("Name + Discriminator", author.getDiscriminatedName())
                    .addInlineField("User Id", author.getIdAsString())
                    .setAuthor(author);
            // Keep in mind that a message author can either be a webhook or a normal user
            author.asUser().ifPresent(user -> {
                embed.addInlineField("Online Status", user.getStatus().getStatusString());
                embed.addField("Connected Clients", user.getCurrentClients().toString());
                // The User#getActivities() method returns a set which might be empty
                embed.addInlineField("Activities", user.getActivities().isEmpty() ? "none"
                        : user.getActivities().stream().map(Activity::getName).collect(Collectors.joining(", ")));
            });
            // Keep in mind that messages can also be sent as private messages
            event.getMessage().getServer()
                    .ifPresent(server -> embed.addInlineField("Server Admin", author.isServerAdmin() ? "yes" : "no"));
            // Send the embed. It logs every exception, besides missing permissions (you are not allowed to send message in the channel)
            event.getChannel().sendMessage(embed)
                    .exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
        }
    }

}
