package atividade3.impl;
import java.util.NoSuchElementException;
import java.util.Stack;

import atividade3.interfaces.TreeIterator;
import atividade3.interfaces.TreeInterface;

public class PreOrderIt implements TreeIterator {
	private Stack<TreeInterface> cursor;
	
	public PreOrderIt(TreeInterface tree) {
		cursor = new Stack<TreeInterface>();
		if(tree != null) {
			cursor.push(tree);
		}
	}

	public boolean hasNext() {
		return !cursor.isEmpty();
	}

	public TreeInterface next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		TreeInterface current = cursor.pop();
		
		for (int i = current.getNumChildren() - 1; i >= 0; i--) {
            cursor.push(current.getChild(i));
        }
        return current;
	}

}
