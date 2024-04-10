package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender()   
	{
		rdGender.click();
	}
	
	public void custdob(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custtelephoneno(String ctelephoneno)
	{
		txttelephoneno.sendKeys(String.valueOf(ctelephoneno));
	}
		
	public void custemailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit()
	{
		btnSubmit.click();
	}

}
