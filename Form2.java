import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Form2 extends JFrame implements ActionListener,KeyListener{
    public Container cp;
    public JLabel t; 
    public JButton Add , Delete;
    public JPanel p;
    public JTextField Item;
    public JList<String> toDo;
    public DefaultListModel<String> TDL;
    public JComboBox<String> timeH , timeM;
    public JList<String> toDoList;

    public Form2(){
        super("To Do List !!");
        Initial();
        setComponent();
        JPanel();
        Time();
        Finally() ;
    }

    public void Initial(){
        cp = getContentPane();
        cp.setLayout(null);
    }

    // กำหนดค่าปุ่มต่างๆ
    public void setComponent(){

        // Harlow Solid Itailc     Javanese Text

        t = new JLabel("To Do List");
        t.setFont(new Font("Harlow Solid Itailc", Font.BOLD , 30));
        t.setBounds(420, 10, 400, 35);
        t.setForeground(new Color(250,190,47));
        
        TDL = new DefaultListModel<>();
        toDo = new JList<String>(TDL);
        toDo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(toDo);
        scrollPane.setPreferredSize(new Dimension(800, 500)); 
        scrollPane.setBounds(30, 50, 800, 500);

        Item = new JTextField("",50);
        Item.setBounds(30, 510, 500, 25);
        Item.setBackground(new Color(178, 178, 178));


        Add = new JButton("Add");
        Add.setBounds(780, 510, 80, 25);
        Add.setForeground(Color.WHITE);
        Add.setBackground(new Color(0,49,165));

        Delete = new JButton("Delete");
        Delete.setBounds(877, 510, 80, 25);
        Delete.setForeground(Color.WHITE);
        Delete.setBackground(new Color(158,41,59));
        
        Add.setActionCommand("Add");
        Delete.setActionCommand("Delete");

        Add.addActionListener(this);
        Add.addKeyListener(this);
        Delete.addActionListener(this);

        cp.add(t);
        cp.add(Item);
        cp.add(Add);
        cp.add(Delete);
        
    }

    // หน้าต่างของ list 
    public void JPanel(){
        p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBounds(9, 50, 970, 500); 
        p.setBackground(new Color(45,45,45));

        // เพิ่ม JList สำหรับแสดงรายการ To-Do
        toDoList = new JList<>(TDL);
        JScrollPane scrollPane = new JScrollPane(toDoList);
        scrollPane.setPreferredSize(new Dimension(925, 430)); 
        //scrollPane.setBackground(new Color(178, 178, 178));
        p.add(scrollPane); 
        cp.add(p); 
    }

    // ส่วนของการเพิ่มเวลา
    public void Time(){
        // หน่วยชั่วโมง
        timeH = new JComboBox<>();
        for (int i = 0 ;i < 24 ; i++ ){
            if( i < 10){
                timeH.addItem("0"+i);
            } else timeH.addItem(""+i);
        }
        cp.add(timeH);
        timeH.setBounds(550, 510, 50, 25);
        timeH.setBackground(Color.white);

        //หน่วยนาที
        timeM = new JComboBox<>();
        for (int i = 0 ;i < 60 ; i++ ){
            if( i < 10){
                timeM.addItem("0"+i);
            } else timeM.addItem(""+i);
        }
        cp.add(timeM);
        timeM.setBounds(610, 510, 50, 25);
        timeM.setBackground(Color.white);


    }
// ตั้งค่าหน้าต่าง JFrame
    public void Finally(){
        cp.setBackground(new Color(45,45,45));
        //cp.setBackground(Color.white);
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // กดปุ่ม
    public void actionPerformed(ActionEvent e) {
        if ("Add".equals(e.getActionCommand())) { // ถ้ากด Add
            String newItem = Item.getText();
            if (!newItem.isEmpty()) { 
                TDL.addElement(newItem);
                Item.setText("");
                System.out.println("test");
            }

            // ยังลบข้อความออกจาก List ไม่ได้
        } else if ("Delete".equals(e.getActionCommand())) {  // ถ้ากด Delete
            System.out.println("test2");
            int Index = toDo.getSelectedIndex(); // สร้าง index มาดูบรรทัดที่เลือก
            //if (!TDL.isEmpty()){
                if (Index >= 0 ) {  // index จะเป็น 0 1 2 3 4 5 ..... จะติดลบไม่ได้
                    toDoList.remove(Index+2); // ลบบรรทัดที่เลือกออก
                    System.out.println(Index);
                    System.out.println("test3");
                }
                System.out.println(Index);
                    System.out.println("test4");
            }
       // }
    }

    public void keyTyped(KeyEvent e) {
       
    }

    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER) { // ถ้ากด ENTER จะ add
            String newItem = Item.getText().trim(); // ลบช่องว่างหน้าและหลังข้อความ
            if (!newItem.isEmpty()) {
                TDL.addElement(newItem);
                Item.setText("");
                System.out.println("Added: " + newItem);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }
    
}

