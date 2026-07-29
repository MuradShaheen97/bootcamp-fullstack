import { Queue } from "Queue.js";

class BST {
  constructor() {
    this.root = null;
  }
  bfs() {
    // If the tree is empty, stop.
    if (this.root === null) return;
    const myQueue = new Queue();
    // Start with the root node.
    myQueue.enqueue(this.root);
    // Visit nodes level by level.
    while (!myQueue.isEmpty()) {
      const temp = myQueue.dequeue();
      console.log(temp.value);
      // Add the left child to the queue.
      if (temp.left) {
        myQueue.enqueue(temp.left);
      }
      // Add the right child to the queue.
      if (temp.right) {
        myQueue.enqueue(temp.right);
      }
    }
  }
}

export { BST };
