package model.entity.mower;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import helper.service.CoordinateFileReaderService;
import model.entity.position.CoordinatePosition;

public class AutomaticMowerTest {

	@Test
	public void testRotateLeftFromNorth() throws Exception {
		AMower mower = CoordinateFileReaderService.getInstance().createMower("8 15", "1 15 N", "G");
		CoordinatePosition position = (CoordinatePosition) mower.getPosition();
		assertEquals('N', position.getDirection());

		mower.move();
		position = (CoordinatePosition) mower.getPosition();
		assertEquals('W', position.getDirection());

	}

	@Test
	public void testRotateRightFromSouth() throws Exception {
		AMower mower = CoordinateFileReaderService.getInstance().createMower("8 15", "1 15 S", "D");
		CoordinatePosition position = (CoordinatePosition) mower.getPosition();
		assertEquals('S', position.getDirection());

		mower.move();
		position = (CoordinatePosition) mower.getPosition();
		assertEquals('W', position.getDirection());

	}

	@Test
	public void testMoveForwardFromSouth() throws Exception {
		AMower mower = CoordinateFileReaderService.getInstance().createMower("8 15", "1 15 S", "A");
		CoordinatePosition position = (CoordinatePosition) mower.getPosition();
		assertEquals('S', position.getDirection());
		assertEquals(15, position.getyCoordinate());

		mower.move();
		position = (CoordinatePosition) mower.getPosition();
		assertEquals('S', position.getDirection());
		assertEquals(14, position.getyCoordinate());

	}

}
