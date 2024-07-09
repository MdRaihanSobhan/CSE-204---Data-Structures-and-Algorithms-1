Package MainProject

List:
It's an interface for implementing ADT
There are 13 methods in this interface.
clear() : deletes all elements from the list
insert(item) : inserts an item to the list, in the current position.
append(item) : appends an item as the last element of the list
remove() : removes the element of current position from the list
moveToStart(): Set the current position to the start of the list
moveToEnd(): Set the current position to the end of the list
prev() : Move the current position one step left. No change if already at the beginning.
next() : Move the current position one step right. No change if already at the end.
length(): Return the number of elements in the list.
currPos(): Return the position (in the list) of the current element.
moveToPos(int pos) : Set current position.
getValue(): Return the current element.
Search(item): Search returns the position of the element item or -1 if not found

Arr:
Arr implements the interface List (Array based implementation)

LL:
LL does the Linked List implementation

LinkNode:
LinkNode is a supporting class for LL, it represents the elements and address of the nodes of the linked list and their getters and setters.

Main :
A simple main function has been written to implement the ADT
it can be implemented by both array and linked list. By default array based implementation has been commented out

Package TNL
TNL:
TNL imports the Arr and LL files from MainProject package and implements Transit Network Line (Bus, Rickshaw and Train)
A simple main function is written in it for implementing List ADT.
