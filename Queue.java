/**
 * This class implements a queue(deque) as a doubly linked list. There is the 
 * inner class Link which creates the link and another inner class FirstLastList,
 * which is what is used to implement the queue. The Queue class calls the method in 
 * the FirstLastList class.
 * 
 * @author <Jeremiah Baclig>
 * @version <10/21/2019>
 */

public class Queue {
	
	public Queue theQueue;
	
	public static class Link {
		private Country dData;
		private Link next;
		private Link previous;

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
	
	static class FirstLastList {
		
		private Link first;
		private Link last;

		/*
		 * Constructor for LinkList class. Nothing in list yet so first && last = null.
		 */
		private FirstLastList() {
			first = null;
			last = null;
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
		 * Inserts into the end of the list
		 * 
		 * @param dd 	passes in a country object to insert.
		 */
		private void insertLast(Country dd) {
			Link newLink = new Link(dd);
			
			if(isEmpty()) {
				first = newLink;
			}
			else {
				last.next = newLink;
				newLink.previous = last;
			}
			last = newLink;
		}

		/*
		 * Inserts into the beginning of the list.
		 * 
		 * @param dd	passes in a country object to insert.
		 */
		private void insertFirst(Country dd) {
			Link newLink = new Link(dd);
			
			if(isEmpty()) {
				last = newLink;
			}
			
			newLink.next = first;
			first = newLink;
		}
		
		/*
		 * Deletes the first element of the list.
		 * 
		 * @return contents of the new first element
		 */
		public Country deleteFirst() {
			Country temp = first.dData;
			if(first.next == null) {
				last = null;
			}
			first = first.next;
			
			return temp;
		}
		
		/*
		 * Deletes the last element of the list.
		 * 
		 * @return contents of the new last element.
		 */
		public Country deleteLast() {
			Country temp = last.dData;
			
			if(first.next == null) {
				first = null;
			}
			else {
				last.previous.next = null;
			}
			last = last.previous;
			
			return temp;
		}

		/*
		 * Deletes link given a key, which is a country object named dd.
		 * 
		 * @param dd	Country object that is to be searched for and then deleted from the list.
		 * @return current link.
		 */
		private Link delete(Country dd) {
			Link current = first;
			Link previous = first;
			
			while(current.dData != dd) {
				if(current.next == null) {
					return null;
				}
				else {
					previous = current;
					current = current.next;
				}
			}
			
			if(current == first) {
				first = first.next;
			}
			else {
				previous.next = current.next;
			}
			return current;
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
			
			System.out.println(" ");
		}
	}
	
	// create a double ended list
	private FirstLastList theList;

	/*
	 * Constructor for the Queue class. Creates a linked list by using FirstLastList()
	 */
	public Queue() {
		theList = new FirstLastList();
	}

	/*
	 * Insert into the end of the queue. Calls insertLast() in the FirstLastList() class.
	 * 
	 * @param dd	Country object to be inserted.
	 */
	public void insertEnd(Country dd) {
		theList.insertLast(dd);
	}

	/*
	 * Insert into the front of the queue. Calls insertFirst() in the FirstLastList() class.
	 * 
	 * @param dd	Country object to be inserted.
	 */
	public void insertFront(Country dd) {
		theList.insertFirst(dd);
	}

	/*
	 * Removes the last element of the queue by calling deleteLast in the FirstLastList class.
	 */
	public Country removeEnd() {
		return theList.deleteLast();
	}

	/*
	 * Removes the first element of the queue by calling deleteLast in the FirstLastList class.
	 */
	public Country removeFront() {
		return theList.deleteFirst();
	}

	/*
	 * Finds and deletes a particular country given a key. Calls the delete method in the FirstLastList class.
	 * 
	 * @param dd	Country object to be searched for and then deleted.
	 */
	public void findDelete(Country dd) {
		theList.delete(dd);
	}

	/*
	 * Prints the queue by using displayList() method in the List class.
	 */
	public void printQueue() {
		theList.displayList();
	}

	/*
	 * Checks if the queue is empty by implementing the isEmpty() method in the List class.
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
