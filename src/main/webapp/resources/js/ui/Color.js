// BDD - Usually you put the model and grid widget in two different files.
// I put them together just so you could see the relationship between the store and model.



Ext.define('ui.Color', {
	extend: 'Ext.panel.Panel',
	frame:false,
	border:true,
	containerScroll:true,

	initComponent: function(){
		
		var colorStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Color' 			
		});
		
		this.items = [ {
			xtype: 'combo',
			title: 'ColorDesc',
			queryMode: 'local',
			valueField: 'colorDesc',
		    displayField: 'colorDesc', 
			store: colorStore
		}];

		this.callParent(arguments);
	}
});


