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
							ItemMeta wandMeta = wand.getItemMeta();
							wandMeta.setDisplayName(ChatColor.??? + "Wand");
							wand.setItemMeta(wandMeta);

							player.addPotionEffect(new PotionEffect(
									PotionEffectType.SLOW, 1000000, 01));
							player.addPotionEffect(new PotionEffect(
									PotionEffectType.INCREASE_DAMAGE, 1000000,
									1));
									
						} else if (cmd.getName().equalsIgnoreCase("LawlKits")) {
							
							Inventory inv = Bukkit.createInventory(null, 5,
							ChatColor.AQUA + "LawlKits");

							ItemStack tim = new ItemStack(397, 1, (short) 3);
							ItemMeta timMeta = tim.getItemMeta();
							timMeta.setOwner("Lawlzki");
							timMeta.setDisplayName(ChatColor.GOLD + "Tim");
							List<String> timLore = Arrays.asList(ChatColor.GREEN
									+ "The best kit ever!");
							timMeta.setLore(timLore);
							tim.setItemMeta(timMeta);
									
							inv.setItem(0, tim);
							
							player.playSound(player.getLocation(), Sound.BAT_TAKEOFF,
									2F, 1F);
							player.openInventory(inv);
