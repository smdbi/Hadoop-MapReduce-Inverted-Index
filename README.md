# Hadoop-MapReduce-Inverted-Index
Problem Definition
An inverted index is a data structure that allows for quickly retrieving documents containing a given word or expression. It consists of a table indexed by words, and its values are the documents containing the word.

Proposed Solution
The goal is to create an inverted index from a set of documents. The inverted index associates each unique word found in the documents with a list of documents in which that word appears. The proposed solution uses Hadoop MapReduce to create the inverted index. The program consists of three stages:

Mapper: The mapper receives a document and its position as input. It extracts all the words from the document and associates them with the document's position.
Combiner (optional): The combiner merges the results from the mappers before sending them to the reducer.
Reducer: The reducer receives words and document positions as input. It creates a table indexed by words, and its values are lists of document positions containing the word.
2.1 Mapper
The mapper reads each line of the document and extracts the words. For each word, the mapper emits a key-value pair where the key is the word, and the value is the document identifier.

2.2 Combiner
The combiner acts as an intermediate reduction step on the map node. It can help reduce the amount of data transferred to the main reduce node.

2.3 Reducer
The reducer takes the word and the list of document identifiers as input. It creates an inverted index for each word.

Main File (Driver)
Configures and executes the MapReduce job.
Example Execution
Suppose we have the following set of documents:
Doc1: Le chat est sur le tapis.
Doc2: Le chien est dans la maison.
Doc3: Le chat et le chien sont amis.
Output should be as: 
![image](https://github.com/smdbi/Hadoop-MapReduce-Inverted-Index/assets/67858472/f01258a2-6b2b-4484-8a85-0929cd98e01b)
