Ext.define('com.pacegeeks.model.Color', {
	extend: 'Ext.data.Model',
	fields : [
	          {name: 'colorDesc', type: 'string'}
	          ], 
	proxy : {
		type : 'rest',
		url : '/magic/colors'
	},
	nodeParam : 'colorDesc'
});