package mydeacy.groovy.sampleplugin

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.item.Item
import cn.nukkit.plugin.PluginBase

class SamplePlugin extends PluginBase implements Listener {

    @Override
    void onEnable() {
        getLogger().info("Hello Nukkit!!!")
        getServer().getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer()
        player.sendMessage(player.getName() + ", Welcome to my server!")
    }

    @Override
    boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Item item = sender.getInventory().getItemInHand()
            sender.sendMessage("This is " + item.getName() + ". (" + item.getId() + ":" + item.getDamage() + ")")
        }else{
            getLogger().info("Hey Console.")
        }
        return true
    }
}
