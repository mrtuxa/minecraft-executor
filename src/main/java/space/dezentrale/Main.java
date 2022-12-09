package space.dezentrale;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {
    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();
        this.getCommand("uname").setExecutor(new Executor(this));
    }

    @Override
    public void onDisable() {
        instance = null;
        this.getLogger().info("Cancelling tasks...");
        this.getServer().getScheduler().cancelTasks(this);
    }

    public void reload() {
        this.getLogger().info("Reloading the plugin");
        this.getServer().getScheduler().cancelTasks(this);
        this.reloadConfig();
        this.getLogger().info("Plugin reloaded");
    }
}