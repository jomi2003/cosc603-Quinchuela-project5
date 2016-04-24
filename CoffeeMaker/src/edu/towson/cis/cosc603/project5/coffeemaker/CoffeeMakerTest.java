package edu.towson.cis.cosc603.project5.coffeemaker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;

	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	private Recipe r6;
	Recipe newRecipe;
	

	@Before 
	public void setUp() throws Exception{
		cm = new CoffeeMaker();
		i = cm.checkInventory();
	//	i2 = new Inventory(-12);
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		r2 = new Recipe();
		r2.setName("Coffee");
		r2.setPrice(50);
		r2.setAmtCoffee(6);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		r3 = new Recipe();
		r3.setName("Venti");
		r3.setPrice(-50);
		r3.setAmtCoffee(-6);
		r3.setAmtMilk(-1);
		r3.setAmtSugar(-1);
		r3.setAmtChocolate(-2);
		newRecipe = new Recipe();
		r4 = new Recipe();
		r4.setName("Hot Coffee");
		r4.setPrice(50);
		r4.setAmtCoffee(6);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(3);
		r5 = new Recipe();
		r5.setName("Capuccino");
		r5.setPrice(50);
		r5.setAmtCoffee(6);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(0);
		r6 = new Recipe();
		r6.setName("Dark Roast");
		r6.setPrice(50);
		r6.setAmtCoffee(6);
		r6.setAmtMilk(1);
		r6.setAmtSugar(1);
		r6.setAmtChocolate(0);
	
	}
	
	//testing to add a recipe
	@Test
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}
	
	//testing for same recipe name. Event 5 
	@Test
	public void testAddRecipe2() {
		cm.addRecipe(r1);
		assertFalse(cm.addRecipe(r2));
	}
	
	//testing for negative numbers for price. Event 4
	@Test
	public void testAddRecipe3() {
		assertEquals(0, r3.getPrice());
	}
	
	//units of coffee can not be negative E4
	@Test
	public void testAddRecipe4() {
		assertEquals(0, r3.getAmtCoffee());
	}
	
	//units of milk can not be negative E4
	@Test
	public void testAddRecipe5() {
		assertEquals(0, r3.getAmtMilk());
	}
	
	//units of sugar can not be negative E4
	@Test
	public void testAddRecipe6() {
		assertEquals(0, r3.getAmtSugar());
	}
	
	//units of chocolate can not be negative E4
	@Test
	public void testAddRecipe7() {
		assertEquals(0, r3.getAmtChocolate());
	}
		
	//Checking to see if a new recipe can be added after 4 have been added
	//This is a bug because the first element in the array should start from 1
	@Test 
	public void testAddRecipe8() {
		cm.addRecipe(r1);
		cm.addRecipe(r4);
		cm.addRecipe(r3);
		cm.addRecipe(r6);
		cm.addRecipe(r5);
		assertFalse(cm.addRecipe(r2));	
		}
	
	//Checking for integer values for coffee E3
	@Test
	public void testAddRecipe9() {
		assertSame(6, Integer.valueOf(r4.getAmtCoffee()));
	}
	
	
	//Checking for integer values for milk E3
	@Test
	public void testAddRecipe10() {
		assertSame(1, Integer.valueOf(r4.getAmtMilk()));
	}
	
	//Checking for integer values for sugar E3
	@Test
	public void testAddRecipe11() {
		assertSame(1, Integer.valueOf(r4.getAmtSugar()));
	}
		
	//Checking for integer values for chocolate E3
	@Test
	public void testAddRecipe12() {
		assertSame(3, Integer.valueOf(r4.getAmtChocolate()));
	}
	
	//Checking that price is an integer E2
	@Test
	public void testAddRecipe13() {
		assertSame(50, Integer.valueOf(r4.getPrice()));
	}
	
	//Test to get all recipes added
	@Test
	public void testAddRecipe14() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		assertNotNull(cm.getRecipes());
	}
	
	//Test to get the recipe's name
		@Test
		public void testAddRecipe15() {
			cm.addRecipe(r6);
		//	assertSame("Dark Roast", cm.getRecipeForName("Dark Roast"));
			System.out.println(cm.getRecipeForName("Dark Roast"));
		//assertEquals("Dark Roast", cm.getRecipeForName("Dark Roast"));
	
	}
		
	//Check to see if recipe was deleted 
	@Test
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	
	//check to see if a recipe can be deleted without being added
	@Test
	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(r1));
	}
	
	//check to see if an empty recipe can be deleted. Null is used 
	@Test
	public void testDeleteRecipe3() {	
		assertFalse(cm.deleteRecipe(null));

	}
	
	// Test to see if a recipe can be edited
	@Test
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		//Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	// Test to see if a recipe can be edited without being added
	@Test
	public void testEditRecipe2(){
		//cm.addRecipe(r4);
		newRecipe = r4;
		newRecipe.setAmtSugar(2);
		assertFalse(cm.editRecipe(r4, newRecipe));
	}
	
	//Test to check positive price numbers can be added. E5
	@Test
	public void testEditRecipe3(){
		cm.addRecipe(r2);
		newRecipe = r2;
		newRecipe.setPrice(10);
		assertTrue(cm.editRecipe(r2, newRecipe));	
	}
	
	//Test to check that negative price can not be edited. E5
	@Test
	public void testEditRecipe4(){
		cm.addRecipe(r2);
		newRecipe = r2;
		newRecipe.setPrice(-20);
		cm.editRecipe(r2, newRecipe);
		assertEquals(0, newRecipe.getPrice());
	}
	
	//Test to see if Units of coffee can be edited using negative values E4
	@Test
	public void testEditRecipe5(){
		cm.addRecipe(r3);
		newRecipe = r3;
		cm.editRecipe(r3, newRecipe);
		assertEquals(0, r3.getAmtCoffee());
	}
	
	//Test to see if Units of milk can be edited using negative values E4
	@Test
	public void testEditRecipe6(){
		cm.addRecipe(r3);
		newRecipe = r3;
		cm.editRecipe(r3, newRecipe);
		assertEquals(0, r3.getAmtMilk());
	}
	
	//Test to see if Units of sugar can be edited using negative values E4
	@Test
	public void testEditRecipe7(){
		cm.addRecipe(r3);
		newRecipe = r3;
		cm.editRecipe(r3, newRecipe);
		assertEquals(0, r3.getAmtSugar());
	}
	
	//Test to see if Units of chocolate can be edited using negative values E4
	@Test
	public void testEditRecipe8(){
		cm.addRecipe(r3);
		newRecipe = r3;
		cm.editRecipe(r3, newRecipe);
		assertEquals(0, r3.getAmtChocolate());
	}
	
	//Test to see that inventory was added and is not null
	@Test
	public void testAddInventory1(){
		cm.addInventory(6,7,8,9);
		assertNotNull(i);
	}
	
	//Test to see  that inventory was successfully added
	@Test
	public void testAddInventory2(){
		assertTrue(cm.addInventory(6, 7, 8, 9));
	}
	
	//Test to see if units of coffee can be negative. Result will be 0
	@Test
	public void testAddInventory3(){
		assertFalse(cm.addInventory(-6, 7, 8, 9));
		assertEquals(0, i.getCoffee());
		assertEquals(7, i.getMilk());
	}
	
	//Test to see if units of milk can be negative. Result will be 0
	@Test
	public void testAddInventory4(){
		assertFalse(cm.addInventory(6, -7, 8, 9));
		assertEquals(0, i.getMilk());
		assertEquals(8, i.getSugar());
	}
	
	//Test to see if units of sugar can be negative. Result will be 0
	@Test
	public void testAddInventory5(){
		assertFalse(cm.addInventory(6, 7, -8, 9));
		assertEquals(0, i.getSugar());
		assertEquals(9, i.getChocolate());
	}
	
	//Test to see if units of chocolate can be negative. Result will be 0
	@Test
	public void testAddInventory6(){
		assertFalse(cm.addInventory(6, 7, 8, -9));
		assertEquals(0, i.getChocolate());
		assertEquals(6, i.getCoffee());
	}
	
	//Test to see that units can be zero. The values for the units will be populated with default values
	@Test
	public void testAddInventory7(){
		assertTrue(cm.addInventory(0, 0, 0, 0));
	}
	
	//Test to see if Inventory can be successfully checked
	@Test
	public void testCheckInventory1(){
		assertNotNull(i);
	}
	
	//Test to check for inventory coffee units that contain negative value
	@Test
	public void testCheckInventory2(){
		i.setCoffee(-16);
		i.setMilk(-16);
		i.setSugar(-16);
		i.setChocolate(-16);
		cm.addInventory(-12, -12, -12, -12);
		System.out.println(cm.checkInventory());	
	}
	
	//Test to see if a purchase can be  made with amount paid greater than price of beverage
	//and enough ingredients have been added
	@Test
	public void testPurchaseBeverage1(){
	cm.addInventory(6, 7, 8, 9);
	assertEquals(10, cm.makeCoffee(r1, 60));

	
	}
	//Test to see if a purchase can be  made with amount paid less than price of beverage
	//and enough ingredients have been added
	@Test
	public void testPurchaseBeverage2(){
	cm.addInventory(6, 7, 8, 9);
	assertEquals(40, cm.makeCoffee(r1, 40));	
	assertNotNull(i);
	}
	
	//Test to see if a purchase can be  made with amount paid equal than price of beverage
	//and enough ingredients have been added
	@Test
	public void testPurchaseBeverage3(){
	cm.addInventory(6, 7, 8, 9);
	assertEquals(0, cm.makeCoffee(r1, 50));	
	}
	
	//Test to see if enough ingredients have been added. With Inventory values less than Recipe values
	@Test
	public void testPurchaseBeverage4(){
	cm.addInventory(5, 0, 0, 2);
	assertEquals(60, cm.makeCoffee(r4, 60));	
	}
	
	//Test to see if enough ingredients have been added. With Inventory values equal to Recipe values
	@Test
	public void testPurchaseBeverage5(){
	cm.addInventory(6, 1, 1, 0);
	assertEquals(10, cm.makeCoffee(r5, 60));
	}
	
	
	@After
	public void tearDown() throws Exception{
		r1 = null;
		r2 = null;
		r3 = null;
		r4 = null;
		r5 = null;
		r6 = null;
		i = null;
		cm = null;
		
	}
	
	
}