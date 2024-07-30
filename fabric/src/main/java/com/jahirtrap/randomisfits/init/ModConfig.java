package com.jahirtrap.randomisfits.init;

import com.jahirtrap.configlib.TXFConfig;

public class ModConfig extends TXFConfig {
    @Entry(name = "Multitool Interactions")
    public static boolean multitoolInteractions = true;
    @Entry(name = "Toggle Hammer Mode")
    public static boolean toggleHammerMode = true;
    @Entry(name = "Toggle Excavator Mode")
    public static boolean toggleExcavatorMode = true;
    @Entry(name = "Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int kitRepairAmount = 150;
    @Entry(name = "Diamond Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int diamondKitRepairAmount = 600;
    @Entry(name = "Netherite Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int netheriteKitRepairAmount = 900;
}
