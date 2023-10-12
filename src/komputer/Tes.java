/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;
import javax.swing.JOptionPane;
/**
 *
 * @author linad
 */
public class Tes {
    public static void main(String[] args){
        DataKomputer data = new DataKomputer();
        do{
            int p = data.pilihanMenu();
            switch (p){
                case AppInterface.ADD_DATA_KOMPUTER:
                    data.add();  
                    break;
                case AppInterface.SEARC_BY_BRAND:
                    String key = data.keyword("brand");
                    Komputer k = data.searchByBrand(key);
                    data.viewData(k);
                    break;
                case AppInterface.SEARC_BY_MODEL:
                      key = data.keyword("model");
                        k = data.searchByModel(key);
                    data.viewData(k);
                    break;
                case AppInterface.SHOW_DATA:
                    data.showdata();  
                    break;
                case AppInterface.EXIT:
                    data.exit();
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Pilihan salah!");
                break;
            }
        }while(true);
    }
}
