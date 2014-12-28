package helloworld;
import net.canarymod.plugin.Plugin;
import net.canarymod.logger.Logman;
import net.canarymod.Canary;
import net.canarymod.commandsys.*;
import net.canarymod.chat.MessageReceiver;

public class HelloWorld extends Plugin implements CommandListener {
    
    public static Logman logger;
    
    public HelloWorld() {
	logger = getLogman();
    }

    @Override
	public boolean enable() {
	logger.info("Starting up HelloWorld plugin.");
	try {
	    Canary.commands().registerCommands(this,this,false);
	} catch (CommandDependencyException e) {
	    logger.error("Duplicate command name");
	}
	return true;
    }
    
    @Overide
	public void disable() {
    }
    
    @Commands(aliases = {"hello"},
	      description = "Displays 'Hello, World'.",
	      permissions = {""},
	      toolTip = "/hello")
	public void helloCommand(MessageReceiver caller, String[] parameters) {
	String msg = "Hello, World!";
	Canary.instance().getServer().broadcastMessage(msg);
    }
}