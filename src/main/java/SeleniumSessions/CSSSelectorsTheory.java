package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorsTheory {

static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");

		//id:
		// #id
		// tagname#id
		// #username
		// input#username
		
		//class:
		// .class
		// tagname.class
		// .login-email
		// input.login-email
		
		//class + id
		// .class#id
		// #id.class
		// input.login-email
		// 
		// 
		
		// .c1.c2.c3....cn
		// tagname.c1.c2.c3.....cn
		// .form-control.private-form_control.login-email
		// input.form-control.private-form_control.login-email
		// input.form-control#username.private-form_control.login-email
		
		// css with attributes:
		// tagname[attr='value'] -- css
		//tagname[@attr='value'] -- xpath 
		
		// input[name='email']
		// input[id='input-email']
		// input[id='input-email'][name='email']
		//input#'input-email'[name='email'][type='text']
		
		// 
		// input[placeholder*='Address']  -- contains in CSS
		// input[placeholder^='E-Mail']   -- starts with in CSS
		// input[placeholder$='Address']  -- ends with in CSS  (Xpath has NO ends-with)
		
		
		//text in CSS : not supported/ available
		//text in Xpath : Yes -- tagname[text()='value']
		
		//Parent to child: Yes
		// > sign gives 'direct child'
		// form#hs-login > div     -- direct child - 8
		// just give one space between parent and child --  gives direct & indirect child
		// form#hs-login div       -- direct + indirect child - 22
		
		// select#Form_getForm_Country > option 
		
		//CHild to Parent in CSS -- NO backward traversing
		//Child to GrandParent -- NO
		//Preceding SIbling -- NO 
		
		//Sibling COncept in CSS:
		// label[for = 'input-email']+input#input-email    --- immediate siblings
		// option[value='Algeria'] + option      --- immediate sibling starting from 'Algeria'  --1
		// option[value='Algeria'] ~ option      --- all the following siblings starting from 'Algeria' -- more
		
		//comma in css:  --- works like and operator
		// input#username,input#password,button#loginBtn
		
		//CHecks if all fields are available on page. Good for Sanity testing.
		int mand_fields_count = 
				driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,input#remember")).size();
		
		
		if(mand_fields_count == 4) {
			System.out.println("All imp mandatory fields are present o page");
		}
		
		
		//not in CSS:    --- excludes whatever is given in not() incase there are multiple elements
		// div.form-group > input.form-control:not(#input-password)
		
		//index in CSS:   ------    :nth-of-type(index)
		// select#Form_getForm_Country > option:nth-of-type(5)   --- go to index 5
		// select#Form_getForm_Country > option:nth-of-type(n)   --- gives all
		// select#Form_getForm_Country > option:first-child      --- gives first child only (not available in Xpath)
		// select#Form_getForm_Country > option:last-child    --- gives last child
		// select#Form_getForm_Country > option:nth-child(4)    --- gives 4th child
		// select#Form_getForm_Country > option:nth-last-child(2)    --- goes last child and then the 2nd last child
		// select#Form_getForm_Country > option:nth-child(odd)    --- gives all odd number child
		// select#Form_getForm_Country > option:nth-child(even)    --- gives all even number child
		// select#Form_getForm_Country > option:nth-of-type(n+4)   --- gives value after every 4 values
		// select#Form_getForm_Country > option:nth-of-type(4n)   --- starts from 4 and gives multiples of 4 values
		
//******************* Odd and Even in xpath: *************************//
		// (//select[@id='Form_getForm_Country']/option)[position()mod 2 = 0]  --- gives all even numbers
		// (//select[@id='Form_getForm_Country']/option)[position()mod 2 != 0]  --- gives all odd numbers
		// (//select[@id='Form_getForm_Country']/option)[position()mod 2 = 1]  --- gives all odd numbers		
		
		
		//Cascaded classes in CSS:  --- YEs
		// tagname.c1.c2......cn
		driver.findElement(By.cssSelector("input.form-control.private-form_control.login-email"));
		 // input[class = 'form-control private-form_control login-email']
		
		
		//                             xpath   vs   CSS:
		//1. Performance:               good         good
		//2. Syntax:                    complex      simple if u remember the names
		//3. backward traversing        Yes           No
		//4.Sibling                     Yes           Yes -- only following
//****	//5. text                       Yes           No
//****	//6. ancestor/parent            Yes           No
		//7. ends-with:                 No            Yes
		//8. index                      Yes           Yes+1 -- more options
		//9. not:                       Yes(!)         Yes   -- :not()
		//10. comma:                     No            Yes
		//11. SVG:                      Yes            No
		//12. shadowDOM:                 No           Yes
		//13. Psuedo:                   No            Yes
		//14. index-last:               Yes           Yes
		//15. index-first:              No            Yes

		//Xpath is good for WebTables
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
