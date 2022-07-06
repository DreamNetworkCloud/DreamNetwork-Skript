package be.alexandre01.dreamnetwork.skript.effects;

import be.alexandre01.dreamnetwork.api.objects.RemoteService;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public class StartEffect extends Effect {
    private Expression<RemoteService> template;



    public StartEffect() {
        super();
    }

    @Override
    protected void execute(Event event) {
        template.getSingle(event).start();
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        template = (Expression<RemoteService>) expressions[0];
        return true;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "start template";
    }
}
