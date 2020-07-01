package com.example.designpattern.leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: Card
 * @Description: 按递增顺序显示卡牌
 * @Author: Grechur
 * @CreateDate: 2019/11/11 17:12
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/11 17:12
 */
public class Card {

    public static void main(String[] args) {
        int[] a = {17,13,11,2,3,5,7};
        int[] b = deckRevealedIncreasingA(a);
        for (int i : b) {
            System.out.print(i+" ");
        }
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }


    public static int[] deckRevealedIncreasingA(int[] deck) {
        if (deck == null || deck.length < 1) {
            return deck;
        }

        Arrays.sort(deck);// 得到升序排列的数组

        Queue<Integer> queue = new LinkedList<>();
        for (int i = deck.length - 1;i >= 0;i--) {// 倒着遍历，便是按降序访问
            queue.add(deck[i]);// 选最大值插入队列
            if (i == 0) {// 数组中所有元素均在队列中，退出过程
                break;
            }

            queue.add(queue.poll());// 将队头元素插入到队尾中
        }

        for (int i = deck.length - 1;i >= 0;i--) {
            deck[i] = queue.poll();// 倒回去，得到answer
        }

        return deck;
    }


}
