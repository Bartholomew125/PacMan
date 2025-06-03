package com.example.controller.searching;

import com.example.controller.Algebra;
import com.example.model.Pos2D;

public class FleeAlgorithm extends AbstractSearchAlgorithm {

    public FleeAlgorithm() {
    }

    @Override
    public Node search() {
        double longestDistance = 0;
        Pos2D bestPos = this.getStartPos();
        for (Pos2D pos : this.getNeighbours(this.getStartPos())) {
            double dist = Algebra.distanceBetween(this.getGoalPos(), pos);
            if (dist > longestDistance) {
                longestDistance = dist;
                bestPos = pos;
            }
        }

        Node start = new Node(this.getStartPos());
        Node end = new Node(bestPos);
        System.out.println(bestPos);

        start.addChild(end);
        end.setParent(start);

        return end;
    }
}
