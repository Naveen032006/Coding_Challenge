class MyStack {
    Queue<Integer> q;
    public MyStack() {
         q=new LinkedList<>();
    }
    
    public void push(int x) {
        int n=q.size();
        q.add(x);
        for(int i=0;i<n;i++){
            q.add(q.peek());
            q.poll();
        }
    }
    
    public int pop() {
        if(q.isEmpty()) return -1;
        int temp=q.poll();
        return temp;
    }
    
    public int top() {
        if(q.isEmpty()) return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */