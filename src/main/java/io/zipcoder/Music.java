package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

public class Music {

    private final String[] playList;


    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
        int nodeCountForward = forward(startIndex, selection);
        int nodeCountBackward = backward(startIndex, selection);
        return Math.min(nodeCountForward, nodeCountBackward);
    }

    public Integer forward(Integer startIndex, String selection) {
        int nodeCountForward = 0;
        for (int i = startIndex; !playList[i].equals(selection); i++) {
            if (i == playList.length - 1) {
                i = -1;
            }
            nodeCountForward++;
        }
        return nodeCountForward;
    }

    public Integer backward(Integer startIndex, String selection) {
        int nodeCountBackward = 0;
        for (int i = startIndex; !playList[i].equals(selection); i--) {
            if (i == 0) {
                i = playList.length;
            }
            nodeCountBackward++;
        }
        return nodeCountBackward;
    }

}

/*
 public Integer forward(Integer startIndex, String selection) {
        ArrayList<String> linkedplaylist = new ArrayList<>();
        Collections.addAll(linkedplaylist, playList);
        ListIterator<String> list = linkedplaylist.listIterator(startIndex);
        int nodeCountForward = 0;
        while (list.hasNext() && !list.next().equals(selection)) {
            String next = list.next();
            System.out.println(next);
                nodeCountForward++;
                System.out.println(nodeCountForward);

        }return nodeCountForward;
    }




public Integer backward(Integer startIndex, String selection){
            LinkedList<String> linkedplaylist1 = new LinkedList<>();
            Collections.addAll(linkedplaylist1, playList);
            if (startIndex == 0) {
                startIndex = linkedplaylist1.size();
            }
            ListIterator<String> list1 = linkedplaylist1.listIterator(startIndex);
            int nodeCountBackward = 1;
            while (list1.hasPrevious() && !list1.previous().equals(selection)) {
                String prev = list1.previous();
                System.out.println(prev);
                if (prev.equals(selection)) {
                    nodeCountBackward++;
                    System.out.println(nodeCountBackward);
                }
            } return nodeCountBackward;
        }
 */