Ext.define('com.pacegeeks.model.Type', {
	extend: 'Ext.data.Model',
	fields : [
	          {name: 'typeDesc', type: 'string'}
	          ], 
	proxy : {
		type : 'rest',
		url : '/magic/types'
	},
	nodeParam : 'typeDesc'
});