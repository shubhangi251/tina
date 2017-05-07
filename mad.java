packagelazyTrees;
import cs_1c.Traverser;

import java.util.*;


public class LazySearchTree<E extends Comparable< ? super E >>implements Cloneable
{
protected intmSize; //Size of undeleted(lazy undelete) nodes
protected LazySTNodemRoot;
intmSizeHard; //real size of tree with lazy deleted nodes
    //constructor
public LazySearchTree() { clear(); }
public booleanempty() { return (mSize== 0); }
public intsize() { return mSize; }
public void clear() { mSize= 0; mRoot= null; }
public intshowHeight() { return findHeight(mRoot, -1); }

public String  sizeHard()
    {
return("hard size is :"+ mSizeHard);
    }

public E findMin()     //reimplement issue when the last one of the middle one is lolzzzz
{
if (mRoot== null)
throw new NoSuchElementException();
return findMin(mRoot).data;
    }

public E findMax()
    {
if (mRoot== null)
throw new NoSuchElementException();
return findMax(mRoot).data;
    }

public E find( E x )
    {
LazySTNoderesultNode;
resultNode = find(mRoot, x);
if (resultNode == null)
throw new NoSuchElementException();
return resultNode.data;
    }
public booleancontains(E x)  { return find(mRoot, x) != null; }

public booleaninsert( E x )
    {
intoldSize = mSize;
mRoot= insert(mRoot, x);
return (mSize!= oldSize);
    }

public booleanremove( E x )
    {
intoldSize = mSize; //
mRoot= remove(mRoot, x);
return (mSize!= oldSize);
    }

public <F extends Traverser<? super E >>void traverseHard(F func)
    {
traverseHard(func, mRoot);
    }

public <F extends Traverser<? super E >>void traverseSoft(F func)
    {
traverseSoft(func, mRoot);
    }

public Object clone() throws CloneNotSupportedException
    {
LazySearchTree<E>newObject = (LazySearchTree<E>)super.clone();
newObject.clear();  // can't point to other's data

newObject.mRoot= cloneSubtree(mRoot);
newObject.mSize= mSize;

return newObject;
    }

// private helper methods ----------------------------------------
protected LazySTNodefindMin(LazySTNode root )
    {
if (root == null)
return null;
if (root.lftChild== null)
        {
if(root.deleted==false)
return root;
else
                return null;
        }
LazySTNode temp= findMin(root.lftChild);
if(temp==null)
return root;
else
            return temp;
    }

protected LazySTNodefindMax(LazySTNode root ) //reimplement
{
if (root == null)
return null;
if (root.rtChild== null)
        {
if(root.deleted==false)
return root;
else
                return null;
        }
LazySTNode temp= findMax(root.rtChild);
if(temp==null)
return root;
else
            return temp;
    }

protected LazySTNode insert(LazySTNode root, E x )
    {
intcompareResult;  // avoid multiple calls to compareTo()

if (root == null)
        {
mSize++;
mSizeHard++;
return new LazySTNode(x, null, null);
        }

compareResult = x.compareTo(root.data);
if ( compareResult<0 )
root.lftChild= insert(root.lftChild, x);
else if ( compareResult>0 )
root.rtChild= insert(root.rtChild, x);
//if equal means same exist, so just turn it true
else if(root.deleted== true)
        {
root.deleted= false;
mSize++;
        }
//Should there be an case of equal and duplicate?
return root;
    }

protected LazySTNode remove(LazySTNode root, E x  )
    {
intcompareResult;  // avoid multiple calls to compareTo()

if (root == null)
return null;

compareResult = x.compareTo(root.data);
if ( compareResult<0 )
root.lftChild= remove(root.lftChild, x);
else if ( compareResult>0 )
root.rtChild= remove(root.rtChild, x);

// found the node for lazy deletion
else
{
root.deleted= true;
mSize--;
        }
return root;
// found the node
        /*else if (root.lftChild != null &&root.rtChild != null)
        {
root.data = findMin(root.rtChild).data;
root.rtChild = remove(root.rtChild, root.data);
        }
        else
        {
            root = (root.lftChild != null)? root.lftChild : root.rtChild;
mSize--;
        }
        */

}

protected <F extends Traverser<? super E>>void traverseHard(F func, LazySTNodetreeNode)
    {
if (treeNode == null)
return;

traverseHard(func, treeNode.lftChild);
func.visit(treeNode.data);
traverseHard(func, treeNode.rtChild);
    }

protected <F extends Traverser<? super E>>void traverseSoft(F func, LazySTNodetreeNode)
    {
if (treeNode == null)
return;
traverseSoft(func, treeNode.lftChild);
if(treeNode.deleted==false)
func.visit(treeNode.data);
traverseSoft(func, treeNode.rtChild);
    }

protected LazySTNode find(LazySTNode root, E x )
    {
intcompareResult;  // avoid multiple calls to compareTo()

if (root == null)
return null;

compareResult = x.compareTo(root.data);
if (compareResult<0)
return find(root.lftChild, x);
if (compareResult>0)
return find(root.rtChild, x);
if(root.deleted==false)
return root;   // found
else
            return null;   //not found as deleted

}

protected LazySTNodecloneSubtree(LazySTNode root)
    {
LazySTNodenewNode;
if (root == null)
return null;

// does not set myRoot which must be done by caller
newNode = new LazySTNode
                (
root.data,
cloneSubtree(root.lftChild),
cloneSubtree(root.rtChild)
                );
return newNode;
    }

protected intfindHeight(LazySTNodetreeNode, intheight )
    {
intleftHeight, rightHeight;
if (treeNode == null)
return height;
        height++;
leftHeight = findHeight(treeNode.lftChild, height);
rightHeight = findHeight(treeNode.rtChild, height);
return (leftHeight>rightHeight)? leftHeight : rightHeight;
    }
public class LazySTNode
    {
public booleandeleted=false;
// use public access so the tree or other classes can access members
public LazySTNodelftChild, rtChild;
public E data;
public LazySTNodemyRoot;  // needed to test for certain error


public LazySTNode(E d, LazySTNodelft, LazySTNodert )
        {
lftChild= lft;
rtChild= rt;
data = d;
        }

public LazySTNode()
        {
this(null, null, null);
        }

// function stubs -- for use only with AVL Trees when we extend
public intgetHeight() { return 0; }
booleansetHeight(intheight) { return true; }
    }
















