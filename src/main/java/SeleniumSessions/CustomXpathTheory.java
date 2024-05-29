package SeleniumSessions;

import org.openqa.selenium.By;

public class CustomXpathTheory {

	public static void main(String[] args) {
		
		//Xpath: address of the element in the DOM
				//XMLPath
				//1. absolute xpath
				//html/body/div[2]/div/div/div[3]/div[2]/div/div/div[2]/h4/a
				//2. relative xpath(custom xpath) 
				
				//1. using single attr:
				//tagname[@attrname = 'value']
				//input[@id = 'input-email']
				//input[@name='email']
				
				//input[@name] --5
				//input[@value='Login'] --1
				
				//2. using multiple attrs:
				//tagname[@attr1='value' and @attr2='value' and @attr3='value']
				//input[@type='submit' and @value='Login' ] --- 1
			
				//input[@type='submit'] -- 3
				//input[@type='text' or @type='email' ]
				//input[@type and @value='Login']
				//input[@type and @value]
				//a[@href]
				
				//3. text():
				//tagname[text()='value']
				//h2[text()='New Customer']
				//a[text()='Desktops']
				
				//4. text() and attributes:
				//tagname[@attr='value' and text()='value']
				//a[@class='dropdown-toggle' and text()='Desktops']
				//a[@class='dropdown-toggle' and text()='Desktops' and @data-toggle='dropdown']
				//a[text()='Desktops' and @class='dropdown-toggle' and @data-toggle='dropdown']
				
				//5. contains() with attr:
				//tagname[contains(@arrName, 'value')]
				//input[contains(@placeholder, 'E-Mail')]
				//input[contains(@placeholder, 'Address')]
				
				//tagname[contains(@arrName1, 'value') and @attr2='value']
				//input[contains(@placeholder, 'Address') and @name='email']
				//input[contains(@placeholder, 'Address') and @name='email' and contains(@id,'email')]
				//a[contains(@href,'wishlist')]
				
				//dynamic ids:
				//<input id=firstname_123 />
				//<input id=firstname_345 />
				//<input id=firstname_900 />
				//<input id=firstname_987 />

				//input[contains(@id,'firstname_')]
				
				//6. contains() with text():
				//tagname[contains(text(), 'value')]
				//p[contains(text(), 'Customer service, IT, and CRM software')]
				//a[contains(text(), 'Customer')]
				
				//7. contains() with text() and attr:
				//tagname[contains(text(),'value') and contains(@attr,'value')]
				//a[contains(text(),'Notebooks') and contains(@href,'category&path')]
				
				//tagname[contains(text(),'value') and contains(@attr1,'value') and @attr2='value']

				//8. starts-with():
				//tagname[starts-with(@attr, 'value')]
				//input[starts-with(@placeholder, 'E-Mail')]
				
				//9. starts-with() with text():
				//tagname[starts-with(text(),'value')]
				//a[starts-with(text(),'Forgotten')]
				
				//dynamic ids:
				//<input id=firstname_123_login />
				//<input id=456_firstname_login />
				//EXT JS
				
				//input[contains(@id,'firstname_') and contains(@id,'_login')]
		
//X		//10. ends-with() is not supported in xpath
		
		//11. index based xpath     --- Better to avoid in case indexing may change
//		(//tagname[attr = 'value'])[index]  ------- (capture group)[index--starts with 1]
//		(//a[text() = 'Forgotten Password'])[1]    --capturing 1st element
//      (//a[@class = 'list-group-item'])[5]	   --capturing 5th element	
//		(//a[@class = 'list-group-item'])[position() = 5]   --- using position() function
//       (//a[@class = 'list-group-item'])[last()]      -- points to the last element		
//      (//a[@class = 'list-group-item'])[last()-1]      -- points to the last-1 element
//      (//a[@class = 'list-group-item'])[last() - last() +1]  -- points to the 1st one
//X      (//a[@class = 'list-group-item'])[first()]      -- first() is not allowed		
		
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]
		
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()-last()+1]
						
		By fgt_pwd = By.xpath("(//a[text()='Forgotten Password'])[1]");
				
		//*
		//*[@id]
		//*[@class='form-control'] -- 100 ---> 6
		//input[@class='form-control'] -- 20 ---> 6
		//*[@href]
		
		
		//12. normalize-space():    ---- if text is '  yes' having space
		//label[contains(text(),'yes')]  --  does not work for text having spaces
		//label[normalize-space()='yes']  --  works for text having spaces
		
//******************* Odd and Even in xpath: *************************//
		// (//select[@id='Form_getForm_Country']/option)[position()mod 2 = 0]  --- gives all even numbers
		// (//select[@id='Form_getForm_Country']/option)[position()mod 2 != 0]  --- gives all odd numbers
		// (//select[@id='Form_getForm_Country']/option)[position()mod 2 = 1]  --- gives all odd numbers		
					
		
		
		
		
		
		
	}

}
