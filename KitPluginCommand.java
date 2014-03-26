@SuppressWarnings("unused")
public class KitPluginCommand implements CommandExecutor {

	private final LawlKits plugin;

	public KitPluginCommand(LawlKits plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (player.hasPermission(Permissions.PERM_KIT)) {
				if (args.length == 1) {
					String kit = args[0];
					PlayerInventory inv = player.getInventory();

					if (kit.equalsIgnoreCase("tim")) {
						if (player.hasPermission(Permissions.PERM_KIT_TIM)) {
							if (LawlKits.classes.containsKey(player)) {
								LawlKits.classes.remove(player);
							}
							LawlKits.classes.put(player, "Tim");

							LawlKits.msg(player, "Kit " + ChatColor.DARK_RED
									+ "Tim" + ChatColor.YELLOW
									+ " has been selected.");

							PlayerUtil.refreshPlayer(player);

							inv.addItem(new ItemStack(Material.WOOD_AXE, 1));

							player.addPotionEffect(new PotionEffect(
									PotionEffectType.SLOW, 1000000, 01));
							player.addPotionEffect(new PotionEffect(
									PotionEffectType.INCREASE_DAMAGE, 1000000,
									1));
						} else {
							LawlKits.errMsg(player,
									"You do not have permission for kit: Tim");
									
