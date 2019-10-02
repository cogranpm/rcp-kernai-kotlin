package com.parinherm.ui

import org.eclipse.e4.ui.di.Focus
import org.eclipse.e4.ui.di.Persist
import org.eclipse.e4.ui.model.application.ui.basic.MPart
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Text
import javax.annotation.PostConstruct
import javax.inject.Inject

class KotlinPart {
	
	@Inject
	private lateinit var part: MPart
	
	@PostConstruct
	fun createComposite(parent: Composite) {
		/*parent.setLayout(GridLayout(1, false))
		txtInput = Text(parent, SWT.BORDER)
		txtInput.setMessage("Enter text to mark part as dirty")
		txtInput.addModifyListener({ e -> part.setDirty(true) })
		txtInput.setLayoutData(GridData(GridData.FILL_HORIZONTAL))
		tableViewer = TableViewer(parent)
		tableViewer.setContentProvider(ArrayContentProvider.getInstance())
		tableViewer.setInput(createInitialDataModel())
		tableViewer.getTable().setLayoutData(GridData(GridData.FILL_BOTH))
		*/
		val root = Composite(parent, SWT.NONE)

 		val txtInput: Text = Text(root, SWT.BORDER)
        root.setLayout(FillLayout(SWT.VERTICAL))

     
      

	}
	
	
	
	@Focus
	fun setFocus() {
		//txtInput.setFocus()
		//tableViewer.getTable().setFocus()
	}

	@Persist
	fun save() {
		part.setDirty(false)
	}

}