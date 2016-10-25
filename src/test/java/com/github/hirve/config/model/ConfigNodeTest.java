/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class ConfigNodeTest {
  
  private final String testLine = "  aaa a( 2, 3 r,3 ,4 ) = a1 b('1000')= b1 id (aaaId) c(2) = c1 ";
  private final String testLine2 = "  bbb a ()= a2 id (bbbId) b(2\") = b2 ";

  public ConfigNodeTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getInstruction method, of class ConfigNode.
   */
  @Test
  public void testGetInstruction() {
    System.out.println("getInstruction");
    ConfigNode configNode = new ConfigNode(testLine);
    assertEquals("aaa", configNode.getInstruction().getKeyword());
  }

  /**
   * Test of getId method, of class ConfigNode.
   */
  @Test
  public void testSetId_getId() {
    System.out.println("getId");
    ConfigNode configNode = new ConfigNode(testLine);
    configNode.setId("id1");
    assertEquals("id1", configNode.getId());
  }

  /**
   * Test of getLine method, of class ConfigNode.
   */
  @Test
  public void testGetLine() {
    System.out.println("getLine");
    ConfigNode configNode = new ConfigNode(testLine);
    assertEquals(testLine, configNode.getLine());
  }

  /**
   * Test of setLine method, of class ConfigNode.
   */
  @Test
  public void testSetLine() {
    System.out.println("setLine");
    ConfigNode configNode = new ConfigNode(testLine);
    assertEquals(testLine, configNode.getLine());
    
    configNode.setLine(testLine2);
    assertEquals(testLine2, configNode.getLine());
  }

  /**
   * Test of toString method, of class ConfigNode.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    ConfigNode configNode = new ConfigNode(testLine);
    assertEquals(testLine, configNode.toString());
  }

  /**
   * Test of getOffset method, of class ConfigNode.
   */
  @Test
  public void testGetOffset() {
    System.out.println("getOffset");
    ConfigNode configNode = new ConfigNode(testLine);
    assertEquals(2, configNode.getOffset());
  }

  /**
   * Test of getStructureNode method, of class ConfigNode.
   */
  @Test
  public void testGetStructureNode() {
    System.out.println("getStructureNode");
    ConfigNode<String> configNode = new ConfigNode<>(testLine);
    configNode.setStructureNode("a");
    assertTrue(configNode.getStructureNode() instanceof String);
  }

  /**
   * Test of appendChild method, of class ConfigNode.
   */
  @Test
  public void testAppendChild_getChilds() {
    System.out.println("appendChild");
    ConfigNode configNode = new ConfigNode(testLine);
    
    ConfigNode childNode1 = new ConfigNode(testLine);
    configNode.appendChild(childNode1);
    ConfigNode childNode2 = new ConfigNode(testLine);
    configNode.appendChild(childNode2);
    
    List<ConfigNode> childs = configNode.getChilds();
    assertEquals(childNode1, childs.get(0));
    assertEquals(childNode2, childs.get(1));
  }

  /**
   * Test of setParent method, of class ConfigNode.
   */
  @Test
  public void testSetParent_getParent() {
    System.out.println("setParent");
    ConfigNode configNode = new ConfigNode(testLine);
    ConfigNode childNode1 = new ConfigNode(testLine);
    configNode.appendChild(childNode1);
    assertEquals(configNode, childNode1.getParent());
  }

  /**
   * Test of isRoot method, of class ConfigNode.
   */
  @Test
  public void testIsRoot() {
    System.out.println("isRoot");
    ConfigNode configNode = new ConfigNode();
    ConfigNode childNode1 = new ConfigNode(testLine);
    configNode.appendChild(childNode1);
    assertTrue(configNode.isRoot());
    assertFalse(childNode1.isRoot());
  }

  /**
   * Test of getRoot method, of class ConfigNode.
   */
  @Test
  public void testGetRoot() {
    System.out.println("getRoot");
    ConfigNode configNode = new ConfigNode();
    ConfigNode childNode1 = new ConfigNode(testLine);
    configNode.appendChild(childNode1);
    assertEquals(configNode, childNode1.getRoot());
  }

  /**
   * Test of isInTreeOf method, of class ConfigNode.
   * 
   * configNode
   * |--childNode1
   * `--childNode2
   *    `--childOfChildNode2
   */
  @Test
  public void testIsInTreeOf() {
    System.out.println("isInTreeOf");
    ConfigNode configNode = new ConfigNode();
    
    ConfigNode childNode1 = new ConfigNode(testLine);
    configNode.appendChild(childNode1);
    assertTrue(childNode1.isInTreeOf(configNode));
    assertFalse(configNode.isInTreeOf(childNode1));
    
    ConfigNode childNode2 = new ConfigNode(testLine);
    configNode.appendChild(childNode2);
    assertTrue(childNode2.isInTreeOf(configNode));
    assertFalse(childNode2.isInTreeOf(childNode1));
    
    ConfigNode childOfChildNode2 = new ConfigNode(testLine);
    childNode2.appendChild(childOfChildNode2);
    assertTrue(childOfChildNode2.isInTreeOf(configNode));
    assertTrue(childOfChildNode2.isInTreeOf(childNode2));
    assertFalse(childOfChildNode2.isInTreeOf(childNode1));
  }

  /**
   * Test of getById method, of class ConfigNode.
   * 
   * configNode
   * |--childNode1
   * `--childNode2
   *    `--childOfChildNode2 id=id1
   */
  @Test
  public void testGetById() {
    System.out.println("getById");
    ConfigNode configNode = new ConfigNode();
    
    ConfigNode childNode1 = new ConfigNode(testLine);
    configNode.appendChild(childNode1);
    ConfigNode childNode2 = new ConfigNode(testLine);
    configNode.appendChild(childNode2);
    
    ConfigNode childOfChildNode2 = new ConfigNode(testLine);
    childNode2.appendChild(childOfChildNode2);
    childOfChildNode2.setId("id1");
    
    assertEquals(childOfChildNode2, configNode.getById("id1"));
    assertEquals(childOfChildNode2, childNode2.getById("id1"));
    assertNull(childNode1.getById("id1"));
  }
}
