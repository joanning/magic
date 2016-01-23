Ext.define('com.pacegeeks.model.SubType', {
	extend: 'Ext.data.Model',
	fields : [
	          {name: 'subtypeDesc', type: 'string'}
	          ], 
	proxy : {
		type : 'rest',
		url : '/magic/subtypes'
	},
	nodeParam : 'subtypeDesc'
});