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
				
		ICard c1 = new Card("TestCard1", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Clay);
		
		ICard c2 = new Card("TestCard2", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		// Karte 3
		tmpValue.add(ResourceType.Papyrus);
		
		ICard c3 = new Card("TestCard3", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		ICard c = new Card("TestCard4", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
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
				
		ICard c1 = new Card("TestCard5", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Papyrus);
		
		ICard c2 = new Card("TestCard6", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		ICard c = new Card("TestCard7", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
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
				
		ICard c1 = new Card("TestCard8", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Clay);
		
		ICard c2 = new Card("TestCard9", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		//Karte 3
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Papyrus);
				
		ICard c3 = new Card("TestCard10", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
				
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		ICard c = new Card("TestCard11", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
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
				
		ICard c1 = new Card("TestCard12", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Clay);
		
		ICard c2 = new Card("TestCard13", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		//Karte 3
		tmpValue.add(ResourceType.Papyrus);
				
		ICard c3 = new Card("TestCard14", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
				
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		ICard c = new Card("TestCard15", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
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
				
		ICard c1 = new Card("TestCard16", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpValue.clear();
		
		//Karte 2
		tmpValue.add(ResourceType.Stone);
		tmpValue.add(ResourceType.Clay);
		
		ICard c2 = new Card("TestCard17", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c2);
		tmpValue.clear();
		
		//Karte 3
		tmpValue.add(ResourceType.Papyrus);
				
		ICard c3 = new Card("TestCard18", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue, tmpCost, false, "RM_Ziegelei_3.jpg");
				
		tmpCards.add(c3);
		tmpValue.clear();
		
		// gespielte Karte
		tmpValue.add(ResourceType.GearWheel);		
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Clay);
		tmpCost.add(ResourceType.Papyrus);
		
		ICard c = new Card("TestCard19", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValue, tmpCost, false, "TestName");
		
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
