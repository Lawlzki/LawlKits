public class LawlKits extends JavaPlugin implements Listener {

	public static HashMap<Player, String> classes = new HashMap<Player, String>();

	public static final Logger logger = Logger.getLogger("Minecraft.LawlKits");
	public static final String loggerPrefix = "[LawlKits] ";

	public static LawlKits mainPlugin;

	public void onDisable() {
		log("LawlKits is made by Lawlzki!");
	}

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();

		log("LawlKits is made by Lawlzki!");

		mainPlugin = this;

		getCommand("lkit").setExecutor(new KitPluginCommand(this));
	}

public static void help(Player player) {
		player.sendMessage(ChatColor.GREEN + "=================["
				+ ChatColor.BLUE + "LawlKits" + ChatColor.GREEN
				+ "]=================");
		player.sendMessage(ChatColor.YELLOW + "/lkit [kit]" + ChatColor.BLUE
				+ " - Allows you to choose a kit");
		player.sendMessage(ChatColor.GRAY
				+ "   (Aliases: kits, class, classes)");
		player.sendMessage(ChatColor.GRAY
				+ "   (Available Kits: Tim)");
		player.sendMessage(ChatColor.GREEN
				+ "========================================");
	}
}
