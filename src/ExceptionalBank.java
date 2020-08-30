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

import java.util.Arrays;

import java.util.Random;

import java.util.Scanner;

import java.util.zip.DataFormatException;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;



/**
 * 
 * This class implements an expanded version of elastic bank application
 * 
 * 
 * 
 * @author Sai Rahul Reddy Kondlapudi
 * 
 * 
 * 
 * @Description This is the Exceptional Bank Class
 * 
 * 
 * 
 * @version 1.0
 * 
 * 
 * 
 */

public class ExceptionalBank {

  private Coin[] coins; // array which stores all coins held in this elastic bank

  private int size; // size of this elastic bank

  private int expansionsLeft; // number of expansions left for this elastic bank

  private static Random rand = new Random(100); // random integers generator



  /**
   * 
   * Creates a new elastic bank object with a given initial capacity
   * 
   * 
   * 
   * @param initialCapacity initial capacity of this elastic bank
   * 
   * 
   * 
   * @throws IllegalArgumentException if the argument is zero or negative.
   * 
   */

  public ExceptionalBank(int initialCapacity) throws java.lang.IllegalArgumentException {

    if (initialCapacity <= 0)

      throw new java.lang.IllegalArgumentException(

              "WARNING! The initial " + "capacity of a bank must be a non-zero positive integer.");

    coins = new Coin[initialCapacity];

    this.expansionsLeft = 2;

  }



  /**
   * 
   * Creates a new elastic bank object with an initial capacity equal to 10
   * 
   */

  public ExceptionalBank() {

    this(10);

  }



  /**
   * 
   * Returns the capacity of this elastic bank
   * 
   * 
   * 
   * @return the capacity of this elastic bank
   * 
   */

  public int capacity() {

    return coins.length;

  }



  /**
   * 
   * Returns the expansions left for this elastic bank
   * 
   * 
   * 
   * @return the expansions left for this elastic bank
   * 
   */

  public int getExpansions() {

    return this.expansionsLeft;

  }



  /**
   * 
   * Returns the number of coins held in this elastic bank
   * 
   * 
   * 
   * @return the size of this elastic bank
   * 
   */

  public int getSize() {

    return this.size;

  }



  /**
   * 
   * Returns the value in cents of coins held in this elastic bank
   * 
   * 
   * 
   * @return the balance of this elastic bank
   * 
   */

  public int getBalance() {

    int balance = 0;

    // add the value of each coin held in this bank to balance, then return it

    for (int i = 0; i < size; i++) {

      balance += coins[i].value();

    }

    return balance;

  }



  /**
   * 
   * Returns the number of coins with a specific coinName held in this bank. The coin name
   * 
   * comparison is case insensitive
   * 
   * 
   * 
   * @param coinName name of a coin
   * 
   * @return the count of coins having the provided coinName, held in this bank
   * 
   */

  public int getSpecificCoinCount(String coinName) {

    int count = 0;

    for (int i = 0; i < size; i++) {

      if (coins[i].name().equalsIgnoreCase(coinName))

        count++;

    }

    return count;

  }



  /**
   * 
   * Returns a string representation of all the coins held in this elastic bank. Each coin is
   * 
   * represented by the pair "(name, value)", and the string representation should contain all of
   * 
   * these pairs in one space-separated line. For example: "(PENNY, 1) (QUARTER, 25) (PENNY, 1)
   * 
   * (DIME, 10) (NICKEL, 5)"
   * 
   * 
   * 
   * @return a String representation of the contents of the bank.
   * 
   */

  public String getCoins() {

    String contents = "";

    // traverse the coins oversize array and add each coin's string representation to the string to

    // be returned

    for (int i = 0; i < size; i++) {

      contents += "(" + coins[i].name() + ", " + coins[i].value() + ")";

      if (i < size - 1)

        contents += " ";

    }

    return contents;

  }



  /**
   * 
   * Returns a summary of this bank contents
   * 
   * 
   * 
   * @return an empty string if this bank is empty, and a string representation of the summary of
   * 
   *         this bank otherwise. The summary of the bank is a set of lines. Each line is formatted
   * 
   *         as follows "coin_name:coin_count"
   * 
   */

  public String getSummary() {

    String summary = "";

    Coin[] values = Coin.values();

    // traverse this bank contents and update its summary

    for (int i = 0; i < values.length; i++) {

      String name = values[i].name();

      int count = getSpecificCoinCount(name);

      if (count != 0) {

        summary += name + ":" + count + "\n";

      }

    }

    return summary.trim(); // remove whitespace (spaces, new lines etc.) from the beginning and end

    // of summary and return the resulting string



  }



  /**
   * 
   * Removes and returns a coin at a random position from this elastic bank
   * 
   * 
   * 
   * @return the removed coin or null if this bank is empty
   * 
   * 
   * 
   * @throws NoSuchElementException if the entered value is zero.
   * 
   */

  public Coin removeCoin() throws java.util.NoSuchElementException {

    if (size == 0) {

      throw new java.util.NoSuchElementException(

              "WARNING! This bank is empty." + " Unable to remove a coin.");



    } else {

      int randPosition = rand.nextInt(size); // get a random position from 0 .. size-1

      Coin removedCoin = coins[randPosition]; // store the coin to be removed

      // The order of the coins within this bank (a piggy bank) is not important

      // So, move the coin at the end of the coins array to the random position

      // and set that last element to null.

      coins[randPosition] = coins[size - 1];

      coins[size - 1] = null;

      size--; // update size

      return removedCoin;

    }



  }



  /**
   * 
   * Removes all the coins from this elastic bank
   * 
   */

  public void empty() {

    // set all the non-null references within the coins array to null

    for (int i = 0; i < size; i++) {

      coins[i] = null;

    }

    // set the size of this bank to 0

    size = 0;

  }



  /**
   * 
   * adds a Coin to the bank and adjusts the capacity of coins if necessary and possible
   * 
   * 
   * 
   * @param c coin to be added to this elastic bank
   * 
   * 
   * 
   * @throws java.lang.IllegalArgumentException - with the following error message "WARNING! You
   * 
   *                                            cannot add a null reference to this bank." if c is
   * 
   *                                            null.
   * 
   */

  public void addCoin(Coin c) throws java.lang.IllegalArgumentException {

    // check if this bank is full

    if (c == null)

      throw new IllegalArgumentException("WARNING! You cannot add a null reference to this bank.");

    if (size == coins.length) {

      // check whether there are expansions left

      if (this.expansionsLeft > 0) {

        // expand the capacity of this elastic bank by 10

        coins = Arrays.copyOf(coins, coins.length + 10);

        this.expansionsLeft--;

      } else { // no expansions left

        // empty this elastic bank

        empty();

      }

    }

    // add c at the end of this bank

    coins[size] = c;

    size++;

  }



  /*
   * 
   * Adds a number of the same coin type with respect to a provided command line. The format of the
   * 
   * command line is "coin_name:coins_count". Such command line refers to adding coins_count of
   * 
   * coin_name to this bank. For instance, "PENNY:5", or " Penny : 5 " refer to adding 5 pennies to
   * 
   * this bank. If the format of the provided command line is incorrect, no coins
   * 
   * 
   * 
   * @param command - command line to add a number of coins of the same type to this bank.
   * 
   * 
   * 
   * @throws java.lang.IllegalArgumentException - with the following error message "WARNING! The
   * 
   * addCoins() method does not accept a null reference as input." if command is null.
   * 
   * 
   * 
   * @throws java.util.zip.DataFormatException - with the following error message
   * 
   * "The format of the command line " + command + " is incorrect." if the format of the provided
   * 
   * command is incorrect
   * 
   * 
   * 
   * @throws java.util.NoSuchElementException - with the following error message
   * 
   * "The coin name provided in the command line " + command + " is invalid." if coin_name argument
   * 
   * within the provided command line does not refer to a valid coin name with respect to the
   * 
   * constant names defined in the enum Coin.
   * 
   */

  public void addCoins(String str) throws java.util.zip.DataFormatException {



    if (str == null) {

      throw new IllegalArgumentException(

              "WARNING! The addCoins() method does not accept" + " a null reference as input.");

    }



    if (!(str.contains(":"))) {

      throw new java.util.zip.DataFormatException(

              "The format of the command line " + str + " is incorrect.");

    }



    String name = str.replaceAll("\\s+", "");

    String[] parts = name.split(":", 2);

    String coinName = parts[0];

    if (!isNumeric(parts[1])) {

      throw new NumberFormatException("The format of the command line " + str + " is incorrect.");

    }

    int numAdd = Integer.valueOf(parts[1]);



    if (numAdd < 0)

      throw new DataFormatException("The format of the command line " + str + " is incorrect.");



    if (coinName.equalsIgnoreCase("PENNY")) {

      for (int i = 0; i < numAdd; i++) {

        addCoin(Coin.PENNY);

      }

    } else if (coinName.equalsIgnoreCase("NICKEL"))

      for (int i = 0; i < numAdd; i++) {

        addCoin(Coin.NICKEL);

      }



    else if (coinName.equalsIgnoreCase("DIME"))

      for (int i = 0; i < numAdd; i++) {

        addCoin(Coin.DIME);

      }

    else if (coinName.equalsIgnoreCase("QUARTER"))

      for (int i = 0; i < numAdd; i++) {

        addCoin(Coin.QUARTER);

      }

    else {

      throw new java.util.NoSuchElementException(

              "The coin name provided in " + "the command line " + str + " is invalid.");

    }



  }



  /*
   * 
   * This is a helper method which is used to identify if the string is a number or not.
   * 
   * 
   * 
   * @param str
   * 
   * 
   * 
   * @throws DataFormatException if the properly formated data is not entered.
   * 
   */

  private static boolean isNumeric(String str) throws DataFormatException {

    if (str == null || str.length() == 0) {

      return false;

    }

    try {

      Integer.parseInt(str);

    } catch (NumberFormatException nfe) {

      throw new DataFormatException(

              "The format of the command line" + " \\\" + command + \\\" is incorrect.");

    }

    return true;



  }



  /*
   * 
   * Load a list of coins from a file object which refers to a data file written in a specific
   * 
   * format (a set of lines each formatted as follows "coin_name:coin_count"). Lines formatted
   * 
   * correctly will be added as new coins to this elastic bank. Lines formatted incorrectly must be
   * 
   * skipped (go to the next line). This method prints/displays the following message for every
   * 
   * skipped line "WARNING! Skipping line. " + "raison_of_the error".
   * 
   * 
   * 
   * @param file - file object which refers to a data file of coin_names and their counts.
   * 
   * 
   * 
   * @throws java.lang.NullPointerException - with or without error message if file is null.
   * 
   * 
   * 
   * @throws java.io.FileNotFoundException - with or without error message if file is not found.
   * 
   */

  public void loadCoins(File file) throws java.io.FileNotFoundException {

    if (file == null) {

      throw new NullPointerException("Nothing exists in file.");

    } else if (!(file.exists())) {

      throw new java.io.FileNotFoundException("File does not exist.");

    }

    Scanner scnr = new Scanner(file);

    while (scnr.hasNextLine()) {

      try {

        addCoins(scnr.nextLine());

      } catch (Exception e) {

        System.out.println(

                e.getMessage() + "\"WARNING! Skipping line. \" " + "\"reason_of_the error\"");

      }

    }

    scnr.close();

  }



  /*
   * 
   * Save the summary of this bank to the provided file in a specific format for each line:
   * 
   * coin_name:coin_count. For instance, if a bank contains 2 quarters, 1 dime, 5 nickels, and 10
   * 
   * pennies, its contents will be saved as follows: PENNY:10 NICKEL:5 DIME:1 QUARTER:2 Note that
   * 
   * the order of lines does not matter.
   * 
   * 
   * 
   * @param file - File object where a summary of the contents of this bank will be saved
   * 
   * 
   * 
   * @throws java.lang.NullPointerException - with or without error message if file is null.
   * 
   */

  public void saveBankSummary(File file) {

    if (file == null) {

      throw new NullPointerException("Nothing exists in file.");

    }



    try {

      PrintWriter writer = new PrintWriter(file);

      writer.print(getSummary());

      writer.close();

    } catch (FileNotFoundException e) {

      System.out.println(e.getMessage() + "The file can't be accessed.");

    }

  }



  public static void main(String[] args) {
  }
}

