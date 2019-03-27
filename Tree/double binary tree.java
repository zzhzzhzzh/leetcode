void doubleTree(Node node)  
    { 
        Node oldleft; 
   
        if (node == null) 
            return; 
   
        /* do the subtrees */
        doubleTree(node.left); 
        doubleTree(node.right); 
   
        /* duplicate this node to its left */
        oldleft = node.left; 
        node.left = new Node(node.data); 
        node.left.left = oldleft; 
    }
