# Triangulation

This is one of the assigments I completed while taking the ***Data structures and algorithms*** course at ***IIT Delhi***. 

**The submission required that the implementation of all data structures (except arrays) must be from scratch and no import statements must be used.**

## Problem Statement

3D shapes can be approximated by triangles as shown in the figures below:

![Triangulation](https://github.com/pranjalrai-iitd/Triangulation/blob/master/Capture.PNG)

Triangulation can be implemented using a Graph Data structure.

A point in 3D space is defined using 3 coordinates xi,yi,zi. Given 3 unique points, they can be joined to form a triangle. To create a shape from the triangles, two triangles are joined if they have a common edge.

Implementing a graph data structure can help store complex 3D shapes as various connected trianlges. This graph can be used to identify various features of the 3D shape like Centroid, Diameter along with mesh type (proper, improper and semi proper).

Implement such a graph data structure which can execute the following queries efficiently:

- ADD_TRIANGLE X1 Y1 Z1  X2 Y2 Z2 X3 Y3 Z3

This query creates a creates- a triangle from 3 points P1(X1,Y1,Z1), P2(X2,Y2,Z2), P3(X3,Y3,Z3). It includes 9 numbers, which together represent one triangle.
It returns True if the triangle is valid. A triangle is valid if the 3 points are non-collinear else it is not valid.

- TYPE_MESH

This query returns the type of mesh created by the triangles. This query will be given only when triangles are valid. Return type is integer. Return 1 for proper_mesh, 2 for semi proper mesh and 3 for improper mesh.


- COUNT_CONNECTED_COMPONENTS

This query counts the number of connected components and returns it.This query will be given only when triangles are valid. 2 triangles are connected if there is a path between them.


- BOUNDARY_EDGES

This query returns the edges which are part of the boundary. (An edge is made up of 2 points. The 2 points could be in any order.) The returned edges should be sorted based upon non-decreasing edge length. The edge length is the Euclidean distance between its endpoints. You must implement your own sorting.
In case there are no boundary edges return null.
This query will be given only when triangles are valid.


- NEIGHBORS_OF_TRIANGLE X1 Y1 Z1 X2 Y2 Z2 X3 Y3 Z3

Return all the triangles which are neighbors to the given triangle. The Triangles should be returned in the order of their insertion.
Return null if query triangle does not exist.
Each returned triangle is an object of Triangle interface (This applies to all triangle queries.)
This query will be given only when triangles are valid.
Return null if query triangle does not exist.

- EDGE_NEIGHBOR_TRIANGLE X1 Y1 Z1 X2 Y2 Z2 X3 Y3 Z3

Return all the edge neighbors of the triangle. Each returned  edge is an object of EdgeInterface( This follows everywhere). The order between edges does not matter.
Return null if query triangle does not exist.


- VERTEX_NEIGHBOR_TRIANGLE X1 Y1 Z1 X2 Y2 Z2 X3 Y3 Z3

Return all the vertex neighbors of this triangle. Each  returned vertex is an object of PointInterface. ( This follows for all point queries.)
The order between vertices does not matter.
Return null if query triangle does not exist.



- EXTENDED_NEIGHBOR_TRIANGLE X1 Y1 Z1 X2 Y2 Z2 X3 Y3 Z3

Returns all the extended neighbors of this triangle.
The order within the neighbors is First come first serve. The triangle which was created first is returned first.
In case there are no extended neighbors of  query triangle, return null.
Return null if query triangle does not exist.
This query will be given only when triangles are valid.



- IS_CONNECTED Xa1 Ya1 Za1 Xa2 Ya2 Za2 Xa3 Ya3 Za3 Xb1 Yb1 Zb1 Xb2 Yb2 Zb2 Xb3 Yb3 Zb3

Given two triangles Ta and Tb created using points  Xa1 Ya1 Za1 Xa2 Ya2 Za2 Xa3 Ya3 Za3 and Xb1 Yb1 Zb1 Xb2 Yb2 Zb2 Xb3 Yb3 Zb3  respectively, check if they are connected by a path consisting of triangles in between. A hop from triangle R1 to R2 is allowed if R2 is a neighbor of R1(They must share an edge).
Return True if they are connected else False.
This query will be given only when triangles are valid.
Return False if query triangle does not exist.


- INCIDENT_TRIANGLES X Y Z

Given a point (X,Y,Z), return all the triangles which have one vertex as (X,Y,Z). The triangles are to be returned in the order of their insertion.
If the query point does not exist return null.

- NEIGHBORS_OF_POINT X Y Z

Given a point (X,Y,Z), return all the points which are neighbors of it. The points can be returned in any order.
If the query point does not exist, return null.




- EDGE_NEIGHBORS_OF_POINT X1 Y1 Z1

Given a point (X,Y,Z), return all its edge neighbors. The order of edges does not matter.
If the query point does not exist return null.



- FACE_NEIGHBORS_OF_POINT X1 Y1 Z1

Given a point (X,Y,Z), return all its Face neighbors.
The triangles are to be returned in the order of their insertion.
If the query point does not exist return null.



- TRIANGLE_NEIGHBOR_OF_EDGE X1 Y1 Z1 X2 Y2 Z2

Given two points P1(X1,Y1,Z1) and P2(X2,Y2,Z2), return the triangles which are incident on the edge connecting P1 and P2.
The triangles should be returned in the order as they were inserted.
If the query edge does not exist return null.



- MAXIMUM_DIAMETER

The diameter is defined as the maximum topological distance between 2 triangles in the shape. Topological distance is defined as the minimum  number of hops required to go from triangle T1 to triangle T2 by hopping through triangles in between. A hop from a triangle R1 to triangle R2 is allowed only if R1 and R2 share a common edge. Ex: Fig 7 the diameter is 4.
For this query, return the diameter of the shape produced. If shape is having more than 1 component return  the diameter of the component which has maximum number of triangles (any one, if multiple maxima exist) If the largest component has just 1 triangle return 0.



- CENTROID

Return an array of the centroids of different connected components. The centroid of a connected component is a point (x, y, z) such that x is the average of x coordinates of all vertices of that component, y is the average of y. and z of z components. The centroids should be sorted by their X coordinates first, and then by Y and then by Z. Two coincident centroids may appear in any order.

 


- CENTROID OF COMPONENT X Y Z

For the connected component containing point P(X,Y,Z), return its centroid.



- CLOSEST COMPONENTS


Find the distance between the closest connected components.
The distance between two components is defined as the minimum Euclidean distance between any two  vertices, respectively, of the two components.
For the shapes that you have found,to be closest you need to return the 2 closest vertices(one in first shape, other of second shape) as an array of 2 points. The order does not matter.
If there are multiple such pairs of vertices possible, return any 1.


## Contents

The repository contains the ***Java*** implemetation of the graph data structure from scratch, which can answer all the above queries. **No imports were used in this assignment other than importing arrays**

## References
- Prof. Subodk Kumar, IIT Delhi (http://web.iitd.ac.in/~csz188551/COL106_2019/assignment6/index.html)
- Wikipedia (for images)
