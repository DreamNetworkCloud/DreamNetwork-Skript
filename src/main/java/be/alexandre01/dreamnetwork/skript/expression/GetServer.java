package be.alexandre01.dreamnetwork.skript.expression;

import be.alexandre01.dreamnetwork.api.objects.RemoteService;
import be.alexandre01.dreamnetwork.api.objects.server.DNServer;
import be.alexandre01.dreamnetwork.plugins.spigot.api.DNSpigotAPI;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;


public class GetServer extends SimpleExpression<DNServer> {
    private Expression<RemoteService> remoteService;
    private Expression<Integer> id;
    private DNSpigotAPI api;

    public GetServer() {
        api = DNSpigotAPI.getInstance();
    }


    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends DNServer> getReturnType() {
        return DNServer.class;
    }

    @Override
    public String toString(Event event, boolean b) {
        return "server from template with id integer";
    }


    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        remoteService = (Expression<RemoteService>) expressions[0];
        id = (Expression<Integer>) expressions[1];
        return true;
    }

    @Override
    protected DNServer[] get(Event event) {
        DNServer server = null;
        RemoteService service = remoteService.getSingle(event);
        int id = this.id.getSingle(event);
        if(service.getServers().containsKey( id )) {
            server = service.getServers().get( id );
        }

        return new DNServer[]{server};
    }
}
