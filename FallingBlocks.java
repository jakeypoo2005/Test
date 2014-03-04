package me.jakeypoo2005.test;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class FallingBlocks extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		for(Block b : event.blockList()) {
			float x = (float) -5 + (float) (Math.random() * ((5 - -5) + 1));
			float y = (float) -6 + (float) (Math.random() * ((6 - -6) + 1));
			float z = (float) -5 + (float) (Math.random() * ((5 - -5) + 1));
			
			@SuppressWarnings("deprecation")
			FallingBlock fallingBlock = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
			fallingBlock.setDropItem(false);
			fallingBlock.setVelocity(new Vector(x, y, z));
			
			b.setType(Material.AIR);
		}
	}
}
