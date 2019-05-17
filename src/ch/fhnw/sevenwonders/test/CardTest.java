package ch.fhnw.sevenwonders.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.models.Board;
import ch.fhnw.sevenwonders.models.Card;
import ch.fhnw.sevenwonders.models.Player;

class CardTest {
	

	/**
	 *  Test: Testet, ob die gespielte Karte aus einem Mix von ValueCalculationType null, And und Or finanziert werden kann.
	 */
	@Test
	public void testIsPlayable4 () {
		
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();

		ArrayList<ResourceType> tmpResource = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpValueOne = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostOne = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpValueTwo = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostTwo = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpValueThree = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostThree = new ArrayList<ResourceType>();
		
		
		
		
		//Board

		tmpResource.add(ResourceType.Papyrus);
		tmpValueOne.add(ResourceType.VictoryPoint);
		tmpValueOne.add(ResourceType.VictoryPoint);
		tmpValueOne.add(ResourceType.VictoryPoint);
		tmpCostOne.add(ResourceType.Stone);
		tmpCostOne.add(ResourceType.Stone);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpValueTwo.add(ResourceType.Coin);
		tmpCostTwo.add(ResourceType.Wood);
		tmpCostTwo.add(ResourceType.Wood);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpValueThree.add(ResourceType.VictoryPoint);
		tmpCostThree.add(ResourceType.Papyrus);
		tmpCostThree.add(ResourceType.Papyrus);
		
		
		Board board = new Board("Ephesos A", tmpResource, tmpValueOne, tmpCostOne, tmpValueTwo, tmpCostTwo, tmpValueThree, tmpCostThree, "Board_Ephesos_A.jpg");
		board.setStepOneBuilt(false);
		board.setStepTwoBuilt(false);
		board.setStepThreeBuilt(false);
		
		// Karte 1
		ArrayList<ResourceType> tmpValue1 = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost1 = new ArrayList<ResourceType>();
		tmpValue1.add(ResourceType.Clay);
		tmpValue1.add(ResourceType.Wood);
		tmpCost1.add(ResourceType.Coin);
		
		Card c1 = new Card("EINS", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.Or, tmpValue1, tmpCost1, false, "RM_Ziegelei_3.jpg");
		
		//Karte 2
		ArrayList<ResourceType> tmpValue2 = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost2 = new ArrayList<ResourceType>();
		tmpValue2.add(ResourceType.Wood);
		tmpValue2.add(ResourceType.Clay);
		tmpCost2.add(ResourceType.Coin);
		
		Card c2 = new Card("ZWEI", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue2, tmpCost2, false, "RM_Ziegelei_3.jpg");
		
		//Karte 3
		ArrayList<ResourceType> tmpValue3 = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost3 = new ArrayList<ResourceType>();
		tmpValue3.add(ResourceType.Stone);
		tmpCost3.add(ResourceType.Coin);
		
		Card c3 = new Card("DREI", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue3, tmpCost3, false, "RM_Ziegelei_3.jpg");
		
		
		// gespielte Karte
		ArrayList<ResourceType> tmpValueK = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostK = new ArrayList<ResourceType>();
		tmpValueK.add(ResourceType.Clay);		
		tmpCostK.add(ResourceType.Clay);
		tmpCostK.add(ResourceType.Clay);
		tmpCostK.add(ResourceType.Wood);
		
		Card cT = new Card("TestCard", Age.AgeI, CardType.ScientificStructures, 3, ValueCalculationType.And, tmpValueK, tmpCostK, false, "RM_Ziegelei_3.jpg");
		
		tmpCards.add(c1);
		tmpCards.add(c2);
		tmpCards.add(c3);
		
		Player p = new Player();
		p.setBoard(board);
		p.setCards(tmpCards);
		
		assertTrue(cT.isPlayable(p));
	}
	
}
