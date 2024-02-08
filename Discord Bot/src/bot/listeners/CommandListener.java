package bot.listeners;

import bot.commands.TemplateCommand;
import bot.commands.GreetCommand;
import bot.commands.PingCommand;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class CommandListener {
	//an arraylist that contains all the classes that are using the TemplateCommand interface
	public final static List<TemplateCommand> commands = new ArrayList<TemplateCommand>();
	
	//initializing some commands
	static {
		commands.add(new GreetCommand());
		commands.add(new PingCommand());
	}
	
	public static Mono<Void> handle(ChatInputInteractionEvent event){
		//convert the array list into a Flux class -> stream of multiple items i guess
		return Flux.fromIterable(commands)
				//filter all the commands that dont match the name of the event it's for (??) is this even required
				.filter(command -> command.getName().equals(event.getCommandName()))
				//get the first and only item that matches our filter
				.next()
				//have our command class handle all the logic belonging to that class
				.flatMap(command -> command.handle(event));
	
	}

}
