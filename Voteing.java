PROGRAM:
LOGIN.JAVA:
package javaapplication1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class javaapplication1 extends javax.swing.JFrame {
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;

public javaapplication1() {
initComponents();
}
private void initComponents() {
jButton1 = new javax.swing.JButton();
username = new javax.swing.JTextField();
jButton3 = new javax.swing.JButton();
jLabel1 = new javax.swing.JLabel();
jLabel2 = new javax.swing.JLabel();
password = new javax.swing.JPasswordField();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jButton1.setText("RESET");
username.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
usernameActionPerformed(evt);
}
});
jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jButton3.setText("LOGIN");
jButton3.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton3ActionPerformed(evt);
}
});
jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel1.setText("USERNAME :");
jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel2.setText("PASSWORD :");
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
String sql = "select * from login";
try {
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vote","root","Password@123");
pst = con.prepareStatement(sql);
rs = pst.executeQuery();
while(rs.next()){
String dbus = rs.getString("username");
String dbps = rs.getString("password");
String us = username.getText();
String ps = password.getText();
if(dbus.equals(us) && dbps.equals(ps)){
this.setVisible(false);

Home h = new Home();
h.setVisible(true);
}
}
con.close();


} catch (SQLException ex) {
Logger.getLogger(javaapplication1.class.getName()).log(Level.SEVERE, null, ex);
}


}
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new javaapplication1().setVisible(true);
}
});
}
// Variables declaration - do not modify
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton3;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JPasswordField password;
private javax.swing.JTextField username;
// End of variables declaration
}
HOME.JAVA:
package javaapplication1;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Home extends javax.swing.JFrame {
Connection con = null;
PreparedStatement pst = null;
ResultSet rs = null;

public Home() {
initComponents();


try {
String sql = "select Boothid from Booth";
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vote","root","Password@123");
pst = con.prepareStatement(sql);
rs = pst.executeQuery();
while(rs.next()){
boothid.addItem(rs.getString("Boothid"));
}

sql = "select count(VoterId) from Voter";
pst = con.prepareStatement(sql);
rs = pst.executeQuery();
while(rs.next()){
tv.setText(rs.getString("count(VoterId)"));
}

sql = "select count(VoterId) from Voter where Checkvote = 1";
pst = con.prepareStatement(sql);
rs = pst.executeQuery();
while(rs.next()){
tvv.setText(rs.getString("count(VoterId)"));
}

con.close();
} catch (SQLException ex) {
System.out.println(ex); }
}
private void initComponents() {
jTabbedPane1 = new javax.swing.JTabbedPane();
jPanel2 = new javax.swing.JPanel();
boothid = new javax.swing.JComboBox<>();
jLabel1 = new javax.swing.JLabel();
view = new javax.swing.JButton();
jLabel2 = new javax.swing.JLabel();
boothloc = new javax.swing.JLabel();
jLabel4 = new javax.swing.JLabel();
boothin = new javax.swing.JLabel();
jLabel6 = new javax.swing.JLabel();
voters = new javax.swing.JLabel();
jLabel8 = new javax.swing.JLabel();
votersvoted = new javax.swing.JLabel();
jLabel10 = new javax.swing.JLabel();
malevoters = new javax.swing.JLabel();
jLabel12 = new javax.swing.JLabel();
malevoted = new javax.swing.JLabel();
jLabel14 = new javax.swing.JLabel();
femalevoters = new javax.swing.JLabel();
jLabel16 = new javax.swing.JLabel();
femalevoted = new javax.swing.JLabel();
jLabel18 = new javax.swing.JLabel();
pop = new javax.swing.JLabel();
jPanel1 = new javax.swing.JPanel();
jLabel3 = new javax.swing.JLabel();
tv = new javax.swing.JLabel();
jLabel7 = new javax.swing.JLabel();
tvv = new javax.swing.JLabel();
setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel1.setText("Booth ID :");
view.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
view.setText("VIEW");
view.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
viewActionPerformed(evt);
}
});
jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel2.setText("Booth Location :");
jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel4.setText("Booth Incharge :");
jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel6.setText("Total Voters :");
jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel8.setText("Voters Voted :");
jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel10.setText("Male Voters :");
jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel12.setText("Male Voters Voted :");
jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel14.setText("Female Voters :");
jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel16.setText("Female Voters Voted :");
jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
jLabel18.setText("Percentage Of Pool :");
}
private void viewActionPerformed(java.awt.event.ActionEvent evt) {
float x = 0,y = 0,z = 0;
try {
String sql = "select * from Booth where BoothId = ?";
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vote","root","Password@123");
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
boothloc.setText(rs.getString("location"));
boothin.setText(rs.getString("BIncharge"));
}

sql = "select count(VoterId) from Voter where BoothId = ?";
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
x = parseInt(rs.getString("count(VoterId)"));
voters.setText(rs.getString("count(VoterId)"));
}

sql = "select count(VoterId) from Voter where BoothId = ? && Checkvote = 1";
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
y = parseInt(rs.getString("count(VoterId)"));
votersvoted.setText(rs.getString("count(VoterId)"));
}

sql = "select count(VoterId) from Voter where BoothId = ? && Gender = 'male'";
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
malevoters.setText(rs.getString("count(VoterId)"));
}
sql = "select count(VoterId) from Voter where BoothId = ? && Gender = 'male' && Checkvote = 1";
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
malevoted.setText(rs.getString("count(VoterId)"));
}

sql = "select count(VoterId) from Voter where BoothId = ? && Gender = 'female'";
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
femalevoters.setText(rs.getString("count(VoterId)"));
}

sql = "select count(VoterId) from Voter where BoothId = ? && Gender = 'female' && Checkvote = 1";
pst = con.prepareStatement(sql);
pst.setInt(1,parseInt(boothid.getSelectedItem().toString()));
rs = pst.executeQuery();
while(rs.next()){
femalevoted.setText(rs.getString("count(VoterId)"));
}

z = (y/x)*100;
int a = (int) z;
String b = String.valueOf(a);
pop.setText(b + "%");



} catch (SQLException ex) {
Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
}

}
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new Home().setVisible(true);
}
});
}
// Variables declaration - do not modify
private javax.swing.JComboBox<String> boothid;
private javax.swing.JLabel boothin;
private javax.swing.JLabel boothloc;
private javax.swing.JLabel femalevoted;
private javax.swing.JLabel femalevoters;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel10;
private javax.swing.JLabel jLabel12;
private javax.swing.JLabel jLabel14;
private javax.swing.JLabel jLabel16;
private javax.swing.JLabel jLabel18;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JLabel jLabel8;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JTabbedPane jTabbedPane1;
private javax.swing.JLabel malevoted;
private javax.swing.JLabel malevoters;
private javax.swing.JLabel pop;
private javax.swing.JLabel tv;
private javax.swing.JLabel tvv;
private javax.swing.JButton view;
private javax.swing.JLabel voters;
private javax.swing.JLabel votersvoted;
// End of variables declaration
private String parseFloat(float z) {
throw new UnsupportedOperationException("Not supported yet."); // Generated from
nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
}






OUTPUT:
Login.java
a) i) List the count of voters in each booth
ii) list the count of male voters vited
c) Display the Booth Id, Location, and count of voters voted
d) write a function to return the percentage of pool in a booth when booth id is given as input.
c) Display the overall count of voters voted in the election



RESULT:
Thus the program to develop an application for Voting management system and design a database
schema and create necessary table is completed
