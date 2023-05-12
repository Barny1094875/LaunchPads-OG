package me.barny1094875.launchpad.Listeners;

import me.barny1094875.launchpad.LaunchPad;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class OnEntityDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){

        // check if the damage was fall damage
        if(event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
            // check if the entity was a player
            if(event.getEntity() instanceof Player) {
                // check the entity was in the launchedPlayers list
                ArrayList<Player> launchedList = LaunchPad.getLaunchedPlayers();
                Entity eventPlayer = (Player) event.getEntity();
                if (launchedList.contains(eventPlayer)) {
                    event.setCancelled(true);
                    launchedList.remove(eventPlayer);
                }
            }
        }

    }


}
