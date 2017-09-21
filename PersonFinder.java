/*
  ______ __  __          __  __ ________   _____   ___
 |  ____|  \/  |   /\   |  \/  |  ____\ \ / / _ \ / _ \
 | |__  | \  / |  /  \  | \  / | |__   \ V / (_) | (_) |
 |  __| | |\/| | / /\ \ | |\/| |  __|   > < \__, |> _ <
 | |____| |  | |/ ____ \| |  | | |____ / . \  / /| (_) |
 |______|_|  |_/_/    \_\_|  |_|______/_/ \_\/_/  \___/

Emanuel Estrada Larios - A01633605
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class PersonFinder extends JPanel implements ActionListener{

  private LinearProbeHash finder;
  private JTextField tfNombrePersona;
  private JButton btAdd, btSearch, btDlt, btExport, btDonate;

  ///////////////////////////////////////////////////////////

  public PersonFinder(){
    super();
    this.setPreferredSize(new Dimension(400,300));
    this.finder = new LinearProbeHash(1000);

    this.add(new JLabel("<html><center><br><b>Ruleta 3<br>Emanuel Estrada Larios<br>Linear Probing Hash</b><br><br>Problema: Con motivo de los recientes desastres naturales<br>mucha gente no tiene información acerca de sus seres queridos.<br>Este herramienta permite que las personas se registren<br>como seguras y busquen informaci&oacute;n acerca de sus familiares.<br><br>Ingrese el nombre completo de la persona:<br><br></center></html>"));

    this.tfNombrePersona = new JTextField(40);
    this.add(this.tfNombrePersona);

    this.btAdd = new JButton("Reportar como segura");
    this.btAdd.addActionListener(this);
    this.add(this.btAdd);

    this.btSearch = new JButton("Buscar persona");
    this.btSearch.addActionListener(this);
    this.add(this.btSearch);

    this.btDlt = new JButton("Eliminar registro");
    this.btDlt.addActionListener(this);
    this.add(this.btDlt);

    this.btExport = new JButton("Descargar lista de registros");
    this.btExport.addActionListener(this);
    this.add(this.btExport);

    this.btDonate = new JButton("Dona ahora a la Cruz Roja Mexicana");
    this.btDonate.setForeground(Color.RED);
    this.btDonate.addActionListener(this);
    this.add(this.btDonate);

  }

  //////////////////////////////////////////////////////////

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this.btAdd)
      addPerson(this.tfNombrePersona.getText());
    else if(e.getSource() == this.btSearch)
      JOptionPane.showMessageDialog(null,searchPerson(this.tfNombrePersona.getText()));
    else if(e.getSource() == this.btDlt)
      deletePerson(this.tfNombrePersona.getText());
    else if(e.getSource() == this.btExport)
      finder.printTable();
    else{
      try {
        Runtime rt = Runtime.getRuntime();
        String url = "https://cruzrojadonaciones.org/";
        rt.exec("open " + url);
      }
      catch (IOException f) {}
    }
  }

  ///////////////////////////////////////////////////////////

  private int calculateKey(String name){

    char[] charArr = name.toCharArray();
    int asciiKey = 0;

    for(int i=0; i<charArr.length; i++)
      asciiKey += (int) charArr[i];

    return asciiKey;
  }

  //////////////////////////////////////////////////////////

  public void addPerson(String name){
    char[] ch = name.toCharArray();
    for(int i=0; i<ch.length; i++){
      if (ch[i] < 32 || (ch[i] > 90 && ch[i] < 97) || ch[i] > 122) {
        JOptionPane.showMessageDialog(null,"Porfavor ingrese caracteres validos.");
        return;
      }
    }
    Key newPerson = new Key(calculateKey(name),name);
    finder.insertElement(newPerson);
    JOptionPane.showMessageDialog(null,name + " ha sido registrado(a) como seguro(a).");
  }

  //////////////////////////////////////////////////////////

  public String searchPerson(String name){
    int j = finder.searchElement(new Key(calculateKey(name),name));
    if(j!=0)
      return "Registro #" + j + ": " + (finder.getIndex(j)).data.toString() + " ha sido reportado(a) como seguro(a).";
    else
      return "No existe registro de la persona que buscas.";
  }

  /////////////////////////////////////////////////////////

  public void deletePerson(String name){
    if(searchPerson(name) != "No existe registro de la persona que buscas."){
      finder.deleteElement(new Key(calculateKey(name),name));
      JOptionPane.showMessageDialog(null,"El registro de " + name + " ha sido eleminado.");
    }
    else
      JOptionPane.showMessageDialog(null,"No existe registro de la persona que buscas.");

  }

  /////////////////////////////////////////////////////////

  public static void main(String[] args) {
    PersonFinder ps = new PersonFinder();
    ps.addPerson("Emanuel");
    System.out.println(ps.searchPerson("Emanuel"));
    ps.deletePerson("Emanuel");
    System.out.println(ps.searchPerson("Emanuel"));
  }


}
