//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////

//

// Title: Exceptional Bank

// Files: ExceptionalBank.java, ExceptionalBankTester.java

// Course: (CS 300, Fall, and 2020)

//

// Author: Sai Rahul Reddy Kondlapudi

// Email: kondlapudi@wisc.edu

// Lecturer's Name: Gary Dahl

//

//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////

//

// Partner Name: (name of your pair programming partner)

// Partner Email: (email address of your programming partner)

// Partner Lecturer's Name: (name of your partner's lecturer)

//

// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:

// ___ Write-up states that pair programming is allowed for this assignment.

// ___ We have both read and understood the course Pair Programming Policy.

// ___ We have registered our team prior to the team registration deadline.

//

///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////

//

// Students who get help from sources other than their partner and the course

// staff must fully acknowledge and credit those sources here. If you did not

// receive any help of any kind from outside sources, explicitly indicate NONE

// next to each of the labels below.

//

// Persons: None

// Online Sources: None

//

///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

import java.util.zip.DataFormatException;

import java.io.File;

import java.io.FileNotFoundException;



/**
 * 
 * @author Sai Rahul Reddy Kondlapudi
 * 
 * 
 * 
 * @Description This is the ExceptionalBankTester class
 * 
 * 
 * 
 * @version 1.0
 *
 * 
 * 
 */

public class ExceptionalBankTester {

  /**
   * 
   * This method checks whether the ExceptionalBank constructor throws an IllegalArgumentException
   * 
   * with appropriate error message, when it is passed a zero or a negative capacity. This test must
   * 
   * fail if another kind of exception is thrown for such test scenario.
   *
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   * 
   * 
   */

  public static boolean testExceptionalBankConstructor() {

    try {

      // create an exceptional bank with a negative capacity

      ExceptionalBank bank = new ExceptionalBank(-10);

      System.out.println(

              "Problem detected. The constructor call of the ExceptionalBank class did not "

                      + "throw an IllegalArgumentException when it is passed a negative capacity.");

      return false; // return false if no exception has been thrown

    } catch (IllegalArgumentException e1) {

      // check that the caught IllegalArgumentException includes

      // an appropriate error message

      if (e1.getMessage() == null // your test method should not throw

              // a NullPointerException,but must return false if e1.getMessage is null

              || !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {

        System.out

                .println("Problem detected. The IllegalArgumentException thrown by the constructor "

                        + "call of the ExceptionalBank class when it is passed a negative capacity "

                        + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      // an exception other than IllegalArgumentException has been thrown

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "constructor of the ExceptionBank class with a negative argument. "

                      + "An IllegalArgumentException was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank

      // constructor code.

      return false;

    }

    return true; // test passed

  }



  /**
   * 
   * This method checks whether ExceptionalBank.removeCoin() method throws a NoSuchElementException
   * 
   * with an appropriate error message, when it is called on an empty bank.
   *
   * 
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   * 
   * 
   */

  public static boolean testRemoveCoinEmptyBank() {

    try {

      ExceptionalBank bank = new ExceptionalBank(1);

      bank.removeCoin();

      bank.removeCoin();

      System.out

              .println("Problem detected. The Method call did not throw a NoSuchElementException.");

      return false; // return false if no exception has been thrown

    } catch (NoSuchElementException e) {



      if (e.getMessage() == null

              || !e.getMessage().toLowerCase().contains(" unable to remove a coin.")) {

        System.out.println("Problem detected. The NoSuchElementException thrown by the method "

                + "call of the ExceptionalBank class when it is called on an empty bank "

                + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with an empty bank. "

                      + "A NoSuchElementException was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether the ExceptionalBank constructor creates without errors an empty
   * 
   * exceptional bank with capacity 20 when it is passed 20 as input parameter. This test must fail
   * 
   * if any exception is thrown for such test scenario.
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise
   * 
   * 
   * 
   */

  public static boolean testGoodExceptionalBankConstructor() {

    ExceptionalBank bank = new ExceptionalBank(20);

    if (bank.capacity() != 20)

      return false;

    return true;

  }



  public static boolean testAddCoin() {

    try {

      ExceptionalBank bank = new ExceptionalBank(1);

      bank.addCoin(null);

      System.out.println(

              "Problem detected. The Method call did not throw a IllegalArgumentException.");

      return false;

    } catch (IllegalArgumentException e) {



      if (e.getMessage() == null

              || !e.getMessage().toLowerCase().contains(" cannot add a null reference")) {

        System.out.println("Problem detected. The IllegalArgumentException thrown by the method "

                + "call of the ExceptionalBank class when it is called on a null "

                + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with null. " + "A IllegalArgument was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether ExceptionalBank.addCoins() method throws an IllegalArgumentException
   * 
   * with an appropriate error message when it is passed a null reference as input argument
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise.
   * 
   * 
   * 
   */

  public static boolean testAddCoinsIllegalArgument() {

    try {

      ExceptionalBank bank = new ExceptionalBank(10);

      bank.addCoins(null);

      System.out.println(

              "Problem detected. The Method call did not throw a IllegalArgumentException.");

      return false;

    } catch (IllegalArgumentException e) {



      if (e.getMessage() == null || !e.getMessage().toLowerCase()

              .contains("does not accept a null reference as input.")) {

        System.out.println("Problem detected. The IllegalArgumentException thrown by the method "

                + "call of the ExceptionalBank class when it is called on a null "

                + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with null. " + "A IllegalArgument was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether ExceptionalBank.addCoins() method throws a NoSuchElementException
   * 
   * with an appropriate error message when it is passed a String object with a correct format
   * 
   * (meaning "string:positive_number"), but with a coin name not defined in the enum Coin's
   * 
   * constants. For instance, when it is passed "blabla:10".
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise.
   * 
   * 
   * 
   */

  public static boolean testAddCoinsNoSuchElement() {

    try {

      ExceptionalBank bank = new ExceptionalBank(10);

      bank.addCoins("Rahul:2");

      System.out

              .println("Problem detected. The Method call did not throw a NoSuchElementException.");

      return false;

    } catch (NoSuchElementException e) {



      if (e.getMessage() == null

              || !e.getMessage().toLowerCase().contains("the coin name provided in")) {

        System.out.println("Problem detected. The NoSuchElementException thrown by the method "

                + "call of the ExceptionalBank class when it is called with undefined coin name "

                + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with undefined coin name "

                      + "A NoSuchElementException was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether ExceptionalBank.addCoins() method throws a DataFormatException with
   * 
   * an appropriate error message when it is passed an incorrectly formatted string object, for
   * 
   * instance "quarter: five", or ": 6", or "DIME:-5"
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise.
   * 
   * 
   * 
   */

  public static boolean testAddCoinsInvalidDataFormat() {

    try {

      ExceptionalBank bank = new ExceptionalBank(10);

      bank.addCoins("penny:  ten");

      System.out.println("Problem detected. The Method call did not throw a DataFormatException.");

      return false;

    }



    catch (IllegalArgumentException e1) {



      if (e1.getMessage() == null

              || !e1.getMessage().toLowerCase().contains("the format of the command")) {

        System.out.println("Problem detected. The NumberFormatException thrown by the method "

                + "call of the ExceptionalBank class when it is called with incorrect"

                + " formatted string " + "does not contain an appropriate error message.");

        return false;

      }

    }



    catch (DataFormatException e) {



      if (e.getMessage() == null

              || !e.getMessage().toLowerCase().contains("the format of the command line")) {

        System.out.println("Problem detected. The DataFormatException thrown by the method "

                + "call of the ExceptionalBank class when it is called with incorrect"

                + " formatted string " + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with an incorrectly formatted string "

                      + "A DataFormatException was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether the ExceptionalBank.addCoins() works appropriately when it is passed
   * 
   * a String with a valid format.
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise.
   * 
   * 
   * 
   */

  public static boolean testAddCoinsValidFormat() {



    ExceptionalBank bank = new ExceptionalBank(20);

    try {

      bank.addCoins("QUARTER:2");

    } catch (DataFormatException e) {

      e.printStackTrace();

    }

    {

      if (bank.getSpecificCoinCount("Quarter") != 2)

        return false;

    }

    try {

      bank.addCoins("Penny : 3");

    } catch (DataFormatException e) {



      e.printStackTrace();

    }

    if (bank.getSpecificCoinCount("Penny") != 3)

      return false;



    return true;

  }



  public static boolean testLoadCoinsNullReference() {

    try {

      ExceptionalBank bank = new ExceptionalBank(10);

      bank.loadCoins(null);;

      System.out.println("Problem detected. The Method call did not throw a NullPointerExeption.");

      return false;

    } catch (NullPointerException e) {



      if (e.getMessage() == null

              || !e.getMessage().toLowerCase().contains("nothing exists in file.")) {

        System.out.println("Problem detected. The NullPointerException thrown by the method "

                + "call of the ExceptionalBank class when it is called with null "

                + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with undefined coin name "

                      + "A NullPointerException was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether ExceptionalBank.loadCoins() method throws a FileNotFoundException
   * 
   * when it is passed a non found file.
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise.
   * 
   */

  public static boolean testLoadCoinsFileNotFound() {

    try {

      ExceptionalBank bank = new ExceptionalBank(10);

      File file = new File("rohit.txt");

      bank.loadCoins(file);

      System.out

              .println("Problem detected. The Method call did not throw a FileNotFoundException.");

      return false;

    } catch (FileNotFoundException e) {



      if (e.getMessage() == null

              || !e.getMessage().toLowerCase().contains("file does not exist.")) {

        System.out.println("Problem detected. The FileNotFoundException thrown by the method "

                + "call of the ExceptionalBank class when it is called with a non found file "

                + "does not contain an appropriate error message.");

        return false;

      }

    } catch (Exception e2) {

      System.out

              .println("Problem detected. An unexpected exception has been thrown when calling the "

                      + "the method with undefined coin name "

                      + "A FileNotFoundException was expected to be thrown. "

                      + "But, it was NOT the case.");

      e2.printStackTrace();

      return false;

    }

    return true;

  }



  /*
   * 
   * This method checks whether ExceptionalBank.loadCoins() method loads appropriately without
   * 
   * throwing any exception when it is passed a found file.
   * 
   * 
   * 
   * @returns true when this test verifies a correct functionality, and false otherwise.
   * 
   * 
   * 
   */

  public static boolean testLoadCoinsFileFound() {



    File file = new File("C:\\Users\\saira\\Desktop/rohit.txt");

    if (!file.exists())

      return false;



    return true;

  }



  public static void main(String[] args) {

    System.out.println("testExceptionalBankConstructor: " + testExceptionalBankConstructor());

    System.out.println("testRemoveCoinEmptyBank: " + testRemoveCoinEmptyBank());

    System.out

            .println("testGoodExceptionalBankConstructor: " + testGoodExceptionalBankConstructor());

    System.out.println("testAddCoin: " + testAddCoin());

    System.out.println("testAddCoinsIllegalArgument: " + testAddCoinsIllegalArgument());

    System.out.println("testAddCoinsNoSuchElement: " + testAddCoinsNoSuchElement());

    System.out.println("testAddCoinsInvalidDataFormat: " + testAddCoinsInvalidDataFormat());

    System.out.println("testAddCoinsValidFormat: " + testAddCoinsValidFormat());

    System.out.println("testLoadCoinsNullReference: " + testLoadCoinsNullReference());

    System.out.println("testLoadCoinsFileNotFound: " + testLoadCoinsFileNotFound());

    System.out.println("testLoadCoinsFileFound: " + testLoadCoinsFileFound());



  }

}

