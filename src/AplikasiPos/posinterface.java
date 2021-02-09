package AplikasiPos;

import javax.swing.JTable;

public interface posinterface {
    public void create(Pos p);
    public void read(JTable table);
    public void update(Pos p);
    public void delete(int kd);
    
   
}
