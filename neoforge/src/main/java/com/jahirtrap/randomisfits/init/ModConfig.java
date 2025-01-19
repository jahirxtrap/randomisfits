package com.jahirtrap.randomisfits.init;

import com.jahirtrap.configlib.TXFConfig;

public class ModConfig extends TXFConfig {
    @Entry(name = "Multitool Interactions", itemDisplay = "randomisfits:iron_multitool")
    public static boolean multitoolInteractions = true;
    @Entry(name = "Toggle Hammer Mode", itemDisplay = "randomisfits:iron_hammer")
    public static boolean toggleHammerMode = true;
    @Entry(name = "Toggle Excavator Mode", itemDisplay = "randomisfits:iron_excavator")
    public static boolean toggleExcavatorMode = true;
    @Entry(name = "Toggle Lumberaxe Felling", itemDisplay = "randomisfits:iron_lumberaxe")
    public static boolean toggleLumberaxeFelling = true;
    @Entry(name = "Felling Limit", min = 1, max = Integer.MAX_VALUE, itemDisplay = "randomisfits:iron_lumberaxe")
    public static int fellingLimit = 512;
    @Entry(name = "Iron Kit Repair Amount", min = 1, max = Integer.MAX_VALUE, itemDisplay = "randomisfits:iron_repair_kit")
    public static int ironKitRepairAmount = 150;
    @Entry(name = "Diamond Kit Repair Amount", min = 1, max = Integer.MAX_VALUE, itemDisplay = "randomisfits:diamond_repair_kit")
    public static int diamondKitRepairAmount = 600;
    @Entry(name = "Netherite Kit Repair Amount", min = 1, max = Integer.MAX_VALUE, itemDisplay = "randomisfits:netherite_repair_kit")
    public static int netheriteKitRepairAmount = 900;
    @Entry(name = "Wearable Light Blocks", itemDisplay = "randomisfits:lamp")
    public static boolean wearableLightBlocks = true;
    @Entry(name = "Right Click Slot Open Menu", itemDisplay = "randomisfits:crafting_plate")
    public static boolean rightClickSlotOpenMenu = true;
    @Entry(name = "Item Autorepair Interval", min = 0, max = Integer.MAX_VALUE, itemDisplay = "randomisfits:zurite_ingot")
    public static int itemAutorepairInterval = 30;
    @Entry(name = "Item Autorepair Amount", min = 0, max = Integer.MAX_VALUE, itemDisplay = "randomisfits:zurite_ingot")
    public static int itemAutorepairAmount = 1;
}
