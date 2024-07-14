package com.jahirtrap.randomisfits.init;

import com.jahirtrap.randomisfits.util.configlib.TXFConfig;

public class RandomisfitsModConfig extends TXFConfig {
    @Entry(name = "Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int kitRepairAmount = 150;
    @Entry(name = "Diamond Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int diamondKitRepairAmount = 600;
    @Entry(name = "Netherite Kit Repair Amount", min = 1, max = Integer.MAX_VALUE)
    public static int netheriteKitRepairAmount = 900;
}
