package com.dgex.offspring.swt.table;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

public class GenericEditingSupport extends EditingSupport {

  private final CellEditor editor;
  private final IGenericTableColumn column;

  public GenericEditingSupport(ColumnViewer viewer,
      IGenericTableColumn column) {
    super(viewer);
    this.editor = new TextCellEditor((Composite) viewer.getControl(),
        column.getAlignMent());
    this.column = column;
  }

  @Override
  protected CellEditor getCellEditor(Object element) {
    return editor;
  }

  @Override
  protected boolean canEdit(Object element) {
    return true;
  }

  @Override
  protected Object getValue(Object element) {
    Object[] data = { null, null, null, null };
    column.getDataProvider().getCellData(element, data);
    return data[ICellDataProvider.TEXT];
  }

  @Override
  protected void setValue(Object element, Object value) {}
}