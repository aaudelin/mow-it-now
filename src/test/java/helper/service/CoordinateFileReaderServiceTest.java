package helper.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import exception.CoordinateFileReadException;
import model.entity.field.AField;
import model.entity.field.CoordinateField;
import model.entity.order.AOrder;
import model.entity.order.MoveOrder;
import model.entity.order.RotateOrder;
import model.entity.position.APosition;
import model.entity.position.CoordinatePosition;

public class CoordinateFileReaderServiceTest {

	@Test(expected = CoordinateFileReadException.class)
	public void testInvalidField() throws Exception {
		CoordinateFileReaderService.getInstance().createField("G 15");
	}

	@Test(expected = CoordinateFileReadException.class)
	public void testInvalidPosition() throws Exception {
		CoordinateFileReaderService.getInstance().createPosition("1 15 Z 8");
	}

	@Test(expected = CoordinateFileReadException.class)
	public void testInvalidOrders() throws Exception {
		CoordinateFileReaderService.getInstance().createOrders("ADL X");
	}

	@Test
	public void testField() throws Exception {
		AField field = CoordinateFileReaderService.getInstance().createField("8 15");
		assertTrue(field instanceof CoordinateField);
	}

	@Test
	public void testPosition() throws Exception {
		APosition position = CoordinateFileReaderService.getInstance().createPosition("1 15 S");
		assertTrue(position instanceof CoordinatePosition);
	}

	@Test
	public void testOrders() throws Exception {
		List<AOrder> orders = CoordinateFileReaderService.getInstance().createOrders("DAG");
		assertTrue(orders.get(0) instanceof RotateOrder);
		assertTrue(orders.get(1) instanceof MoveOrder);
		assertTrue(orders.get(2) instanceof RotateOrder);
	}

}
