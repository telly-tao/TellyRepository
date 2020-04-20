package TestDemo;

import org.junit.Test;

import FactoryPattern.Factory.ShapeFactory;
import FactoryPattern.Iinterface.Shape;

public class ShapeTest {

	
	ShapeFactory shapeFactory = new ShapeFactory();
	@Test
	public void circle() {
	      //获取 Circle 的对象，并调用它的 draw 方法
	      Shape shape1 = shapeFactory.getShape("CIRCLE");
	 
	      //调用 Circle 的 draw 方法
	      shape1.draw();
	}
	@Test
	public void rectangle() {
	      //获取 Rectangle 的对象，并调用它的 draw 方法
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");
	 
	      //调用 Rectangle 的 draw 方法
	      shape2.draw();
	      
	}
	@Test
	public void square() {
	      //获取 Square 的对象，并调用它的 draw 方法
	      Shape shape3 = shapeFactory.getShape("SQUARE");
	 
	      //调用 Square 的 draw 方法
	      shape3.draw();
	} 
}
