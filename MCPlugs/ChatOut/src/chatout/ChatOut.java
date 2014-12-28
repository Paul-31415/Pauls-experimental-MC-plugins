/***
 * Excerpted from "Learn to Program with Minecraft Plugins, CanaryMod Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/ahmine2 for more book information.
***/
package helloworld;
import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;
import com.pragprog.ahmine.ez.EZPlugin;

public class ChatOut extends EZPlugin {
  @Command(aliases = { "chatout" },
            description = "Displays the arguement in chat.",
            permissions = { "" },
            toolTip = "/chatout str")
  public void helloCommand(MessageReceiver caller, String[] parameters) {
      int args = parameters.length;
      String msg = "";
      for (int i=1; i<args; i++) {
	  msg = msg.concat(" ").concat(parameters[i]);
      }
      msg = msg.substring(1);
    Canary.instance().getServer().broadcastMessage(msg);
  }
}
