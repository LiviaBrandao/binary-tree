# Huffman Coding
This is a huffman code, the data structure II final project, using Java and Tree and Binary Table. This has the goal to compact and de-compact files very efficiently

## Some of the logic behind
``` Java
This project has 2 parts:

Compact 
{ 
    1 - Generate Occurency table.
    2 - Generate the Tree List (nodes).
    3 - Generate a tree with this list.
    4 - Create Binary table with the list.
    5 - It stores an Object that has
    {
        - BitSet, the text;
        - Binary Table;
    } 
}

Unzip
{
    1 - Reads the compacted file stored in the object;
    2 - Records it into a file the bitset translation;
}

```
