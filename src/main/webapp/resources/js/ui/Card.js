// BDD - Usually you put the model and grid widget in two different files.
// I put them together just so you could see the relationship between the store and model.

Ext.define('ui.Card', {
	extend: 'Ext.form.Panel',
	alias: ['widget.cardEditPanel'],
	frame:false,
	border:true,
	containerScroll:true,
	card: this.card,
	//grid: this.grid,
	listeners: {
		afterRender: function(thisForm, options){
			if(!Ext.isEmpty(this.card)){
				thisForm.loadRecord(this.card);
				var errors = this.card.validate();
				thisForm.getForm().markInvalid(errors);
			} else {
				thisForm.loadRecord(new com.pacegeeks.model.Card());
			}
		}
		
	},

	initComponent: function(){
		
		var me = this;
		var artistStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Artist' 			
		});
		
		var colorStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Color' 			
		});
		
		var rarityStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Rarity' 			
		});
		
		var subtypeStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.SubType' 			
		});
		
		var typeStore = Ext.create('Ext.data.Store', {
			autoLoad: true,
			model : 'com.pacegeeks.model.Type' 			
		});
		
		//var newCard = com.pacegeeks.model.card();
		
		this.items = [{
			//scope: this,
			//xtype: 'form',
			//name: 'cardForm',
			//items: [{
		        xtype: 'textfield',
		        name: 'cardName',
		        fieldLabel: 'CardName',
		        //fieldValue: newCard.cardName,
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		        xtype: 'textfield',
		        name: 'cardManaCost',
		        fieldLabel: 'CardManaCost',
		        //fieldValue: newCard.cardManaCost,
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		        xtype: 'textfield',
		        name: 'cardConvertedManaCost',
		        fieldLabel: 'CardConvertedManaCost',
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		        xtype: 'textfield',
		        name: 'cardText',
		        fieldLabel: 'CardText',
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		        xtype: 'textfield',
		        name: 'cardPower',
		        fieldLabel: 'CardPower',
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		        xtype: 'textfield',
		        name: 'cardToughness',
		        fieldLabel: 'CardToughness',
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		        xtype: 'combo',
		        fieldLabel: 'Rarity',
		        title: 'Rarity',
		        queryMode: 'local',
		        valueField: 'id',
		        displayField: 'rarityDesc', 
				store: rarityStore
		    },{
		    	xtype: 'textfield',
		        name: 'cardNumber',
		        fieldLabel: 'CardNumber',
		        width: 400,
		        allowBlank: false  // requires a non-empty value
		    },{
		    	xtype: 'combo',
		    	fieldLabel: 'ArtistName',
				title: 'ArtistName',
				queryMode: 'local',
				valueField: 'id',
			    displayField: 'artistName', 
				store: artistStore
		    },{
		    	xtype: 'combo',
		    	fieldLabel: 'ColorDesc',
				title: 'ColorDesc',
				queryMode: 'local',
				valueField: 'colorDesc',
			    displayField: 'colorDesc', 
				store: colorStore
		    },{
		    	xtype: 'combo',
		    	fieldLabel: 'SubTypeDesc',
				title: 'SubTypeDesc',
				queryMode: 'local',
				valueField: 'subtypeDesc',
			    displayField: 'subtypeDesc', 
				store: subtypeStore
		    },{
		    	xtype: 'combo',
		    	fieldLabel: 'TypeDesc',
				title: 'TypeDesc',
				queryMode: 'local',
				valueField: 'typeDesc',
			    displayField: 'typeDesc', 
				store: typeStore
		    },{
		    	xtype: 'button',
		    	title: 'Save'
		    }];
		//}];
		

		this.callParent(arguments);
	}
});


