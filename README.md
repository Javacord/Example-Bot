# Javacord Example Bot <a href="https://javacord.org/wiki"><img src="https://shields.javacord.org/badge/Wiki-Home-red.svg?style=flat-square" alt="Javacord Wiki"></a> <a href="https://discord.gg/0qJ2jjyneLEgG7y3"><img src="https://shields.javacord.org/discord/151037561152733184.svg?colorB=%237289DA&label=Discord&style=flat-square" alt="Discord Server"></a>
This bot is an example for the [Javacord](https://github.com/Javacord/Javacord) library.

## Features

The bot currently supports the following commands:
- **`!copyAvatar`**
Sets the avatar of the bot to the avatar of the user who used this command. This command can only be used by the creator of the bot.
You can find the implementation here: [CopyAvatarCommand.java](https://github.com/Javacord/Example-Bot/blob/master/src/main/java/org/javacord/examplebot/command/CopyAvatarCommand.java)
- **`!userInfo`**
Shows some basic information (id, name, etc.) about the user who used this command. You can find the implementation here: [UserInfoCommand.java](https://github.com/Javacord/Example-Bot/blob/master/src/main/java/org/javacord/examplebot/command/UserInfoCommand.java)

## Running the bot

After compiling the bot using Maven (take a look at the [pom.xml](https://github.com/Javacord/Example-Bot/blob/master/pom.xml)),
you can run the bot using `java -jar examplebot.jar yourBotToken`. You can view the login process by looking at the 
[Main.java](https://github.com/Javacord/Example-Bot/blob/master/src/main/java/org/javacord/examplebot/Main.java)
class.
