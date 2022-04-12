package umc.finallyTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.table.TableCellEditor;

public class TabKeyListener extends KeyAdapter {
    public void keyPressed(KeyEvent evt) {
      if (evt.getKeyCode() == KeyEvent.VK_TAB) {
//        if (inTabbingEditor == true) {
//          TableCellEditor editor = getCellEditor();
//          int editRow = getEditingRow();
//          int editColumn = getEditingColumn();
//          if (editor != null) {
//            boolean stopped = editor.stopCellEditing();
//            if (stopped == true) {
//              boolean forward = (evt.isShiftDown() == false);
//              moveToNextEditor(editRow, editColumn, forward);
//            }
//          }
//        }
      }
    }
  }