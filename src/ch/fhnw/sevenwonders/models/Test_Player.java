package ch.fhnw.sevenwonders.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.interfaces.IBoard;

class Test_Player {
/*
	@Test
	void testEvaluateVictoryCoin() {
		Player p = new Player();
		p.getCoinWallet()
				.addAll(Arrays.asList(ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin,
						ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin,
						ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));
		assertEquals(p.evaluateVictoryCoin(), 4);
	}
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
		
		tmpValueTwo.addAll(Arrays.asList(ResourceType.VictoryPoint, ResourceType.VictoryPoint, ResourceType.VictoryPoint,
				ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));
		
		tmpCostTwo.addAll(Arrays.asList(ResourceType.Wood, ResourceType.Wood));
		
		tmpValueThree.addAll(Arrays.asList(ResourceType.VictoryPoint, ResourceType.VictoryPoint, ResourceType.VictoryPoint, ResourceType.VictoryPoint,
				ResourceType.VictoryPoint, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin, ResourceType.Coin));
		
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
/*
	@Test
	void testEvaluateVictoryDirect() {
		fail("Not yet implemented");
	}

	@Test
	void testEvaluateVictoryResearch() {
		fail("Not yet implemented");
	}

	@Test
	void testEvaluate() {
		fail("Not yet implemented");
	}
*/
}
