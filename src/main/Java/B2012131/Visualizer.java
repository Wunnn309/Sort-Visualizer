package B2012131;

import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;

import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
public class Visualizer
{
	private static final int PADDING = 20,PADDING_BOT=40;
	private static final int MAX_BAR_HEIGHT = 580, MIN_BAR_HEIGHT = 30;
	public int[] array;
	private int capacity, speed;
	private Bar[] bars;
	// statistic
	private long startTime, time;
	public int comp, selectswap=0,inserswap=0,bubbleswap=0,quickswap=0,heapswap=0,mergeswap=0;

	private Color originalColor, swappingColor, comparingColor;

	private BufferStrategy bs;
	private Graphics g;

	private SortedListener listener;

	public Visualizer(int[] array, int fps,SortedListener listener)
	{
		this.array = array;
		this.speed = (int) (1000.0/fps);
		this.listener = listener;
		startTime = time = comp = selectswap=inserswap=bubbleswap=quickswap=heapswap=mergeswap = 0;

		originalColor = ColorManager.BAR_WHITE;
		comparingColor = Color.YELLOW;
		swappingColor = ColorManager.BAR_RED;
                if (bs != null){
                    bs.dispose();
                }
		bs = listener.getBufferStrategy();
	}

        public void createLabelArray(int canvasWidth, int canvasHeight){
            JLabel[] LBA=new JLabel[array.length];
            double x = PADDING;
		int y = canvasHeight- PADDING_BOT;
		double width = (double) (canvasWidth - PADDING*2) / array.length;
            for(int i = 0; i < array.length; i++){
                LBA[i]=new JLabel(String.valueOf(array[i]));
                LBA[i].setLocation((int)x, canvasHeight-20);
                LBA[i].setVisible(true);
            }
        }
	public void createArray(int canvasWidth, int canvasHeight)
	{
		bars = new Bar[array.length];
                
		// initial position
		double x = PADDING;
		int y = canvasHeight- PADDING_BOT;

		// width of all bars
		double width = (double) (canvasWidth - PADDING*2) / array.length;
                
		// get graphics
                g = bs.getDrawGraphics();
		g.setColor(ColorManager.MyCanvasColor);
		g.fillRect(0,0 , canvasWidth, canvasHeight);
		Bar bar;
		for (int i = 0; i < array.length; i++)
                {
                        double height =(double) (canvasHeight*array[i])/99;
			bar = new Bar((int)x, y, (int)width, array[i], originalColor);
			bar.draw(g);
			bars[i] = bar;
			x += width;
		}

		bs.show();
		g.dispose();
	}


	// return a color for a bar
	private Color getBarColor(int value)
	{
		int interval = (int) (array.length / 5.0);
		if (value < interval)
			return ColorManager.BAR_ORANGE;
		else if (value < interval * 2)
			return ColorManager.BAR_YELLOW;
		else if (value < interval * 3)
			return ColorManager.BAR_GREEN;
		else if (value < interval * 4)
			return ColorManager.BAR_PINK;
		return ColorManager.BAR_BLUE;

	}


	/* BUBBLE SORT */
	public int bubbleSort()
	{

		// get graphics
        g = bs.getDrawGraphics();

		// calculate elapsed time
		startTime = System.nanoTime();
		Sort.BubbleSort(array.clone());
		time = System.nanoTime() - startTime;

		comp = bubbleswap = 0;
		int count = 0;
		for (int i = array.length-1; i >= 0; i--)
		{
			count = 0;
			for (int j = 0; j < i; j++)
			{
				colorPair(j, j+1, comparingColor);

				if (array[j] > array[j+1])
				{
					swap(j, j+1);
					count++;
					bubbleswap++;
				}

				comp++;
			}

			bars[i].setColor(getBarColor(i));
			bars[i].draw(g);
			bs.show();

			if (count == 0)  // the array is sorted
				break;
		}

		finishAnimation();
		g.dispose();
                return bubbleswap;
	}


	/* SELECTION SORT */
	public int selectionSort()
	{

		// get graphics
        g = bs.getDrawGraphics();

		// calculate elapsed time
		startTime = System.nanoTime();
		Sort.SelectionSort(array.clone());
		time = System.nanoTime() - startTime;

		comp = selectswap = 0;
		for (int i = array.length-1; i >= 0; i--)
		{
			// find the max
			int max = array[i], index = i;
			for (int j = 0; j <= i; j++)
			{
				if (max < array[j])
				{
					max = array[j];
					index = j;
				}

				colorPair(index, j, comparingColor);
				comp++;
			}

			swap(i, index);
			selectswap++;

			bars[i].setColor(getBarColor(i));
			bars[i].draw(g);
			bs.show();
		}

		finishAnimation();

		g.dispose();
                return selectswap;
	}


	/* INSERTION SORT */
	public int insertionSort()
	{

		// gett graphics
		g = bs.getDrawGraphics();

		// calculate elapsed time
		startTime = System.nanoTime();
		Sort.InsertionSort(array.clone());
		time = System.nanoTime() - startTime;

		comp = inserswap = 0;

		Bar bar;
		for (int i = 1; i < array.length; i++)
		{
			bars[i].setColor(getBarColor(i));

			// find the insertion location by comparing to its predecessor
			int index = i-1, element = array[i];
			while (index >= 0 && element < array[index])
			{
				array[index+1] = array[index];

				bar = bars[index+1];
				bar.clear(g);
				bar.setValue(bars[index].getValue());
				colorBar(index+1, swappingColor);

				index--;
				comp++;
				inserswap++;
			}
			comp++;

			index++;

			// insert the element
			array[index] = element;

			bar = bars[index];
			bar.clear(g);
			bar.setValue(element);
			bar.setColor(getBarColor(index));
			bar.draw(g);

			bs.show();
		}

		finishAnimation();

		g.dispose();
                return inserswap;
	}


	/* QUICK SORT */
	public int quickSort()
	{

		g = bs.getDrawGraphics();

		// calculate elapsed time
		startTime = System.nanoTime();
		Sort.QuickSort(array.clone());
		time = System.nanoTime() - startTime;

		comp = quickswap = 0;

		quickSort(0, array.length-1);

		finishAnimation();
		g.dispose();
                return quickswap;
	}


	// recursive quicksort
	private void quickSort(int start, int end)
	{
		if (start < end)
		{
			// place pivot in correct spot
			int pivot = partition(start, end);

			// coloring
			bars[pivot].setColor(getBarColor(pivot));
			bars[pivot].draw(g);
			bs.show();

			// sort the left half
			quickSort(start, pivot-1);

			// sort the right half
			quickSort(pivot+1, end);
		}
	}


	// quick sort partition
	private int partition(int start, int end)
	{
		// pivot is the last element
		int pivot = array[end];

		// mark it as pivot
		Bar bar = bars[end];
		Color oldColor = bar.getColor();
		bar.setColor(comparingColor);
		bar.draw(g);
		bs.show();

		int index = start-1;
		for (int i = start; i < end; i++)
		{
			if (array[i] < pivot)
			{
				index++;
				swap(index, i);
				quickswap++;
			}
			comp++;
		}

		bar.setColor(oldColor);
		bar.draw(g);
		bs.show();

		// move pivot to correct location
		index++;
		swap(index, end);
		quickswap++;

		return index;
	}

	/* MERGE SORT */
	public int mergeSort()
	{

		g = bs.getDrawGraphics();

		// calculate elapsed time
		startTime = System.nanoTime();
		Sort.MergeSort(array.clone());
		time = System.nanoTime() - startTime;

		comp = mergeswap = 0;

		mergeSort(0, array.length-1);

		finishAnimation();
		g.dispose();
                return mergeswap;
	}


	// recursive mergeSort
	private void mergeSort(int left, int right)
	{
		if (left >= right)
			return;

		// find the middle
		int middle = (right + left) / 2;

		// sort the left half
		mergeSort(left, middle);

		// sort the second half
		mergeSort(middle+1, right);

		// merge them
		merge(left, middle, right);
	}


	// merge for mergeSort
	private void merge(int left, int middle, int right)
	{
		Color mergeColor = getBarColor(middle);

		// number of items in the first half
		int n1 = middle - left + 1;
		int n2 = right - middle;  // second half

		// create array for those parts
		int[] leftArr = new int[n1];
		for (int i = 0; i < n1; i++)
			leftArr[i] = array[left+i];

		int[] rightArr = new int[n2];
		for (int i = 0; i < n2; i++)
			rightArr[i] = array[middle+i+1];

		// starting index
		int l = 0, r = 0, k = left;  // k: for the original array

		// merge
		while (l < n1 && r < n2)
		{
			Bar bar = bars[k];
			bar.clear(g);
			if (leftArr[l] < rightArr[r]) {
				array[k] = leftArr[l];
				bar.setValue(leftArr[l]);
				l++;
			} else {
				array[k] = rightArr[r];
				bar.setValue(rightArr[r]);
				r++;
			}

			bar.setColor(mergeColor);
			colorBar(k, swappingColor);
			k++;
			comp++;
			mergeswap++;
		}


		// add the remaining in the two arrays if there are any
		while (l < n1)
		{
			Bar bar = bars[k];
			bar.clear(g);

			array[k] = leftArr[l];
			bar.setValue(leftArr[l]);
			bar.setColor(mergeColor);
			colorBar(k, swappingColor);
			l++;
			k++;
			mergeswap++;
		}

		while (r < n2)
		{
			Bar bar = bars[k];
			bar.clear(g);

			array[k] = rightArr[r];
			bar.setValue(rightArr[r]);
			bar.setColor(mergeColor);
			colorBar(k, swappingColor);
			r++;
			k++;
			mergeswap++;
		}
	}
        
	// swap 2 elements given 2 indexes
	private void swap(int i, int j)
	{
		// swap the elements
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;

		// clear the bar
		bars[i].clear(g);
		bars[j].clear(g);

		// swap the drawings
		bars[j].setValue(bars[i].getValue());
		bars[i].setValue(temp);

		colorPair(i, j, swappingColor);
	}


	private void colorPair(int i, int j, Color color)
	{
		Color color1 = bars[i].getColor(), color2 = bars[j].getColor();
		// drawing
		bars[i].setColor(color);
		bars[i].draw(g);

		bars[j].setColor(color);
		bars[j].draw(g);

		bs.show();

		// delay
		try {
			TimeUnit.MILLISECONDS.sleep(speed);
		} catch (Exception ex) {}

		// put back to original color
		bars[i].setColor(color1);
		bars[i].draw(g);

		bars[j].setColor(color2);
		bars[j].draw(g);

		bs.show();
	}


	// color the bar in speed time and put it
	// back to its original color
	private void colorBar(int index, Color color)
	{
		Bar bar = bars[index];
		Color oldColor = bar.getColor();

		bar.setColor(color);
		bar.draw(g);
		bs.show();

		try {
			TimeUnit.MILLISECONDS.sleep(speed);
		} catch (Exception ex) {}

		bar.setColor(oldColor);
		bar.draw(g);

		bs.show();
	}


	// swiping effect when the sorting is finished
	private void finishAnimation()
	{
		// swiping to green
		for (int i = 0; i < bars.length; i++)
		{
			colorBar(i, comparingColor);
			bars[i].setColor(getBarColor(i));
			bars[i].draw(g);
			bs.show();
		}

		// show elapsed time and comparisons
		//listener.onArraySorted(time, comp, swapping);
	}


	// for restore purpose
	public void drawArray()
	{

		g = bs.getDrawGraphics();

		for (int i = 0; i < bars.length; i++)
		{
			bars[i].draw(g);
		}

		bs.show();
		g.dispose();
	}




	public void setarray(int[] array)
	{
		this.array = array;
	}

	public void setFPS(int fps)
	{
		this.speed = (int) (1000.0/fps);
	}

	public interface SortedListener
	{
		//void onArraySorted(int swapping);
		BufferStrategy getBufferStrategy();
	}

    
}
