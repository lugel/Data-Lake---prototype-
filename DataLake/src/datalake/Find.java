/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalake;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Desktop;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.xml.sax.SAXParseException;
/**
 *
 * @author Wojtek
 */
public class Find extends javax.swing.JFrame {

   double min=99999.99;
    double max=-9999.99;
   double avg=0.0;
   int counter=0;
   Boolean showResults=true;
    Boolean  possibleSearch;
    public Find() {
        initComponents();
        blockDateInput();
        possibleSearch=true;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find files");
        setResizable(false);

        jLabel1.setText("Data poczatkowa");

        jLabel2.setText("Data koncowa");

        jLabel3.setText("Szukany parametr");

        jLabel5.setText("Lokalizacja");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prędkość dźwięku [m/s]", "Temperatura zmierzona dźwiękiem [°C]", "Ciśnienie atmosferyczne [mbar]", "Temperatura  [°C]", "Wilgotność [%]", "Wskazanie kompasu [°]", "Prędkość U-V", "Prędkość wiatru [m/s]", "Kierunek wiatru", "Skladnik W - śs pionowa predkosci wiatru [m/s]", "Temperatura wewnątrz pomieszczenia [°C]" }));

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jDateChooser2.setEnabled(false);

        jButton1.setText("wyszukaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Szukana wartość");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Średnia", "Min", "Max" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  void openCSVandTXT(String filename, int comboBoxChoice, int whatToDo ,Date dateStart , Date DateEnd) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("jezioroDanych//" + filename));
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String[] data = null;
            String line;
            reader.readLine();
            reader.readLine();        
            showResults=false;
            switch (whatToDo) {
                case 0:
                    while ((line = reader.readLine()) != null) {
                        
                       if(line.isEmpty()) //pozwalamy na spację 
                           continue;
                        int count=0;
                for(int i = 0; i < line.length(); i++) {    
                 if(line.charAt(i) == ';')    
                       count++;    
                 }    
                if(count!=12){
               showResults = false;
               return;
                }
                       
                             data = line.split(";");
                        if ((data[comboBoxChoice+2].isEmpty()) || ((format.parse(data[0])).before(dateStart) ||
                            (format.parse(data[0])).after(DateEnd))) {
                            continue;
                        }
                        avg+= Double.parseDouble(data[comboBoxChoice+2].trim());
                        counter++;   
                    }
                    showResults=true;
                    break;
                case 1:
                    while ((line = reader.readLine()) != null) {
                               if(line.isEmpty())
                           continue;
                                     int count=0;
                for(int i = 0; i < line.length(); i++) {    
                 if(line.charAt(i) != ';')    
                       count++;    
                 }    
                if(count!=12) { 
               showResults = false;
               return;
                } 
               
                        data = line.split(";");
                        if ((data[comboBoxChoice+2].isEmpty()) || ((format.parse(data[0])).before(dateStart) ||
                            (format.parse(data[0])).after(DateEnd))) {
                            continue;
                        }
                        if (Double.parseDouble(data[comboBoxChoice+2]) < min) {
                            min = Double.parseDouble(data[comboBoxChoice+2]);
                        }
                    }
                    showResults=true;
                     break;
                      
                case 2:
                    while ((line = reader.readLine()) != null) {
                               if(line.isEmpty())
                           continue;
                                     int count=0;
                for(int i = 0; i < line.length(); i++) {    
                 if(line.charAt(i) != ';')    
                       count++;    
                 }    
                if(count!=12){
               showResults = false;
               return;
                }
              
                        data = line.split(";");
                
                        if ((data[comboBoxChoice+2].isEmpty()) || ((format.parse(data[0])).before(dateStart) ||
                            (format.parse(data[0])).after(DateEnd))) {
                            continue;
                        }
                        if (Double.parseDouble(data[comboBoxChoice+2]) > max) {
                            max = Double.parseDouble(data[comboBoxChoice+2]);
                        }
                    }
                     showResults=true;
                     break;
            }                
            reader.close();
       
        } catch (FileNotFoundException ex) {
                     showWarning();
        } catch (IOException ex) {
            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
  void openXML(String filename, int comboBoxChoice, int whatToDo ,Date dateStart , Date DateEnd) throws ParserConfigurationException, SAXException, ParseException, IOException {
       
      showResults=false;  
      
        String parameters[] = {"PredkoscDzwieku","TemperaturaZamierzonaDzwiekiem",
            "CisnienieAtmosferyczne","Temperatura","Wilgotnosc","WskazanieKompasu","PrędkoscU-V","PrędkoscWiatru",
            "KierunekWiatru","Wysokosc","TemperaturaWewnatrzPomieszczenia"};
        
        try {
            File file = new File("jezioroDanych//" + filename);  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            DocumentBuilder db = dbf.newDocumentBuilder();  
        Document doc = db.parse(file);  
        doc.getDocumentElement().normalize();  
            NodeList nodeList = doc.getElementsByTagName("Pogoda");  

            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
      
            switch (whatToDo) {
                case 0:
                       for (int itr = 0; itr < nodeList.getLength(); itr++)   {  
                         Node node = nodeList.item(itr);  
                    if (node.getNodeType() == Node.ELEMENT_NODE)   { 
                    Element eElement = (Element) node;  
                    Date date =  format.parse(eElement.getAttribute("Data"));
                    if (eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent().isEmpty()
                            || date.before(dateStart) ||  date.after(DateEnd))
                        continue;  
                        avg+= Double.parseDouble(eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent().trim());
                        counter++;   
                    }
            }
                        showResults=true;
                    break;
                case 1:
                       for (int itr = 0; itr < nodeList.getLength(); itr++)    {  
                        Node node = nodeList.item(itr);    
                    if (node.getNodeType() == Node.ELEMENT_NODE) {  
                    Element eElement = (Element) node;  
                    Date date =  format.parse(eElement.getAttribute("Data"));

                    if (eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent().isEmpty()
                                || date.before(dateStart) ||  date.after(DateEnd)) 
                            continue;
                        if (Double.parseDouble(eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent()) < min) {
                            min = Double.parseDouble(eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent());
                        }
                    }
                    }
                        showResults=true;
                     break;
                case 2:
                      for (int itr = 0; itr < nodeList.getLength(); itr++)   {  
                        Node node = nodeList.item(itr);  
                     if (node.getNodeType() == Node.ELEMENT_NODE)   { 
                    Element eElement = (Element) node;  
                    Date date =  format.parse(eElement.getAttribute("Data"));
                    if (eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent().isEmpty()
                            || date.before(dateStart) ||  date.after(DateEnd))
                        continue;  
                        if (Double.parseDouble(eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent()) > max) {
                            max = Double.parseDouble(eElement.getElementsByTagName(parameters[comboBoxChoice]).item(0).getTextContent());
                        }
                    }
            }
                       showResults=true;
                     break;
            }                
         
        } catch (FileNotFoundException ex) {
                  showWarning();
        }      catch (SAXParseException ex) {
                  showResults=false;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
        }  
}
void openJSON(String filename, int comboBoxChoice, int whatToDo ,Date dateStart , Date DateEnd) throws ParserConfigurationException, SAXException, ParseException, IOException {
          JSONParser jsonParser = new JSONParser();
        String parameters[] = {"PredkoscDzwieku","TemperaturaZamierzonaDzwiekiem",
            "CisnienieAtmosferyczne","Temperatura","Wilgotnosc","WskazanieKompasu","PrędkoscU-V","PrędkoscWiatru",
            "KierunekWiatru","Wysokosc","TemperaturaWewnatrzPomieszczenia"};
        
        try (FileReader reader = new FileReader("jezioroDanych//" + filename))
        {
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Object obj = jsonParser.parse(reader);
 
            JSONArray dataList = (JSONArray) obj;

             switch (whatToDo) {
                case 0:
                     for ( int i =0; i<dataList.size();i++){
           JSONObject employeeObject =  ((JSONObject) dataList.get(i));
            String dateStirng = (String) employeeObject.get("Data");    
             Date date =  format.parse(dateStirng);
             
              if (date.before(dateStart) ||  date.after(DateEnd))
                      continue;  
               Object obja =   employeeObject.get(parameters[comboBoxChoice]);    
               if(obja.getClass().getName()=="java.lang.Double")
               {
                    avg+= (double) employeeObject.get(parameters[comboBoxChoice]); 
                           counter++;
               }
               else if (obja.getClass().getName()=="java.lang.Long"){
                   Long l = (long) employeeObject.get(parameters[comboBoxChoice]);
                    double d = l.doubleValue();
                    avg+=d;
                           counter++;
               }
                    }
                    break;
             
        case 1:
             for ( int i =0; i<dataList.size();i++){
            JSONObject employeeObject =  ((JSONObject) dataList.get(i));
            String dateStirng = (String) employeeObject.get("Data");    
             Date date =  format.parse(dateStirng);
              if (date.before(dateStart) ||  date.after(DateEnd))
                      continue;  
               Object obja =   employeeObject.get(parameters[comboBoxChoice]);    
               if(obja.getClass().getName()=="java.lang.Double" )
               {
                       if ((Double)employeeObject.get(parameters[comboBoxChoice]) < min) {
                            min = (Double)employeeObject.get(parameters[comboBoxChoice]);
               }
               }
               else if (obja.getClass().getName()=="java.lang.Long"){
                   Long l = (long) employeeObject.get(parameters[comboBoxChoice]);
                    double d = l.doubleValue();
                       if (d < min) {
                            min = d;
               }
                    }
               }
                    
             break;
              case 2:
                     for ( int i =0; i<dataList.size();i++){
            JSONObject employeeObject =  ((JSONObject) dataList.get(i));
            String dateStirng = (String) employeeObject.get("Data");    
             Date date =  format.parse(dateStirng);
               if (date.before(dateStart) ||  date.after(DateEnd))
                      continue;  
                     Object obja =   employeeObject.get(parameters[comboBoxChoice]);    
               if(obja.getClass().getName()=="java.lang.Double" )
               {
                       if ((Double)employeeObject.get(parameters[comboBoxChoice])>  max) {
                            max = (Double)employeeObject.get(parameters[comboBoxChoice]);
               }
               }
               else if (obja.getClass().getName()=="java.lang.Long"){
                   Long l = (long) employeeObject.get(parameters[comboBoxChoice]);
                    double d = l.doubleValue();
                       if (d > max) {
                            max = d;
               }
                    }
               }
                    
             break;
             }
          
        } catch (FileNotFoundException ex) {
                   showWarning();
        } catch (IOException | ParseException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        if ("date".equals(evt.getPropertyName())) {
            jDateChooser2.setEnabled(true);
            if(jDateChooser2.getDate()!=null && jDateChooser1.getDate().after(jDateChooser2.getDate())) 
                jDateChooser2.setDate(null);
                jDateChooser2.setMinSelectableDate(jDateChooser1.getDate());
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          
        if(jDateChooser2.getDate()!=null && jDateChooser1.getDate()!=null)
        if(jTextField3.getText().length()>0) {
            
            //TEST
            long startTime = System.nanoTime();
            //TEST
            
            
            Date dateStartEntered = null;
            Date dateEndEntered =  null; 
        
            ArrayList<String> viableLines = new ArrayList<String>();
            ArrayList <Date> dateRangeCheck = new ArrayList<Date>();
            ArrayList <Date> dateRangeFile = new ArrayList<Date>();
            int comboBoxChoice = 0;
            int whatToDo = 0;
            String[] data = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
         
            try {
                    dateStartEntered = jDateChooser1.getDate();
                    Date dateStartFile;
                    dateEndEntered =  sdf.parse(sdf.format(jDateChooser2.getDate())); 
                    Date dateEndFile;
           
                    String locationEntered = jTextField3.getText();
                    if(locationEntered.length()==0) //błędna lokalizacja
                    {
                        Frame frame = new Frame();
                        JOptionPane.showMessageDialog(frame, "Błędna lokalizacja.", "Komunikat",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                String locationFile;
            
                comboBoxChoice = jComboBox1.getSelectedIndex();
                whatToDo = jComboBox2.getSelectedIndex();
            
                DateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
            
                BufferedReader reader;
                reader = new BufferedReader(new FileReader("jezioroDanych//meta.txt"));
                String line;
                Calendar c = Calendar.getInstance();
                c.setTime(dateStartEntered);

                while(!(c.getTime().after(dateEndEntered))){
                    dateRangeCheck.add(c.getTime());
                    c.add(Calendar.DAY_OF_MONTH, 1); 
                };

                while ((line = reader.readLine()) != null) {
                    data = line.split(" ");
                    int numberSpace = line.split(" ").length; //liczenie spacji w lini
                    dateStartFile = dF.parse(data[numberSpace-3]); //uwzględniamy to że są spacje w nazwie pliku
                    dateEndFile = dF.parse(data[numberSpace-2]);
                    locationFile = data[numberSpace-1];    

                    if  ( locationEntered.equals(locationFile)) {   
                        c.setTime(dateStartFile);
                        while(!(c.getTime().after( dateEndFile))){
                            dateRangeFile.add(c.getTime());
                            c.add(Calendar.DAY_OF_MONTH, 1); 
                        }
                        int dateRageFileSizeBeforeDelete = dateRangeCheck.size();
                        for (int i=0; i< dateRangeFile.size();i++)
                            for(int j=0;j<dateRangeCheck.size();j++)
                            {
                                if(dateRangeCheck.get(j).equals(dateRangeFile.get(i)))
                                    dateRangeCheck.remove(j); //czyścimy dni które są w meta.txt
                            } 
                        //jak plik zawiera jakiś dzień to dodajemy go do listy 
                    if(dateRageFileSizeBeforeDelete != dateRangeCheck.size())
                        viableLines.add(line);
                    }
                    dateRangeFile.clear();
                }

                System.out.println(viableLines);
//            if (viableLines.isEmpty()) {
//                Frame frame = new Frame();
//                JOptionPane.showMessageDialog(frame, "Brak danych dla podanego miejsca\nw danym okresie czasu.",
//                       "Komunikat",JOptionPane.WARNING_MESSAGE);
//            }

            } catch (FileNotFoundException ex) {
                showWarning();
            } catch (IOException ex) {
                Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            if(dateRangeCheck.isEmpty()!=true) //jesli nie zostało wyczyszczone nie wykonujemy wyszukania 
            {
               possibleSearch=false;
               Frame frame = new Frame();
               JOptionPane.showMessageDialog(frame, "Brak danych dla\npodanego zakresu dat.",
                       "Komunikat",JOptionPane.WARNING_MESSAGE);
               return;
            }
            for (String line : viableLines) {
            
                Date dateStartSearch=null; //uwzględniamy to że są spacje w nazwie pliku
                Date  dateEndSearch=null;
            
                data = line.split(" ");
                int numberSpace = line.split(" ").length; //liczenie spacji w lini
                DateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
                String type = data[numberSpace-4];
                try {
                    dateStartSearch = dF.parse(data[numberSpace-3]); //uwzględniamy to że są spacje w nazwie pliku
                    dateEndSearch = dF.parse(data[numberSpace-2]);
                } catch (ParseException ex) {
                    Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                }
                //uwzględnienie pliku bez rozszerzenia
                String fileName = line.substring(0, line.lastIndexOf(type)-1);
                if( !type.equals(""))
                    fileName += "." + type;
                else
                    fileName=fileName.substring(0, line.lastIndexOf(dF.format(dateStartSearch))-2);
            
            
          //  fileName += "." + type;
                System.out.println(fileName);
                System.out.println(comboBoxChoice);
                System.out.println(whatToDo);
                System.out.println(dateStartSearch);
                System.out.println(dateEndSearch);
            //jakich dat szuakmy w danym pliku
            
                if(dateStartSearch.before(dateStartEntered ))
                    dateStartSearch=dateStartEntered;
                if(dateEndSearch.after(dateEndEntered ))
                    dateEndSearch=dateEndEntered;
            
                if (type.equals("csv")) {
                    openCSVandTXT(fileName, comboBoxChoice, whatToDo,dateStartSearch, dateEndSearch);        
                } else if (type.equals("txt")) {
                    openCSVandTXT(fileName, comboBoxChoice, whatToDo,dateStartSearch, dateEndSearch);     
                } else if (type.equals("xml")) {
                    try {     
                        openXML(fileName, comboBoxChoice, whatToDo,dateStartSearch, dateEndSearch);
                    } catch (ParserConfigurationException | SAXException | ParseException | IOException ex) {
                        Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (type.equals("json")) {
                    try {     
                        openJSON(fileName, comboBoxChoice, whatToDo,dateStartSearch, dateEndSearch);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SAXException ex) {
                        Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    showResults=false;
                    File file = new File("jezioroDanych//"+fileName);
                    Desktop desktop = Desktop.getDesktop();
        
                    try {
                        if(file.exists())
                            desktop.open(file);
                        else
                            showWarning();
                    } catch (IOException ex) {
                        Logger.getLogger(Find.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            long endTime = System.nanoTime();
            System.out.println("Czas wykonania: "+ (endTime-startTime)/1000000 + " ms");
        //wyświetlamy wynik
        if(showResults==true)
        {       Frame frame = new Frame();
             switch (whatToDo) {
                case 0:
                    JOptionPane.showMessageDialog(frame, avg/=counter, "Średnia wartość",JOptionPane.PLAIN_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(frame, min, "Minimalna wartość",JOptionPane.PLAIN_MESSAGE);
                    break;  
                case 2:
                    JOptionPane.showMessageDialog(frame, max, "Maksymalna wartość",JOptionPane.PLAIN_MESSAGE);
                    break;
            }    
        }
        else
        {
             Frame frame = new Frame();
               JOptionPane.showMessageDialog(frame, "Błędny format danych.", "Komunikat",JOptionPane.ERROR_MESSAGE);
        }
            
        
    min=99999.99;
    max=-9999.99;
    avg=0.0;
    counter=0;
      }
        else{
             Frame frame = new Frame();
               JOptionPane.showMessageDialog(frame, "Za krótka nazwa lokalizacji.",
                       "Komunikat",JOptionPane.ERROR_MESSAGE);   
        }
        else
        {
            Frame frame = new Frame();
               JOptionPane.showMessageDialog(frame, "Brak wyboru daty.",
                       "Komunikat",JOptionPane.ERROR_MESSAGE);   
        }

    }//GEN-LAST:event_jButton1ActionPerformed
void showWarning()
{
    showResults=false;
      Frame frame = new Frame();
               JOptionPane.showMessageDialog(frame, "Nie znaleziono pliku w jeziorze.", "Komunikat",JOptionPane.WARNING_MESSAGE);
}

  public static void blockDateInput(){
      JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser1.getDateEditor();
            editor.setEditable(false);
      editor = (JTextFieldDateEditor) jDateChooser2.getDateEditor();
          editor.setEditable(false);
  }
     /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

            try {
            
                
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Find().setVisible(true);
                }
            });
    
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private static com.toedter.calendar.JDateChooser jDateChooser1;
    private static com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private static javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
