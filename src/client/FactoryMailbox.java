package client;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

import libraries.ImageLibrary;
import resource.Resource;

public class FactoryMailbox extends FactoryObject {

	private Vector<Resource> available;
	Random rand;
	
	protected FactoryMailbox(Vector<Resource> deliveries){
		super(new Rectangle(0,0,1,1));
		available = deliveries;
		mImage = ImageLibrary.getImage(Constants.resourceFolder + "mailbox" + Constants.png);
		mLabel = "Mailbox";
		rand = new Random();
	}
	
	public Resource getStock() {
		int toStock = Math.abs(rand.nextInt() % available.size());
		int number = Math.abs(rand.nextInt() % 25 + 1);
		return new Resource(available.elementAt(toStock).getName(), number);
	}

}
