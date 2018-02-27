# Javacord Example Bot
This bot is an example for the [Javacord](https://github.com/BtoBastian/Javacord) library.

## Features

The bot currently supports the following commands:
- **`!copyAvatar`**
Sets the avatar of the bot to the avatar of the user who used this command. This command can only be used by the creator of the bot.
You can find the implementation here: [CopyAvatarCommand.java](https://github.com/BtoBastian/JavacordExampleBot/blob/master/src/main/java/de/btobastian/examplebot/CopyAvatarCommand.java)
- **`!userInfo`**
Shows some basic information (id, name, etc.) about the user who used this command. You can find the implementation here: [UserInfoCommand.java](https://github.com/BtoBastian/JavacordExampleBot/blob/master/src/main/java/de/btobastian/examplebot/UserInfoCommand.java)

## Running the bot

After compiling the bot using Maven (take a look at the [pom.xml](https://github.com/BtoBastian/JavacordExampleBot/blob/master/pom.xml)),
you can run the bot using `java -jar examplebot.jar yourBotToken`. You can view the login process by looking at the 
[Main.java](https://github.com/BtoBastian/JavacordExampleBot/blob/master/src/main/java/de/btobastian/examplebot/Main.java)
class.
