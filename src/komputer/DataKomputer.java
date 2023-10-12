/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author linad
 */
public class DataKomputer implements AppInterface {

    private final Komputer[] komputer;
    private String model;
    
    public DataKomputer(){
        komputer = new Komputer[1000];
    }
    
    @Override
    public int pilihanMenu() {
         String p = JOptionPane.showInputDialog(null, ""
         + "<html>"
         + "=====Pilihan=====================<br>"
         + "1 &rarr; Tambah Data Komputer<br>"
         + "2 &rarr; Cari berdasarkan Brand Komputer<br>"
         + "3 &rarr; Cari berdasarkan Model Komputer<br>"
         +"4 &rarr; Tampilkan Data Komputer<br>"
         + "5 &rarr; Keluar Aplikasi<br>"
         + "===============================<br>"
         + "<b>Ketik Pilihan Anda:</b>"
         + "</html>",
           "Menu Pilihan",
           JOptionPane.QUESTION_MESSAGE);
         
         int pilihan = Integer.parseInt(p); //casting
         return pilihan;
         
    }

    @Override
    public void add() {
        Komputer kom = new Komputer();
        String brand = JOptionPane.showInputDialog(null, "Ketik Brand:", "" 
                + "Brand", JOptionPane.QUESTION_MESSAGE);
        kom.setBrand(brand);
        String model = JOptionPane.showInputDialog(null, "Ketik Model:", ""
             + "Model", JOptionPane.QUESTION_MESSAGE);
        kom.setModel(model);
         String disk = JOptionPane.showInputDialog(null, "Tipe Disk(SSD/Harddisk):", ""
             + "Tipe Disk", JOptionPane.QUESTION_MESSAGE);
        kom.setDiskType(disk);
         String size = JOptionPane.showInputDialog(null, "Kapasitas Disk (Angka):", ""
             + "Kapasitas Disk (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int diskSize = Integer.parseInt(size); //casting
        kom.setDiskSize(diskSize);
        String ram= JOptionPane.showInputDialog(null, "Kapasitas RAM (Angka)", ""
        + "Ukuran RAM (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int ramSize = Integer.parseInt(ram); //casting
        kom.setRam(ramSize);
        
        for (int i = 0; i < komputer.length; i++){
            if(komputer[i] == null){
                komputer[i] = kom;
                break;
            }
        }
        viewData(kom);

    }

    @Override
    public String keyword(String type) {
       String key = JOptionPane.showInputDialog(null,"Ketik"+type+"Komputer",type, JOptionPane.QUESTION_MESSAGE);
       return key;
    }

    @Override
    public Komputer searchByBrand(String brand) {
        List<Komputer> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*" + brand.toLowerCase() + ".*");

        for (Komputer k : komputer) {
            if (k != null && pattern.matcher(k.getBrand().toLowerCase()).matches()) {
                results.add(k);
            }
        }

        return results.isEmpty() ? null : results.get(0);
    }
    
    @Override
    public Komputer searchByModel(String model) {
        List<Komputer> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(".*" + model.toLowerCase() + ".*");

        for (Komputer k : komputer) {
            if (k != null && pattern.matcher(k.getModel().toLowerCase()).matches()) {
                results.add(k);
            }
        }

        return results.isEmpty() ? null : results.get(0);
        
    }


    @Override
    public void viewData(Komputer k) {
       if(k == null){
           JOptionPane.showMessageDialog(null,"Data tidak ditemukan!");
       }else {
           JOptionPane.showMessageDialog(null,
                   "Brand\t\t: "+k.getBrand() +
                          "\nModel\t\t:"+k.getModel() +
                           "\nDisk Type\t: "+k.getDiskType() +
                           "\nDisk Size\t: "+k.getRam(),
                            "Data Komputer",
                            JOptionPane.INFORMATION_MESSAGE);
       }
    }
    
    public void showdata(){
         if (komputer.length == 0) {
        JOptionPane.showMessageDialog(null, "Not found!");
        return;
    }

    Object[] cols = {
        "NUM", "BRAND", "MODEL", "DISK TYPE", "DISK SIZE", "RAM SIZE"
    };
    Object[][] rows = new Object[komputer.length][6];
    for (int i = 0; i < komputer.length; i++) {
        Komputer currentKomputer = komputer[i]; 
        if (currentKomputer == null) {
            break;
        }
        rows[i][0] = i + 1;
        rows[i][1] = currentKomputer.getBrand();
        rows[i][2] = currentKomputer.getModel();
        rows[i][3] = currentKomputer.getDisk();
        rows[i][4] = currentKomputer.getDiskSize();
        rows[i][5] = currentKomputer.getRam();
    }
    JTable table = new JTable(rows, cols);
    JOptionPane.showMessageDialog(null, new JScrollPane(table));
}
    

    @Override
    public void exit() {
       System.exit(0);
    }
    
}
