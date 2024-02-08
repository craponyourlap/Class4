package bot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import reactor.core.publisher.Mono;

public class GreetCommand implements TemplateCommand{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "greet";
	}

	@Override
	public Mono<Void> handle(ChatInputInteractionEvent event) {
		// TODO Auto-generated method stub
		//get name
		String name = event
				.getOption("name")
				.flatMap(ApplicationCommandInteractionOption::getValue)
				.map(ApplicationCommandInteractionOptionValue::asString)
				.get();
		return event.reply().withEphemeral(true).withContent("Hello, "+name);
	}

}
