/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page.replacement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import sun.misc.LRUCache;
/**
 * 
 *
 * @author doaatarek
 */
//Sara Tarek & Ahmed Tamer 



 
public class Page_replacement 
{
    public static void FIRSTINFIRSTOUT(int FSize,int PSize,int PagesARRAY[])
    {
        int k=0,FAULTCOUNT=0,noOfswaps=0;
         int Frm[]=new int[FSize];
       for(int count1=0;count1<FSize;count1++)
       {
           Frm[count1]=-1;
       }
       boolean Matching;
      for(int count2=0;count2<PSize;count2++)
            {
                        Matching=false;


                                for(int count1=0;count1<FSize;count1++)
                                if(Frm[count1]==PagesARRAY[count2])
                                {
                                        Matching=true;
                                        noOfswaps=noOfswaps+1;
                                        System.out.println("HIT(No page replacement)");
                                }
                                if(Matching==false)
                                {
                                        Frm[k]=PagesARRAY[count2];
                                        k++;
                                        if(k>=FSize)
                                        k=0;
                                        FAULTCOUNT=FAULTCOUNT+1;
                                        System.out.println("Page fault is found");
                                }
                       for(int count3=0;count3<FSize;count3++)
              {
                  System.out.println(Frm[count3]);
                  if(count3==FSize-1)
                      System.out.println("-----");
                  
              }
                }
      System.out.println("Number of Swaps:- "+noOfswaps+"  Number of PageFaults is :- "+FAULTCOUNT);
       }
   
   
 

    public static int search(int PagesARRAY[], int key) 
    { int index =0;
    
        for (int i = index; i < PagesARRAY.length; i++)  
        { 
            if (PagesARRAY[i] == key) 
                return i; 
        } 
        return -1; 
    } 
  
        
    public static void optimalalgorithm(int FSize,int PSize, int PagesARRAY[])
    {     
        int currentIndex=0,FAULTCOUNT=0,noOfHits=0,locationidf=0;
        boolean isFull=false;
        int Frm[]=new int[FSize];
        for(int count1=0;count1<FSize;count1++)
       {
           Frm[count1]=-1;
       }
        for(int count2 = 0; count2<PSize; count2++)
        {
         int search = -1;
         for(int count1= 0; count1 < FSize; count1++)
         {
          if(Frm[count1] == PagesARRAY[count2])
          {
           search = count1;
            System.out.println("HIT(No page replacement)");
           noOfHits=noOfHits+1;
           break;
          } 
         }
        if(search == -1)
         {
          if(isFull)
          {
           int index[] = new int[FSize];
           boolean index_flag[] = new boolean[FSize];
           for(int count1 = count2 + 1; count1 < PSize; count1++)
           {
            for(int count3 = 0; count3 < FSize; count3++)
            {
             if((PagesARRAY[count1] == Frm[count3]) && (index_flag[count3] == false))
             {
              index[count3] = count1;
              index_flag[count3] = true;
              break;
             }
            }
           }
           int farthest = index[0];
           locationidf = 0;
           if(farthest == 0)
            farthest = 200;
           for(int count1 = 0; count1 < FSize; count1++)
           {
            if(index[count1] == 0)
             index[count1] = 200;
            if(index[count1] > farthest)
            {
             farthest = index[count1];
             locationidf = count1;
            }
           }
          }
          Frm[locationidf] = PagesARRAY[count2];
          System.out.println("Page fault is found");
          FAULTCOUNT=FAULTCOUNT+1;
          if(!isFull)
          {
          locationidf++;
              if(locationidf == FSize)
              {
               locationidf = 0;
               isFull = true;
              }
          }
         }
        
        for(int count3=0;count3<FSize;count3++)
              {
                  System.out.println(Frm[count3]);
                  if(count3==FSize-1)
                      System.out.println("-----");
                  
              }
                }
      System.out.println("Number of Swaps:- "+noOfHits+"  Number of PageFaults is :- "+FAULTCOUNT);
            }
    

    public static void LeastRecentlyUsedALGO(int FSize,int PSize, int PagesARRAY[])
    {
        int currentIndex=0,FAULTCOUNT=0,noOfHits=0,locationidf=0;//pointer
        boolean isFull=false;
        int Frm[]=new int[FSize];
        for(int count1=0;count1<FSize;count1++)
        {
           Frm[count1]=-1;
        }    
        for(int count2 = 0; count2<PSize; count2++)
        {
            int search = -1;
            for(int count1= 0; count1 < FSize; count1++)
            {
                if(Frm[count1] == PagesARRAY[count2])
                {
                    search = count1;
                    System.out.println("HIT(No page replacement)");
                    noOfHits=noOfHits+1;
                    break;
                }
            }
            if(search == -1)
            {
                if(isFull)
                {
                    int index[] = new int[FSize];
                    boolean index_flag[] = new boolean[FSize];
                    for(int count1 = count2 + 1; count1 < PSize; count1++)
                    {
                        for(int count3 = 0; count3 < FSize; count3++)
                        {
                            if((PagesARRAY[count1] == Frm[count3]) && (index_flag[count3] == false))
                            {
                                index[count3] = count1;
                                index_flag[count3] = true;
                                break;
                            }
                        }
                    }
                    int farthest = index[FSize];
                    locationidf = 0;
                    if(farthest == 0)
                        farthest = 200;
                    for(int count1 = FSize-1; count1 > 0; count1--)
                    {
                        if(index[count1] == 0)
                            index[count1] = 200;
                        if(index[count1] > farthest)
                        {
                            farthest = index[count1];
                            locationidf = count1;
                        }
                    }
                }
                Frm[locationidf] = PagesARRAY[count2];
                System.out.println("Page fault is found");
                FAULTCOUNT=FAULTCOUNT+1;
                if(!isFull)
                {
                    locationidf++;
                    if(locationidf == FSize)
                    {
                        locationidf = 0;
                        isFull = true;
                    }
                }
            }
            for(int count3=0;count3<FSize;count3++)
            {
                System.out.println(Frm[count3]);
                if(count3==FSize-1)
                    System.out.println("-----");
            }
        }
        System.out.println("Number of Swaps:- "+noOfHits+"  Number of PageFaults is :- "+FAULTCOUNT);   
    }

    public static void lru(int capacity,int PSize, int arr[])
    {
        int noOfHits=0;
        //int capacity = 4;
       
        // To represent set of current pages.We use 
        // an Arraylist 
        ArrayList<Integer> F =new ArrayList<>(capacity); 
        for(int i = 0; i < F.size(); i++ )
        {
            if(F.contains((Integer)arr[i]))
            {
                
            }
            else
            {
                F.set(i, arr[i]);
            }
            
            
        }
        int FAULTCOUNT=0; 
        for(int i = 0;i<arr.length;i++) 
        { 
            
            // Insert it into set if not present 
            // already which represents page fault 
            if(!F.contains(arr[i])) 
            {
                if(F.get(0)==-1)
                {
                    F.set(0,arr[i]);
                    FAULTCOUNT++;
                }
                else
                {
                    for(int j=0; j<F.size(); j++)
                    {
                        if(F.get(i)==-1)
                        {
                             F.set(0,arr[i]);
                             FAULTCOUNT++;
                             break;
                        }
                    }
                }
            }
            else
            {
                
            } 

        } 
        System.out.println(FAULTCOUNT); 
       }

        /**
         *
         * @param args
         * @throws IOException
         */
        public static void main(String[] args) throws IOException
        {
            int choice;
            int sizeofframes,sizeofpages;
            BufferedReader readthevalues =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Number of frames to be inserted is: ");
            sizeofframes=Integer.parseInt(readthevalues.readLine());     
            System.out.println("Number of pages to be inserted is :");
            sizeofpages=Integer.parseInt(readthevalues.readLine());
            int numofP[]=new int[sizeofpages];
            System.out.println("please enter your values :");
            for(int arraycounter=0;arraycounter<sizeofpages;arraycounter++)
            {
                numofP[arraycounter]=Integer.parseInt(readthevalues.readLine());
            }
            
            System.out.println("-----");
            System.out.println(" to choose the algorithms ");
            System.out.println("FIFO press 1");
            System.out.println("Optimal Press 2");System.out.println("Optimal Press 2");
            System.out.println("LRU press 3");
       
            choice = Integer.parseInt(readthevalues.readLine());
            while ( choice > 3 || choice < 1)
            {
                System.out.println("wrong input please enter 1 or 2 or 3");
                choice=Integer.parseInt(readthevalues.readLine());
            }
            switch(choice)
            {
                case 1:
                    FIRSTINFIRSTOUT(sizeofframes,sizeofpages ,numofP );
                    break;
                case 2:
                    optimalalgorithm(sizeofframes,sizeofpages,numofP); 
                    break;
               // case 3:
                    
                   //4 break;
            }
       
            
           
           
            
             
       }
}