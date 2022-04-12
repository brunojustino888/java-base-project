package umc.finallyTable;

import javax.swing.JTable;

public interface Comparator {
  public abstract boolean shouldHighlight(JTable tbl, Object value, int row, int column);
}