package net.keinekohle.simplestats.util;

public class Util
{
    public static int cmToKm (int cm)
    {
        return cm / 100 / 1000;
    }

    public static int ticksToMin (int ticks)
    {
        return ticks / 20 / 60;
    }
}
