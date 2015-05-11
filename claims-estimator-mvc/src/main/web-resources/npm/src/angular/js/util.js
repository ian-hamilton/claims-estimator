/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. License: MIT
 */ 

var claims = {
		
		generateFields : function(schema) {
			var index=0;
			var formFields = new Array();
			
			 $.each(schema.properties, function(key, value) {
        		var formField = new Object();
        		formField.templateOptions = new Object();
        		
        		formField.key = key;
        		
        		switch(value.type) {
        			case 'string':
        				formField.type = 'input';
        				break;
        			default:
        				formField.type = 'input';
        		}
        		
        		formField.templateOptions.required = value.required;
        		formField.templateOptions.label = key;        		
        		
        		formFields[index++] = formField;
        	 });
			 
			 return formFields;
		}
		
}