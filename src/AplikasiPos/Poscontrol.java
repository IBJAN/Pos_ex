/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AplikasiPos;

import AplikasiPos.Pos;
import AplikasiPos.Pos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CATUR WARGA COMPUTER
 */
public class Poscontrol implements posinterface{
    
    private String[] header = {"KODE BARANG","NAMA BARANG","JENIS BARANG","PENGIRIMAN"};
    
    private ArrayList<Pos> list = new ArrayList();
    
    public void read(JTable table){
        
        DefaultTableModel data = new DefaultTableModel (null, header);
        
        for (int i = 0; i < list.size(); i++) {
            Object[] ob = new Object[4];
            ob[0]=list.get(i).getKd_Barang();
            ob[1]=list.get(i).getNama_Barang();
            ob[2]=list.get(i).getJenis_Barang();
            ob[3]=list.get(i).getJenis_Pengiriman();
            data.addRow(ob);
        }
        table.setModel(data);
        
    }
    
    public void create(Pos p){
        list.add(p);
        JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN !!!");
        
    }
    
    
    public void update( Pos p){
        for (int i = 0; i < list.size(); i++) {
            if (p.getKd_Barang()== list.get(i).getKd_Barang()) {
                
                list.set(i, p); 
            }
        }
        JOptionPane.showMessageDialog(null, "UBAH BERHASIL!");
    }
    
    public void delete(int kd) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKd_Barang()== kd) {
                list.remove(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Berhasil dihapus!");
    }
    public void search(){
        
    }
    
}
