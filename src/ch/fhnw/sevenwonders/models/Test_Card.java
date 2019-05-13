package ch.fhnw.sevenwonders.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.interfaces.ICard;

class Test_Card {

	/**
	 *  Erster Test: Testet, ob die gespielte Karte mit Karten vom ValueCalculationType null finanziert werden kann.
	 */
	@Test
	public void testIsPlayable1 () {
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();
		ArrayList<ResourceType> tmpValue = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost = new ArrayList<ResourceType>();
		
		// Karte 1
		tmpValue.add(ResourceType.Clay);
				
		Card c1 = new Card("", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Clay);
		
		Card c2 = new Card("", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		// Karte 3
		tmpValue.add(ResourceType.Papyrus);
		
		Card c3 = new Card("", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		Card c = new Card("TestCard", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
		tmpCost.clear();
		tmpValue.clear();
		
		assertTrue(c.isPlayable(tmpCards));
	}
	
	/**
	 *  Zweiter Test: Testet, ob die gespielte Karte mit Karten vom ValueCalculationType And finanziert werden kann.
	 */
	@Test
	public void testIsPlayable2 () {
		// Test, ob Karte mit ValueCalculationType Null Karten gefunden wird.
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();
		ArrayList<ResourceType> tmpValue = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost = new ArrayList<ResourceType>();
		
		// Karte 1
		tmpValue.add(ResourceType.Clay);
		tmpValue.add(ResourceType.Clay);
				
		Card c1 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Papyrus);
		
		Card c2 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		Card c = new Card("TestCard", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
		tmpCost.clear();
		tmpValue.clear();
		
		assertTrue(c.isPlayable(tmpCards));
	}
	
	/**
	 *  Dritter Test: Testet, ob die gespielte Karte mit Karten vom ValueCalculationType Or finanziert werden kann.
	 */
	@Test
	public void testIsPlayable3 () {
		// Test, ob Karte mit ValueCalculationType Null Karten gefunden wird.
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();
		ArrayList<ResourceType> tmpValue = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost = new ArrayList<ResourceType>();
		
		// Karte 1
		tmpValue.add(ResourceType.Clay);
		tmpValue.add(ResourceType.Wood);
				
		Card c1 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Clay);
		
		Card c2 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		//Karte 3
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Papyrus);
				
		Card c3 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
				
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		Card c = new Card("TestCard", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
		tmpCost.clear();
		tmpValue.clear();
		
		assertTrue(c.isPlayable(tmpCards));
	}
	
	/**
	 *  Vierter Test: Testet, ob die gespielte Karte aus einem Mix von ValueCalculationType null, And und Or finanziert werden kann.
	 */
	@Test
	public void testIsPlayable4 () {
		// Test, ob Karte mit ValueCalculationType Null Karten gefunden wird.
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();
		ArrayList<ResourceType> tmpValue = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost = new ArrayList<ResourceType>();
		
		// Karte 1
		tmpValue.add(ResourceType.Clay);
		tmpValue.add(ResourceType.Wood);
				
		Card c1 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Clay);
		
		Card c2 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		//Karte 3
		tmpValue.add(ResourceType.Papyrus);
				
		Card c3 = new Card("", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
				
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		Card c = new Card("TestCard", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
		tmpCost.clear();
		tmpValue.clear();
		
		assertTrue(c.isPlayable(tmpCards));
	}
	
	/**
	 *  Fünfter Test: Karte nicht finanzierbar bzw. spielbar.
	 */
	@Test
	public void testIsPlayable5 () {
		// Test, ob Karte mit ValueCalculationType Null Karten gefunden wird.
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();
		ArrayList<ResourceType> tmpValue = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost = new ArrayList<ResourceType>();
		
		// Karte 1
		tmpValue.add(ResourceType.Ore);
		tmpValue.add(ResourceType.Wood);
				
		Card c1 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Clay);
		
		Card c2 = new Card("", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		//Karte 3
		tmpValue.add(ResourceType.Papyrus);
				
		Card c3 = new Card("", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
				
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		Card c = new Card("TestCard", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
		tmpCost.clear();
		tmpValue.clear();
		
		assertFalse(c.isPlayable(tmpCards));
	}
	
	/*@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}*/
}
