package be.alexandre01.dreamnetwork.skript.condition;

import be.alexandre01.dreamnetwork.api.objects.server.DNServer;
import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

public class IsStarted extends Condition {

    private Expression<DNServer> server;

    @Override
    public boolean check(Event event) {
        if(server.getSingle(event) != null){
            return true;
        }
        return false;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "server is started";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return false;
    }
}
