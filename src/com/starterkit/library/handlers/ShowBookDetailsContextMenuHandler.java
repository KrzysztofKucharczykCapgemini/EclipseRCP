package com.starterkit.library.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.starterkit.library.dialogs.BookDetailsDialog;
import com.starterkit.library.models.BookModel;

public class ShowBookDetailsContextMenuHandler extends AbstractHandler {

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			for (Iterator<Object> iterator = strucSelection.iterator(); iterator.hasNext();) {
				Object element = iterator.next();
				BookDetailsDialog bookDetailsDialog = new BookDetailsDialog(null, (BookModel) element);
				bookDetailsDialog.open();
			}
		}
		return null;
	}

}
