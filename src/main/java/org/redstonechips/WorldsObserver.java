/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.redstonechips;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.World;

/**
 *
 * @author taleisenberg
 */
public class WorldsObserver {
    private final static List<World> loadedWorlds = new ArrayList<>();

    public static boolean isWorldLoaded(World w) {
        return loadedWorlds.contains(w);
    }

    public static void clearLoadedWorldsList() {
        loadedWorlds.clear();
    }

    public static void addLoadedWorld(World world) {
        loadedWorlds.add(world);
    }
    
    public static void removeLoadedWorld(World unloadedWorld) {
        loadedWorlds.remove(unloadedWorld);
    }
    
    private static World unloadingWorld = null;
    
    public static void setUnloadingWorld(World world) {
        unloadingWorld = world;
    }
    
    public static boolean isWorldUnloading(World world) {
        return world!=null && unloadingWorld==world;
    }      

    public static World getUnloadingWorld() {
        return unloadingWorld;
    }
    
    public static boolean removeUnloadingWorld() {
        boolean ret = loadedWorlds.remove(unloadingWorld);
        unloadingWorld = null;
        return ret;
    }
}