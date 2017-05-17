
package fromatobbackoffice;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class StationComboBoxModel implements ComboBoxModel<Station> {
    private ArrayList<Station> list;
    private Object selectedItem;
    
    public StationComboBoxModel(ArrayList<Station> list) {
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
    public Station getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
}
