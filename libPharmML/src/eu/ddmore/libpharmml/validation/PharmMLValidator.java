/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
package eu.ddmore.libpharmml.validation;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.tree.TreeNode;

import eu.ddmore.libpharmml.IErrorHandler;
import eu.ddmore.libpharmml.dom.PharmML;
import eu.ddmore.libpharmml.dom.dataset.ColumnDefinition;
import eu.ddmore.libpharmml.dom.dataset.ColumnMapping;
import eu.ddmore.libpharmml.dom.dataset.DatasetMap;
import eu.ddmore.libpharmml.dom.modellingsteps.TargetTool;
import eu.ddmore.libpharmml.impl.LoggerWrapper;

/**
 * Class meant to perform validation following the rules in the PharmML specification. There is 
 * no schema-based validation performed within this object.
 * @author F. Yvon
 *
 */
public class PharmMLValidator {
	
	private final PharmML dom;
	
	public PharmMLValidator(PharmML dom){
		this.dom = dom;
	}
	
	/**
	 * Validates a whole PharmML DOM by browsing it recursively, seeking for validatable objects.
	 * 
	 * <p>When an object implementing the {@link Validatable} interface is met, the validation errors
	 * that may be found are added to a master list, which is returned at the end of the process.
	 * @param errorHandler
	 */
	public void validate(IErrorHandler errorHandler){	
		SymbolResolver sr = new SymbolResolver(dom, errorHandler);
		sr.validateAll();
		recursiveValidate(errorHandler, dom);
	}
	
	/**
	 * Recursive method that parses a PharmML tree and validates any validatable element.
	 * @param errors The list that shall be filled during the process.
	 * @param wEl The element to validate. Its mapped children are fetched and this method
	 * is executed on each child.
	 */
	private void recursiveValidate(IErrorHandler errorHandler, TreeNode el){
		if(el instanceof Validatable){
			LoggerWrapper.getLogger().info("Validating "+el);
			((Validatable)el).validate(errorHandler);
		}
		if(el instanceof DatasetMap){
			LoggerWrapper.getLogger().info("Validating "+el);
			validateDatasetMap((DatasetMap) el, errorHandler);
		}
		if(el instanceof TargetTool){
			// TODO: put TargetTool is the same process as DatasetMap
			LoggerWrapper.getLogger().info("Validating "+el);
			validateTargetTool((TargetTool) el, errorHandler);
		}
		@SuppressWarnings("unchecked")
		Enumeration<TreeNode> children = el.children();
		while(children.hasMoreElements()){
			recursiveValidate(errorHandler, children.nextElement());
		}
	}
	
	public static void validateDatasetMap(DatasetMap dm, IErrorHandler errorHandler){
		Set<String> columnIds = new HashSet<String>();
		if(dm.getDataSet() != null){
			for(ColumnDefinition column : dm.getDataSet().getListOfColumnDefinition()){
				if(column.getColumnId() != null){
					columnIds.add(column.getColumnId());
				}
			}
		}
		for(ColumnMapping cm : dm.getListOfColumnMapping()){
			if(cm.getColumnRef() != null && cm.getColumnRef().getColumnIdRef() != null){
				if(!columnIds.contains(cm.getColumnRef().getColumnIdRef())){
					errorHandler.handleError("S13", "The column reference \""+cm.getColumnRef().getColumnIdRef()+"\" does not resolve to"
							+ " a column in the associated dataset.", cm);
				}
			}
		}
		
	}
	
	public static void validateTargetTool(TargetTool tt, IErrorHandler errorHandler){
		Set<String> columnIds = new HashSet<String>();
		if(tt.getTargetToolData() != null && tt.getTargetToolData().getDefinition() != null){
			for(ColumnDefinition column : tt.getTargetToolData().getDefinition().getListOfColumn()){
				if(column.getColumnId() != null){
					columnIds.add(column.getColumnId());
					// TODO: control of columnId unicity
				}
			}
		}
		for(ColumnMapping cm : tt.getColumnMapping()){
			if(cm.getColumnRef() != null && cm.getColumnRef().getColumnIdRef() != null){
				if(!columnIds.contains(cm.getColumnRef().getColumnIdRef())){
					errorHandler.handleError("S13", "The column reference \""+cm.getColumnRef().getColumnIdRef()+"\" does not resolve to"
							+ " a column in the associated dataset.", cm);
				}
			}
		}
		
	}

}
