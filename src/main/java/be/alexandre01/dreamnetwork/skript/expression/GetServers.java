package be.alexandre01.dreamnetwork.skript.expression;

import be.alexandre01.dreamnetwork.api.objects.RemoteService;
import be.alexandre01.dreamnetwork.api.objects.server.DNServer;
import be.alexandre01.dreamnetwork.plugins.spigot.api.DNSpigotAPI;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;


public class GetServers extends SimpleExpression<DNServer> {
    private Expression<RemoteService> remoteService;
    private DNSpigotAPI api;

    public GetServers() {
        api = DNSpigotAPI.getInstance();
    }


    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public Class<? extends DNServer> getReturnType() {
        return DNServer.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "servers from template";
    }


    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        remoteService = (Expression<RemoteService>) expressions[0];
        return true;
    }

    @Override
    protected DNServer[] get(Event event) {
        return remoteService.getSingle(event).getServers().values().toArray(new DNServer[0]);
    }
}
