package com.nerostarx.articulocate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*public class Graph {
    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    // Constructor
    public Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    public void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);    //Add v to w's list
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    void APUtil(int u, boolean visited[], int disc[],
                int low[], int parent[], boolean ap[])
    {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext())
        {
            int v = i.next();  // v is current adjacent of u

            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (!visited[v])
            {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u]  = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more chilren.
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;

                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if (parent[u] != NIL && low[v] >= disc[u])
                    ap[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u]  = Math.min(low[u], disc[v]);
        }
    }

    // The function to do DFS traversal. It uses recursive function APUtil()
    public ArrayList<Integer> apFun() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V]; // To store articulation points

        ArrayList<Integer> intList = new ArrayList();

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++)
            if (ap[i])
                intList.add(i);

        return intList;
    }
}*/

//==================================================================================================
public class Graph{

    public static int V = 0;
    public static ArrayList<Integer> tags = new ArrayList<>();

    // implementation of traveling
// Salesman Problem
    public static int travllingSalesmanProblem(ArrayList<ArrayList<Integer>> graph,
                                        int s)
    {
        int tag = 0;
        // store all vertex apart
        // from source vertex
        ArrayList<Integer> vertex = new ArrayList<Integer>();

        for (int i = 0; i < V; i++)
            if (i != s)
                vertex.add(i);

        // store minimum weight
        // Hamiltonian Cycle.
        int min_path = Integer.MAX_VALUE;

        do
        {
            tag++;
            // store current Path weight(cost)
            int current_pathweight = 0;

            // compute current path weight
            int k = s;

            for (int i = 0;
                 i < vertex.size(); i++)
            {
                current_pathweight +=
                        graph.get(k).get(vertex.get(i));

                k = vertex.get(i);
            }
            current_pathweight += graph.get(k).get(s);

            // update minimum
            min_path = Math.min(min_path,
                    current_pathweight);
            if(tag<=1){
                tags.add(min_path);
            }
        } while (findNextPermutation(vertex));


        return min_path;
    }

    // Function to swap the data
// present in the left and right indices
    public static ArrayList<Integer> swap(
            ArrayList<Integer> data,
            int left, int right)
    {
        // Swap the data
        int temp = data.get(left);
        data.set(left, data.get(right));
        data.set(right, temp);

        // Return the updated array
        return data;
    }

    // Function to reverse the sub-array
// starting from left to the right
// both inclusive
    public static ArrayList<Integer> reverse(
            ArrayList<Integer> data,
            int left, int right)
    {
        // Reverse the sub-array
        while (left < right)
        {
            int temp = data.get(left);
            data.set(left++,
                    data.get(right));
            data.set(right--, temp);
        }

        // Return the updated array
        return data;
    }

    // Function to find the next permutation
// of the given integer array
    public static boolean findNextPermutation(
            ArrayList<Integer> data)
    {
        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.size() <= 1)
            return false;

        int last = data.size() - 2;

        // find the longest non-increasing
        // suffix and find the pivot
        while (last >= 0)
        {
            if (data.get(last) <
                    data.get(last + 1))
            {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;

        int nextGreater = data.size() - 1;

        // Find the rightmost successor
        // to the pivot
        for (int i = data.size() - 1;
             i > last; i--) {
            if (data.get(i) >
                    data.get(last))
            {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and
        // the pivot
        data = swap(data,
                nextGreater, last);

        // Reverse the suffix
        data = reverse(data, last + 1,
                data.size() - 1);

        // Return true as the
        // next_permutation is done
        return true;
    }
}

