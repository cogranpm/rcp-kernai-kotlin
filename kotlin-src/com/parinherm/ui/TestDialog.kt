package com.parinherm.ui

import org.eclipse.jface.dialogs.Dialog
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Text
import javax.inject.Inject

class TestDialog @Inject constructor(parentShell: Shell) : Dialog (parentShell) {
	
	init {
		//getShell().setText("Some kind of dialog")
	}
	
	override fun createDialogArea(parent: Composite) : Control{
		
		val comp: Composite = super.createDialogArea(parent) as Composite
		val layout: GridLayout = comp.getLayout() as GridLayout
		layout.numColumns = 2
		val lblUserName: Label = Label(comp, SWT.RIGHT)
		lblUserName.setText("User Name: ")
		val txtUserName: Text = Text(comp, SWT.SINGLE)
		val data: GridData = GridData(GridData.FILL_HORIZONTAL)
		txtUserName.setLayoutData(data)
		return comp
	}
		
//	override fun createDialogArea(parent: Composite) : Control{
//		return super.createDialogArea(parent)
//	}
}