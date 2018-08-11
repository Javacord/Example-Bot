# Javacord Example Bot <a href="https://javacord.org/wiki"><img src="https://shields.javacord.org/badge/Wiki-Home-red.svg?style=flat-square" alt="Javacord Wiki"></a> <a href="https://discord.gg/0qJ2jjyneLEgG7y3"><img src="https://shields.javacord.org/discord/151037561152733184.svg?colorB=%237289DA&label=Discord&style=flat-square" alt="Discord Server"></a>
This bot is an example for the [Javacord](https://github.com/Javacord/Javacord) library.

## Features

The bot currently supports the following commands:
- **`!copyAvatar`**
Sets the avatar of the bot to the avatar of the user who used this command. This command can only be used by the creator of the bot.
You can find the implementation here: [CopyAvatarCommand.java](https://github.com/Javacord/Example-Bot/blob/master/src/main/java/org/javacord/examplebot/command/CopyAvatarCommand.java)
- **`!userInfo`**
Shows some basic information (id, name, etc.) about the user who used this command. You can find the implementation here: [UserInfoCommand.java](https://github.com/Javacord/Example-Bot/blob/master/src/main/java/org/javacord/examplebot/command/UserInfoCommand.java)

## Running the bot for testing

To run the bot right from Gradle (just for testing, not for production) you can do `gradlew run --args your-bot-token-here`.
You can view the login process by looking at the 
[Main.java](https://github.com/Javacord/Example-Bot/blob/master/src/main/java/org/javacord/examplebot/Main.java)
class.

## Building the bot for production

To get a distributable package you run `gradlew distZip`. The created zip is located at `build/distributions/examplebot-1.0.0.zip` and contains all necessary things to run the bot, except the token.
Take a look at the [build.gradle](https://github.com/Javacord/Example-Bot/blob/master/build.gradle) file.

## Running the bot for production

After you built the distributable package as described in the previous section, you can copy over the zip file to where you want to run your bot. There you unzip it whereever you like and run one of the included start scripts.

```shell
unzip examplebot-1.0.0.zip
cd examplebot-1.0.0
bin/examplebot your-bot-token-here
```

The log file will be created in a `log` directory where you execute the last command.
