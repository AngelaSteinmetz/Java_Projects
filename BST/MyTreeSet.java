import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyTreeSet<E>
{
    private TreeNode<E> myRoot; // holds the root of this BST

    // Constructor: creates an empty BST.
    public MyTreeSet()
    {
        myRoot = null;
    }

    // post: prints the data fields of the tree, one per line
    public void printInorder()
    {
        printInorderHelper( myRoot );
//        System.out.println();
    }

    // pre : root points to a binary search tree
    // post: prints the data fields of the tree using an inorder traversal
    private void printInorderHelper( TreeNode<E> root )
    {
        if (root != null)
        {
            printInorderHelper(root.getLeft());
            System.out.print(root.getValue() + " ");
            printInorderHelper(root.getRight());
        }
    }

    // post: prints the data fields of the tree, one per line
    public void printPreorder()
    {
        printPreorderHelper( myRoot );
//        System.out.println();
    }

    // pre : root points to a binary search tree
    // post: prints the data fields of the tree using an inorder traversal
    private void printPreorderHelper( TreeNode<E> root )
    {
        if (root != null)
        { 
            System.out.print(root.getValue() + " ");
            printPreorderHelper(root.getLeft());
            printPreorderHelper(root.getRight());
        }
    }

    // post: prints the data fields of the tree, one per line
    public void printPostorder()
    {
        printPostorderHelper( myRoot );
//        System.out.println();
    }

    // pre : root points to a binary search tree
    // post: prints the data fields of the tree using an inorder traversal
    private void printPostorderHelper( TreeNode<E> root )
    {
        if (root != null)
        {
            printPostorderHelper(root.getLeft());
            printPostorderHelper(root.getRight());
            System.out.print(root.getValue() + " ");
        }
    }

    // post: returns the number of nodes in the tree
    public int countNodes()
    {
        return countNodesHelper( myRoot );
    }

    // pre : root points to a binary tree
    // post: returns the number of nodes
    private int countNodesHelper( TreeNode<E> root )
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            return countNodesHelper(root.getLeft()) + countNodesHelper(root.getRight()) + 1;
        }
    }

    // post: returns the number of leaves in the tree
    public int countLeaves()
    {
        return countLeaves( myRoot );
    }

    // pre : root points to a binary tree
    // post: returns the number of leaves
    private int countLeaves( TreeNode<E> root )
    {
        if (root == null)
        {
            return 0;
        }
        if (root.getRight() == null && root.getLeft() == null)
        {
            return 1;
        }
        else if (root.getRight() == null)
        {
            return countLeaves(root.getLeft());
        }
        else if (root.getLeft() == null)
        {
            return countLeaves(root.getRight());
        }
        else
        {
            return countLeaves(root.getRight()) + countLeaves(root.getLeft());
        }
    }

    // post: returns the number of nodes in the longest path from the root
    // to a leaf of the tree
    public int height()
    {
        return height( myRoot );
    }

    // pre : root points to a binary tree
    // post: returns the number of nodes in the longest path from the root
    // to a leaf of the tree
    private int height( TreeNode<E> root )
    {
        if (root == null)
        {
            return 0;
        }
        if (root.getRight() == null && root.getLeft() == null)
        {
            return 1;
        }
        else if (root.getRight() == null)
        {
            return height(root.getLeft()) + 1;
        }
        else if (root.getLeft() == null)
        {
            return height(root.getRight()) + 1;
        }
        else
        {
            return max(height(root.getRight()), height(root.getLeft())) + 1;
        }
    }

    // post: returns the number of nodes in the longest path in the tree
    public int width()
    {
        return width( myRoot );
    }

    // pre : root points to a binary tree
    // post: returns the number of nodes in the longest path in the tree
    private int width( TreeNode<E> root )
    {
        if (root == null)
        {
            return 0;
        }
        if (root.getRight() == null && root.getLeft() == null)
        {
            return 1;
        }
        else if (root.getRight() == null)
        {
            int longestPath = 1 + height(root.getLeft());
            return max( longestPath, width(root.getLeft()) );
        }
        else if (root.getLeft() == null)
        {
            int longestPath = 1 + height(root.getRight());
            return max( longestPath, width(root.getRight()) );
        }
        else
        {
            int longestPath = 1 + height(root.getLeft()) + height(root.getRight());
            int max = max( longestPath, width(root.getLeft()) );
            return max( max, width(root.getRight()) );
        }
    }

    // helper for height and width methods.
    // post: return the largest of a and b
    private int max( int a, int b )
    {
        if ( a > b )
            return a;
        else
            return b;
    }

    // post: root of this tree is set to null
    public void clearTree()
    {
        myRoot = null;
    }

    // post: root points to a tree that is a mirror image of the original tree.
    public void interchange()
    {
        interchange( myRoot );
    }

    // pre : root points to a binary tree
    // post: root points to a tree that is a mirror image of the original tree.
    private void interchange( TreeNode<E> root )
    {
        if (root.getRight() == null && root.getLeft() == null)
        {
            return;
        }
        else if (root.getRight() == null)
        {
            root.setRight( root.getLeft() );
            root.setLeft( null );
            interchange(root.getRight());
        }
        else if (root.getLeft() == null)
        {
            root.setLeft( root.getRight() );
            root.setRight( null );
            interchange(root.getLeft());
        }
        else
        {
            TreeNode<E> temp = root.getRight();
            root.setRight( root.getLeft() );
            root.setLeft( temp );
            interchange(root.getLeft());
            interchange(root.getRight());
        }
    }

    // post: prints the data fields of nodes on the same level
    // of the tree
    public void printLevel( int level )
    {
        printLevel( myRoot, level );
//        System.out.println();
    }

    // pre : root points to a binary tree
    // post: prints the data fields of nodes on the same level
    // of the tree
    private void printLevel( TreeNode<E> root, int level )
    {
        if (root == null)
        {
            return;
        }
        if (level == 0)
        {
            System.out.print( root.getValue() + " ");
        }
        else if (root.getRight() == null)
        {
            printLevel(root.getLeft(), level - 1);
        }
        else if (root.getLeft() == null)
        {
            printLevel(root.getRight(), level - 1);
        }
        else
        {
            printLevel(root.getLeft(), level - 1);
            printLevel(root.getRight(), level - 1);
        }
    }

    // post: returns true if ancestor is the ancestor of descendant
    // else returns false
    public boolean isAncestor( Comparable ancestor, Comparable descendant )
    {
        return isAncestor( myRoot, ancestor, descendant );
    }

    // pre : root points to a binary search tree
    // post: returns true if ancestor is the ancestor of descendant
    // else returns false
    private boolean isAncestor( TreeNode<E> root, Comparable a, Comparable d )
    {
        // find if descendant is in subtree with root at ancestor
        if ( findPtr( findPtr( root, a ), d ) != null )
            return true;
        else
            return false;
    }

    // pre : root points to a binary search tree
    // post: returns the value of a node with data equal to target or null
    // if not found
    private TreeNode<E> findPtr( TreeNode<E> root, Comparable target )
    {
        if (root == null || root.getValue().equals( target ))
        {
//            System.out.println(root);
//            System.out.println(root.getValue());
            return root;
        }
//        else if (root.getRight() == null)
//        {
//            return findPtr(root.getLeft(), target);
//        }
//        else if (root.getLeft() == null)
//        {
//            return findPtr(root.getRight(), target);
//        }
        else
        {
//            System.out.println("root : " + root.getValue() + " target: " + target);
            TreeNode<E> left = findPtr(root.getLeft(), target);
            TreeNode<E> right = findPtr(root.getRight(), target);
            
//            if (left != null)
//            {
//                System.out.println("left: " + left.getValue());
//            }
//            if (right != null)
//            {
//                System.out.println("right: " + right.getValue());
//            }
            
            if (left != null)
            {
                return left;
            }
            else
            {
                return right;
            }
        }

    }

    public int[] nodeCounts()
    {
        return nodeCounts( myRoot );
    }

    // Exercise 21
    // Write a method, nodeCounts, that returns an array of two elements:
    // the first is set to the number of nodes in the tree rooted at root;
    // the second is the difference between the node counts for the left
    // and right subtrees of root. For an empty tree, both values should
    // be set to 0.
    private int[] nodeCounts( TreeNode<E> root )
    {
        int[] result = new int[2];

        if (root == null)
        {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        result[0] = countNodesHelper(root);
        result[1] = countNodesHelper(root.getLeft()) - countNodesHelper(root.getRight());
//        result[0] = countNodesHelper(root);
//        int[] left = nodeCounts(root.getLeft());
//        int[] right = nodeCounts(root.getRight());
//        
//        int[1] = left[0] - right[0];
        return result;
    }

    public void accumulate()
    {
        accumulate( (TreeNode<Integer>)myRoot );
    }

    // Exercise 22
    // Replaces the value in each node with the sum of the values in all the
    // nodes of its subtree.
    // Precondition: the nodes of the tree rooted at root hold Integer values.
    private void accumulate( TreeNode<Integer> root )
    {
        
        if (root == null)
        {
            return;
        }
        if (root.getRight() != null && root.getLeft() != null)
        {
            accumulate(root.getRight());
            accumulate(root.getLeft());
            root.setValue( root.getValue() + root.getLeft().getValue() + root.getRight().getValue() );
        }
        else if (root.getRight() != null)
        {
            accumulate(root.getRight());
            root.setValue( root.getValue() + root.getRight().getValue() );
        }
        else if (root.getLeft() != null)
        {
            accumulate(root.getLeft());
            root.setValue( root.getValue() + root.getLeft().getValue() );
        }
//        if (root == null)
//        {
//            return;
//        }
// 
//        if (root.getRight() != null && root.getLeft() != null)
//        {
//            root.setValue( 0 );
//            if (root.getLeft().getRight() != null || root.getLeft().getLeft() != null)
//            {
//                root.setValue( root.getValue() + root.getLeft().getValue());
//            }
//            if (root.getRight().getRight() != null || root.getRight().getLeft() != null)
//            {
//                root.setValue( root.getValue() + root.getRight().getValue());
//            }
////            root.setValue( root.getRight().getValue() + root.getLeft().getValue() );
//            accumulate(root.getLeft());
//            accumulate(root.getRight());
//            root.setValue( root.getValue() + root.getLeft().getValue() + root.getRight().getValue() );
//        }
//        else if (root.getLeft() != null)
//        {
//            if (root.getLeft().getRight() != null || root.getLeft().getLeft() != null)
//            {
//                root.setValue( root.getLeft().getValue());
//            }
//            accumulate(root.getLeft());
//            root.setValue( root.getValue() + root.getLeft().getValue());
//        }
//        else if (root.getRight() != null)
//        {
//            if (root.getRight().getRight() != null || root.getRight().getLeft() != null)
//            {
//                root.setValue( root.getRight().getValue());
//            }
//            accumulate(root.getRight());
//            root.setValue( root.getValue() + root.getRight().getValue());
//        }
        
//        root.setValue( root.getLeft().getValue() + root.getRight().getValue() );
    }

    public TreeNode<E> trim()
    {
        return trim( myRoot );
    }

    // Exercise 23
    // Write a trim method that removes all the leaves from the tree rooted
    // at root and returns a reference to the root of the modified tree
    // (or null, if the original tree is empty or has only one node).
    private TreeNode<E> trim( TreeNode<E> root )
    {
        if ((root.getRight() == null && root.getLeft() == null) || root == null)
        {
            return null;
        }
        if (trim(root.getLeft()) == null)
        {
            root.setLeft( null );
        }
        if (trim(root.getRight()) == null)
        {
            root.setRight( null );
        }
        
        return root;
    }

    public double minMaxAverage()
    {
        return minMaxAverage( (TreeNode<Integer>)myRoot );
    }

    // Exercise 24
    // Write a method, minMaxAverage, that returns the average of the
    // smallest and the largest value in a binary search tree rooted at
    // root (assuming the nodes of the tree hold Integer values).
    private double minMaxAverage( TreeNode<Integer> root )
    {
        TreeNode<Integer> min = root;
        TreeNode<Integer> max = root;
        
        while (min.getLeft() != null)
        {
            min = min.getLeft();
        }
        
        while (max.getRight() != null)
        {
            max = max.getRight();
        }
        
        double answer = (max.getValue() + min.getValue()) / 2.0;
        
        return answer;
    }

    // *************** non-exercise methods: *********************

    // Returns true if this BST contains value; otherwise returns false.
    public boolean contains( E value )
    {
        return contains( myRoot, value );
    }

    // Adds value to this BST, unless this tree already holds value.
    // Returns true if value has been added; otherwise returns false.
    public boolean add( E value )
    {
        if ( contains( value ) )
            return false;
        myRoot = add( myRoot, value );
        return true;
    }

    // Returns a string representation of this BST.
    public String toString()
    {
        String str = toString( myRoot );
        if ( str.endsWith( ", " ) )
            str = str.substring( 0, str.length() - 2 );
        return "[" + str + "]";
    }

    // *************** Private helper methods: *********************

    // Returns true if the BST rooted at node contains value;
    // otherwise returns false (recursive version).
    private boolean contains( TreeNode<E> node, E value )
    {
        if ( node == null )
            return false;
        else
        {
            int diff = ( (Comparable<E>)value ).compareTo( node.getValue() );
            if ( diff == 0 )
                return true;
            else if ( diff < 0 )
                return contains( node.getLeft(), value );
            else
                // if (diff > 0)
                return contains( node.getRight(), value );
        }
    }

    // Adds value to the BST rooted at node. Returns the
    // root of the new tree.
    // Precondition: the tree rooted at node does not contain value.
    private TreeNode<E> add( TreeNode<E> node, E value )
    {
        if ( node == null )
            node = new TreeNode<E>( value );
        else
        {
            int diff = ( (Comparable<E>)value ).compareTo( (E)node.getValue() );
            if ( diff < 0 )
                node.setLeft( add( node.getLeft(), value ) );
            else // if (diff > 0)
                node.setRight( add( node.getRight(), value ) );
        }
        return node;
    }

    public void printSideways()
    {
        if ( myRoot == null )
            return;
        printSideways( myRoot, 0 );
    }

    // Precondition: original argument != null
    private void printSideways( TreeNode<E> t, int depth )
    {
        if ( t.getRight() != null )
            printSideways( t.getRight(), depth + 1 );

        process( (E)t.getValue(), depth );

        if ( t.getLeft() != null )
            printSideways( t.getLeft(), depth + 1 );
    }

    // Simply display the toString version of my_data
    private void process( E obj, int depth )
    {
        for ( int j = 1; j <= depth; j++ )
            System.out.print( "    " );
        System.out.println( obj.toString() );
    }

    // Returns a string representation of the tree rooted at node.
    private String toString( TreeNode<E> node )
    {
        if ( node == null )
            return "";
        else
            return toString( node.getLeft() ) + node.getValue() + ", "
                + toString( node.getRight() );
    }
}