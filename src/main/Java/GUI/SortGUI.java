/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import B2012131.ColorManager;
import B2012131.MyCanvas;
import B2012131.Visualizer;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author minhq
 */
public class SortGUI extends javax.swing.JFrame implements Visualizer.SortedListener,
	    MyCanvas.VisualizerProvider{
    private static final int WIDTH =1280, HEIGHT = 720;
    private static int cWidth = WIDTH -20-250,cHeight = HEIGHT -120 -20;
    private MyCanvas canvas;
    private Visualizer visualizer;
    private JLabel swapLabel;
    private int[] array;
    private int swapping=0;
    private boolean temp= true;
    private String txt[];
    private String Txt=null;
    private File file,f=new File("file\\Result.txt");

    public SortGUI() {
        f=new File("file\\Result.txt");
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(WIDTH,HEIGHT+200));
        setMinimumSize(new Dimension(WIDTH,HEIGHT+20));
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 20));
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(ColorManager.BACKGROUND);
        setTitle("Minh Quan's Sorting Visualizer");
        init();
    }
    private void init() {
        // add canvas
        canvas = new MyCanvas(this);
        canvas.setFocusable(false);
	canvas.setMaximumSize(new Dimension(cWidth, cHeight));
	canvas.setMinimumSize(new Dimension(cWidth, cHeight));
	canvas.setPreferredSize(new Dimension(cWidth, cHeight));
	canvas.setBounds(250, 120, cWidth, cHeight);
        mainPanel.add(canvas);
	pack();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        insertionSort = new javax.swing.JButton();
        bubbleSort = new javax.swing.JButton();
        quickSort = new javax.swing.JButton();
        selectionSort = new javax.swing.JButton();
        mergeSort = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        Create = new javax.swing.JButton();
        Arraytxt = new javax.swing.JTextField();
        Random = new javax.swing.JButton();
        sparr = new javax.swing.JSpinner();
        btnopen = new javax.swing.JButton();
        Jlabel = new javax.swing.JLabel();
        btncreatefile = new javax.swing.JButton();
        fpsslider = new javax.swing.JSlider();
        lblfile = new javax.swing.JLabel();
        lblfps = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 235, 231));
        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);
        mainPanel.setInheritsPopupMenu(true);
        mainPanel.setMaximumSize(new java.awt.Dimension(1280, 720));
        mainPanel.setMinimumSize(new java.awt.Dimension(1280, 720));
        mainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 147, 115));
        jLabel1.setText("Sort");
        jLabel1.setMaximumSize(new java.awt.Dimension(180, 120));
        jLabel1.setMinimumSize(new java.awt.Dimension(180, 120));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 120));

        insertionSort.setBackground(new java.awt.Color(204, 147, 115));
        insertionSort.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insertionSort.setForeground(new java.awt.Color(255, 255, 255));
        insertionSort.setText("InsertionSort");
        insertionSort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        insertionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertionSortActionPerformed(evt);
            }
        });

        bubbleSort.setBackground(new java.awt.Color(204, 147, 115));
        bubbleSort.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bubbleSort.setForeground(new java.awt.Color(255, 255, 255));
        bubbleSort.setText("BubbleSort");
        bubbleSort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubbleSortActionPerformed(evt);
            }
        });

        quickSort.setBackground(new java.awt.Color(204, 147, 115));
        quickSort.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quickSort.setForeground(new java.awt.Color(255, 255, 255));
        quickSort.setText("QuickSort");
        quickSort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickSortActionPerformed(evt);
            }
        });

        selectionSort.setBackground(new java.awt.Color(204, 147, 115));
        selectionSort.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectionSort.setForeground(new java.awt.Color(255, 255, 255));
        selectionSort.setText("SelectionSort");
        selectionSort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionSortActionPerformed(evt);
            }
        });

        mergeSort.setBackground(new java.awt.Color(204, 147, 115));
        mergeSort.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mergeSort.setForeground(new java.awt.Color(255, 255, 255));
        mergeSort.setText("MergeSort");
        mergeSort.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeSortActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(204, 147, 115));
        reset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset Array");
        reset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        Create.setBackground(new java.awt.Color(204, 147, 115));
        Create.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Create.setForeground(new java.awt.Color(255, 255, 255));
        Create.setText("Create Array");
        Create.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Create.setPreferredSize(new java.awt.Dimension(113, 31));
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateClick(evt);
            }
        });

        Arraytxt.setToolTipText("Nhập dữ liệu mảng");
        Arraytxt.setName("Nhập chuỗi mảng"); // NOI18N
        Arraytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArraytxtActionPerformed(evt);
            }
        });

        Random.setBackground(new java.awt.Color(204, 147, 115));
        Random.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Random.setForeground(new java.awt.Color(255, 255, 255));
        Random.setText("Random Array");
        Random.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomActionPerformed(evt);
            }
        });

        btnopen.setBackground(new java.awt.Color(204, 147, 115));
        btnopen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnopen.setForeground(new java.awt.Color(255, 255, 255));
        btnopen.setText("Open File");
        btnopen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopenActionPerformed(evt);
            }
        });

        Jlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Jlabel.setText("FPS Slider");

        btncreatefile.setBackground(new java.awt.Color(204, 147, 115));
        btncreatefile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btncreatefile.setForeground(new java.awt.Color(255, 255, 255));
        btncreatefile.setText("Create");
        btncreatefile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncreatefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreatefileActionPerformed(evt);
            }
        });

        fpsslider.setMaximum(60);
        fpsslider.setMinimum(1);
        fpsslider.setValue(30);

        lblfile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblfile.setText("Not selected file");

        lblfps.setText("30");

        jButton1.setBackground(new java.awt.Color(204, 147, 115));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Set fps");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(Random, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sparr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Arraytxt)
                            .addComponent(btnopen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncreatefile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(fpsslider, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblfps, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Jlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                        .addComponent(selectionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bubbleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblfile)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(insertionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bubbleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quickSort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mergeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(Jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lblfile)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fpsslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Create, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Arraytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Random, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sparr, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnopen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncreatefile, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 1280, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void selectionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionSortActionPerformed
        swapping=visualizer.selectionSort();
        String s="SelectionSort: "+swapping+" steps";
        try {
            writeFile(s);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str[]=new String[visualizer.array.length];
        for(int i=0;i < str.length;i++){
                str[i]=new String(String.valueOf(visualizer.array[i]));
            }
        String string=String.join(" ", str);
        try {
            writeFile("Array after sorting: "+string);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }                            
    }//GEN-LAST:event_selectionSortActionPerformed

    private void insertionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertionSortActionPerformed
        swapping=visualizer.insertionSort();
        String s="InsertionSort: "+swapping+" steps";
        try {
            writeFile(s);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str[]=new String[visualizer.array.length];
        for(int i=0;i < str.length;i++){
                str[i]=new String(String.valueOf(visualizer.array[i]));
            }
        String string=String.join(" ", str);
        try {
            writeFile("Array after sorting: "+string);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_insertionSortActionPerformed

    private void bubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubbleSortActionPerformed
        swapping=visualizer.bubbleSort();
        String s="BubbleSort: "+swapping+" steps";
        try {
            writeFile(s);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str[]=new String[visualizer.array.length];
        for(int i=0;i < str.length;i++){
                str[i]=new String(String.valueOf(visualizer.array[i]));
            }
        String string=String.join(" ", str);
        try {
            writeFile("Array after sorting: "+string);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bubbleSortActionPerformed

    private void quickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickSortActionPerformed
        swapping=visualizer.quickSort();
        String s="QuickSort: "+swapping+" steps";
        try {
            writeFile(s);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str[]=new String[visualizer.array.length];
        for(int i=0;i < str.length;i++){
                str[i]=new String(String.valueOf(visualizer.array[i]));
            }
        String string=String.join(" ", str);
        try {
            writeFile("Array after sorting: "+string);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_quickSortActionPerformed

    private void mergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeSortActionPerformed
        swapping=visualizer.mergeSort();
        String s="MergeSort: "+swapping+" steps";
        try {
            writeFile(s);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str[]=new String[visualizer.array.length];
        for(int i=0;i < str.length;i++){
                str[i]=new String(String.valueOf(visualizer.array[i]));
            }
        String string=String.join(" ", str);
        try {
            writeFile("Array after sorting: "+string);
        } catch (IOException ex) {
            Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mergeSortActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        visualizer = new Visualizer(array.clone(), fpsslider.getValue(),this);
        visualizer.createArray(cWidth, cHeight);
        for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
    }//GEN-LAST:event_resetActionPerformed

    private void CreateClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateClick
        if(evt.getSource()==Create){
            temp=true;
            txt= Arraytxt.getText().split(" ");
            array= new int[txt.length];
            for(int i=0;i<txt.length;i++){
                if(Integer.parseInt(txt[i])>0 && Integer.parseInt(txt[i])<=100){
                    array[i]=Integer.parseInt(txt[i]);
                }
                else {
                    temp=false;
                    break;
                }
            }
            
        if(temp==false){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,
                "Value <=0 or value > 100",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }else{
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        visualizer = new Visualizer(array.clone(), fpsslider.getValue(),this);
        visualizer.createArray(cWidth, cHeight);
        if (f.exists()) {
            if (f.delete()) {
                System.out.println("Deleted the existing file: " + f.getName());
            } else {
            System.out.println("Failed to delete the existing file.");
            }
        }
        try {
            if (f.createNewFile()) {
                System.out.println("Created the new file: " + f.getName());
            } else {
                System.out.println("Failed to create the new file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                writeFile("Array before sorting: "+Arraytxt.getText());
            } catch (IOException ex) {
                Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_CreateClick

    private void ArraytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArraytxtActionPerformed

    }//GEN-LAST:event_ArraytxtActionPerformed

    private void RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomActionPerformed
        Random rd= new Random();
        if((Integer)sparr.getValue()>=2&& (Integer)sparr.getValue()<=100){
            array= new int[(Integer)sparr.getValue()];
            for(int i=0;i < (Integer)sparr.getValue();i++){
                int ranNum = rd.nextInt(100)+1;
                array[i]=ranNum;
            }
            String s[]=new String[array.length];
            for(int i=0;i < s.length;i++){
                s[i]=new String(String.valueOf(array[i]));
            }
            String string=String.join(" ", s);
            for(int i=0;i < (Integer)sparr.getValue();i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
            visualizer = new Visualizer(array.clone(), fpsslider.getValue(),this);
            visualizer.createArray(cWidth, cHeight);
            System.out.println("File: "+ f.getName());
            if (f.exists()) {
                if (f.delete()) {
                    System.out.println("Deleted the existing file: " + f.getName());
                } else {
                System.out.println("Failed to delete the existing file.");
                }
            }
            try {
                if (f.createNewFile()) {
                    System.out.println("Created the new file: " + f.getName());
                } else {
                    System.out.println("Failed to create the new file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Arraytxt.setText(string);
            try {
                writeFile("Array before sorting: "+Arraytxt.getText());
            } catch (IOException ex) {
                Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        else{
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,
                "Number of array elements <2 or >100",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RandomActionPerformed

    private void btnopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopenActionPerformed
        FileFilter ft = new FileNameExtensionFilter("Text Document", "txt");
        JFileChooser j = new JFileChooser("file");
        j.addChoosableFileFilter(ft);
        j.showSaveDialog(null);
        lblfile.setText(j.getSelectedFile().getAbsolutePath());
        file = new File(j.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_btnopenActionPerformed

    private void btncreatefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreatefileActionPerformed
        try{
            BufferedReader br =Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            Txt=br.readLine();
        } catch (Exception e){
            e.printStackTrace();
        }
        temp=true;
        txt= Txt.split(" ");
        array= new int[txt.length];
        for(int i=0;i<txt.length;i++){
                if(Integer.parseInt(txt[i])>0 && Integer.parseInt(txt[i])<=100){
                    array[i]=Integer.parseInt(txt[i]);
                }
                else {
                    temp=false;
                    break;
                }
            }
        if(temp==false){
            JFrame frame = new JFrame("JOptionPane showMessageDialog example");
            JOptionPane.showMessageDialog(frame,
                "Value <=0 or value > 100",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }else{
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
        visualizer = new Visualizer(array.clone(), fpsslider.getValue(),this);
        visualizer.createArray(cWidth, cHeight);
        if (f.exists()) {
            if (f.delete()) {
                System.out.println("Deleted the existing file: " + f.getName());
            } else {
            System.out.println("Failed to delete the existing file.");
            }
        }
        try {
            if (f.createNewFile()) {
                System.out.println("Created the new file: " + f.getName());
            } else {
                System.out.println("Failed to create the new file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arraytxt.setText(Txt);
        try {
                writeFile("Array before sorting: "+Arraytxt.getText());
            } catch (IOException ex) {
                Logger.getLogger(SortGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btncreatefileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lblfps.setText(Integer.toString(fpsslider.getValue()));
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
		new SortGUI().setVisible(true);
            }
	});
    }
        @Override
    public void onDrawArray() {
        if (visualizer != null)
		visualizer.drawArray();
    }



    public BufferStrategy getBufferStrategy()
	{
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null)
		{
			canvas.createBufferStrategy(2);
			bs = canvas.getBufferStrategy();
		}

		return bs;
	}

    public void onArraySorted(int swapping)
    {
            	
        }
    public void writeFile(String s) throws FileNotFoundException, IOException{
        OutputStream outputStream = new FileOutputStream(f,true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write(s);
        outputStreamWriter.write("\n");
        // Đây là phương thức quan trọng!
        // Nó sẽ bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
        outputStreamWriter.flush();
        outputStreamWriter.close();
        outputStream.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Arraytxt;
    private javax.swing.JButton Create;
    private javax.swing.JLabel Jlabel;
    private javax.swing.JButton Random;
    private javax.swing.JButton btncreatefile;
    private javax.swing.JButton btnopen;
    private javax.swing.JButton bubbleSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSlider fpsslider;
    private javax.swing.JButton insertionSort;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblfile;
    private javax.swing.JLabel lblfps;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton mergeSort;
    private javax.swing.JButton quickSort;
    private javax.swing.JButton reset;
    private javax.swing.JButton selectionSort;
    private javax.swing.JSpinner sparr;
    // End of variables declaration//GEN-END:variables
}
