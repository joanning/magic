// BDD - Usually you put the model and grid widget in two different files.
// I put them together just so you could see the relationship between the store and model.


Ext.define('ui.Artist', {
	extend: 'Ext.panel.Panel',
	frame:false,
	border:true,
	containerScroll:true,

	initComponent: function(){
		
		var artistStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Artist' 			
		});
		
		this.items = [ {
			xtype: 'grid',
			title: 'Artist',
			id: 'artist',
			height: 270,
			store: artistStore,
			columns:[{
				header: 'ID',
				dataIndex: 'id',
				width: 50,
				sortable: true,
				hideable: false
			}, {
				header: 'First Name',
				dataIndex: 'artistFirstName',
				width: 200,
				sortable: true,
				hideable: false
			},{
				header: 'Last Name',
				dataIndex: 'artistLastName',
				width: 200,
				sortable: true,
				hideable: false
			}]
		}];

		this.callParent(arguments);
	}
});

