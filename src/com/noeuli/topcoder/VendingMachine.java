package com.noeuli.topcoder;

// SRM 145 DIV2 Level3 500 point
public class VendingMachine {
	private final int ROTATE_LIMIT = 5;	 // 5 minutes
	private final boolean LOGD = true;
	
	class Purchase {
		int shelf;
		int column;
		int time;
		
		public Purchase(String data) {
			int comma = data.indexOf(",");
			int colon = data.indexOf(":");

			shelf = Integer.valueOf(data.substring(0, comma));
			column = Integer.valueOf(data.substring(comma+1, colon));
			time = Integer.valueOf(data.substring(colon+1, data.length()));
			
			if (LOGD) System.out.println("value=" + shelf + "," + column + "," + time);
		}
	}
	
	class Column {
		int[] goods;
		int shelves;
		int total;
		
		public Column(int shel) {
			shelves = shel;
			goods = new int[shelves];
			total = 0;
		}
		
		public void put(int idx, int price) {
			goods[idx] = price;
			total += price;
		}
		
		public int get(int idx) {
			return goods[idx];
		}
		
		public void remove(int idx) {
			total -= goods[idx];
			goods[idx] = 0;
		}
	}
	
	class Inventory {
		Column[] columns;
		int cols;
		
		public Inventory(int column) {
			cols = column;
			columns = new Column[cols];
		}
	}
	
	private Inventory mInventory;
	private int mLastTime = 0;
	private int mCurrentColumn = 0;
	
	private int getCloseDirection(int base, int dest, int count) {
		if (dest==base) return 0;
		else if (dest>base) return dest-base;
		else return base+count-dest;
	}

	private int moveToExpensiveColumn() {
		int expensiveColumn = 0;
		int total = 0;
		for (int i=0; i<mInventory.cols; i++) {
			if (total < mInventory.columns[i].total) {
				total = mInventory.columns[i].total;
				expensiveColumn = i;
			}
		}
		
		int moved = 0;
		if (mCurrentColumn!=expensiveColumn) {
			moved = getCloseDirection(mCurrentColumn, expensiveColumn, mInventory.cols);
			mCurrentColumn = expensiveColumn;
		}
		//mLastTime += moved;
		
		return moved;
	}
	
	private int buy(Purchase p) {
		if (LOGD) System.out.println("buy(" + p + ")");
		
		Column col = mInventory.columns[p.column];
		int move = getCloseDirection(mCurrentColumn, p.column, mInventory.cols);
		if (col.get(p.shelf)==0) return -1;
		else col.remove(p.shelf);
		mLastTime = p.time;
		return move;
	}
	
	/**
	 * 
	 * @param prices
	 * @param purchases
	 * @return If a user tries to purchase an item that was already purchased, 
	 * 		this is an incorrect simulation, and your method should return -1. 
	 * 		Otherwise, your method should return how long the motor was running, in seconds.
	 */
	public int motorUse(String[] prices, String[] purchases) {
		int running = 0;
		
		// Convert input prices
		int cols = prices.length;
		mInventory = new Inventory(prices.length);
		
		for (int i=0; i<cols; i++) {
			String temp[] = prices[i].split(" ");
			int shelves = temp.length;
			mInventory.columns[i] = new Column(shelves);
			for (int j=0; j<shelves; j++) {
				mInventory.columns[i].put(j, Integer.valueOf(temp[j]));
			}
		}
		
		// Verify
		if (LOGD) {
			System.out.println("columns=" + mInventory.cols + " shelves=" + mInventory.columns[0].shelves);
			for (int i=0; i<mInventory.cols; i++) {
				Column col = mInventory.columns[i];
				for (int j=0; j<col.shelves; j++) {
					System.out.println("Column " + i + " Shelf " + j + " has " + col.get(j));
				}
			}
			System.out.println("");
		}

		// Start
		mCurrentColumn = 0;

		// move to the most expensive columns after power on.
		running = moveToExpensiveColumn();
		
		// Convert input purchases
		int purchase_length = purchases.length;
		Purchase purchase[] = new Purchase[purchase_length];
		for (int i=0; i<purchase_length; i++) {
			purchase[i] = new Purchase(purchases[i]);

			// Calculate.
			int moved = buy(purchase[i]);
			if (moved==-1) {
				if (LOGD) System.out.println("Invalid. return -1");
				return -1;
			} else {
				running += moved;
			}
		}

		/*
		// move to the most expensive columns at the end of the simulation
		moveToExpensiveColumn();
*/
		if (LOGD) {
			System.out.println("");
			System.out.println("running=" + running);
		}
		
		return running;
	}
}
