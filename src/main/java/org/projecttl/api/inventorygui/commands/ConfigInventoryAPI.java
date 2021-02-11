package org.projecttl.api.inventorygui.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.projecttl.api.inventorygui.InventoryGUI;
import org.projecttl.api.inventorygui.utils.CreateGUI;

public class ConfigInventoryAPI implements CommandExecutor {

    public static String inventoryName = ChatColor.GREEN + "Test GUI";
    public static String item_1 = ChatColor.GOLD + "Test_1";
    public static String item_2 = ChatColor.BLUE + "Test_2";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("gui")) {
            String server = Bukkit.getServer().getMinecraftVersion();
            String githubURL = "https://github.com/ProjectTL12345/";

            if (args.length == 0) {
                sender.sendMessage("§6===========§f[§aInventory_GUI§f]§6===========");
                sender.sendMessage(ChatColor.YELLOW + "API Version:" + ChatColor.AQUA + " 1.2v");
                sender.sendMessage(ChatColor.YELLOW + "Minecraft Version: " + ChatColor.GREEN + server);
                sender.sendMessage(ChatColor.YELLOW + "Author:" + ChatColor.AQUA + " Project_TL");
                sender.sendMessage(ChatColor.YELLOW + "Helper:" + ChatColor.LIGHT_PURPLE + " None");
                sender.sendMessage(ChatColor.YELLOW + "Dependency Library:" + ChatColor.LIGHT_PURPLE + " None");
                sender.sendMessage("§6===================================");

                return true;
            }

            else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("test")) {
                    if (args[1].equalsIgnoreCase("test")) {
                        CreateGUI testGUI = new CreateGUI(27, inventoryName);
                        testGUI.setItem(new ItemStack(Material.BEDROCK), item_1, 10);
                        testGUI.setItem(new ItemStack(Material.COMPASS), item_2, 13);
                        testGUI.setExitButton(16);

                        testGUI.openInventory(((Player) sender));
                        return true;
                    }
                }

                else if (args[0].equalsIgnoreCase("development")) {
                    if (args[1].equalsIgnoreCase("info")) {
                        sender.sendMessage("§6===========§f[§aInventory_GUI§f]§6===========");
                        sender.sendMessage(ChatColor.YELLOW + "Developer:" + ChatColor.AQUA + " Project_TL");
                        sender.sendMessage(ChatColor.YELLOW + "Develop Language:" + ChatColor.RED + " Java");
                        sender.sendMessage(ChatColor.YELLOW + "Help Developer:" + ChatColor.LIGHT_PURPLE + " None");
                        sender.sendMessage(ChatColor.YELLOW + "Github: " + ChatColor.GREEN + ChatColor.UNDERLINE + githubURL);
                        sender.sendMessage("§6===================================");

                        return true;
                    }
                }
            }

            else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("development")) {
                    if (args[1].equalsIgnoreCase("info")) {
                        if (args[2].equalsIgnoreCase("another")) {
                            sender.sendMessage("<Inventory_GUI> Another developer is none.");

                            return true;
                        }

                        else if (args[2].equalsIgnoreCase("github")) {
                            sender.sendMessage("<Inventory_GUI> Developer's github URL is \"" + ChatColor.GREEN + ChatColor.UNDERLINE + githubURL + ChatColor.RESET +"\".");

                            return true;
                        }

                        else if (args[2].equalsIgnoreCase("developer")) {
                            sender.sendMessage("<Inventory_GUI> Developer name is " + ChatColor.AQUA + "\"Project_TL\""+ ChatColor.RESET +".");

                            return true;
                        }

                        else if (args[2].equalsIgnoreCase("language")) {
                            sender.sendMessage("<Inventory_GUI> This API is written for " + ChatColor.RED + "\"Java\"" + ChatColor.RESET + ".");

                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
