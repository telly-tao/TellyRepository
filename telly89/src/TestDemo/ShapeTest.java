package TestDemo;

import org.junit.Test;

import FactoryPattern.Factory.ShapeFactory;
import FactoryPattern.Iinterface.Shape;

public class ShapeTest {

	
	ShapeFactory shapeFactory = new ShapeFactory();
	@Test
	public void circle() {
	      //��ȡ Circle �Ķ��󣬲��������� draw ����
	      Shape shape1 = shapeFactory.getShape("CIRCLE");
	 
	      //���� Circle �� draw ����
	      shape1.draw();
	}
	@Test
	public void rectangle() {
	      //��ȡ Rectangle �Ķ��󣬲��������� draw ����
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");
	 
	      //���� Rectangle �� draw ����
	      shape2.draw();
	      
	}
	@Test
	public void square() {
	      //��ȡ Square �Ķ��󣬲��������� draw ����
	      Shape shape3 = shapeFactory.getShape("SQUARE");
	 
	      //���� Square �� draw ����
	      shape3.draw();
	} 
}
