package linkedList;

/**
 * <a href="https://leetcode.com/problems/design-phone-directory/">原文链接（按住ctrl然后点链接）</a>
 * Design a Phone Directory which supports the following operations: （1）get: Provide a number which is not assigned to
 * anyone; (2) check: Check if a number is available or not; (3) release: Recycle or release a number;
 */

/**
 * 这道题是让我们给XX移动公司设计一个号码库，并且拥有如下功能：（1）get: 提供一个还没有任何人使用的号码；（2）check: 检查一个号码是否被
 * 使用了； （3）release: 回收一个号码。
 */

/**
 * 遇到这种design问题，我们应当挑选最合适的data structure来帮助我们解决问题。那么问题来了：我怎么知道选啥data structure呢？
 * 答案是：从问题入手，分析它想让我们实现的功能。根据所需的feature，来制定我们的data structure。
 * 好吧，纸上谈来终觉浅，我们来看看这个号码库。首先我们可以从数组下手，看看效果如何。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class DesignPhoneDirectory {
	boolean[] flag;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
    	flag = new boolean[maxNumbers];
    	Arrays.fill(flag, true);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	for (int i = 0; i < flag.length; i++) {
    		if (flag[i]) {
    			flag[i] = false;
    			return i;
    		}
    	}
    	return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
    	return flag[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
    	flag[number] = true;
    }
}

/**
 * 用数组是可以工作的，但有时候上面这种方法会跑超时。归根结底是因为每次我们去call get()方法的时候，都需要去遍历一遍数组，来找出第一个合适的。这样的design其实是
 * 非常低效率的。由于题目并没有要求必须是返回第一个available的号码，那么我们可以想： 如果可以维护一个全是available号码的数据结构，每次call get()的时候，只用返
 * 回第一个号码就可以了，这样就能用O（1）的时间复杂度来实现了。那么问题来了，如果我release了一个number，它就需要添加到我们的数据结构里，但具体加到哪儿呢？其实只要
 * 能用O(1)的时间加到头或者尾，都ok！（因为插到中间部分还想用O（1）的时间？呵呵。。）
 * 现在大家应该能猜到该用啥数据结构了吧？对了，就是链表。那关于已经被使用过的号码该咋存储呢？我们可以用hashset来存，因为这样的话只需要O（1）的时间就能找到这个号码
 * 了 。话不多说，上代码！
 */
class DeisignPhoneDirectory2 {
	LinkedList<Integer> list = new LinkedList<Integer>();
	HashSet<Integer> set = new HashSet<Integer>();
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public DeisignPhoneDirectory2 (int maxNumbers) {
	    for (int i = 0; i < maxNumbers; i++) {
	    	list.offer(i);
	    }
	}
	
	/** Provide a number which is not assigned to anyone.
	    @return - Return an available number. Return -1 if none is available. */
	public int get() {
	    if (list.isEmpty()) {
	    	return -1;
	    }
	    int number = list.poll();
	    set.add(number);
	    return number;
	}
	
	/** Check if a number is available or not. */
	public boolean check(int number) {
	    return !set.contains(number);
	}
	
	/** Recycle or release a number. */
	public void release(int number) {
	    if (set.contains(number)) {
	    	set.remove(number);
	    	list.offer(number);
	    }
	}
}
