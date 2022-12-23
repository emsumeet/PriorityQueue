public class HeapPQueue implements PQueue  
{
    private int[] list;
    private static int size = -1;

    //constructor
    public HeapPQueue(int[] items) 
    {
        this.list=items;
        for(int i=0; i<items.length; i++)
        {  
           insert(items[i]);
        }
    }

  

    public int size() 
    {
        return size+1;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void insert(int key) 
    {
        size = size + 1;
        this.list[size] = key;
        heapup(size);
    }

    public int removeMin() 
    { 
        int result = this.list[0];
        this.list[0] = this.list[size];
        size = size - 1;
        heapdown(0);
        return result;
    }

    public int min()
    {
        return this.list[0];
    }


    private void bottom_up(int[] items)
    {
        int index = 0;
        for(int i = (index-1/2); i>= 1; i--)
        {
            heapdown(i);
        }
    }

    private void heapdown(int i)
    {
        int min = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l <= size && this.list[l] < this.list[min])
        {
            min = l;
        }
       if (r <= size && this.list[r] < this.list[min])
       {
            min = r;
       }

      if (i != min)
      {
          int x= i;
          int y= min;
          int temp= list[x];
          this.list[x] = this.list[y];
          this.list[y] = temp;
          heapdown(min);
      }
    }

    private void heapup(int i)
    {
        while (i > 0 && list[(i-1)/2] > list[i])
        {
            //Swap 
            int a = i-1/2;
            int b = i;
            int temp= list[a];
            this.list[a] = this.list[b];
            this.list[b] = temp;

            i = i-1/2;
        }
    }

    public static void main(String args[])
    {
         int[] list= {2,5,9,7,6,8,1};
         HeapPQueue h = new HeapPQueue(list);
         h.removeMin(); 
         int j = 0;
         System.out.print("Priority Queue : ");
         while (j <= size)
         {
              System.out.print(list[j] + " ");
              j++;
         }
        System.out.println("Key of Highest priority: "+ h.min());
    }
}