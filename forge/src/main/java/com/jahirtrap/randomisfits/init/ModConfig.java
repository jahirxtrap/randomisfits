package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.util.configlib.TXFConfig;

public class ModConfig extends TXFConfig {
    @Entry(name = "Multitool Interactions")
    public static boolean multitoolInteractions = true;
    @Entry(name = "Toggle Hammer Mode")
    public static boolean toggleHammerMode = true;
    @Entry(name = "Toggle Excavator Mode")
    public static boolean toggleExcavatorMode = true;
    @Entry(name = "Toggle Lumberaxe Felling")
    public static boolean toggleLumberaxeFelling = true;
    @Entry(name = "Felling Limit", min = 1, max = Integer.MAX_VALUE)
    public static int fellingLimit = 512;
    @Entry(name = "Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int kitRepairAmount = 150;
    @Entry(name = "Diamond Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int diamondKitRepairAmount = 600;
    @Entry(name = "Netherite Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int netheriteKitRepairAmount = 900;
    @Entry(name = "Wearable Light Blocks")
    public static boolean wearableLightBlocks = true;
    @Entry(name = "Right Click Slot Open Menu")
    public static boolean rightClickSlotOpenMenu = true;
    @Entry(name = "Item Autorepair Interval", min = 0, max = Integer.MAX_VALUE)
    public static int itemAutorepairInterval = 30;
    @Entry(name = "Item Autorepair Amount", min = 0, max = Integer.MAX_VALUE)
    public static int itemAutorepairAmount = 1;
}
