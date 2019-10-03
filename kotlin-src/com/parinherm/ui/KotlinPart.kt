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

import kotlin.math.*
import kotlin.collections.*
import org.eclipse.e4.ui.model.application.MApplication
import org.eclipse.e4.core.contexts.IEclipseContext
import org.eclipse.e4.ui.di.UISynchronize
import org.eclipse.e4.ui.model.application.ui.basic.MWindow
import org.eclipse.e4.ui.workbench.modeling.EPartService
import org.eclipse.e4.ui.services.IServiceConstants
import org.eclipse.swt.widgets.Shell
import javax.inject.Named
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.e4.core.contexts.ContextInjectionFactory
import org.eclipse.jface.dialogs.Dialog

class KotlinPart {
	
	@Inject
	private lateinit var part: MPart
	
	@Inject
	private lateinit var application: MApplication;

	@Inject
	private lateinit var context: IEclipseContext
	
	@Inject
	private lateinit var sync: UISynchronize
	
	
	//@Inject
	//private lateinit var logger: Logger
	
	@Inject
	private lateinit var window: MWindow 
	
	@Inject
	private lateinit var partService: EPartService
	
    @Inject
    @Named (IServiceConstants.ACTIVE_SHELL)
    private lateinit var shell: Shell
	
	
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
		
		var arrayOfMine: ArrayList<String> = ArrayList()
		arrayOfMine.add("Micko")
		
		var listStuff = mutableListOf("Collections", "Functions")
		
		val root = Composite(parent, SWT.NONE)

 		val txtInput: Text = Text(root, SWT.BORDER)
		txtInput.addModifyListener { _ -> part.setDirty(true) }
		val cosVal = cos(90.0)
		txtInput.setText(cosVal.toString() + arrayOfMine[0])
		
        root.setLayout(FillLayout(SWT.VERTICAL))

		val btnGo = Button(root, SWT.PUSH)
		btnGo.setText("GO")
		btnGo.addSelectionListener(object: SelectionAdapter(){
			override fun widgetSelected(e: SelectionEvent){
				savePart()
			}
		})
     
      

	}
	
	
	fun savePart() {
		
		var dlg: TestDialog = ContextInjectionFactory.make(TestDialog::class.java, context)
		if (dlg.open() != Dialog.OK){
			return
			
		}
		
		
		//val partService: EPartService = ctx.get(EPartService::class.java)
		partService.saveAll(true)
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