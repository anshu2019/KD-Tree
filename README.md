# kd-tree
This is a implementation of famous 2d tree based on the algorithm of Robert Sedgewick .
https://www.youtube.com/watch?v=EsY8KSXKe5k

We will input delimated text file to generate a 2D tree , which contains geo location for thousands of crime data point in PA.
Our objective is to utilize KD tree to implement a efficient search algorithm to pinpoint location on google map.

For each crime record, the file contains (X, Y) coordinate pairs in the state plane coordinate system. These (X, Y) coordinates are useful for calculating the distance between points (using the Pythagorean theorem). Each record also contains latitude and longitude coordinates. These coordinates are useful for displaying locations in GIS tools such as Google Earth. The other fields are not so important for our purposes. However, all of the data contained in the file will be represented in your tree.

The data structure that we will implement is a type of space-partitioning tree called a 2d Tree. We will use this data structure to store the crime records – we will store one crime record per node in the tree.

