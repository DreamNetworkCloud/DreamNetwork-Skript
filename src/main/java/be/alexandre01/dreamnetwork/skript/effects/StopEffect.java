package be.alexandre01.dreamnetwork.skript.effects;

import be.alexandre01.dreamnetwork.api.objects.RemoteService;
import be.alexandre01.dreamnetwork.api.objects.server.DNServer;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

public class StopEffect extends Effect {
    private Expression<DNServer> server;



    public StopEffect() {
        super();
    }

    @Override
    protected void execute(Event event) {
        server.getSingle(event).stop();
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        server = (Expression<DNServer>) expressions[0];
        return true;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "stop server";
    }
}
