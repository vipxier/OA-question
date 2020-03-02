package OA;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class TOPKWords {
	public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if(words == null || words.length == 0)
        {
            return new String[0];
        }
        
        Map<String, Integer> hashMap = new HashMap<>();
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue() == o2.getValue())
				{
					return o1.getKey().compareTo(o2.getKey());
				}
				
				return o2.getValue() - o1.getValue();
			}
        	
        });
            
        for(String word : words)
        {
            if(!hashMap.containsKey(word))
            {
                hashMap.put(word, 1);
            }
            else
            {
                hashMap.put(word, hashMap.get(word) + 1);
            }
        }
        
        for(Map.Entry<String, Integer> entry : hashMap.entrySet())
        {
            queue.offer(entry);
        }
        
        String[] result = new String[k];
        
        for(int i = 0; i < k ; i ++)
        {
            if(!queue.isEmpty())
            {
                result[i] = queue.poll().getKey();
            }
        }
        
        return result;
    }
}
