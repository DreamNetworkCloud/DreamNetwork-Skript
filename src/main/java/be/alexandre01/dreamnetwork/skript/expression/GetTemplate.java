package be.alexandre01.dreamnetwork.skript.expression;

import be.alexandre01.dreamnetwork.api.objects.RemoteService;
import be.alexandre01.dreamnetwork.plugins.spigot.api.DNSpigotAPI;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;

public class GetTemplate extends SimpleExpression<RemoteService> {
    DNSpigotAPI api;
    private Expression<String> name;
    public GetTemplate(){
        api = DNSpigotAPI.getInstance();
    }

    @Override
    protected RemoteService[] get(Event event) {
        return new RemoteService[]{api.getServices().get(name.getSingle(event))};
    }


    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends RemoteService> getReturnType() {
        return RemoteService.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "template with name string";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        name = (Expression<String>) expressions[0];
        return true;
    }
}
