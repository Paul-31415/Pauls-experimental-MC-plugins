/***
 * Excerpted from "Learn to Program with Minecraft Plugins, CanaryMod Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/ahmine2 for more book information.
***/
package laservision;

import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.world.effects.Particle;
import net.canarymod.api.world.effects.Particle.Type;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.effects.SoundEffect;
import net.canarymod.api.world.blocks.Block;
import net.canarymod.api.world.blocks.BlockType;
import net.canarymod.BlockIterator;
import net.canarymod.LineTracer;
import com.pragprog.ahmine.ez.EZPlugin;

public class LaserVision extends EZPlugin {

  @Command(aliases = { "laservision" },
            description = "Shoot a laser",
            permissions = { "" },
            toolTip = "/laservision")
  public void laservisionCommand(MessageReceiver caller, String[] args) {
    if (caller instanceof Player) { 
      Player me = (Player)caller;      
      BlockIterator sightItr = new BlockIterator(new LineTracer(me), true);
      Block bp = sightItr.next();
      while (sightItr.hasNext()) {
        Block b = sightItr.next();
        spawnParticle(b.getLocation(), Particle.Type.LAVA); //should be DRIP_LAVA but that doesn't work
        if (b.getType() != BlockType.Air) {
          bp.getWorld().setBlockAt(bp.getLocation(), BlockType.FireBlock);
          playSound(bp.getLocation(), SoundEffect.Type.FIRE_IGNITE);
          break;
        }
	bp = b;
      }
    }
  }
}
