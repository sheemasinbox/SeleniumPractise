package SeleniumSessions;

public class WaitConcept {

	public static void main(String[] args) {
		
		//sync between script and application (slow, server slowness, network issues)
		
		//sync: wait
		//1. Static Wait: Thread.sleep(10000) : 10secs : if ele found in 2secs, still it waits for 10 secs
		//				  Thread.sleep(); is Java method

/*
		2. Dynamic Wait: 10secs : if ele found in 2secs, it will cancels remaining 8 secs
		   2.a: Implicitly Wait : global wait for all Web Elements
		   2.b: Explicitly Wait : for a specific web element
		   	
		   Explicitly Wait is of 2 types:
		   i. WebDriverWait (class)
		   ii. FluentWait   (class)
		   
		Hierarchy:
		Wait(Interface): until();
			<---Implements--- FluentWait(class): (@Overridden) until(){ } + other methods
					<----Extends--- WebDriverWait(class) -- inherits all -- no methods
					
		So, WebDriverWait is also a FluentWait

*/
	}

}
