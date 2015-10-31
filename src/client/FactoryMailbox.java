package client;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

import libraries.ImageLibrary;
import resource.Resource;

public class FactoryMailbox extends FactoryObject {

	private Vector<Resource> available;
	Random rand;
	private Queue<Resource> mail;
	
	protected FactoryMailbox(Vector<Resource> deliveries){
		super(new Rectangle(0,0,1,1));
		available = deliveries;
		mImage = ImageLibrary.getImage(Constants.resourceFolder + "mailbox" + Constants.png);
		mLabel = "Mailbox";
		rand = new Random();
		mail = new LinkedList<Resource>();
	}
	
	public Resource getStock() throws InterruptedException {
		while (mail.isEmpty()) {
			Thread.sleep(200);
		}
		return mail.remove();
	}
	
	public void insert(Resource resource) {
		for (Resource r : available) {
			if (r.getName().equals((resource.getName()))) {
				mail.add(resource);
				break;
			}
		}
	}

}
