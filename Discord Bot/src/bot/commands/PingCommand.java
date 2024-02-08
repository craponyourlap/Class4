package bot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;

public class PingCommand implements TemplateCommand{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ping";
	}

	@Override
	public Mono<Void> handle(ChatInputInteractionEvent event) {
		// TODO Auto-generated method stub
		return event.reply().withEphemeral(true).withContent("Pong!");
	}
	
}
