package be.alexandre01.dreamnetwork.skript;

import be.alexandre01.dreamnetwork.api.objects.RemoteService;
import be.alexandre01.dreamnetwork.api.objects.server.DNServer;
import be.alexandre01.dreamnetwork.skript.condition.IsStarted;
import be.alexandre01.dreamnetwork.skript.effects.StartEffect;
import be.alexandre01.dreamnetwork.skript.effects.StopEffect;
import be.alexandre01.dreamnetwork.skript.expression.GetServer;
import be.alexandre01.dreamnetwork.skript.expression.GetServers;
import be.alexandre01.dreamnetwork.skript.expression.GetTemplate;
import ch.njol.skript.Skript;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.lang.ExpressionType;

import ch.njol.skript.registrations.Classes;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DreamNetwork-Skript-Addon is enabled!");


        //Skript event

        Skript.registerAddon(this);



        //Skript expression
        Skript.registerExpression(GetTemplate.class, RemoteService.class, ExpressionType.PROPERTY, "template with name %string%");
        Skript.registerExpression(GetServer.class, DNServer.class, ExpressionType.PROPERTY, "server from %template% with id %integer%");
        Skript.registerExpression(GetServers.class, DNServer.class, ExpressionType.PROPERTY, "servers from template");
        //Skript effect
        Skript.registerEffect(StartEffect.class, "start %template%");
        Skript.registerEffect(StopEffect.class, "stop %server%");

        //Skript condition
        Skript.registerCondition(IsStarted.class, "%server% is started");

        Classes.registerClass(new ClassInfo<>(RemoteService.class, "template").user("template").name("template"));
        Classes.registerClass(new ClassInfo<>(DNServer.class, "server").user("server").name("server"));


    }

    @Override
    public void onDisable() {
        getLogger().info("DreamNetwork-Skript-Addon is disabled!");
    }

}
