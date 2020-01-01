package de.ardania.jan.xcraftspecialitems;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static JavaPlugin PLUGIN;

    public void onEnable(){
        PLUGIN = this;
        getServer().getPluginManager().registerEvents(new SpecialItemListener(), this);
    }
}
