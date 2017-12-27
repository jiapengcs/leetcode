package com.jiapengcs.leetcode.medium;

import java.util.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-27
 *
 * 133. Clone Graph
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * 1. First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * 2. Second node is labeled as 1. Connect node 1 to node 2.
 * 3. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *      1
 *     / \
 *    /   \
 *   0 --- 2
 *        / \
 *        \_/
 * 分析：DFS + Hash或者BFS + Hash
 */
public class No_133 {

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    // DFS
    //----------------------------------------------------------------------

    private static Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) { //map中包含node，说明node的neighbors已经连接好了，直接返回。若判断条件相反会造成死循环。
            return map.get(node.label);
        }
        map.put(node.label, new UndirectedGraphNode(node.label));
        for (UndirectedGraphNode neighbor : node.neighbors) {
            map.get(node.label).neighbors.add(cloneGraph(neighbor));
        }
        return map.get(node.label);
    }

    // BFS
    //----------------------------------------------------------------------

    public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(node.label, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.remove();
            for (UndirectedGraphNode nb : n.neighbors) {
                if (!map.containsKey(nb.label)) {
                    map.put(nb.label, new UndirectedGraphNode(nb.label));
                    queue.add(nb);
                }
                map.get(n.label).neighbors.add(map.get(nb.label));
            }
        }
        return map.get(node.label);
    }

    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(0);
        UndirectedGraphNode node3 = new UndirectedGraphNode(0);
//        List<UndirectedGraphNode> list1 = Arrays.asList(node2);
//        node1.neighbors = list1;
        cloneGraph2(node1);
    }
}
