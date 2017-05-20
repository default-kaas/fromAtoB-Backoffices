package fromatobbackoffice;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class LockerComboBoxModel implements ComboBoxModel<Locker> {
    private ArrayList<Locker> list;
    private Object selectedItem;
    
    public LockerComboBoxModel(ArrayList<Locker> list) {
        this.list = list;
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Locker getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
}