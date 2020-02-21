/**
 * This class implements a stack using a linked list. There is the inner class Link which
 * creates the link and another inner class LinkList, which is what is used to
 * implement the stack. The Stack class calls the method in the LinkList class.
 * 
 * @author <Jeremiah Baclig>
 * @version <10/21/2019>
 */

public class Stack {
	
	static class Link {

		private Country dData;
		private Link next;
		
		/*
		 * Constructor for the nested Link class.
		 * 
		 * @param dd	Country object that is passed in.
		 */
		private Link (Country dd) {
			dData = dd;
		}
		
		/*
		 * Prints out the country object - subsequent items on a new line.
		 */
		public void displayLink() {
			System.out.print(dData + "\n");
		} 
	}
	
	static class LinkList {
		
		private Link first;
		
		/*
		 * Constructor for LinkList class. Nothing in list yet so first = null.
		 */
		private LinkList() {
			first = null;
		}
		
		/*
		 * Checks if the list is empty.
		 * 
		 * @return true or false if the value of first is null.
		 */
		public boolean isEmpty() {
			return first == null;
		}
		
		/*
		 * Inserts into the beginning of the list.
		 * 
		 * @param dd	passes in a country object to insert.
		 */
		private void insertFirst(Country dd) {
			Link newLink = new Link(dd);
			newLink.next = first;
			first = newLink;
		}
		
		/*
		 * Deletes the first element of the list.
		 * 
		 * @return contents of the new first element
		 */
		public Country deleteFirst() {
			Link temp = first;
			first = first.next;
			return temp.dData;
		}
		
		/*
		 * Prints out the list by iterating each link and calling displayLink() from Link class.
		 */
		public void displayList() {
			Link current = first;
			
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
			System.out.println("");	
		}
	}
	
		// create a list
		private LinkList theList;
	
		/*
		 * Constructor for the Stack class. Creates a 
		 * linked list by using LinkList()
		 */
		Stack() {
			theList = new LinkList();
		}
	
		/*
		 * Pushes a country object onto the stack.
		 * 
		 * @param dd	country object passed in to push.
		 */
		public void push(Country dd) {
			theList.insertFirst(dd);
		}
	
		/*
		 * Pops a country off the top of the stack.
		 * 
		 * @return uses the deleteFirst() method in the List class
		 */
		public Country pop() {
			return theList.deleteFirst();
		}
		
		/*
		 * Prints the stack by using displayList() method in the List class.
		 */
		public void printStack() {
			theList.displayList();
		}
		
		/*
		 * Checks if the stack is empty by implementing the isEmpty() method in the List class.
		 */
		public boolean isEmpty() {
			return theList.isEmpty();
		}
		
		/*
		 * Returns false always due to a linked list being flexible and not having limitations on size.
		 */
		public boolean isFull() {
			return false;
		}
}
