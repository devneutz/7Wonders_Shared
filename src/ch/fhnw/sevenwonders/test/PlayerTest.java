package ch.fhnw.sevenwonders.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.interfaces.IBoard;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.models.Board;
import ch.fhnw.sevenwonders.models.Card;
import ch.fhnw.sevenwonders.models.Player;

class PlayerTest {
	/*
	 * @Test void testEvaluateVictoryCoin() { Player p = new Player();
	 * p.getCoinWallet() .addAll(Arrays.asList(ResourceType.Coin, ResourceType.Coin,
	 * ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin,
	 * ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin,
	 * ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));
	 * assertEquals(p.evaluateVictoryCoin(), 4); }
	 */
	@Test
	void testEvaluateVictoryWonder() {
		ArrayList<IBoard> tmpBoardList = new ArrayList<IBoard>();

		ArrayList<ResourceType> tmpResource = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpValueOne = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostOne = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpValueTwo = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostTwo = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpValueThree = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCostThree = new ArrayList<ResourceType>();

		tmpResource.add(ResourceType.Papyrus);

		tmpValueOne.addAll(Arrays.asList(ResourceType.VictoryPoint, ResourceType.VictoryPoint, ResourceType.Coin,
				ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));

		tmpCostOne.addAll(Arrays.asList(ResourceType.Stone, ResourceType.Stone));

		tmpValueTwo.addAll(Arrays.asList(ResourceType.VictoryPoint, ResourceType.VictoryPoint,
				ResourceType.VictoryPoint, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));

		tmpCostTwo.addAll(Arrays.asList(ResourceType.Wood, ResourceType.Wood));

		tmpValueThree.addAll(Arrays.asList(ResourceType.VictoryPoint, ResourceType.VictoryPoint,
				ResourceType.VictoryPoint, ResourceType.VictoryPoint, ResourceType.VictoryPoint, ResourceType.Coin,
				ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));

		tmpCostThree.addAll(Arrays.asList(ResourceType.Papyrus, ResourceType.Cloth, ResourceType.Glas));

		IBoard b = new Board("TestBoard", tmpResource, tmpValueOne, tmpCostOne, tmpValueTwo, tmpCostTwo, tmpValueThree,
				tmpCostThree, "TestBoard.jpg");

		tmpBoardList.add(b);

		b.setStepOneBuilt(true);
		b.setStepTwoBuilt(true);
		b.setStepThreeBuilt(true);

		Player p = new Player();

		p.setBoard(b);

		assertEquals(p.evaluateVictoryWonder(), 10);
	}

	@Test
	void testEvaluateVictoryDirect() {
		ArrayList<ICard> tmpCards = new ArrayList<ICard>();

		// Karte 1
		ArrayList<ResourceType> tmpValue1 = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost1 = new ArrayList<ResourceType>();
		tmpValue1.add(ResourceType.VictoryPoint);
		tmpValue1.add(ResourceType.VictoryPoint);

		Card c1 = new Card("EINS", Age.AgeI, CardType.RawMaterials, 3, ValueCalculationType.And, tmpValue1, tmpCost1,
				false, "Test.jpg");

		// Karte 2
		ArrayList<ResourceType> tmpValue2 = new ArrayList<ResourceType>();
		ArrayList<ResourceType> tmpCost2 = new ArrayList<ResourceType>();
		tmpValue2.add(ResourceType.VictoryPoint);

		Card c2 = new Card("ZWEI", Age.AgeI, CardType.RawMaterials, 3, null, tmpValue1, tmpCost1, false, "Test.jpg");
		
		tmpCards.add(c1);
		tmpCards.add(c2);
		
		Player p = new Player();

		for (int i = 0; i < tmpCards.size(); i++) {
			for (int j = 0; j < tmpCards.get(i).getValue().size(); j++) {

				p.getPlayerResources().add(tmpCards.get(i).getValue().get(j));
			}
		}
		
		assertEquals(p.evaluateVictoryDirect(), 3);

	}
	/*
	 * @Test void testEvaluateVictoryResearch() { fail("Not yet implemented"); }
	 * 
	 * @Test void testEvaluate() { fail("Not yet implemented"); }
	 */
}
