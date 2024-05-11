package main

type MyLinkedList struct {
	Size      int
	dummyHead *MyListNode
}

type MyListNode struct {
	Val  int
	Next *MyListNode
}

func Constructor() MyLinkedList {
	return MyLinkedList{0, &MyListNode{}}
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 || index >= this.Size {
		return -1
	}
	cur := this.dummyHead.Next
	for i := 0; i < index; i++ {
		cur = cur.Next
	}
	return cur.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	this.AddAtIndex(0, val)
}

func (this *MyLinkedList) AddAtTail(val int) {
	this.AddAtIndex(this.Size, val)
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 || index > this.Size {
		return
	}
	cur := this.dummyHead
	for i := 0; i < index; i++ {
		cur = cur.Next
	}
	temp := &MyListNode{val, cur.Next}
	cur.Next = temp
	this.Size++
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 || index >= this.Size {
		return
	}
	cur := this.dummyHead
	for i := 0; i < index; i++ {
		cur = cur.Next
	}
	cur.Next = cur.Next.Next
	this.Size--
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
